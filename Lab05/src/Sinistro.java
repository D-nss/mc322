import java.util.Random;
public class Sinistro {
	private final int id;
	private String  data;
	private String endereco;
	private Seguro seguro;
	private Condutor condutor;

	//Constructor
	public Sinistro (String data, String endereco,Seguro seguro, Condutor condutor) {
		Random random = new Random();
		int id = random.nextInt(999999999);
		this.id = id;
		this.data = data;
		this.endereco = endereco;
		this.seguro = seguro;
		this.condutor = condutor;
	}

	//Getters e setters
	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public int getId () {
		return id;
	}
	
	public String getData () {
		return data;
	}
	
	public void setData (String data) {
		this.data = data;
	}
	
	public String getEndereco () {
		return endereco;
	}
	
	public void setEndereco (String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return "\nID:" + getId() + "\nData:" + getData() + "\nEndereco:" + getEndereco(); //+ "\nSeguradora:" + getSeguradora().toString() + "\nVeiculo:" + getVeiculo().toString() + "\nCliente:" + getCliente().toString();
				
	}
}

