package com.zuitt.wdc044.controllers;


import com.zuitt.wdc044.models.Post;
import com.zuitt.wdc044.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;

    //route for creating a new post
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<?> createPost(@RequestHeader(value = "Authorization") String stringToken, @RequestBody Post post){
        postService.createPost(stringToken, post);

        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }

    //route for getting all posts
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<?> getPosts(){
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    //route for editing a post
    @RequestMapping(value = "/posts/{postid}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePost(@PathVariable Long postid, @RequestHeader(value = "Authorization") String stringToken, @RequestBody Post post){

        return postService.updatePost(postid, stringToken, post);

    }

    //route for deletion of specific post
    @RequestMapping(value = "/posts/{postid}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePost(@PathVariable Long postid, @RequestHeader(value = "Authorization") String stringToken){

        return postService.deletePost(postid, stringToken);

    }

    //Activity s05
    @RequestMapping(value = "/myPosts", method = RequestMethod.GET)
    public ResponseEntity<?> getMyPosts(@RequestHeader(value = "Authorization") String stringToken){
        Iterable<Post> myPosts = postService.getMyPosts(stringToken);
        return new ResponseEntity<>(myPosts, HttpStatus.OK);
    }




}
