package com.sesion09.clase09.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sesion09.clase09.Models.EmpleadosModel;

@Repository
public interface EmpleadosRepositoty extends JpaRepository<EmpleadosModel, Integer>{
    
}
