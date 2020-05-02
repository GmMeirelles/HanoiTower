package Hanoi_Tower;

public class HanoiTower {

    //Criando variaveis que representam cada torre.
    private Pilha pinoA;
    private Pilha pinoB;
    private Pilha pinoC;

    //Criando construtor da classe
    public HanoiTower() {
        // declara uma pilha com tamanho 3
        pinoA = new Pilha(3);
        // insere disco de tamanho 3
        pinoA.push(3);
        // insere disco de tamanho 2
        pinoA.push(2);
        // insere disco de tamanho 1
        pinoA.push(1);
        // declara uma pilha com tamanho 3
        pinoB = new Pilha(3);
        // declara uma pilha com tamanho 3
        pinoC = new Pilha(3);
    }

    // Move disco de uma torre para outra
    public void move(char origem, char dest) {
        //Verifica se origem é igual ao destino
        if (origem == dest) {
            System.out.println("Origem igual ao destino, reveja suas escolhas.");
        } //Caso não seja, o jogador pode prosseguir e a movimento é feito.
        else {
            /*
             Após coletar a origem e destino eles são usados como parâmetro
             no switch case.
             */
            switch (origem) {
                //Caso o jogaor escolha como origem a torre A
                case 'A':
                    //Desempilhando a torre A e armazenando o valor em uma variavel
                    int auxA = pinoA.pop();

                    //Se o destino for B
                    if (dest == 'B') {
                        /*
                         Verifica se o prat desempilhado é menor do que o prato
                         já existente na torre ou se a torre está vazia.
                         */
                        if (auxA < pinoB.peek() || pinoB.peek() == -1) {
                            //Se atender as condições, empilha o prato na torre B
                            pinoB.push(auxA);
                        } //Se não atender as condições:
                        else {
                            //O prato volta para a torre de origem
                            pinoA.push(auxA);
                        }
                    } /*
                     Verifica se o prat desempilhado é menor do que o prato
                     já existente na torre ou se a torre está vazia.
                     */ else if (dest == 'C') {
                        if (auxA < pinoC.peek() || pinoC.peek() == -1) {
                            //Se atender as condições, empilha o prato na torre C
                            pinoC.push(auxA);
                        } else {
                            //O prato volta para a torre de origem
                            pinoA.push(auxA);
                        }
                    }
                    //Finaliza o switch case
                    break;

                //A MESMA LÓGICA SEGUE NOS OUTROS CASES ('B' & 'C')    
                case 'B':
                    int auxB = pinoB.pop();
                    if (dest == 'A') {
                        if (auxB < pinoA.peek() || pinoA.peek() == -1) {
                            pinoA.push(auxB);
                        } else {
                            System.out.println("Você tentou colocar um prato maior do que o já\nexistente na coluna.");
                            pinoB.push(auxB);
                        }
                    } else if (dest == 'C') {
                        if (auxB < pinoC.peek() || pinoC.peek() == -1) {
                            pinoC.push(auxB);
                        } else {
                            System.out.println("Você tentou colocar um prato maior do que o já\nexistente na coluna.");
                            pinoB.push(auxB);
                        }
                    }

                    break;
                case 'C':
                    int auxC = pinoC.pop();
                    if (dest == 'A') {
                        if (auxC < pinoA.peek() || pinoA.peek() == -1) {
                            pinoA.push(auxC);
                        } else {
                            System.out.println("Você tentou colocar um prato maior do que o já\nexistente na coluna.");
                            pinoC.push(auxC);
                        }
                    } else if (dest == 'B') {
                        if (auxC < pinoB.peek() || pinoB.peek() == -1) {
                            pinoB.push(auxC);
                        } else {
                            System.out.println("Você tentou colocar um prato maior do que o já\nexistente na coluna.");
                            pinoC.push(auxC);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    //Método que verifica se o jogador conseguiu atingir o objetivo proposto.  
    public void winVerif() throws InterruptedException {
        //Verifica se a torre C está cheia o que resulta no final do game.
        if (pinoC.isFull()) {
            //Animação de "PARABÉNS" para o jogagor saber que o jogo acabou.
            for (int i = 0; i < 1000; i++) {
                System.out.print("P");
                Thread.sleep(400);
                System.out.print(" A");
                Thread.sleep(400);
                System.out.print(" R");
                Thread.sleep(400);
                System.out.print(" A");
                Thread.sleep(400);
                System.out.print(" B");
                Thread.sleep(400);
                System.out.print(" É");
                Thread.sleep(400);
                System.out.print(" N");
                Thread.sleep(400);
                System.out.print(" S");
                Thread.sleep(700);
                this.clearConsole();
            }
        }
    }

    //Printa o estado atual das torres.
    public void print() {
        //Cria vetores para armazenar cada torre
        int[] vetorA = new int[3];
        int[] vetorB = new int[3];
        int[] vetorC = new int[3];

        //Printa organizadamente as torres para melhor vizualização do jogador
        for (int i = 2; i >= 0; i--) {
            vetorA[i] = pinoA.peekPosition(i);
            vetorB[i] = pinoB.peekPosition(i);
            vetorC[i] = pinoC.peekPosition(i);
            System.out.println(vetorA[i] + "  " + vetorB[i] + "   " + vetorC[i]);
        }
        System.out.println("A   B   C");
    }

    //Gambiarra criada para limpar o console kkk
    public void clearConsole() {
        for (int clear = 0; clear <= 100; clear++) {
            System.out.println("\n");
        }
    }
}
