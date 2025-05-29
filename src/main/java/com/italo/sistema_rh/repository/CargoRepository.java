package com.italo.sistema_rh.repository;

import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.model.Departamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CargoRepository {
    private List<Cargo> cargos = new ArrayList<>();
    private Long proximoId = 1L;

    public Cargo salvar(Cargo cargo) {
        cargo.setId(proximoId++);
        cargos.add(cargo);
        return cargo;
    }

    public Cargo buscarPorId(Long id) {
        return cargos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Cargo> listarTodos() {
        return new ArrayList<>(cargos);
    }

    public void remover(Long id) {
        cargos.removeIf(c -> c.getId().equals(id));
    }

    public Cargo atualizarCargo(Cargo cargo) {
        Cargo cargoBanco = buscarPorId(cargo.getId());
        if (Objects.isNull(cargoBanco)) {
            return null;
        }
        cargos.removeIf(x -> x.getId().equals(cargo.getId()));
        Cargo cargoAtualizado = new Cargo(cargo.getId(), cargo.getNome(), cargo.getDescricao());
        cargos.add(cargoAtualizado);
        return cargoAtualizado;

    }

    public List<Cargo> buscarPorNome(String nome) {
        return cargos.stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }
}