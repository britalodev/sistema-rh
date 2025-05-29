package com.italo.sistema_rh.service;

import com.italo.sistema_rh.model.Cargo;
import com.italo.sistema_rh.repository.CargoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CargoServiceTest {
    
    @Mock
    private CargoRepository cargoRepository;
    
    private CargoService cargoService;
    
    @Before
    public void setUp() {
        cargoService = new CargoService();
        // Injeção manual do mock (vamos melhorar isso depois)
        cargoService.cargoRepository = cargoRepository;
    }
    
    @Test
    public void deveSalvarCargo() {
        // Given
        Cargo cargo = new Cargo(null, "Desenvolvedor", "Desenvolvedor Java");
        Cargo cargoSalvo = new Cargo(1L, "Desenvolvedor", "Desenvolvedor Java");
        when(cargoRepository.salvar(cargo)).thenReturn(cargoSalvo);
        
        // When
        Cargo resultado = cargoService.salvar(cargo);
        
        // Then
        assertNotNull(resultado);
        assertEquals(Long.valueOf(1L), resultado.getId());
        verify(cargoRepository).salvar(cargo);
    }
    
    @Test
    public void deveBuscarCargoPorId() {
        // Given
        Long id = 1L;
        Cargo cargo = new Cargo(id, "Analista", "Analista de Sistemas");
        when(cargoRepository.buscarPorId(id)).thenReturn(cargo);
        
        // When
        Cargo resultado = cargoService.buscarPorId(id);
        
        // Then
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        verify(cargoRepository).buscarPorId(id);
    }
    
    @Test
    public void deveListarTodosCargos() {
        // Given
        List<Cargo> cargos = Arrays.asList(
            new Cargo(1L, "Dev", "Desenvolvedor"),
            new Cargo(2L, "QA", "Quality Assurance")
        );
        when(cargoRepository.listarTodos()).thenReturn(cargos);
        
        // When
        List<Cargo> resultado = cargoService.listarTodos();
        
        // Then
        assertEquals(2, resultado.size());
        verify(cargoRepository).listarTodos();
    }
    
    @Test
    public void deveRemoverCargo() {
        // Given
        Long id = 1L;
        
        // When
        cargoService.remover(id);
        
        // Then
        verify(cargoRepository).remover(id);
    }
    
    @Test
    public void deveAtualizarCargo() {
        // Given
        Cargo cargo = new Cargo(1L, "Dev Sr", "Desenvolvedor Senior");
        Cargo cargoAtualizado = new Cargo(1L, "Dev Sr", "Desenvolvedor Senior");
        when(cargoRepository.atualizarCargo(cargo)).thenReturn(cargoAtualizado);
        
        // When
        Cargo resultado = cargoService.atualizCargo(cargo);
        
        // Then
        assertNotNull(resultado);
        assertEquals(cargo.getId(), resultado.getId());
        verify(cargoRepository).atualizarCargo(cargo);
    }
}