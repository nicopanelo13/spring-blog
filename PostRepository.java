package com.zuitt.wdc044.repositories;

import com.zuitt.wdc044.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository - interface that has marked of @Repository contains methods for database manipulation
//by inheriting CrudRepository, PostRepository has inherited its pre-defined methods for creating, retrieving, updating and deleting record. We can actually perform CRUD operations.
@Repository
public interface PostRepository extends CrudRepository<Post, Object>{

    List<Post> findByUserId(Long userId);

}
