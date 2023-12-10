package com.mycompany.main;

public class Arvore_AVL {

    private No_AVL no;

    public Arvore_AVL() {
        this.no = null;
    }

    private No_AVL rotacaoDireita(No_AVL b) {
        No_AVL a = b.getEsquerda();
        No_AVL temp = a.getDireita();

        a.setDireita(b);
        b.setEsquerda(temp);
        b.setAltura(1 + Math.max(getAltura(b.getEsquerda()), getAltura(b.getDireita())));
        a.setAltura(1 + Math.max(getAltura(a.getEsquerda()), getAltura(a.getDireita())));
        return a;
    }

    private No_AVL rotacaoEsquerda(No_AVL a) {
        No_AVL b = a.getDireita();
        No_AVL temp = b.getEsquerda();

        b.setEsquerda(a);
        a.setDireita(temp);
        a.setAltura(1 + Math.max(getAltura(a.getEsquerda()), getAltura(a.getDireita())));
        b.setAltura(1 + Math.max(getAltura(b.getEsquerda()), getAltura(b.getDireita())));
        return b;
    }

    private int getAltura(No_AVL noAtual) {
        if (noAtual == null) {
            return 0;
        }
        return noAtual.getAltura();
    }

    private int getFatorEquilibrio(No_AVL noAtual) {
        if (noAtual == null) {
            return 0;
        }
        return getAltura(noAtual.getEsquerda()) - getAltura(noAtual.getDireita());
    }

    private No_AVL minValueNode(No_AVL noAtual) {
        No_AVL atual = noAtual;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }

    private No_AVL balancear(No_AVL noAtual, int valor) {
        noAtual.setAltura(1 + Math.max(getAltura(noAtual.getEsquerda()), getAltura(noAtual.getDireita())));

        int fatorEquilibrio = getFatorEquilibrio(noAtual);

        if (fatorEquilibrio > 1 && valor < noAtual.getEsquerda().getValor()) {
            return rotacaoDireita(noAtual);
        }

        if (fatorEquilibrio < -1 && valor > noAtual.getDireita().getValor()) {
            return rotacaoEsquerda(noAtual);
        }

        if (fatorEquilibrio > 1 && valor > noAtual.getEsquerda().getValor()) {
            noAtual.setEsquerda(rotacaoEsquerda(noAtual.getEsquerda()));
            return rotacaoDireita(noAtual);
        }

        if (fatorEquilibrio < -1 && valor < noAtual.getDireita().getValor()) {
            noAtual.setDireita(rotacaoDireita(noAtual.getDireita()));
            return rotacaoEsquerda(noAtual);
        }

        return noAtual;
    }

    public void inserir(int valor) {
        this.no = inserirRec(this.no, valor);
    }

    private No_AVL inserirRec(No_AVL noAtual, int valor) {
        if (noAtual == null) {
            return new No_AVL(valor);
        }
        if (valor < noAtual.getValor()) {
            noAtual.setEsquerda(inserirRec(noAtual.getEsquerda(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setDireita(inserirRec(noAtual.getDireita(), valor));
        } else {
            return noAtual;
        }
        
        return balancear(noAtual, valor);

    }

    public void remover(int valor) {
        this.no = removerRec(this.no, valor);
    }

    private No_AVL removerRec(No_AVL noAtual, int valor) {
        if (noAtual == null) {
            return noAtual;
        }

        if (valor < noAtual.getValor()) {
            noAtual.setEsquerda(removerRec(noAtual.getEsquerda(), valor));
        } else if (valor > noAtual.getValor()) {
            noAtual.setDireita(removerRec(noAtual.getDireita(), valor));
        } else {
            if (noAtual.getEsquerda() == null) {
                return noAtual.getDireita();
            } else if (noAtual.getDireita() == null) {
                return noAtual.getEsquerda();
            }
            No_AVL temp = minValueNode(noAtual.getDireita());
            noAtual.setValor(temp.getValor());
            noAtual.setDireita(removerRec(noAtual.getDireita(), temp.getValor()));
        }

        return balancear(noAtual, valor);
    }

    public void buscar(int valor) {
        buscarRec(this.no, valor);
    }

    private boolean buscarRec(No_AVL noAtual, int valor) {
        if (noAtual == null) {
            return false;
        }

        if (valor == noAtual.getValor()) {
            return true;
        }

        if (valor < noAtual.getValor()) {
            return buscarRec(noAtual.getEsquerda(), valor);
        } else {
            return buscarRec(noAtual.getDireita(), valor);
        }
    }
}
