package Tde2;

public class Pilha {
    private int capacidade;
    private Integer topo;
    private int dados[];

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1;
        dados = new int[capacidade];
    }

    public int pop() {
        // remove
        if (!this.PilhaVazia()) {
            var valor = dados[topo];
            topo = topo - 1;
            return valor;
        } else {
            return - 1;
        }
    }

    public boolean push(int num) {
        // impilha, insere
        if (!this.pilhaCheia()) {
            if ((this.PilhaVazia() || dados[topo] > num)) {
                topo = topo + 1;
                dados[topo] = num;
                return true;
            }
        } else {
            System.out.println("A pilha está cheia");
        }
        return false;
    }

    public boolean pilhaCheia() {
        if (topo == dados.length - 1) {
            return true;
        }
        return false;
    }

    public boolean PilhaVazia() {
        if (topo == -1) {
            return true;
        }
        return false;

    }

    public void imprimePilha() {
        for (int i = topo; i >= 0; i--) {
            System.out.println(dados[i]);
        }
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public int[] getDados() {
        return dados;
    }

    public void setDados(int[] dados) {
        this.dados = dados;
    }

}



