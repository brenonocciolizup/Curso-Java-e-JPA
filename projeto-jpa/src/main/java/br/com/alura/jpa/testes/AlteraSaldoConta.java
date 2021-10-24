package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//pegando ("achando") registro pela chave primária, que é o id 
		Conta contaBreno = em.find(Conta.class, 1);
		
		em.getTransaction().begin();
		
		contaBreno.setSaldo(20.00);
		
		em.getTransaction().commit();
	}
}
