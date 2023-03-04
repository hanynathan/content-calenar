package dev.contentcalenar.repository;

import dev.contentcalenar.model.Content;
import dev.contentcalenar.model.Status;
import dev.contentcalenar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }
    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.Id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content contentData = new Content(1,
                "My first blog post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentList.add(contentData);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void save(Content content) {
        contentList.removeIf(c -> c.Id().equals(content.Id()));
        contentList.add(content);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(c -> c.Id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.Id().equals(id));
    }
}
