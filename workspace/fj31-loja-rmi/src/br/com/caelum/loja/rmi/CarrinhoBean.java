package br.com.caelum.loja.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoBean extends UnicastRemoteObject implements Carrinho {

	private double total;
	private List<Livro> livros = new ArrayList<>();
	
	protected CarrinhoBean() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addLivro(Livro livro) throws RemoteException {
		livros.add(livro);
		total += livro.getPreco();
		
		System.out.printf("Livro %s adicionado com sucesso!\n", livro.getNome());
	}

	@Override
	public List<Livro> getLivros() throws RemoteException {
		return this.livros;
	}

	@Override
	public double getTotal() throws RemoteException {
		return this.total;
	}

}
