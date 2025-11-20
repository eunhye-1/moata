package com.mysite.sbb.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController {
	
	private final PostRepository postRepository;
	private final PostService postService;
	
	@GetMapping("/community")
    public String communityList(Model model)
    {
		List<Post> postList=this.postRepository.findAll(); // 모든 포스트 긁어오기
		model.addAttribute("postList",postList); // 리스트 템블릿에 전달
    		return "community";
    }
	
	@GetMapping("/community_detail")
    public String community_detail()
    {
    		return "community_detail";
    }
	
	@GetMapping("/community_write")
    public String community_write()
    {
    		return "community_write";
    }
	
	@PostMapping("/community_write")
	public String writeProcess(@RequestParam("title") String title,
	                           @RequestParam("content") String content,
	                           @RequestParam("category") String category) {

	    postService.writePost(title, content, category);

	    return "redirect:/community";
	}

	
	
}
