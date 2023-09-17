package Tde2;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    Pilha torre1;
    Pilha torre2;
    Pilha torre3;

    Scanner scanner = new Scanner(System.in);
    int quantidadeJogadas = 0;

    public Jogo(int capacidade) {
        torre1 = new Pilha(capacidade);
        torre2 = new Pilha(capacidade);
        torre3 = new Pilha(capacidade);
    }

    void iniciarJogo() {
        while (!torre1.pilhaCheia()) {
            Random random = new Random();
            torre1.push(random.nextInt(100));
        }
        torre1.imprimePilha();
    }

    boolean movimentacao(Pilha pilhaOrigem, Pilha pilhaDestino) {
        quantidadeJogadas++;
        if (!pilhaOrigem.PilhaVazia()) {
            var valor = pilhaOrigem.pop();
            if (!pilhaDestino.push(valor)) {
                pilhaOrigem.push(valor);
            } else {
                validaFimJogo();
            }
            return true;
        } else {
            return false;
        }
    }

    public int menu1() {
        System.out.println("Olá, escolha uma das opções do menu abaixo: ");
        System.out.println("\n|0 - sair do jogo|");
        System.out.println("|1 - movimentar|");
        return scanner.nextInt();
    }


    public void menuInicial() {
        int opcaoEscolhida = menu1();
        while (opcaoEscolhida != 0) {
            if (opcaoEscolhida == 0) {
                System.out.println("Fim");
                System.exit(0);
            } else if (opcaoEscolhida == 1) {
                menuMovimentacao();
            } else {
                System.out.println("Opção inválida");
            }
            opcaoEscolhida = menu1();
        }
    }

    public void menuMovimentacao() {
        int acao = acaoMovimentacao();
        while (acao != 0) {
            if (acao == 1) {
                movimentacao(torre1, torre2);
            } else if (acao == 2) {
                movimentacao(torre1, torre3);
            } else if (acao == 2) {
                movimentacao(torre1, torre3);
            } else if (acao == 3) {
                movimentacao(torre2, torre1);
            } else if (acao == 4) {
                movimentacao(torre2, torre3);
            } else if (acao == 5) {
                movimentacao(torre3, torre1);
            } else if (acao == 6) {
                movimentacao(torre3, torre2);
            } else if (acao == 0) {
                System.out.println("Opção inválida");
            } else {
                System.out.println("Opção inválida");
            }
            imprimirPilhas();
            acao = acaoMovimentacao();
        }
    }

    public int acaoMovimentacao() {
        System.out.println("Escolha uma movimentação: ");
        System.out.println("0 - Voltar para o menu anterior");
        System.out.println("1 - De torre 1 para torre 2");
        System.out.println("2 - De torre 1 para torre 3");
        System.out.println("3 - De torre 2 para torre 1");
        System.out.println("4 - De torre 2 para torre 3");
        System.out.println("5 - De torre 3 para torre 1");
        System.out.println("6 - De torre 3 para torre 2");

        return scanner.nextInt();
    }

    private void validaFimJogo() {
        if (torre2.pilhaCheia() || torre3.pilhaCheia()) {
            System.out.println("Parabéns, jogo concluído.");
            System.out.println("Ordenação concluída em " + quantidadeJogadas + " jogadas.");
            imprimirPilhas();
            System.exit(0);
        }
    }

    public void imprimirPilhas() {

        System.out.println("------IMPRESÃO DA PILHA 1-----");
        torre1.imprimePilha();
        System.out.println("-----------Fim---------------");
        System.out.println("------IMPRESÃO DA PILHA 2-----");
        torre2.imprimePilha();
        System.out.println("-----------Fim---------------");
        System.out.println("------IMPRESÃO DA PILHA 3-----");
        torre3.imprimePilha();
        System.out.println("-----------Fim---------------");
    }

    public void solucaoAutomatica() {
        int automatica = movimentacaoAutomatica();
        while (automatica != 1) {
            if (automatica == 3){
                movimentacao(torre1, torre3);
                movimentacao(torre1, torre2);
                movimentacao(torre3, torre2);
                movimentacao(torre1, torre3);
                movimentacao(torre2, torre1);
                movimentacao(torre2, torre3);
                movimentacao(torre1, torre3);
            } else if (automatica == 4){
                movimentacao(torre1, torre3); //1
                movimentacao(torre1, torre2);            //2
                movimentacao(torre3, torre2) ;               //3
                movimentacao(torre1, torre3);  //4
                movimentacao(torre2, torre1);                //5
                movimentacao(torre2, torre3);                //6
                movimentacao(torre1, torre3) ;               //7
                movimentacao(torre1, torre2) ;               //8
                movimentacao(torre3, torre2) ;               //9
                movimentacao(torre3,torre1) ;               //10
                movimentacao(torre2, torre1)   ;             //11
                movimentacao(torre1, torre2)  ;              //12
                movimentacao(torre1, torre3)  ;              //13
                movimentacao(torre2, torre3)  ;              //14
                movimentacao(torre2, torre1)  ;              //15
                movimentacao(torre3, torre2)  ;              //16
                movimentacao(torre3, torre1) ;               //17
                movimentacao(torre2, torre1)  ;              //18
                movimentacao(torre2, torre3)  ;              //19
                movimentacao(torre1, torre3)     ;           //20
                movimentacao(torre1, torre2)    ;            //21
                movimentacao(torre3, torre2)    ;            //22
                movimentacao(torre1, torre3)     ;           //23
                movimentacao(torre2, torre1)    ;            //24
                movimentacao(torre2, torre3)    ;            //25
                movimentacao(torre1, torre3)    ;            //25
            } else if (automatica == 5){


            }
            imprimirPilhas();
            automatica = movimentacaoAutomatica();
        }
    }

    //
    public int movimentacaoAutomatica() {
        System.out.println("Digite 1 caso não deseje uma solução automática");
        System.out.println(" 3 Tamanho: 3");
        System.out.println(" 4 para tamanho 4");
        System.out.println(" 5 para tamanho 5");
        System.out.println("");
        System.out.println("Digite 2 caso deseje preencher as pilhas automáticamente");

        return scanner.nextInt();

    }
}





