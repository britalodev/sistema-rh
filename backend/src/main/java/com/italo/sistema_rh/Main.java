package com.italo.sistema_rh;

import com.italo.sistema_rh.controller.FuncionarioController;
import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.model.Departamento;
import com.italo.sistema_rh.model.Funcionario;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();

        // Criar um departamento
        Departamento departamento = new Departamento(1L, "TI", "São Paulo");

        // Criar um cargo
        Cargo cargo = new Cargo(1L, "Desenvolvedor", "Desenvolvedor Java");

        // Criar um funcionário
        Funcionario funcionario = new Funcionario(
            1L,
            "João",
            "joao@example.com",
            cargo,
            departamento,
            LocalDate.of(1990, 5, 10),
            LocalDate.of(2015, 3, 1)
        );

        // Salvar o funcionário
        funcionarioController.salvar(funcionario);

        // Listar todos os funcionários
        System.out.println(funcionarioController.listarTodos());
    }
}