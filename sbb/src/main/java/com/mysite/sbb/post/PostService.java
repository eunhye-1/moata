package com.mysite.sbb.post;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void writePost(String title, String content, String category) {

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCategory(category);
        //post.setViewCnt(0);

        postRepository.save(post);
    }
}
