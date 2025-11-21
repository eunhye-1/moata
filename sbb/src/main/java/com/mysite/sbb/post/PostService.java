package com.mysite.sbb.post;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserRepository;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void writePost(String title, String content, String category, String userId) 
    {
    	
    		//userId로 SiteUser 조회
    	 	SiteUser user = userRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCategory(category);
        post.setUser(user);
        //post.setViewCnt(0);

        postRepository.save(post);
    }
}
