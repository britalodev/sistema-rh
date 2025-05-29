package com.italo.sistema_rh.controller;

import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.service.CargoService;

import java.util.List;

public class CargoController {
    public CargoService cargoService = new CargoService();

    public Cargo salvar(Cargo cargo) {
        return cargoService.salvar(cargo);
    }

    public Cargo buscarPorId(Long id) {
        return cargoService.buscarPorId(id);
    }

    public List<Cargo> listarTodos() {
        return cargoService.listarTodos();
    }

    public void remover(Long id) {
        cargoService.remover(id);
    }

    public Cargo atualizarCargo(Cargo cargo) {
        return cargoService.atualizCargo(cargo);
    }

    public List<Cargo> buscarPorNome(String nome) {
        return cargoService.buscarPorNome(nome);
    }
}