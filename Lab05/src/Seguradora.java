import java.util.LinkedList;

public class Seguradora {
	static LinkedList<Seguradora> listaSeguradora = new LinkedList<Seguradora>();
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private LinkedList<Cliente> listaClientes;
	private LinkedList<Seguro> listaSeguros;
	private final String cnpj; 
	
	//Constructor
    public Seguradora ( String nome , String telefone , String email , String endereco, String cnpj) {
        this.nome = nome ;
		this.cnpj = cnpj;
        this.telefone = telefone ;
        this.email = email ;
        this.endereco = endereco ;
        this.listaClientes = new LinkedList<Cliente>();
        this.listaSeguros = new LinkedList<Seguro>();
        }
	
	 // Getters e setters
	 public String getNome () {
	 return nome;
	 }

	 public String getCnpj () {
		return cnpj;
		}
	
	 public void setNome ( String nome ) {
		this.nome = nome;
	 }
	
	 public String getTelefone () {
	 return telefone;
	 }
	
	 public void setTelefone ( String telefone ) {
		 this.telefone = telefone;
	 }
	
	 public String getEmail () {
	 return email;
	 }
	
	 public void setEmail ( String email ) {
		 this.email = email;
	 }
	
	 public String getEndereco () {
		 return endereco;
	 }
	
	 public void setEndereco ( String endereco ) {
		 this.endereco = endereco;
	 }
	
	 public String toString() {
			return "\nNome:" + getNome() +"\ncnpj:" + getCnpj()+ "\nTelefone:" + getTelefone() + "\nEmail:" + getEmail() + "\nEndereco:" + getEndereco() +"\nLista Clientes:" + getListaClientes() +"\nLista Seguros:" + getListaSeguros();
	}

	public LinkedList<Cliente> getListaClientes() {
		return this.listaClientes;
	}

	public void setListaClientes(LinkedList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public LinkedList<Seguro> getListaSeguros() {
		return listaSeguros;
	}

	public void setListaSeguros(LinkedList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}

	
	
	public Cliente buscarCliente(String nome){
		for(Cliente clientes: listaClientes){
			if (clientes.getNome().equals(nome))
				return clientes;
			}
		return null;
	}




	static public Seguradora buscarSeguradora(String nome){
		for(Seguradora seg: Seguradora.listaSeguradora){
			if (seg.getNome().equals(nome))
				return seg;
			}
		return null;
	}


	/*public void listarVeiculo(){
		for(Cliente clientes: listaClientes){
			System.out.println(clientes.getListaVeiculos());		
			}
		
	}

	public void listarVeiculosCliente(String nome){
		for (Cliente indice : listaClientes) {
			if(indice.getNome().equals(nome))
			System.out.println(indice.getListaVeiculos());
		}
	}*/

	public boolean cadastrarCliente(Cliente cliente) {
        //cadastra cliente e reotna um boolean
		return this.getListaClientes().add(cliente);
		
	}

	public boolean gerarSeguro(Seguro seguro) {
		return this.getListaSeguros().add(seguro);
		
	}
	
	
	public boolean removerCliente(String cliente) {
        //remove cliente e reotna um boolean
		int i=0;
		for(Cliente indice : listaClientes) {
			if(indice.getNome() == cliente) {
				listaClientes.remove(i);
			}
			i++;
		}
				return true;
			
		
	}

	public boolean cancelarSeguro(int id) {
		int i=0;
		for(Seguro indice : listaSeguros) {
			if(indice.getId() == id) {
				listaSeguros.remove(i);
			}
			i++;
		}
				return true;
			
		
	}

	/*public boolean removerSinistro(int sin) {
        //remove cliente e reotna um boolean
		int i=0;
		for(Sinistro indice : listaSinistros) {
			if(indice.getId() == sin) {
				listaSinistros.remove(i);
			}
			i++;
		}
				return true;
			
		
	}*/


	
	public void listarClientes(String tipoCliente){
        //lista clientes de um tipo
		LinkedList<Cliente> clientes = new LinkedList<Cliente>();
		if (tipoCliente == "PF") {
			for(Cliente indice : listaClientes) {
				if(indice instanceof ClientePF) {
					clientes.add(indice);
				}
			}
		}
		else  {
			for(Cliente indice : listaClientes) {
				if(indice instanceof ClientePJ) {
					clientes.add(indice);
				}
			}
		}
		System.out.println(clientes);
	}
	
	public boolean gerarSinistro(String data, String endereco, Condutor condutor, Seguro seguro) {
        //gera um sinistro
		
		seguro.getListaSinistros().add(new  Sinistro (data, endereco, seguro, condutor));
		return true;
	}
	
	/*public boolean visualizarSinistro() {
        //imprime os sinistros de um cliente
		System.out.print("\nQuem é o dono do carro para visualizar o sinistro?\n");
		String cliente = AppMain.lerStr();
		int teste = 0;
		for (Sinistro indice : listaSinistros) {
			if(indice.getCliente().getNome() == cliente);{
				System.out.println(indice.toString());
				teste = 1;
			}
		}
		if(teste == 1)
			return true;
		else
			return false;
	}

	public int qtdSinistro(Cliente cliente) {
		int teste = 0;
		for (Sinistro indice : listaSinistros) {
			if(indice.getCliente() == cliente);{
				teste += 1;
			}
		}
		
			return teste;
	}
	
	public void listarSinistros(){
		System.out.print("\nLista de sinistros:\n");
		for (Sinistro indice : listaSinistros) {
			System.out.println(indice.toString());
		}
	}

	public void listarSinistrosCliente(String nome){
        //imprime todos os sinistros
		for (Sinistro indice : listaSinistros) {
			if(indice.getCliente().getNome().equals(nome))
			System.out.println(indice.toString());
		}
	}

	public void calcularReceita(){
		double soma = 0;
		for(Cliente clientes: listaClientes){
			clientes.setValorSeguro(this.buscarCliente(nome).calculaScore () * (1 + qtdSinistro(this.buscarCliente(nome))));
			soma += clientes.getValorSeguro();
			}
			System.out.println("RECEITA: " + soma+ "RS");
	}

	public void calcularPrecoSeguroCliente(String nome){
		this.buscarCliente(nome).setValorSeguro(this.buscarCliente(nome).calculaScore () * (1 + qtdSinistro(this.buscarCliente(nome))));
	}*/

	public LinkedList < Seguro > getSegurosPorCliente ( Cliente cliente ) {
		LinkedList < Seguro > segurosCliente = new LinkedList <Seguro>() ;
			for (Seguro seguro : listaSeguros) {
				if ( seguro.getCliente().equals(cliente)) {
					segurosCliente.add(seguro);
					}
			}
		return segurosCliente ;
		}
}

