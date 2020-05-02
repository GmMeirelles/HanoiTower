package Hanoi_Tower;

/**
 * Pilha From HanoiTower
 * @author aarth
 */
public class Pilha {
    private int[] vetor;
    private int topo;
// Construtor
    public Pilha( int MaxSize) {
        vetor = new int[MaxSize];
        topo = -1;
   }
   
// Verificador Pilha Cheia
    public boolean isFull () {
        return ( topo == vetor . length -1) ;
        
    }
// Empilha
    public void push ( int elemento ) {
        if ( isFull () == false ) {
        topo ++;
        vetor [ topo ] = elemento ;
        }
    }
// Verifica se a pilha esta vazia
    public boolean isEmpty () {
        return (topo == -1) ;
    }
// Desempilha
    public int pop () {
    if( isEmpty () == false ) {
        int elemento = vetor [ topo ];
        topo --;
        return elemento ;
     } else {
        return -1;
        }
    }

// Mostra o elemento do topo
    public int peek () {
     if( isEmpty () == false ) {
            return vetor [ topo ];
     } else {
            return -1;
        }
    }
    
    public int peekPosition (int position ) {
        if( isEmpty () || position > topo ) {
            return -1;
        } else {
             return vetor [ position ];
            }
        }

 // mostra quantos elemetos tem na pilha
 public int size () {
 return topo + 1;
 }

    // imprime os elementos do topo ate o inicio
    public void print () {
        if( isEmpty () ) {
            System . out . println (" Pilha vazia ") ;
        }
        else {
            for ( int i = topo ; i >= 0; i --) {
               System . out . println ( vetor [ i ]) ;
            }
        }
    }
}
