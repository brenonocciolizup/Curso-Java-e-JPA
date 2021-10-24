package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// criando objeto conta e setando atributos
		Conta conta = new Conta();
		conta.setTitular("Breno");
		conta.setNumero(1234);
		conta.setAgencia(4321);

		// inicia uma transa��o
		em.getTransaction().begin();
		// persistindo objeto conta
		em.persist(conta);
		// finaliza a transa��o
		em.getTransaction().commit();

	}
}
