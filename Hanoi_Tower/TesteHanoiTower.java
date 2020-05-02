/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hanoi_Tower;

import java.util.Scanner;

/**
 *
 * @author aarth
 */
public class TesteHanoiTower {

    public static void main(String[] args) throws InterruptedException {
        //Criando objeto da classe HanoiTower
        HanoiTower ht = new HanoiTower();
        //Criando objeto Scanner para coletar dados do jogador
        Scanner entrada = new Scanner(System.in);

        //Introução ao game
        System.out.println("==========WELCOME TO HANOI TOWER GAME==========\n");

        //Breve explicação do game
        System.out.println("Essa é a organização padrão\ntente passar os pratos para a última coluna.\nEspaço vazio é representado por -1. \n\nBoa sorte!");

        //Printando as torres sem nenhuma alteração
        ht.print();

        //Perguntando se o usuário deseja jogar
        System.out.println("\nDeseja iniciar o jogo?\n[1]Sim\n[2]Não");

        //Armazenando resposta em váriavel
        int start = entrada.nextInt();

        //Se ele quiser jogar, aqui se inicia o game.
        if (start == 1) {
            /*
             Criando variaveis Destino e Origem para serem colocadas de
             parametro no método move.
             */
            char dest, origem;

            System.out.println("Show, vamos lá");

            //Limpando o terminal e começando o jogo
            System.out.print("Iniciando o jogo, se prepare");
            for (int i = 0; i < 7; i++) {
                System.out.print(".");
                Thread.sleep(700);
            }
            /*
             Limpando o console (Gambiarra por não ter uma função
             em java que faça isso)
             */
            ht.clearConsole();

            //Perguntando para onde o jogador deseja mover o primeiro prato.
            System.out.println("Para onde deseja mover o primeiro prato?\nDigite a origem e destino.");

            //Váriavel que decide se o jogo está ou não em andamento.
            int continuar = 1;

            /*
             Enquanto continuar for igual a 1 o game continua, isso pode ser
             alterado na pergunta "Continuar?" ao final de fazer um movimento.      
             */
            while (continuar == 1) {
                //Printando estado atual das torres.
                ht.print();

                //Pedindo a torre de origem para o jogador.
                System.out.print("Origem: ");
                origem = entrada.next().charAt(0);

                //Pedindo a torre de destino.
                System.out.print("Destino: ");
                dest = entrada.next().charAt(0);

                //Usando o método move para fazer o deslocamento do prato.
                ht.move(origem, dest);

                //Limpando o console
                ht.clearConsole();

                //Estado da torre depois do movimento realizado.
                ht.print();

                //Perguntando se o jogador deseja continuar.
                System.out.println("Continuar?\n[1]Sim\n[2]Não");
                continuar = entrada.nextInt();

                //Limpando o console
                ht.clearConsole();

                //Verificando se o jogador atingiu o objetivo.
                ht.winVerif();
            }
        } //Caso o usuário não queira jogar e finalizar ali mesmo
        else {
            //Limpando o console e encerrando o game.
            ht.clearConsole();
            System.out.println("Ok, nos vemos na próxima");
        }
    }
}
