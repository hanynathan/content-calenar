package dev.contentcalenar.repository;

import dev.contentcalenar.model.Content;
import dev.contentcalenar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {
    List<Content> findAllByContentType(String type);
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT *
            FROM Content
            WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
