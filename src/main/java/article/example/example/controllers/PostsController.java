package article.example.example.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import article.example.example.models.PostsDto;
import article.example.example.service.PostsService;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/article")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @PostMapping("/")
    public ResponseEntity<Object> createArticle(@RequestBody @Valid PostsDto postsRequest) {
        return new ResponseEntity<Object>(postsService.savePost(postsRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(postsService.getPostsById(id), HttpStatus.OK);
    }

    @GetMapping("/{limit}/{offset}")
    public ResponseEntity<Object> getAll(@Valid @PathVariable(value = "limit") int limit,
            @Valid @PathVariable(value = "offset") int offset) {
        return new ResponseEntity<>(postsService.getAllPosts(limit, offset), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = {
            RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH
    })
    public ResponseEntity<Object> updatePostById(
            @NotBlank(message = "Id tidak boleh kosong") @PathVariable(value = "id") Long id,
            @Valid @RequestBody PostsDto postsDto) {
        return new ResponseEntity<Object>(postsService.savePost(id, postsDto), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.POST, RequestMethod.DELETE })
    public ResponseEntity<Object> deletePostById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Object>(postsService.deleteById(id), HttpStatus.OK);
    }

}
