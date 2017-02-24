package com.nixsolutions.dao.impl.h2;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.nixsolutions.bean.*;
import com.nixsolutions.dao.BookDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-spring-config.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:db-data.xml")
public class BookDAOImplTest{

  //  @Autowired
    private BookDAO bookDAO;

    @Test
    @ExpectedDatabase("classpath:book/book-add.xml")
    public void testShouldAddBook() throws Exception {

        //given
        bookDAO = new BookDAOImpl();
        Author author = new Author(3, "Gilbert", "Shildt", null);
        PublishingHouse ph = new PublishingHouse(2, "Rosmen");
        Genre genre = new Genre(3, "Science fiction");
        Language language = new Language(4, "Polish");
        Shelf shelf = new Shelf(2, 2);
        Book book = new Book("Polska istoria", 2001, "Some desrpt", 12, 12, author, ph, genre,language, shelf);
       // IDataSet expectedSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/book/book-add.xml"));
      //  ITable expectedTable = expectedSet.getTable("book");

        //when
        bookDAO.add(book);
//        IDatabaseConnection connection = getConnection();
//        IDataSet actualSet = connection.createDataSet();
//        ITable actualTable = actualSet.getTable("book");
//
//        // then
//        String[] cols = {"book_id", "book_rate", "number_of_readings"};
//        assertEqualsIgnoreCols(expectedTable, actualTable, cols);
    }

//    @Test
//    public void testShouldUpdateBook() throws Exception {
//        //given
//        Author author = new Author(3, "Gilbert", "Shildt", null);
//        PublishingHouse ph = new PublishingHouse(2, "Rosmen");
//        Genre genre = new Genre(3, "Science fiction");
//        Language language = new Language(4, "Polish");
//        Shelf shelf = new Shelf(2, 2);
//        book = new Book("Polska istoria", 2001, "Some desrpt", 1, 1, author, ph, genre,language, shelf);
//        book.setBookID(4L);
//        IDataSet expectedSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/book/book-update.xml"));
//        ITable expectedTable = expectedSet.getTable("book");
//
//        //when
//        bookDAO.edit(book);
//        IDatabaseConnection connection = getConnection();
//        IDataSet actualSet = connection.createDataSet();
//        ITable actualTable = actualSet.getTable("book");
//
//        // then
//        String[] cols = {"book_id", "book_rate", "number_of_readings"};
//        assertEqualsIgnoreCols(expectedTable, actualTable, cols);
//    }
//
//    @Test
//    public void testShouldDeleteBook() throws Exception {
//        //given
//        Long bookID = 5L;
//        IDataSet expectedSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/book/book-delete.xml"));
//        ITable expectedTable = expectedSet.getTable("book");
//
//        //when
//        bookDAO.delete(bookID);
//        IDatabaseConnection connection = getConnection();
//        IDataSet actualSet = connection.createDataSet();
//        ITable actualTable = actualSet.getTable("book");
//
//        // then
//        String[] cols = {"book_id", "book_rate", "number_of_readings"};
//        assertEqualsIgnoreCols(expectedTable, actualTable, cols);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testShouldThrowExceptionIfTryDeleteBookWhichUsedInOrder() throws FileNotFoundException, DataSetException, ClassNotFoundException {
//        //given
//        Long bookID = 2L;
//
//        //when
//        bookDAO.delete(bookID);
//    }
//
//    @Test
//    public void testShouldReturnBook() throws Exception {
//        //given
//        Long bookID = 3L;
//        Book expectedBook = new Book();
//        expectedBook.setBookName("Kobzar");
//        expectedBook.setBookID(bookID);
//
//        //when
//        Book actualBook = bookDAO.getBook(bookID);
//
//        //then
//        assertEquals(expectedBook.getBookName(), actualBook.getBookName());
//    }
//
//
//    @Test
//    public void testSearchByBookName() throws Exception {
//        //given
//        String bookName = "Polska mova.";
//        List<Book> expectedBooksList = new ArrayList<>();
//        Author author = new Author(3, "Gilbert", "Shildt", null);
//        PublishingHouse ph = new PublishingHouse(2, "Rosmen");
//        Genre genre = new Genre(3, "Science fiction");
//        Language language = new Language(4, "Polish");
//        Shelf shelf = new Shelf(2, 2);
//        Book expectedBook = new Book("Polska mova.", 2000, "Some desrpt", 1, 1, author, ph, genre, language, shelf);
//        expectedBooksList.add(expectedBook);
//        expectedBook.setBookRate(0);
//        expectedBook.setNumberOfReadings(0);
//        expectedBook.setBookID(4L);
//
//        //when
//        List<Book> actualBooksList = bookDAO.searchByBookName(bookName);
//
//        //then
//        assertEquals(expectedBooksList.toString(), actualBooksList.toString());
//    }
//
//
//    @Test
//    public void testGetAllBooks() throws Exception {
//        //given
//        List<Book> expectedBooksList = prepareBook();
//
//        //when
//        List<Book> actualBooksList = bookDAO.getAllBooks();
//
//        //then
//        assertEquals(expectedBooksList.toString(), actualBooksList.toString());
//    }
//
//    private List<Book> prepareBook() {
//        List<Book> expectedBooksList = new ArrayList<>();
//        Book book1 = new Book();
//        book1.setBookName("Java 8. Full manual.");
//        book1.setYearOfIssue(2012);
//        book1.setBookDescription("Some desrpt");
//        book1.setBookQuantity(25);
//        book1.setBookInWarehouse(25);
//        book1.setNumberOfReadings(0);
//        book1.setBookRate(0);
//        Book book2 = new Book();
//        book2.setNumberOfReadings(0);
//        book2.setBookName("Java 8.");
//        book2.setYearOfIssue(2013);
//        book2.setBookDescription("Some desrpt");
//        book2.setBookQuantity(50);
//        book2.setBookInWarehouse(50);
//        book2.setBookRate(0);
//        Book book3 = new Book();
//        book3.setBookName("Kobzar");
//        book3.setYearOfIssue(2000);
//        book3.setBookDescription("Some desrpt");
//        book3.setBookQuantity(4);
//        book3.setBookInWarehouse(4);
//        book3.setNumberOfReadings(0);
//        book3.setBookRate(0);
//        Book book4 = new Book();
//        book4.setBookName("Polska mova.");
//        book4.setYearOfIssue(2000);
//        book4.setBookDescription("Some desrpt");
//        book4.setBookQuantity(1);
//        book4.setBookInWarehouse(1);
//        book4.setNumberOfReadings(0);
//        book4.setBookRate(0);
//        Book book5 = new Book();
//        book5.setBookName("Skazki");
//        book5.setYearOfIssue(2000);
//        book5.setBookDescription("Some desrpt");
//        book5.setBookQuantity(4);
//        book5.setBookInWarehouse(4);
//        book5.setNumberOfReadings(0);
//        book5.setBookRate(0);
//        book1.setBookID(1L);
//        book2.setBookID(2L);
//        book3.setBookID(3L);
//        book4.setBookID(4L);
//        book5.setBookID(5L);
//        expectedBooksList.add(book1);
//        expectedBooksList.add(book2);
//        expectedBooksList.add(book3);
//        expectedBooksList.add(book4);
//        expectedBooksList.add(book5);
//        return expectedBooksList;
//    }
}