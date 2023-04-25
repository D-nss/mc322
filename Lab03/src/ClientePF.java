import java.time.LocalDate;

public class ClientePF extends Cliente{
	private String cpf;
	private LocalDate dataNascimento;
    private String educacao;
	private String genero;
	private String classeEconomica;
	private LocalDate dataLicenca;
	
    //Constructor
	public ClientePF ( String nome , String endereco , String dataLicenca , String educacao , String genero , String classeEconomica, String cpf , String dataNascimento ) {
		 super ( nome , endereco);
         this.dataLicenca = LocalDate.parse(dataLicenca);
		 this.educacao = educacao;
		 this.genero = genero;
		 this.classeEconomica = classeEconomica;
		 this.cpf = cpf ;
		 this.dataNascimento = LocalDate.parse(dataLicenca);
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

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
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
		return "\nNome:" + getNome() + "\nEndereco:" + getEndereco() + "\nData da licenca:" + getDataLicenca() + "\nEducacao:" + getEducacao() + "\nGenero:" + getGenero() + "\nClasse economica:" + getClasseEconomica() + "\nLista de veiculos:" + getListaVeiculos() + "\nCPF:" + getCpf() + "\nData de nascimento:" + getDataNascimento();
	}
	
}
