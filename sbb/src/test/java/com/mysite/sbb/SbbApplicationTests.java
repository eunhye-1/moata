package com.mysite.sbb;

import com.mysite.sbb.user.User;
import com.mysite.sbb.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void directSaveToDB() {
        User user = new User();
        user.setUserId("test123");
        user.setPassword("1234");
        user.setEmail("test@test.com");
        user.setPhoneNumber("01012341234");
        user.setPermission('A');

        userRepository.save(user);
    }
}
