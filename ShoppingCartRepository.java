package com.cg.bim.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.bim.entity.ShoppingCart;
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
    List<ShoppingCart> findShoppingCartsByUserId(Integer userid);
    List<ShoppingCart> findShoppingCartsByIsbn(String isbn);
}