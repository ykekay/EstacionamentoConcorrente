import java.util.Random;

public class Garagem {
    private Random randomizador = new Random();

    public Carro GerarCarroAleatorio(Vagas vagas) {

        //instancia duas listas com modelos randomiza a escolha e o retorna
        String[] modelos = {"Civic", "Uno", "Ferrari", "Tesla", "Fusca", "Camaro", "Batmovel", "Van Misterio"};
        String[] cores = {"azul", "branco", "vermelho", "preto", "cromado", "amarelo", "cinza", "rosa"};

        //aleatoriza modelo e cor
        String modelo = modelos[randomizador.nextInt(modelos.length)];
        String cor = cores[randomizador.nextInt(cores.length)];

        //randomiza o tempo que o carro vai ficar na vaga
        int tempo = randomizador.nextInt(10) + 6; // de 6 a 16 seg

        return new Carro(modelo,cor, tempo, vagas);
    }
}