package com.cg.bim.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bim.entity.ShoppingCart;
import com.cg.bim.repository.ShoppingCartRepository;
@RestController
@RequestMapping("/api")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @PostMapping("/shoppingCarts")
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart){
        if(shoppingCart==null) {
            return new ResponseEntity<ShoppingCart>(HttpStatus.NO_CONTENT);
        }else {
            shoppingCartRepository.save(shoppingCart);
            return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
        }
    }
    @GetMapping("/shoppingCarts")
    public ResponseEntity<List<ShoppingCart>> getShoppingCarts(){
        List<ShoppingCart> shoppingCarts= shoppingCartRepository.findAll();
        if(shoppingCarts==null) {
            return new ResponseEntity<List<ShoppingCart>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ShoppingCart>>(shoppingCarts,HttpStatus.OK);
    }
    @GetMapping("/shoppingcart/{userId}")
    public ResponseEntity<ShoppingCart> shoppingCartByUserId(@PathVariable("userId") Integer userId) throws Exception{
        List<ShoppingCart> shoppingCart1=shoppingCartRepository.findShoppingCartsByUserId(userId);
        if(shoppingCart1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }
        else{
            return new ResponseEntity<ShoppingCart>(shoppingCart1.get(0), HttpStatus.OK);
        }
    }
    @PutMapping("/shoppingcart /update/isbn/{userId}")
    public ResponseEntity<ShoppingCart> modifyIsbnByUserID(@PathVariable("userId") Integer userId,@RequestBody String isbn) throws Exception{
        List<ShoppingCart> shoppingCart1=shoppingCartRepository.findShoppingCartsByUserId(userId);
        if(shoppingCart1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }
        else{
            shoppingCart1.get(0).setIsbn(isbn);
            shoppingCartRepository.save(shoppingCart1.get(0));
            return new ResponseEntity<ShoppingCart>(shoppingCart1.get(0), HttpStatus.OK);
            }
    }    
}