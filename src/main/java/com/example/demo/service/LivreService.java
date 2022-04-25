package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LivreService {
    @Autowired
    private LivreRepo repo;
    public List<Livre> listAll() {
         return repo.findByOrderByTitreAsc();
    }

    public void save(Livre livre) {
        repo.save(livre);
    }

    public Livre get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
