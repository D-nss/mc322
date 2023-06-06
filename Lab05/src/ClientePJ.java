import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.lang.model.util.ElementScanner6;

public class ClientePJ extends Cliente{
	private String cnpj;
	private LocalDate dataFundacao;
	private LinkedList<Frota> listaFrota;
	private int qtdeFuncionarios;
  
	//Constructor
	public ClientePJ ( String nome , String endereco , String cnpj , String dataFundacao, int qtd, String email , String telefone ) {
		 super ( nome , endereco, email, telefone);
		 this.setCnpj(cnpj) ;
		 this.setDataFundacao(LocalDate.parse(dataFundacao));
		 this.listaFrota = new LinkedList<Frota>();
		 this.qtdeFuncionarios = qtd;
	 }
	 public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	public LinkedList<Frota> getListaFrota() {
		return listaFrota;
	}

	public void setListaFrota(LinkedList<Frota> listaFrota) {
		this.listaFrota = listaFrota;
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
		return "\n" + super.toString() + "\nData Fundacao:" + getDataFundacao() + "\nCNPJ:" + getCnpj() + "\nLista frota:" + getListaFrota();
	}

	public boolean cadastrarFrota(Frota frota){
		return this.listaFrota.add(frota);
	}

	public LinkedList < Frota > getVeiculosPorFrota ( Frota frotas ) {
		LinkedList < Frota  > listaDeFrota= new LinkedList <Frota>() ;
			for (Frota frota : listaFrota) {
				if ( frota.equals(frotas)) {
					listaDeFrota.add(frota);
					}
			}
		return listaDeFrota ;
		}
	

	public boolean atualizarFrota(Frota frota, String code, ArrayList <Veiculo> lista){
		frota.setCode(code);
		frota.setListaVeiculos(lista);
		return true;
	}


	public int buscarVeiculo(Frota frota, Veiculo veiculo){
		int i=0;
		for(Veiculo ind: frota.getListaVeiculos()){
			if (ind.getPlaca().equals(veiculo.getPlaca()))
				break;
			else 
				i++;
			}
			return i;
	}

	public boolean atualizarFrota(Frota frota, String code, Veiculo veiculo){
		frota.setCode(code);
		frota.getListaVeiculos().remove(buscarVeiculo(frota, veiculo));
		return true;
	}
}

