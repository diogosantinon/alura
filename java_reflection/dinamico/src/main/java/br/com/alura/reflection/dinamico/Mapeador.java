package br.com.alura.reflection.dinamico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class Mapeador {

	private Map<Class<?>, Class<?>> mapa = new HashMap<Class<?>, Class<?>>();
	
	public void load(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(nomeArquivo));
		for(Object key : properties.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName((String) properties.get(key));
			//verifica se eh uma interface
			if(!interf.isInterface()) {
				throw new RuntimeErrorException(null,"Não é uma interface" + interf.getName());
			}
			
			//verfica se eh uma implementacao
			if(!interf.isAssignableFrom(impl)) {
				throw new RuntimeErrorException(null,"A classe " + impl.getName() + " não implementa " + interf.getName());
			}
			
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf) {
		return mapa.get(interf);
	}
}
