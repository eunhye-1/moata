package com.mysite.sbb;

import com.mysite.sbb.user.SiteUser;
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
        SiteUser user = new SiteUser();
        user.setUserId("test1234");
        user.setPassword("1234");
        //user.setEmail("test@test.com");
        user.setPhoneNumber("01012341234");
        user.setPermission("user");

        userRepository.save(user);
    }
}
