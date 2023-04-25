import java.util.LinkedList;

public class Seguradora {
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
	
		
	
	public LinkedList<Integer> buscaListaClientes(LinkedList<Cliente> lista, String cliente) {
        //busca na lista de clientes
		LinkedList<Integer> valores = new LinkedList<Integer>();
		int indice;
		for(indice = 0; indice<lista.size(); indice++) {
			if (lista.get(indice).getNome() == cliente) {
				@SuppressWarnings("removal")
				Integer integer_int = new Integer(indice);
				valores.add(integer_int);
				break;
			}
		}
		return valores;
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

	
	public LinkedList<Cliente> listarClientes(String tipoCliente){
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
		return clientes;
	}
	
	public boolean gerarSinistro(String data, String endereco,Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        //gera um sinistro
		this.getListaSinistros().add(new  Sinistro (data, endereco, seguradora, veiculo, cliente));
		return true;
	}
	
	public boolean visualizarSinistro(String cliente) {
        //imprime os sinistros de um cliente
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
	
	public LinkedList<Sinistro> listarSinistros(){
        //imprime todos os sinistros
		for (Sinistro indice : listaSinistros) {
			System.out.println(indice.toString());
		}
		return getListaSinistros();
	}
}

