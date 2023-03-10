package dev.contentcalenar.repository;

import dev.contentcalenar.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
