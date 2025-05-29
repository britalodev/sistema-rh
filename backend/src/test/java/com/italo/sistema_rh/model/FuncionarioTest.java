package com.italo.sistema_rh.model;

import com.italo.sistema_rh.model.Funcionario;
import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.model.Departamento;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FuncionarioTest {

    @Test
    public void deveCalcularIdadeCorretamente() {
        Funcionario funcionario = new Funcionario(
            1L, "Maria", "maria@example.com",
            new Cargo(1L, "Analista", "Analista de Sistemas"),
            new Departamento(1L, "RH", "Matriz"),
            LocalDate.of(2000, 1, 1),
            LocalDate.of(2020, 1, 1)
        );
        int idade = funcionario.getIdade();
        assertTrue(idade >= 24); // Depende do ano atual
    }

    @Test
    public void deveCalcularTempoDeEmpresaCorretamente() {
        Funcionario funcionario = new Funcionario(
            1L, "Maria", "maria@example.com",
            new Cargo(1L, "Analista", "Analista de Sistemas"),
            new Departamento(1L, "RH", "Matriz"),
            LocalDate.of(2000, 1, 1),
            LocalDate.of(2020, 1, 1)
        );
        int tempo = funcionario.getTempoDeEmpresa();
        assertTrue(tempo >= 4); // Depende do ano atual
    }
}