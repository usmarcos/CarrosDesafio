package service;

import model.Carro;

public class CarroServiceImpl implements CarroService {
    /**
     * Se o carro não estiver ligado o método não faz nada, senão...
     * Se a soma da velocidade atual com a velocidade a mais for menor que a velocidade máxima,
     * esse será o valor atribuído à velocidade atual do carro. Se for maior, será atribuído à
     * velocidade atual a velocidade máxima.
     */
    public void acelerar(Carro carro, int velocidadeAMais) {
        if (!carro.isLigado()) return;
        carro.setVelocidadeAtual(Math.min(carro.getVelocidadeAtual() + velocidadeAMais, carro.getVelocidadeMaxima()));
    }

    /**
     * A função Math.max retorna o maior número entre os dois argumentos passados, nesse caso 0 e
     * carro.getVelocidadeAtual() - velocidadeAMenos. Isso significa que, se o resultado da subtração
     * carro.getVelocidadeAtual() - velocidadeAMenos for menor ou igual a zero, o método irá retornar 0,
     * o que significa que a velocidade do carro será definida como zero, ou seja, o carro estará parado.
     * Caso contrário, o método irá retornar o resultado da subtração, o que significa que a nova velocidade
     * do carro será essa quantidade.
     */
    @Override
    public void frear(Carro carro, int velocidadeAMenos) {
        carro.setVelocidadeAtual(Math.max(0, carro.getVelocidadeAtual() - velocidadeAMenos));
    }

    @Override
    public void ligar(Carro carro) {
        carro.setLigado(true);
    }

    @Override
    public void desligar(Carro carro) {
        if(carro.isLigado())return;
        carro.setLigado(false);
    }

    @Override
    public String estadoAtual(Carro carro) {
        return carro.toString();
    }
}
