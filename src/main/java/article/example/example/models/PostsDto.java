package article.example.example.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostsDto {

    @NotBlank(message = "required")
    @Size(min = 20, message = "Title: required, minimal 20 karakter")
    private String title;

    @NotBlank(message = "required")
    @Size(min = 200, message = "Content: required, minimal 200 karakter")
    private String content;

    @NotBlank(message = "required")
    @Size(min = 3, message = "Category: required, minimal 3 karakter")
    private String category;

    private String status;

    public PostsDto(@NotBlank(message = "required") @Size(min = 20, message = "minimal 20 karakter") String title,
            @NotBlank(message = "required") @Size(min = 200, message = "minimal 200 karakter") String content,
            @NotBlank(message = "required") @Size(min = 3, message = "minimal 3 karakter") String category,
            String status) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.status = status;
    }

    public PostsDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
