package com.example;

///**
// * Created by Owner on 2017/5/1.
// */

import com.example.book.model.Book;
import com.example.book.service.BookService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Map;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    BookService bookService;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception{

        printElasticSearchInfo();

        bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

        Page<Book> books = bookService.findByAuthor("Rambabu Posa", new PageRequest(0,10));

//        List<Book> books = bookService.findByTitle("Elasticsearch Basics");

//        List<Book> books = bookService.findByAuthor("Rambabu Posa");

        books.getContent().forEach(x -> System.out.println(x));


    }

    private void printElasticSearchInfo(){

        System.out.println("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k,v)->{
            System.out.println(k+" = "+v);
        });
        System.out.println("--ElasticSearch--");
    }


}
