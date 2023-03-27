package com.smirltech.demo.service;

import com.smirltech.demo.dto.PostRequestDto;
import com.smirltech.demo.entity.Post;
import com.smirltech.demo.exception.NotFoundException;
import com.smirltech.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    public Post store(PostRequestDto postRequestDto) {
        Post post=new Post();
        post.setTitle(postRequestDto.getTitle());
        post.setContent(postRequestDto.getContent());
        return postRepository.save(post);
    }

    @Override
    public List<Post> index() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(()->new NotFoundException("Not found"));
    }

    @Override
    public String delete(Long id) {
            Post post=postRepository.findById(id).orElseThrow(()->new NotFoundException("Post not found"));
            postRepository.delete(post);
            return "Post deleted";
        }
}
