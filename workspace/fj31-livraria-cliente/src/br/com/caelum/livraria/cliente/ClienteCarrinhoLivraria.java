package br.com.caelum.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.livraria.ejb.Carrinho;
import br.com.caelum.livraria.modelo.Livro;

public class ClienteCarrinhoLivraria {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		
		Carrinho carrinho = (Carrinho) ic.lookup("ejb:livraria/livraria-ejb3/CarrinhoBean!br.com.caelum.livraria.ejb.Carrinho?stateful");
	
		Livro livro = new Livro();
		livro.setNome("Alice no País das Maravilhas");
		livro.setPreco(45.0);
		
		carrinho.addLivro(livro);
		
		System.out.println(carrinho.getTotal());
		carrinho.finalizaCompra();
	}
}
