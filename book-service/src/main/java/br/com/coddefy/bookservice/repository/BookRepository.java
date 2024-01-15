package br.com.coddefy.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.coddefy.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
}
