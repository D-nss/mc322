
import java.util.LinkedList;

public class Cliente {
	private String nome;
	private String endereco;
	private LinkedList<Veiculo> listaVeiculos;
	
	//Constructor
	public Cliente(String nome , String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new LinkedList<Veiculo>();
	}
	
	//Getters e setters
	public String getNome () {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getEndereco () {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LinkedList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(LinkedList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public String toString() {
		return "\nNome:" + getNome() + "\nEndereco:" + getEndereco() + "\nLista de veiculos:" + getListaVeiculos();
	}
}
