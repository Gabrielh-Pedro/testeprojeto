package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import com.example.demo.services.FuncionarioService;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody Funcionario funcionario) {
        funcionarioService.adicionar(funcionario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idFuncionario}/projetos")
    public ResponseEntity<List<Projeto>> buscarProjetosPorFuncionario(@PathVariable Integer idFuncionario) {
        List<Projeto> projetos = funcionarioService.buscarProjetosPorFuncionario(idFuncionario);
        return ResponseEntity.ok(projetos);
    }
}
