import java.util.Random;
public class Sinistro {
	private int id;
	private String  data;
	private String endereco;
	
	//Constructor
	public Sinistro (String  data, String endereco) {
		Random random = new Random();
		int id = random.nextInt(999999999);
		this.id = id;
		this.data = data;
		this.endereco = endereco;
	}

	//Getters e setters
	public int getId () {
		return id;
	}
	
	public void setId (int id) {
		this.id = id;
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
		return "ID:" + getId() + "\nData:" + getData() + "\nEndereco:" + getEndereco();
				
	}
	
}
