package com.italo.sistema_rh.controller;

import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.service.CargoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CargoControllerTest {

    @Mock
    private CargoService cargoService;

    @InjectMocks
    private CargoController cargoController;

    @Before
    public void setUp() {
        // Com @InjectMocks, não precisamos mais da injeção manual
    }

    @Test
    public void deveSalvarCargo() {
        // Given
        Cargo cargo = new Cargo(null, "Desenvolvedor", "Desenvolvedor Java");
        Cargo cargoSalvo = new Cargo(1L, "Desenvolvedor", "Desenvolvedor Java");
        when(cargoService.salvar(cargo)).thenReturn(cargoSalvo);

        // When
        Cargo resultado = cargoController.salvar(cargo);

        // Then
        assertNotNull(resultado);
        assertEquals(Long.valueOf(1L), resultado.getId());
        verify(cargoService).salvar(cargo);
    }

    @Test
    public void deveBuscarCargoPorId() {
        // Given
        Long id = 1L;
        Cargo cargo = new Cargo(id, "Analista", "Analista de Sistemas");
        when(cargoService.buscarPorId(id)).thenReturn(cargo);

        // When
        Cargo resultado = cargoController.buscarPorId(id);

        // Then
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        verify(cargoService).buscarPorId(id);
    }

    @Test
    public void deveListarTodosCargos() {
        // Given
        List<Cargo> cargos = Arrays.asList(
                new Cargo(1L, "Dev", "Desenvolvedor"),
                new Cargo(2L, "QA", "Quality Assurance")
        );
        when(cargoService.listarTodos()).thenReturn(cargos);

        // When
        List<Cargo> resultado = cargoController.listarTodos();

        // Then
        assertEquals(2, resultado.size());
        verify(cargoService).listarTodos();
    }

    @Test
    public void deveRemoverCargo() {
        // Given
        Long id = 1L;

        // When
        cargoController.remover(id);

        // Then
        verify(cargoService).remover(id);
    }

    @Test
    public void deveAtualizarCargo() {
        // Given
        Cargo cargo = new Cargo(1L, "Dev Sr", "Desenvolvedor Senior");
        Cargo cargoAtualizado = new Cargo(1L, "Dev Sr", "Desenvolvedor Senior");
        when(cargoService.atualizCargo(cargo)).thenReturn(cargoAtualizado);

        // When
        Cargo resultado = cargoController.atualizarCargo(cargo);

        // Then
        assertNotNull(resultado);
        assertEquals(cargo.getId(), resultado.getId());
        verify(cargoService).atualizCargo(cargo);
    }

    @Test
    public void deveBuscarCargoPorNome() {
        // Given
        String nome = "Analista";
        List<Cargo> cargos = Arrays.asList(new Cargo(1L, "Analista de Sistemas", "Analista"));
        when(cargoService.buscarPorNome(nome)).thenReturn(cargos);

        // When
        List<Cargo> resultado = cargoController.buscarPorNome(nome);

        // Then
        assertEquals(1, resultado.size());
        assertEquals("Analista de Sistemas", resultado.get(0).getNome());
        verify(cargoService).buscarPorNome(nome);
    }
}