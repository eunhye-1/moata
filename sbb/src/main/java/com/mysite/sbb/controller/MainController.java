package com.mysite.sbb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController 
{ 
    @GetMapping("/")
    public String root() 
    {
    		return "main";
    }
    
    @GetMapping("/community")
    public String communityPage()
    {
    		return "community";
    }
    
    @GetMapping("/chat")
    public String chatyPage()
    {
    		return "chat";
    }
    @GetMapping("/profile")
    public String profilePage()
    {
    		return "profile";
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
}
                                      