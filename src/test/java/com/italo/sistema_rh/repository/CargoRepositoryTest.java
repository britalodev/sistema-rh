package com.italo.sistema_rh.repository;

import com.italo.sistema_rh.model.Cargo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CargoRepositoryTest {
    
    private CargoRepository cargoRepository;
    
    @Before
    public void setUp() {
        cargoRepository = new CargoRepository();
    }
    
    @Test
    public void deveSalvarCargo() {
        // Given
        Cargo cargo = new Cargo(null, "Desenvolvedor", "Desenvolvedor Java");
        
        // When
        Cargo cargoSalvo = cargoRepository.salvar(cargo);
        
        // Then
        assertNotNull(cargoSalvo.getId());
        assertEquals("Desenvolvedor", cargoSalvo.getNome());
        assertEquals("Desenvolvedor Java", cargoSalvo.getDescricao());
    }
    
    @Test
    public void deveBuscarCargoPorId() {
        // Given
        Cargo cargo = new Cargo(null, "Analista", "Analista de Sistemas");
        Cargo cargoSalvo = cargoRepository.salvar(cargo);
        
        // When
        Cargo cargoEncontrado = cargoRepository.buscarPorId(cargoSalvo.getId());
        
        // Then
        assertNotNull(cargoEncontrado);
        assertEquals(cargoSalvo.getId(), cargoEncontrado.getId());
        assertEquals("Analista", cargoEncontrado.getNome());
    }
    
    @Test
    public void deveRetornarNullQuandoCargoNaoExistir() {
        // When
        Cargo cargoEncontrado = cargoRepository.buscarPorId(999L);
        
        // Then
        assertNull(cargoEncontrado);
    }
    
    @Test
    public void deveListarTodosCargos() {
        // Given
        cargoRepository.salvar(new Cargo(null, "Dev", "Desenvolvedor"));
        cargoRepository.salvar(new Cargo(null, "QA", "Quality Assurance"));
        
        // When
        List<Cargo> cargos = cargoRepository.listarTodos();
        
        // Then
        assertEquals(2, cargos.size());
    }
    
    @Test
    public void deveRemoverCargo() {
        // Given
        Cargo cargo = cargoRepository.salvar(new Cargo(null, "Gerente", "Gerente de Projetos"));
        
        // When
        cargoRepository.remover(cargo.getId());
        
        // Then
        Cargo cargoRemovido = cargoRepository.buscarPorId(cargo.getId());
        assertNull(cargoRemovido);
    }
    
    @Test
    public void deveAtualizarCargo() {
        // Given
        Cargo cargo = cargoRepository.salvar(new Cargo(null, "Dev Jr", "Desenvolvedor Junior"));
        Cargo cargoParaAtualizar = new Cargo(cargo.getId(), "Dev Sr", "Desenvolvedor Senior");
        
        // When
        Cargo cargoAtualizado = cargoRepository.atualizarCargo(cargoParaAtualizar);
        
        // Then
        assertNotNull(cargoAtualizado);
        assertEquals(cargo.getId(), cargoAtualizado.getId());
        assertEquals("Dev Sr", cargoAtualizado.getNome());
        assertEquals("Desenvolvedor Senior", cargoAtualizado.getDescricao());
    }
    
    @Test
    public void deveRetornarNullAoTentarAtualizarCargoInexistente() {
        // Given
        Cargo cargoInexistente = new Cargo(999L, "Inexistente", "Cargo que não existe");
        
        // When
        Cargo resultado = cargoRepository.atualizarCargo(cargoInexistente);
        
        // Then
        assertNull(resultado);
    }

    @Test
    public void deveBuscarCargoPorNome() {
        // Given
        cargoRepository.salvar(new Cargo(null, "Desenvolvedor Java", "Desenvolvedor"));
        cargoRepository.salvar(new Cargo(null, "Analista de Sistemas", "Analista"));

        // When
        List<Cargo> cargosEncontrados = cargoRepository.buscarPorNome("Analista");

        // Then
        assertEquals(1, cargosEncontrados.size());
        assertEquals("Analista de Sistemas", cargosEncontrados.get(0).getNome());
    }
}