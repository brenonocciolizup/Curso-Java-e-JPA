package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {
	public static void main(String[] args) {
		//instanciando objetos e setando atributos
		Categoria categoria = new Categoria("viagem");
		Categoria categoria2 = new Categoria("negócios");
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem ao RJ");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		movimentacao.setCategoria(Arrays.asList(categoria, categoria2)); //cria uma lista com os parâmetros passados
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem à SP");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(400.0));
		movimentacao2.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);
		
		//criando EntityManager para realizar transação
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(categoria);
		em.persist(categoria2);
		
		em.persist(movimentacao);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
}
