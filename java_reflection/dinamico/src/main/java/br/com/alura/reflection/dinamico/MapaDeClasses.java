package br.com.alura.reflection.dinamico;

import java.util.Map;

public class MapaDeClasses {

    private Map<String,String> mapa;

    public Class getClass(String chave) throws Exception{
        String valor = mapa.get(chave);
        if(valor != null){
            return Class.forName(valor);
        }else{
            throw new RuntimeException("Chave inválida");
        }
    }
}
