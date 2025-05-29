package com.italo.sistema_rh.service;

import com.italo.sistema_rh.model.Departamento;
import com.italo.sistema_rh.repository.DepartamentoRepository;

import java.util.List;

public class DepartamentoService {
    private DepartamentoRepository departamentoRepository = new DepartamentoRepository();

    public Departamento salvar(Departamento departamento) {
        return departamentoRepository.salvar(departamento);
    }

    public Departamento buscarPorId(Long id) {
        return departamentoRepository.buscarPorId(id);
    }

    public List<Departamento> listarTodos() {
        return departamentoRepository.listarTodos();
    }

    public void remover(Long id) {
        departamentoRepository.remover(id);
    }

    public Departamento atualizDepartamento(Departamento departamento) {
        return departamentoRepository.atualizarDepartamento(departamento);
    }
}