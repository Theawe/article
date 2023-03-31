package article.example.example.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import article.example.example.exceptions.NotFoundException;
import article.example.example.models.Posts;
import article.example.example.models.PostsDto;
import article.example.example.repository.PostsRepository;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    ModelMapper mapper = new ModelMapper();

    public List<Posts> getPosts() {
        return postsRepository.findAll();
    }

    public PostsDto getPostsById(Long id) {
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No posts by ID: " + id));
        PostsDto postsDto = mapper.map(post, PostsDto.class);
        return postsDto;
    }

    public List<PostsDto> getAllPosts(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        List<Posts> listPosts = postsRepository.findAll(pageable).getContent();
        List<PostsDto> listPostsDtos = new ArrayList<>();
        for (Posts post : listPosts) {
            PostsDto postsDto = mapper.map(post, PostsDto.class);
            listPostsDtos.add(postsDto);
        }
        return listPostsDtos;
    }

    public Posts savePost(PostsDto postsRequest) {
        Posts posts = new Posts();
        if (!isStatusValid(postsRequest)) {
            throw new NotFoundException("Status: required, harus memilih antara 'publish', 'draft', 'thrash'");
        }
        posts.setTitle(postsRequest.getTitle());
        posts.setCategory(postsRequest.getCategory());
        posts.setContent(postsRequest.getContent());
        posts.setStatus(postsRequest.getStatus());
        postsRepository.save(posts);
        return null;
    }

    public Posts savePost(Long id, PostsDto postsRequest) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No posts by ID: " + id));
        if (!isStatusValid(postsRequest)) {
            throw new NotFoundException("Status: required, harus memilih antara 'publish', 'draft', 'thrash'");
        }
        posts.setTitle(postsRequest.getTitle());
        posts.setCategory(postsRequest.getCategory());
        posts.setContent(postsRequest.getContent());
        posts.setStatus(postsRequest.getStatus());
        postsRepository.save(posts);
        return null;
    }

    public Posts deleteById(Long id) {
        postsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No posts by ID: " + id));
        postsRepository.deleteById(id);
        return null;
    }

    private boolean isStatusValid(PostsDto postsRequest) {
        String status = postsRequest.getStatus();
        if (status.equalsIgnoreCase("Publish") || status.equalsIgnoreCase("Draft")
                || status.equalsIgnoreCase("Thrash")) {
            return true;
        }
        return false;
    }
}
