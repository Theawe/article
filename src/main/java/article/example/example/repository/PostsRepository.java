package article.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import article.example.example.models.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
