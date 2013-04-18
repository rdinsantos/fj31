 package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteTestaTransacaoException {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();

		GerenciadorLoja gerenciador = (GerenciadorLoja) ic
				.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLivroBean!br.com.caelum.loja.session.GerenciadorLoja");
		
		Livro livro = new Livro();
		livro.setNome("Transações com JEE");
		livro.setPreco(100.0);
		
		gerenciador.salva(livro);
	}
}