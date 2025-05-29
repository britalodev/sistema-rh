package com.italo.sistema_rh.controller;

import com.italo.sistema_rh.model.Funcionario;
import com.italo.sistema_rh.service.FuncionarioService;

import java.util.List;

public class FuncionarioController {
    private FuncionarioService funcionarioService = new FuncionarioService();

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioService.buscarPorId(id);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    public void remover(Long id) {
        funcionarioService.remover(id);
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return funcionarioService.atualizarFuncionario(funcionario);
    }
}