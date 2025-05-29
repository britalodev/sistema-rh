package com.italo.sistema_rh.controller;

import com.italo.sistema_rh.model.Departamento;
import com.italo.sistema_rh.service.DepartamentoService;

import java.util.List;

public class DepartamentoController {
    private DepartamentoService departamentoService = new DepartamentoService();

    public Departamento salvar(Departamento departamento) {
        return departamentoService.salvar(departamento);
    }

    public Departamento buscarPorId(Long id) {
        return departamentoService.buscarPorId(id);
    }

    public List<Departamento> listarTodos() {
        return departamentoService.listarTodos();
    }

    public void remover(Long id) {
        departamentoService.remover(id);
    }

    public Departamento atualizarDepartamento(Departamento departamento) {
        return departamentoService.atualizDepartamento(departamento);
    }
}