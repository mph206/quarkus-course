package tech.donau.course.data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Book {

    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Author should not be blank")
    private String author;

    @Min(value = 1, message = "should be at least one page")
    private Integer pages;

    public Book(@NotBlank(message = "Name should not be blank") String name, @NotBlank(message = "Author should not be blank") String author, @Min(value = 1, message = "should be at least one page") Integer pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public Book() {}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
