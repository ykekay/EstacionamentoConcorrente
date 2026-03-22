public class Carro extends Thread {
    //declara variaveis
    String modelo;
    String cor;
    int tempoEstacionado;

    //instancia uma lista de vagas
    Vagas listaVagas;

    //construtor
    public Carro(String modelo, String cor, int turnos, Vagas listaVagas) {
        this.modelo = modelo;
        this.cor = cor;
        this.tempoEstacionado = turnos * 1000;
        this.listaVagas = listaVagas;
    }


    @Override //sobrescreve o metodo nativo da biblioteca java
    public void run() {
        //tratamento de possiveis erros
        try {
            listaVagas.Preencher(this);     //preenche uma vaga com um carro
            Thread.sleep(tempoEstacionado);     //inicia cronometro com tempo que o carro fica na vaga
            listaVagas.Retirar(this);       //retira quando cronometro zera
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}