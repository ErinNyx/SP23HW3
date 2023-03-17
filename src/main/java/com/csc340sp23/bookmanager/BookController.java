package com.csc340sp23.bookmanager;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// I know I could have set RequestMapping to /book but I started this assignment maybe 7 hours before it was due and I'm
// Done with all the basic stuff like an hour later
// I have some extra time so I'm going to set up a main page and do some styling
@Controller
@RequestMapping("/")

public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping()
    public String mainPage() {
        return "main";
    }

    @GetMapping("/book/all")
    public String getBooks(Model model) {
        model.addAttribute("bookList", bookService.getAllBooks());
        return "list-books";
    }

    @GetMapping("/book/new-book")
    public String updateBook(Model model) {
        return "new-book";
    }

    @PostMapping("/book/add")
    public String createBook(Book book) {
        bookService.save(book);
        return "redirect:/book/all";
    }

    @PostMapping("/book/update")
    public String updateBook(Book book) {
        bookService.save(book);
        return "redirect:/book/all";
    }

    @PostMapping("/book/delete-book/id={bookId}")
    public String deleteBook(@PathVariable long bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/book/all";
    }

    @GetMapping("/book/update-book/id={book}")
    public String updatePage(@PathVariable long book, Model model) {
        model.addAttribute("book", bookService.getBookById(book));
        return "update-book";
    }

    @GetMapping("/book/id={book}")
    public String bookDetail(@PathVariable long book, Model model) {
        model.addAttribute("book", bookService.getBookById(book));
        return "book-detail";
    }
}
