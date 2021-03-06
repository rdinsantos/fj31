package br.com.caelum.loja.client.exemplo;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteGerenciadorPesquisa {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();

		GerenciadorLoja gerenciador = (GerenciadorLoja) ic
				.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLivroBean!br.com.caelum.loja.session.GerenciadorLoja");
		
		List<Livro> livros = gerenciador.buscaLivrosPeloNomeDoAutor("Fowler");
		
		for (Livro livro : livros) {
			System.out.println(livro.getNome());
		}
	}
}
