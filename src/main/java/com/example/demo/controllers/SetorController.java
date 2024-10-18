package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Setor;
import com.example.demo.services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody Setor setor) {
        setorService.adicionar(setor);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Setor>> listarSetoresComFuncionarios() {
        List<Setor> setores = setorService.buscarSetoresComFuncionarios();
        return ResponseEntity.ok(setores);
    }
}

