import java.time.LocalDate;

public class ClientePJ extends Cliente{
	private String cnpj;
	private LocalDate dataFundacao;
	private int qtdeFuncionarios;
    //Constructor
	public ClientePJ ( String nome , String endereco , String cnpj , String dataFundacao, int qtd ) {
		 super ( nome , endereco);
		 this.setCnpj(cnpj) ;
		 this.setDataFundacao(LocalDate.parse(dataFundacao));
		 this.qtdeFuncionarios = qtd;
	 }

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public boolean validarCNPJ() {
        //valida a cnpj
		String novocnpj = this.cnpj.replace(".", "");
		novocnpj = novocnpj.replace("-", "");
		novocnpj = novocnpj.replace("/", "");
		int[] lista_1 = {5,4,3,2,9,8,7,6,5,4,3, 2};
		int[] lista_2 = {6,5,4,3,2,9,8,7,6,5,4,3, 2};
		if(novocnpj.length()!= 14) {
			return false;
		}
		int soma = 0;
		for (int i = 0; i<12; i++) {
			soma+= lista_1[i]*(novocnpj.charAt(i) -48);}
		soma = soma%11;
		if (soma <2 && novocnpj.charAt(12)!=0) {
			soma = 0;
			}
		else
			soma = 11-soma;
		if (soma != (novocnpj.charAt(12) - 48)) {
			return false;
		}
		
		soma= 0;
		
		for (int i = 0; i<13; i++) {
		soma+= lista_2[i]*(novocnpj.charAt(i) -48);}
		soma = soma%11;
		if (soma <2) {
			soma = 0;
			}
			else
				soma = 11-soma;
		if (soma != (novocnpj.charAt(13) - 48)) {
			return false;
		}
		return true;
	}
	
	public void Confere_cnpj() {
        //informa se a cnpj e valida
		if(this.validarCNPJ() == true) {
			System.out.println("Cnpj valido!");
		}
		else
			System.out.println("Cnpj invalido!");
	}

    @Override
	public String toString () {
		return "\nNome:" + getNome() + "\nEndereco:" + getEndereco() + "\nData Fundacao:" + getDataFundacao() + "\nCNPJ:" + getCnpj() + "\nLista de veiculos:" + getListaVeiculos();
	}

	public double calculaScore(){
	return CalcSeguro.VALOR_BASE.getFator() * (1 + (this.qtdeFuncionarios ) /100) * super.getListaVeiculos().size();
	}
}

