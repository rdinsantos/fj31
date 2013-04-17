package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteCarrinhoStateless {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();

		Carrinho carrinho = (Carrinho) ic
				.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho");
		
		Livro livro = new Livro();
		livro.setNome("Pais e Filhos");
		livro.setPreco(100.0);
		
		carrinho.addLivro(livro);
		
		for(Livro l : carrinho.getLivros()) {
			System.out.println(l.getNome());
		}
	}
}
