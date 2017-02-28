package com.nixsolutions.controller.book;

import com.nixsolutions.bean.*;
import com.nixsolutions.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    private static final Logger LOG = LogManager.getLogger(BookController.class.getName());
    private List<Author> authors;
    private Genre genre;
    private Author author;
    private PublishingHouse ph;
    private Language language;
    private Shelf shelf;

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private PublishingHouseService phService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private ShelfService shelfService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String viewBooksList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/book_delete/{book_id}", method = RequestMethod.GET)
    public String bookDelete(@PathVariable("book_id") Long bookID, Model model) {
       Book book = bookService.getBook(bookID);
        if (book.getBookQuantity() > 1) {
            if (book.getBookInWarehouse().equals(book.getBookQuantity())) {
                book.setBookQuantity(book.getBookQuantity() - 1);
                book.setBookInWarehouse(book.getBookInWarehouse() - 1);
                bookService.edit(book);
                return "redirect:/books";
            } else {
                book.setBookQuantity(book.getBookQuantity() - 1);
                bookService.edit(book);
                return "redirect:/books";
            }
        } else {
            try {
                bookService.delete(book.getBookID());
                return "redirect:/books";
            } catch (Exception e) {
                book.setBookQuantity(0);
                book.setBookInWarehouse(0);
                bookService.edit(book);
                model.addAttribute("error", "Cannot delete book which used in orders. Book quantity set 0.");
                return "redirect:/books";
            }
        }
    }

    @RequestMapping(value = "book_description", method = RequestMethod.POST)
    public String viewBookDescription(HttpServletRequest req, Model model) {
        String bookDescription = req.getParameter("book_description");
        model.addAttribute("book_description", bookDescription);
        return "bookDescription";
    }

    @RequestMapping(value = "/update_book/{book_id}", method = RequestMethod.GET)
    public ModelAndView viewBookUpdateForm(@PathVariable("book_id") Long bookID) {
        try{
            Book book = bookService.getBook(bookID);
            return new ModelAndView("updateBook", "book", book);
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

    @RequestMapping(value = "/add_book", method = RequestMethod.GET)
    public String bookAddView() {
        return "addBook";
    }

    @RequestMapping(value = "/add_book", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        String authorFullName[] = book.getAuthor().getFirstName().split(" ");
        validateFields(book, authorFullName);
        bookService.add(book);
        return "books";
    }

    @RequestMapping(value = "/update_book", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") Book book) {
        String authorFullName[] = book.getAuthor().getFirstName().split(" ");
        validateFields(book, authorFullName);
        bookService.edit(book);
        return "redirect:/books";
    }

    private void validateFields(Book book, String[] authorFullName) {
        try {
            searchAuthorByName(authorFullName);
        } catch (Exception e) {
            author.setFirstName(authorFullName[0]);
            author.setLastName(authorFullName[1]);
            if (authorFullName.length == 3) {
                author.setPatronymic(authorFullName[2]);
            }
            authorService.add(author);
            searchAuthorByName(authorFullName);
        }

        try {
            ph = phService.getPublishingHouseByName(book.getPh().getPublishingHouseName());
        } catch (Exception e) {
            ph.setPublishingHouseName(book.getPh().getPublishingHouseName());
            phService.add(ph);
            ph = phService.getPublishingHouseByName(book.getPh().getPublishingHouseName());
        }

        try {
            genre = genreService.searchGenreByName(book.getGenre().getGenre());
        } catch (Exception e) {
            genre.setGenre(book.getGenre().getGenre());
            genreService.add(genre);
            genre = genreService.searchGenreByName(book.getGenre().getGenre());
        }

        try {
            language = languageService.searchLanguageByName(book.getLanguage().getLanguage());
        } catch (Exception e) {
            language.setLanguage(book.getLanguage().getLanguage());
            languageService.add(language);
            language = languageService.searchLanguageByName(book.getLanguage().getLanguage());
        }

        try {
            shelf = shelfService.searchShelfByNumber(book.getShelf().getShelfNumber());
        } catch (Exception e) {
            shelf.setShelfNumber(book.getShelf().getShelfNumber());
            shelfService.add(shelf);
            shelf = shelfService.searchShelfByNumber(book.getShelf().getShelfNumber());
        }

        book.setAuthor(author);
        book.setLanguage(language);
        book.setGenre(genre);
        book.setPh(ph);
        book.setShelf(shelf);
    }

    private void searchAuthorByName(String[] authorFullName) {
        if (authorFullName.length == 2) {
            authors = authorService.searchByName(authorFullName[0], authorFullName[1]);
            if (authors.size() > 0) {
                author = authors.get(0);
            }
        } else if (authorFullName.length == 3) {
            authors = authorService.searchByName(authorFullName[0], authorFullName[1], authorFullName[2]);
            author = authors.get(0);
        }
    }


}
