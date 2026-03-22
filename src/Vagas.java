public class Vagas {
    private Carro[] listaDeVagas = new Carro[5];
    private int vagasDisponiveis = 5;

    //metodo pra colocar carro na vaga
    public synchronized void Preencher(Carro car) throws InterruptedException {

        while (vagasDisponiveis == 0) {
            System.out.println("(...) " + car.modelo + " está aguardando vaga...");
            wait();
        }


        for (int i = 0; i < listaDeVagas.length; i++) {
            if (listaDeVagas[i] == null) {
                listaDeVagas[i] = car;
                vagasDisponiveis--;

                atualizarPainel();
                break;
            }
        }
    }

    //percorre as vagas acha o carro que seja o mesmo e o retira
    public synchronized void Retirar(Carro car) {
        for (int i = 0; i < listaDeVagas.length; i++) {
            if (listaDeVagas[i] == car) {
                listaDeVagas[i] = null;
                vagasDisponiveis++;

                atualizarPainel();
                notifyAll();
                break;
            }
        }
    }

    //metodo que limpa o terminal e exibe
    private void atualizarPainel() {
        limparConsole();
        EXIBIR();
        System.out.println("\n>>> Digite 1 para Novo Carro | 3 para Sair: ");
    }

    //metodo que printa 50x " " para limpar o terminal
    private void limparConsole() {
        // Pula 50 linhas para "limpar" o terminal
        for (int i = 0; i < 50; i++) System.out.println();
    }

    //Exibe as informações do estacionamento
    public synchronized void EXIBIR() {
        System.out.println("==========================================");
        System.out.println("    PAINEL DO ESTACIONAMENTO (AO VIVO)    ");
        System.out.println("==========================================");
        for (int i = 0; i < listaDeVagas.length; i++) {
            String status = (listaDeVagas[i] == null) ? "[  LIVRE  ]" : "[ " + listaDeVagas[i].modelo + " ]";
            System.out.println(" Vaga " + (i + 1) + ": " + status);
        }
        System.out.println("==========================================");
    }
}