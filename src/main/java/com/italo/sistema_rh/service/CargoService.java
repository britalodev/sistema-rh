package com.italo.sistema_rh.service;

import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.repository.CargoRepository;

import java.util.List;

public class CargoService {
    public CargoRepository cargoRepository = new CargoRepository();

    public Cargo salvar(Cargo cargo) {
        return cargoRepository.salvar(cargo);
    }

    public Cargo buscarPorId(Long id) {
        return cargoRepository.buscarPorId(id);
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
}