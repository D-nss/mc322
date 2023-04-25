import java.util.Random;
public class Sinistro {
	private final int id;
	private String  data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	//Constructor
	public Sinistro (String data, String endereco,Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		Random random = new Random();
		int id = random.nextInt(999999999);
		this.id = id;
		this.data = data;
		this.endereco = endereco;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.seguradora = seguradora;
	}

	//Getters e setters
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

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String toString() {
		return "\nID:" + getId() + "\nData:" + getData() + "\nEndereco:" + getEndereco(); //+ "\nSeguradora:" + getSeguradora().toString() + "\nVeiculo:" + getVeiculo().toString() + "\nCliente:" + getCliente().toString();
				
	}
}

