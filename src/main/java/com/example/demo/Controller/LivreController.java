package com.example.demo.Controller;

import java.util.*;

import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class LivreController {
    @Autowired
    private LivreService service;


    // RESTful API methods for Retrieval all books

    @GetMapping("/livers")
    public List<Livre> list() {
        return service.listAll();
    }

    // RESTful API method for geting a book with id
    @GetMapping("/livers/{id}")
    public ResponseEntity<Livre> get(@PathVariable Integer id) {
        try {
            Livre livre = service.get(id);
            return new ResponseEntity<Livre>(livre, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Livre>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for create book
    @PostMapping("/livers")
    public void add(@RequestBody Livre livre) {
        service.save(livre);
    }

    // RESTful API method for Delete operation
    @PutMapping("/livers/{id}")
    public ResponseEntity<?> update(@RequestBody Livre livre, @PathVariable Integer id) {
        try {
            Livre livreExist = service.get(id);
            service.save(livre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/livers/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

