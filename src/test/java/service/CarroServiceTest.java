package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;


public class CarroServiceTest {
    private CarroService carroService = new CarroServiceImpl();
    private Carro carro;
    private void criarCarro() {
        carro = new Carro("Azul", "Fiat", "Uno", 2015, 150);
    }

    @Test
    public void deveAcelerarCorretamente() {
        // Given
        criarCarro();

        // When
        carroService.ligar(carro);
        carroService.acelerar(carro, 10);

        // Then
        Assert.assertEquals(carro.getVelocidadeAtual(), 10);
    }

    @Test
    public void deveFreiarCorretamente() {
        // Given
        criarCarro();

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
        criarCarro();
        //Quando
        carroService.ligar(carro);
        //Então
        Assert.assertTrue(carro.isLigado());
    }

    @Test
    public void deveIniciarDesligado() {
        //Given
        criarCarro();
        //Quando
        carroService.acelerar(carro, 10);
        //Então
        Assert.assertFalse(carro.isLigado());
    }

    @Test
    public void naoDeveAcelerarDesligado() {
        //Given
        criarCarro();
        //Quando
        carroService.acelerar(carro, 10);
        //Então
        Assert.assertEquals(carro.getVelocidadeAtual(), 0);
    }

    @Test
    public void naoDeveTerVelocidadeMenorQueZero() {
        //Dado
        criarCarro();
        //Quando
        carroService.ligar(carro);
        carroService.frear(carro, 20);
        //Então
        Assert.assertEquals(carro.getVelocidadeAtual(), 0);
    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        //Given
        criarCarro();
        //When
        carroService.ligar(carro);
        carroService.acelerar(carro, 90);
        carroService.acelerar(carro, 150);
        //Then
        Assert.assertEquals(carro.getVelocidadeAtual(), carro.getVelocidadeMaxima());
    }

}

