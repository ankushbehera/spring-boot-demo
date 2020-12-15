package com.ankush.springboot.demo.rest;

import com.ankush.springboot.demo.api.BookApi;
import com.ankush.springboot.demo.api.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class BookController implements BookApi {

    @Override
    public ResponseEntity<String> addBook(Book book) {
        return ResponseEntity.ok(book.getTitle()+" is added");
    }

    @Override
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book()
                .title("Name of the Wind")
                .author("Patrick"));
        bookList.add(new Book()
                .title("Mistborn")
                .author("Brandon"));
        return ResponseEntity.ok(bookList);
    }
}