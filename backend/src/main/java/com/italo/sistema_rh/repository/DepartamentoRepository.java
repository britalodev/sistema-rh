package com.italo.sistema_rh.repository;

import com.italo.sistema_rh.model.Departamento;
import com.italo.sistema_rh.model.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DepartamentoRepository {
    private List<Departamento> departamentos = new ArrayList<>();
    private Long proximoId = 1L;

    public Departamento salvar(Departamento departamento) {
        departamento.setId(proximoId++);
        departamentos.add(departamento);
        return departamento;
    }

    public Departamento buscarPorId(Long id) {
        return departamentos.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Departamento> listarTodos() {
        return new ArrayList<>(departamentos);
    }

    public void remover(Long id) {
        departamentos.removeIf(d -> d.getId().equals(id));
    }

        public Departamento atualizarDepartamento(Departamento departamento) {
        Departamento departamentoBanco = buscarPorId(departamento.getId());
        if (Objects.isNull(departamentoBanco)) {
            return null;
        }
        departamentos.removeIf(x -> x.getId().equals(departamento.getId()));
        Departamento departamentoAtualizado = new Departamento(departamento.getId(), departamento.getNome(), departamento.getLocalizacao());
        departamentos.add(departamentoAtualizado);
        return departamentoAtualizado;

    }

        public List<Departamento> buscarPorNome(String nome) {
        return departamentos.stream()
                .filter(f -> f.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }
}