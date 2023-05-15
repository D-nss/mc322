
import java.util.LinkedList;

public class Cliente {
	private String nome;
	private String endereco;
	private LinkedList<Veiculo> listaVeiculos;
	private double valorSeguro;

	//Constructor
	public Cliente(String nome , String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new LinkedList<Veiculo>();
	}
	
	//Getters e setters

	public double getValorSeguro(){
	return valorSeguro;
	}

	public void setValorSeguro(double valor){
	this.valorSeguro = valor;
	}
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

	public boolean removerVeiculo(String placa) {
        //remove cliente e reotna um boolean
		int i=0;
		for(Veiculo indice : listaVeiculos) {
			if(indice.getPlaca() == placa) {
				listaVeiculos.remove(i);
			}
			i++;
		}
				return true;
			
		
	}

	public Veiculo buscarVeiculo(String nome){
		for(Veiculo carro: listaVeiculos){
			if (carro.getPlaca().equals(nome))
				return carro;
			}
		return null;
	}

	public double calculaScore(){
		return 1.00;
	}
}
