package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Setor;
import com.example.demo.repositories.SetorRepository;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public void adicionar(Setor setor) {
        setorRepository.save(setor);
    }

    public List<Setor> buscarSetoresComFuncionarios() {
        return setorRepository.listarSetoresComFuncionarios();
    }
}
