package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// criando objeto conta e setando atributos
		Conta conta = new Conta();
		conta.setTitular("Catarina");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(500.00);

		// inicia uma transação
		em.getTransaction().begin();
		// persistindo objeto conta
		em.persist(conta);
		// finaliza a transação
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = emf.createEntityManager();

		conta.setSaldo(500.0); //alteração não é realizada pois a transação já foi finalizada
		
		//abrimos uma transação e ralizamos o merge para atualizar a entidade e então conseguimos setar o saldo
		em2.getTransaction().begin();
		em2.merge(conta); //mudança de estado detached para managed
		em2.getTransaction().commit();

	}
}
