import java.time.LocalDate;
import java.util.LinkedList;

public class ClientePF extends Cliente{
	private String cpf;
	private LocalDate dataNascimento;
    private String educacao;
	private String genero;
	private LinkedList<Veiculo> listaVeiculos;
	


	//Constructor
	public ClientePF ( String nome , String endereco , String email, String telefone, String educacao , String genero , String cpf , String dataNascimento ) {
		 super ( nome , endereco, email, telefone);
         
		 this.educacao = educacao;
		 this.genero = genero;
		 this.cpf = cpf ;
		 this.dataNascimento = LocalDate.parse(dataNascimento);
		 this.listaVeiculos = new LinkedList<Veiculo>();
	 }
	
	public LinkedList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(LinkedList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public String getCpf () {
		return cpf;
	}
	
	public void setCpf (String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getDataNascimento () {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

    public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean cadastrarVeiculo(Veiculo veiculo) {
		return this.getListaVeiculos().add(veiculo);	
	}

	public boolean removerVeiculo(String placa) {
		int i=0;
		for(Veiculo indice : listaVeiculos) {
			if(indice.getPlaca() == placa) {
				listaVeiculos.remove(i);
			}
			i++;
		}
				return true;
			
		
	}

	@SuppressWarnings("unused")
	public boolean validarCPF() {
        //valida o cpf
		String novocpf = this.cpf.replace(".", "");
		novocpf = novocpf.replace("-", "");
		if(novocpf.length()!= 11) {
			return false;
		}
		for(int u = 0; u<10; u++) {
			if(novocpf.charAt(u) != novocpf.charAt(u+1)) {
				break;}
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

	public void Confere_cpf() {
        //informa se o cpf e valido
		if(this.validarCPF() == true) {
			System.out.println("Cpf valido!");
		}
		else
			System.out.println("Cpf invalido!");
	}
	
	@Override
	public String toString () {
		return "\n" + super.toString() + "\nEducacao:" + getEducacao() + "\nGenero:" + getGenero() + "\nLista de veiculos:" + getListaVeiculos() + "\nCPF:" + getCpf() + "\nData de nascimento:" + getDataNascimento();
	}

	
}
