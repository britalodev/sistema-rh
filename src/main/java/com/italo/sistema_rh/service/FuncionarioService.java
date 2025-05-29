package com.italo.sistema_rh.service;

import com.italo.sistema_rh.model.Funcionario;
import com.italo.sistema_rh.repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.salvar(funcionario);
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.buscarPorId(id);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.listarTodos();
    }

    public void remover(Long id) {
        funcionarioRepository.remover(id);
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.atualizarFuncionario(funcionario);
    }

    public List<Funcionario> buscarFuncionariosPorNome(String nome) {
        return funcionarioRepository.buscarPorNome(nome);
    }
}