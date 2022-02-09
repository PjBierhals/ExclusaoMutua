package com.company;

import javax.swing.*;

public class Threads<carga> implements Runnable {
    private Produtos carga;
    private boolean descarregar;
    private boolean trocaCaminhao;



    public Threads(Produtos carga) {
        this.carga = carga;
        new Thread( this).start();
    }

    @Override
    public void run() {
        while(!descarregar){
            try {
                Thread.sleep(this.carga.getTempoDescarga());
                this.mudaCarga();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

private synchronized void mudaCarga(){
        switch (this.carga){
            case ARROZ:
                this.carga= Produtos.MILHO;
                break;
            case MILHO:
                this.carga= Produtos.SOJA;
                break;
            case SOJA:
                this.carga= Produtos.ARROZ;
                break;
            default:
                break;

        }
        this.trocaCaminhao=true;
        notify();
}

public synchronized void  esperarDescarregar(){
        while (!this.trocaCaminhao){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.trocaCaminhao=false;
}
    public Produtos getCarga() {
        return carga;
    }

    public synchronized void fecharEmpresa(){
        this.descarregar=true;
    }

}
