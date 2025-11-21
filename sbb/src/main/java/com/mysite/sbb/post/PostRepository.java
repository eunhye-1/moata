package com.mysite.sbb.post;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByTitleContaining(String keyword);
	List<Post> findByContentContaining(String keyword); // 검색&조회
}