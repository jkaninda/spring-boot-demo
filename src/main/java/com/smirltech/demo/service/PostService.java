package com.smirltech.demo.service;

import com.smirltech.demo.dto.PostRequestDto;
import com.smirltech.demo.entity.Post;

import java.util.List;

public interface PostService {
    Post store(PostRequestDto postRequestDto);
    List<Post> index();
    Post findById(Long id);
    String delete(Long id);
}
