package br.com.alura.avulsos;

    public class Reitor extends EmpregadoDaFaculdade {
         // informações extras
        String getInfo() {
            return super.getInfo() + " e ele é um reitor";
        }
         // não sobrescrevemos o getGastos!!!
    }