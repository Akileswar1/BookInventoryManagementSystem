package com.cg.bim.repository;
import java.util.List;

import com.cg.bim.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import org.springframework.stereotype.Repository;


import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	List<Author> findAuthorByAuthorID(Integer authorID);
	List<Author> findAuthorByLastName(String lastName);
	List<Author> findAuthorByFirstName(String firstName);

	List<Author> findAllByAuthorIDIn(List<Integer> authoridlist);
	//List<Author> findAuthorsByBookAuthorsIsbn(String isbn);
	@Query(value = "SELECT e FROM author e, bookauthor b WHERE e.authorid = b.authorid AND b.isbn = :isbn",nativeQuery = true)
	List<Author> findAuthorsByBookAuthorIsbn(@Param("isbn") String isbn);

	
//	@Query("select e from Author e")
//	List<Author> findAllAuthors();
//	
//	@Query(value = "select * from Author e where city= :city "
//			+ "and first_name= :firstName", nativeQuery = true)
//	List<Author> findAllAuthorsByFirstNameAndCity(@Param("city") String city, @Param("firstName") String firstName );

	//@Param- named parameters
	
	
//	@Query(value = "select e.city from Author e group by city", nativeQuery = true)
//	List<Object> findAllAuthorsGroupBy();
//	@Query(value = "select e.* from Author e order by city", nativeQuery = true)
//	List<Object> findAllAuthorsOrderBy();
//	@Query(value = "select distinct city from Author", nativeQuery = true)
//	List<Object> findAllAuthorsByDistinct();
//	@Query(value = "select * from Author Having salary>1000", nativeQuery = true)
//	List<Object> findAllAuthorsHaving();
}