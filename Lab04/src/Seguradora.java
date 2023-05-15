import java.util.LinkedList;

public class Seguradora {
	static LinkedList<Seguradora> listaSeguradora = new LinkedList<Seguradora>();
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private LinkedList<Cliente> listaClientes;
	private LinkedList<Sinistro> listaSinistros; 
	
	//Constructor
    public Seguradora ( String nome , String telefone , String email , String endereco ) {
        this.nome = nome ;
        this.telefone = telefone ;
        this.email = email ;
        this.endereco = endereco ;
        this.listaClientes = new LinkedList<Cliente>();
        this.listaSinistros = new LinkedList<Sinistro>();
        }
	
	 // Getters e setters
	 public String getNome () {
	 return nome;
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
			return "\nNome:" + getNome() + "\nTelefone:" + getTelefone() + "\nEmail:" + getEmail() + "\nEndereco:" + getEndereco() +"\nLista Clientes:" + getListaClientes() +"\nLista Sinistros:" + getListaSinistros();
	}

	public LinkedList<Cliente> getListaClientes() {
		return this.listaClientes;
	}

	public void setListaClientes(LinkedList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public LinkedList<Sinistro> getListaSinistros() {
		return this.listaSinistros;
	}

	public void setListaSinistros(LinkedList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
	public Cliente buscarCliente(String nome){
		for(Cliente clientes: listaClientes){
			if (clientes.getNome().equals(nome))
				return clientes;
			}
		return null;
	}

	public void listarVeiculo(){
		for(Cliente clientes: listaClientes){
			System.out.println(clientes.getListaVeiculos());		
			}
		
	}

	public void listarVeiculosCliente(String nome){
		for (Cliente indice : listaClientes) {
			if(indice.getNome().equals(nome))
			System.out.println(indice.getListaVeiculos());
		}
	}

	public boolean cadastrarCliente(Cliente cliente) {
        //cadastra cliente e reotna um boolean
		return this.getListaClientes().add(cliente);
		
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

	public boolean removerSinistro(int sin) {
        //remove cliente e reotna um boolean
		int i=0;
		for(Sinistro indice : listaSinistros) {
			if(indice.getId() == sin) {
				listaSinistros.remove(i);
			}
			i++;
		}
				return true;
			
		
	}


	
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
	
	public boolean gerarSinistro(String data, String endereco,Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        //gera um sinistro
		this.getListaSinistros().add(new  Sinistro (data, endereco, seguradora, veiculo, cliente));
		return true;
	}
	
	public boolean visualizarSinistro() {
        //imprime os sinistros de um cliente
		System.out.print("\nQuem é o dono do carro para visualizar o sinistro?\n");
		String cliente = Lab04.lerStr();
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
	}
}

