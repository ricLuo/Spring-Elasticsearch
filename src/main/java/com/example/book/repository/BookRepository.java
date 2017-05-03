package com.example.book.repository;

///**
// * Created by Owner on 2017/5/1.
// */
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.book.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String>{

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);

//    List<Book> findByAuthor(String author);


}
