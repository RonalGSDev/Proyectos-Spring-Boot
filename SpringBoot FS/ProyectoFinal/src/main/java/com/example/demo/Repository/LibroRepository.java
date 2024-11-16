package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.LibrosModel;

@Repository
public interface LibroRepository extends JpaRepository<LibrosModel,Integer>{
    
}
