package com.italo.sistema_rh.service;

import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.model.Departamento;
import com.italo.sistema_rh.repository.CargoRepository;

import java.util.List;

public class CargoService {
    public CargoRepository cargoRepository = new CargoRepository();

    public Cargo salvar(Cargo cargo) {
        return cargoRepository.salvar(cargo);
    }

    public Cargo buscarPorId(Long id) {
        return cargoRepository.buscarPorId(id).orElse(null);
    }

    public List<Cargo> listarTodos() {
        return cargoRepository.listarTodos();
    }

    public void remover(Long id) {
        cargoRepository.remover(id);
    }

    public Cargo atualizCargo(Cargo cargo) {
        return cargoRepository.atualizarCargo(cargo);
    }

    public List<Cargo> buscarPorNome(String nome) {
        return cargoRepository.buscarPorNome(nome);
    }
}