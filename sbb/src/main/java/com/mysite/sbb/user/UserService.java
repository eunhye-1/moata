package com.mysite.sbb.user;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 모든 유저 목록 가져오기
    public List<User> getList() {
        return this.userRepository.findAll();
    }
    
    // id(key)로 유저 가져오기
    public User getUser(int id) {
        return userRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    // 중복 확인하기
    public boolean isUserDuplicate(String userId) {
    		return userRepository.existsByUserId(userId);
    }
    
    public User login(String userId, String password) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new RuntimeException("아이디가 존재하지 않습니다.");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return user; // 로그인 성공 → user 반환
    }

}
