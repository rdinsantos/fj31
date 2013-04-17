package br.com.caelum.livraria.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import br.com.caelum.livraria.modelo.Livro;

@Stateful
@Remote(Carrinho.class)
public class CarrinhoBean implements Carrinho {
	
	private List<Livro> livros = new ArrayList<>();
	private double total;

	@Override
	public void addLivro(Livro livro) {
		livros.add(livro);
		total += livro.getPreco();
		System.out.printf("Livro %s adicionado com sucesso!\n", livro.getNome());

	}

	@Override
	public List<Livro> getLivros() {
		return this.livros;
	}

	@Override
	public double getTotal() {
		return this.total;
	}

	@Override
	public void finalizaCompra() {
		System.out.println("Finalizando compra de: ");
		for (Livro livro : this.livros) {
			System.out.printf("\tLivro: %s - %f", livro.getNome(), livro.getPreco());
		}
	}
}
