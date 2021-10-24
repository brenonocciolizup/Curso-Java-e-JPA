package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {

	public static void main(String[] args) {
		//cria objeto EntityManager por meio do objeto Persistence que referencia o nome do persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager(); // criando EntityManager
		
		emf.close();
	}

}
