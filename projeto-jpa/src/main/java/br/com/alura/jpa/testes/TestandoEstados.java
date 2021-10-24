package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		//Estado Transient --> n�o tem v�nculo com a JPA, n�o tem id mas pode ser managed
		Conta conta = new Conta();
		conta.setTitular("Jos�");
		conta.setAgencia(121212);
		conta.setNumero(123456);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Transient -> Managed
		em.persist(conta);
		
		//Manged -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
	}

}
