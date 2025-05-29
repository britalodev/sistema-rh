package com.italo.sistema_rh.repository;

import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.model.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FuncionarioRepository {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private Long proximoId = 1L;

    public Funcionario salvar(Funcionario funcionario) {
        funcionario.setId(proximoId++);
        funcionarios.add(funcionario);
        return funcionario;
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarios.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }

    public void remover(Long id) {
        funcionarios.removeIf(f -> f.getId().equals(id));
    }

    public Funcionario atualizarFuncionario(Funcionario funcionario) {
        Funcionario funcionarioBanco = buscarPorId(funcionario.getId());
        if (Objects.isNull(funcionarioBanco)) {
            return null;
        }
        funcionarios.removeIf(x -> x.getId().equals(funcionario.getId()));
        Funcionario funcionarioAtualizado = new Funcionario(funcionario.getId(), funcionarioBanco.getNome(), funcionario.getEmail(),funcionario.getCargo(), funcionario.getDepartamento(), funcionario.getDataNascimento(), funcionario.getDataAdmissao());
        funcionarios.add(funcionarioAtualizado);
        return funcionarioAtualizado;

    }

    public List<Funcionario> buscarPorNome(String nome) {
        return funcionarios.stream()
                .filter(f -> f.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }
}