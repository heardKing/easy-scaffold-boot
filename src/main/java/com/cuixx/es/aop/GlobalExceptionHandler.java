package com.cuixx.es.aop;

import com.cuixx.es.common.Constants;
import com.cuixx.es.common.exception.BizExceptionEnum;
import com.cuixx.es.common.exception.CommonException;
import com.cuixx.es.common.exception.InvalidKaptchaException;
import com.cuixx.es.common.web.tips.ErrorTip;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.DisabledAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.UndeclaredThrowableException;

import static com.cuixx.es.common.utils.HttpUtils.getRequest;


/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(CommonException e) {
//        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        getRequest().setAttribute(Constants.MESSAGE, e.getMessage());
        log.error("业务异常:", e);
        return new ErrorTip(e.getCode(), e.getMessage());
    }

    /**
     * 用户未登录异常
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unAuth(AuthenticationException e) {
        log.error("用户未登陆：", e);
        return "front/login";
    }

    /**
     * 账号被冻结异常
     */
    @ExceptionHandler(DisabledAccountException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String accountLocked(DisabledAccountException e, Model model) {
        String username = getRequest().getParameter("username");
//        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "账号被冻结", getIp()));
        model.addAttribute(Constants.ERROR, "账号被冻结");
        return "front/login";
    }

    /**
     * 账号密码错误异常
     */
    @ExceptionHandler(CredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String credentials(CredentialsException e, Model model) {
        String username = getRequest().getParameter("username");
//        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "账号密码错误", getIp()));
        model.addAttribute(Constants.ERROR, "账号密码错误");
        return "front/login";
    }

    /**
     * 验证码错误异常
     */
    @ExceptionHandler(InvalidKaptchaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String credentials(InvalidKaptchaException e, Model model) {
        String username = getRequest().getParameter("username");
//        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "验证码错误", getIp()));
        model.addAttribute(Constants.ERROR, "验证码错误");
        return "front/login";
    }

    /**
     * 无权访问该资源异常
     */
    @ExceptionHandler(UndeclaredThrowableException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorTip credentials(UndeclaredThrowableException e) {
        getRequest().setAttribute("tip", "权限异常");
        log.error("权限异常!", e);
        return new ErrorTip(BizExceptionEnum.NO_PERMITION.getCode(), BizExceptionEnum.NO_PERMITION.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(RuntimeException e) {
//        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        getRequest().setAttribute(Constants.ERROR, "服务器未知运行时异常");
        log.error("运行时异常:", e);
        return new ErrorTip(BizExceptionEnum.SERVER_ERROR.getCode(), BizExceptionEnum.SERVER_ERROR.getMessage());
    }
}
