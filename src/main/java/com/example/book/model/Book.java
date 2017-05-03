package com.example.book.model;

///**
// * Created by Owner on 2017/5/1.
// */

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ricace", type="books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String releaseDate;

    public Book(){

    }

    public Book(String id, String title, String author, String releaseDate){
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setReleaseDate(releaseDate);
    }


    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    private void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString(){
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
