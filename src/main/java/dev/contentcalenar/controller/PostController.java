package dev.contentcalenar.controller;

import dev.contentcalenar.model.Post;
import dev.contentcalenar.repository.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostRepository postRepo;

    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @GetMapping
    public Iterable<Post> findAll(){
        return postRepo.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Post post){
        return post;
    }
}
