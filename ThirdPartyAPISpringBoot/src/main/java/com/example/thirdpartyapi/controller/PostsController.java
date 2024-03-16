package com.example.thirdpartyapi.controller;

import com.example.thirdpartyapi.postsservice.PostsService;
import com.example.thirdpartyapi.postsservice.PostsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping("/getPosts")
    public List<Map<String,Object>> getAllPost()
    {
        return postsService.getPosts();
    }

    @GetMapping("/getPostById/{id}")
    public Map<String,Object> getPostById(@PathVariable int id)
    {
        return postsService.getPostById(id);
    }

    @PostMapping("/insertPosts")
    public Map<String,Object> insertPosts(@RequestBody Map<String,Object> paylod)
    {
        return postsService.insertPost(paylod);
    }

    @PutMapping("/updatePosts/{id}")
    public Map<String, Object> updatePosts(@RequestBody  Map<String,Object> payload,@PathVariable int id)
    {
        return postsService.updatePosts(payload,id);
    }

    @DeleteMapping("/deletePosts/{id}")
    public Map<String,Object> deletePosts(@PathVariable int id)
    {
        return postsService.deletePosts(id);
    }
}
