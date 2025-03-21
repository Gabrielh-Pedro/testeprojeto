package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("SELECT f FROM Funcionario f JOIN f.projetos p WHERE f.id = :idFuncionario")
    List<Projeto> buscarProjetosPorFuncionario(Integer idFuncionario);
}
