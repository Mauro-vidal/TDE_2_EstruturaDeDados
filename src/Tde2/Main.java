package Tde2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o tamanho das pilhas: ");
        var capacidade = scanner.nextInt();
        Jogo jogo = new Jogo(capacidade);
        jogo.iniciarJogo();
        jogo.menuInicial();
       jogo.solucaoAutomatica();


    }
}
