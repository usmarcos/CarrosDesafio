package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CarroServiceTest {
    private CarroService carroService = new CarroServiceImpl();
    private Carro carro;

    /**
     * Cria um novo carro sempre antes de iniciar os testes para validação
     */
    @Before
    public void inicializaNovoCarro() {
        carro = new Carro("Azul", "Fiat", "Uno", 2015, 150);
    }

    @Test
    public void deveAcelerarCorretamente() {
        //Given

        // When
        carroService.ligar(carro);
        carroService.acelerar(carro, 10);
        // Then
        Assert.assertEquals(carro.getVelocidadeAtual(), 10);
    }

    @Test
    public void deveFreiarCorretamente() {
        // Given

        // When
        carroService.ligar(carro);
        carroService.acelerar(carro, 10);
        carroService.frear(carro, 5);
        // Then
        Assert.assertEquals(carro.getVelocidadeAtual(), 5);
    }

    @Test
    public void deveLigarCorretamente() {
        //Given
        //When
        carroService.ligar(carro);
        //Then
        Assert.assertTrue(carro.isLigado());
    }

    @Test
    public void deveIniciarDesligado() {
        //Given
        //When
        carroService.acelerar(carro, 10);
        //Then
        Assert.assertFalse(carro.isLigado());
    }

    @Test
    public void naoDeveAcelerarDesligado() {
        //Given
        //When
        carroService.acelerar(carro, 10);
        //Then
        Assert.assertEquals(carro.getVelocidadeAtual(), 0);
    }

    @Test
    public void naoDeveTerVelocidadeMenorQueZero() {
        //Given
        //When
        carroService.ligar(carro);
        carroService.frear(carro, 20);
        //Then
        Assert.assertEquals(carro.getVelocidadeAtual(), 0);
    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        //Given
        //When
        carroService.ligar(carro);
        carroService.acelerar(carro, 90);
        carroService.acelerar(carro, 150);
        //Then
        Assert.assertEquals(carro.getVelocidadeAtual(), carro.getVelocidadeMaxima());
    }
    @Test
    public void naoDeveDesligarCarroEmMovimento(){
        //Given
        //When
        carroService.ligar(carro);
        carroService.acelerar(carro,1000);
        carroService.desligar(carro);
        //Then
        Assert.assertEquals(carro.getVelocidadeAtual(), carro.getVelocidadeMaxima());
        Assert.assertTrue(carro.isLigado());
    }
    @Test public void deveRetornarEstadoAtualCorretamente(){
        //Given

        //When
            //usando a variável apenas para ficar claro o when.
        String esperado = carroService.estadoAtual(carro);

        //Then
        Assert.assertEquals(esperado,carro.toString());
        //Assert.assertEquals(carroService.estadoAtual(carro),carro.toString());
    }
}

