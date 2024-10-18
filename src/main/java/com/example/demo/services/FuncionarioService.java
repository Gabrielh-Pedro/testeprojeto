package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import com.example.demo.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void adicionar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public List<Projeto> buscarProjetosPorFuncionario(Integer idFuncionario) {
        return funcionarioRepository.buscarProjetosPorFuncionario(idFuncionario);
    }
}
