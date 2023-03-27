package com.smirltech.demo.controller;

import com.smirltech.demo.dto.PostRequestDto;
import com.smirltech.demo.entity.Post;
import com.smirltech.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("posts")
public class PostController {
    private final PostService postService;

    @GetMapping
    ResponseEntity<List<Post>> index(){
        return ResponseEntity.ok(postService.index());

    }
    @PostMapping
    ResponseEntity<Post> store(@RequestBody PostRequestDto postRequestDto){
        return ResponseEntity.ok(postService.store(postRequestDto));

    }
    @DeleteMapping("{id}")
    ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(postService.delete(id));

    }
    @GetMapping("{id}")
    ResponseEntity<Post> findById(@PathVariable Long id){
        return ResponseEntity.ok(postService.findById(id));

    }
}
