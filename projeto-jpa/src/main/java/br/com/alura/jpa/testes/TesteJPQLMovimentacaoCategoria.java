package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Categoria categoria = new Categoria();
		categoria.setId(5L);
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);

		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movimentacoes = query.getResultList();
		
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Categoria: " + movimentacao.getCategoria());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}

}
