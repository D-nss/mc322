


abstract public class Cliente {
	private String nome;
	private String endereco;
	private String email;
	private String telefone;


	//Constructor
	public Cliente(String nome, String endereco, String email, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
	//Getters e setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	
	public String toString() {
		return "\nNome:" + getNome() + "\nEndereco:" + getEndereco() + "\nTelefone:" + getTelefone()+ "\nEmail:" + getEmail();
	}


}
