package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
  private final ConcurrentHashMap<Long, Post> posts;
  private final AtomicLong idGenerator = new AtomicLong();

  public PostRepository() {
    posts = new ConcurrentHashMap<>();
  }

  public List<Post> all() {
    return new ArrayList<>(posts.values());
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(posts.get(id));
  }

  public Post save(Post post) {
    if (post.getId() != 0 && !posts.containsKey(post.getId())) {
      throw new NotFoundException();
    }

    if (post.getId() == 0) {
      var newId = idGenerator.incrementAndGet();
      post.setId(newId);
      posts.put(newId, post);
    }

    posts.put(post.getId(), post);

    return post;
  }

  public void removeById(long id) {
      posts.containsKey(id) ? posts.remove(id) : throw new NotFoundException();
  }
}
