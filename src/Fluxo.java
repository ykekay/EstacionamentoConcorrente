import java.util.Scanner;

public class Fluxo {
    public void IniciarSistema() {
        Scanner teclado = new Scanner(System.in);
        Vagas vagas = new Vagas();
        Garagem garagem = new Garagem();
        int comando = 0;

        // Mostra o painel vazio logo de cara
        vagas.EXIBIR();
        System.out.println("\n>>> Digite 1 para Novo Carro | 3 para Sair: ");

        while (comando != 3) {
            if (teclado.hasNextInt()) {
                comando = teclado.nextInt();
                if (comando == 1) {

                    garagem.GerarCarroAleatorio(vagas).start();
                }
            }
        }
        System.exit(0);
    }
}