package com.smirltech.demo.repository;

import com.smirltech.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
