package com.cg.bim.repository;

import java.util.List;





import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;




import com.cg.bim.entity.BookAuthor;

import com.cg.bim.entity.BookAuthorPrimaries;
@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorPrimaries>{
	List<BookAuthor> findBookAuthorByIsbn(String isbn);
	List<BookAuthor> findByAuthorID(Integer authorID);
//	List<Author> findAuthorsByBooksIsbn(String isbn);
	
}

