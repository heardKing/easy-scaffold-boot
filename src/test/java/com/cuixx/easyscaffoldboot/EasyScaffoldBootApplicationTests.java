package com.cuixx.easyscaffoldboot;

import com.cuixx.es.sys.user.dao.UserMapper;
import com.cuixx.es.sys.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.cuixx.es.EasyScaffoldBootApplication.class)
public class EasyScaffoldBootApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

}
