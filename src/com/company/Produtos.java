package com.company;

public enum Produtos {
    ARROZ(300),SOJA(400),MILHO(4000);
    private int tempoDescarga;

    Produtos(int temopoDescarga){
        this.tempoDescarga=temopoDescarga;
    }

    public int getTempoDescarga() {
        return tempoDescarga;
    }
}
