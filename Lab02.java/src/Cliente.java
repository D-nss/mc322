
public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String endereco;
	private int idade;
	
	//Constructor
	public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.idade = idade;
	}
	
	//Getters e setters
	public String getNome () {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getCpf () {
		return cpf;
	}
	
	public void setCpf (String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento () {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEndereco () {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getIdade () {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void Confere_cpf() {
		if(this.validarCPF() == true) {
			System.out.println("Cpf valido!");
		}
		else
			System.out.println("Cpf invalido!");
	}
	
	public boolean validarCPF() {
		String novocpf = this.cpf.replace(".", "");
		novocpf = novocpf.replace("-", "");
		if(novocpf.length()!= 11) {
			return false;
		}
		for(int u = 0; u<10; u++) {
			if(novocpf.charAt(u) != novocpf.charAt(u+1))
				break;
			return false;
		}
		int soma = 0;
		int escalar = 10;
		for (int i = 0; i<9; i++) {
			if(novocpf.charAt(i)>57 || novocpf.charAt(i)<48) {
				return false;
			}
			soma+= escalar*(novocpf.charAt(i) -48);
			escalar--;}
		soma = soma*10%11;
		if (soma == 10 || soma == 0) {
			soma = 0;
			}
		if (soma != (novocpf.charAt(9) - 48)) {
			return false;
		}
		soma=0;
		escalar = 11;
		for (int i = 0; i<10; i++) {
			soma+= escalar*(novocpf.charAt(i) -48);
			escalar--;
			}
		soma = soma*10%(11);
		if (soma == 10 || soma == 0) {
			soma = 0;
			}
			if (soma != (novocpf.charAt(10) - 48)) {
				return false;
			}
			return true;
	}
	
	public String toString() {
		return "Nome:" + getNome() + "\nCpf:" + getCpf() + "\nData de Nascimento:" + getDataNascimento() + "\nIdade:" + getIdade() + "\nEndereco:" + getEndereco();
	}
}
