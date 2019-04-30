package com.cuixx.es.common.web.tips;

import lombok.Data;

/**
 * 返回给前台的提示（最终转化为json形式）
 */
@Data
public abstract class Tip {

    protected int code;
    protected String message;
}
