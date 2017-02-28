package com.nixsolutions.service;

import com.nixsolutions.bean.Author;

import java.util.List;

public interface AuthorService {

    public boolean add(Author author);

    public boolean edit(Author author);

    public boolean delete(Integer id);

    public Author getAuthor(Integer id);

    public List<Author> searchByName(String lastName);

    public List<Author> searchByName(String firstName, String lastName);

    public List<Author> searchByName(String firstName, String lastName, String patronymic);

    public List<Author> getAllAuthors();
}
