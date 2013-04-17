package br.com.caelum.loja.cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.com.caelum.loja.rmi.Carrinho;
import br.com.caelum.loja.rmi.CarrinhoFactory;
import br.com.caelum.loja.rmi.Livro;

public class ClienteLojaCarrinho {
	public static void main(String[] args) throws MalformedURLException,
			RemoteException, NotBoundException {
		
		CarrinhoFactory carrinhoFactory = (CarrinhoFactory) Naming
				.lookup("rmi://localhost:1099/loja/carrinhos");
		
		Carrinho carrinho = carrinhoFactory.create();
		
		Livro l1 = new Livro();
		l1.setNome("Pais e Filhos");
		l1.setPreco(100.0);
		
		Livro l2 = new Livro();
		l2.setNome("Noite brancas");
		l2.setPreco(200.0);
		
		carrinho.addLivro(l1);
		carrinho.addLivro(l2);
		
		System.out.println(carrinho.getTotal());
		
		System.out.println(carrinho.getClass());
		System.out.println(carrinho);
	}
}
