package com.company;

public class Main {

    public static void main(String[] args) {

 Threads empresa = new Threads(Produtos.ARROZ);


 for (int i=0;i<10;i++){
     System.out.println("Caminhão "+(i+1)+" Carga de "+ empresa.getCarga()+ " descarregando...");
     empresa.esperarDescarregar();
 }
 empresa.fecharEmpresa();
 System.out.println("Fechou a Empresa so Amanhã");
    }
}
