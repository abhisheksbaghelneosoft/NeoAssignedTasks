package com.practice.dynamic_db_change.repositories;

import com.practice.dynamic_db_change.beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {}
