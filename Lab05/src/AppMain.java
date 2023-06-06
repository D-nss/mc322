
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;
public class AppMain {

	static LinkedList<ClientePF> listaClientesPF = new LinkedList<ClientePF>();
	static LinkedList<ClientePJ> listaClientesPJ = new LinkedList<ClientePJ> ();
	static LinkedList<Veiculo> listaVeiculo = new LinkedList<Veiculo> ();

	public static String lerStr() {
        //lê uma string
		Scanner texto = new Scanner(System.in);
		String str;
		str =  texto.nextLine();
		return str;
	}

	static public Veiculo buscarVeiculo(String nome){
		for(Veiculo clientes: listaVeiculo){
			if (clientes.getPlaca().equals(nome))
				return clientes;
			}
		return null;
	}

	static public Seguro buscarSeguro(int nome, Seguradora seguradora){
		for(Seguro seguro: seguradora.getListaSeguros()){
			if (seguro.getId() == nome)
				return seguro;
			}
		return null;
	}

	static public Condutor buscarCondutor(String nome, Seguro seguro){
		for(Condutor condutor: seguro.getListaCondutores()){
			if (condutor.getNome().equals(nome))
				return condutor;
			}
		return null;
	}

	static public ClientePF buscarClientePF(String nome){
		for(ClientePF clientes: listaClientesPF){
			if (clientes.getNome().equals(nome))
				return clientes;
			}
		return null;
	}

	static public ClientePJ buscarClientePJ(String nome){
		for(ClientePJ clientes: listaClientesPJ){
			if (clientes.getNome().equals(nome))
				return clientes;
			}
		return null;
	}


	public static int lerInt() {
        //lê um int
		Scanner num = new Scanner(System.in);
		int numero;
		numero =  num.nextInt();
		return numero;
	}

	public static void lerClientePF(Seguradora seguradora){
        //lê um clientepf e instancia
		System.out.print("\nCriar ClientePF");
		System.out.print("\nNome:\n");
		String nome = lerStr();
		Validacao.Confere_nome(nome);
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		System.out.print("\nTelefone");
		String telefone = lerStr();
		System.out.print("\nEducacao:");
		String educacao = lerStr();
		System.out.print("\nGenero:");
		String genero = lerStr();
		System.out.print("\nEmail:");
		String email= lerStr();
		System.out.print("\nCPF:");
		String cpf = lerStr();
		Validacao.Confere_cpf(cpf);
		System.out.print("\nData de nascimento (no formato ano-mes-dia, exemplo: 2004-01-25):");
		String dataNascimento = lerStr();
		ClientePF clientePf = new ClientePF(nome, endereco, email, telefone, educacao, genero, cpf, dataNascimento);
		seguradora.cadastrarCliente(clientePf);
		listaClientesPF.add(clientePf);
	}

	public static void lerClientePJ(Seguradora seguradora){
        //lê um clientepj e instancia
		System.out.print("\nCriar ClientePJ");
		System.out.print("\nNome:\n");
		String nome = lerStr();
		Validacao.Confere_nome(nome);
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		System.out.print("\nEmail:");
		String email= lerStr();
		System.out.print("\nCNPJ:");
		String cnpj = lerStr();
		Validacao.Confere_cnpj(cnpj);
		System.out.print("\nTelefone");
		String telefone = lerStr();
		System.out.print("\nData de fundacao(no formato ano-mes-dia, exemplo: 2004-01-25):");
		String datafun = lerStr();
		System.out.print("\nQuantidade de funcionarios:");
		int qtd = lerInt();
		ClientePJ clientePj = new ClientePJ(nome, endereco, cnpj, datafun, qtd, email, telefone);
		seguradora.cadastrarCliente(clientePj);
		listaClientesPJ.add(clientePj);
	}

	public static void lerCondutor(Seguradora seguradora){
        //lê um clientepj e instancia
		System.out.print("\nCriar condutor");
		System.out.print("\nNome:\n");
		String nome = lerStr();
		System.out.print("\nData de Nascimento\n");
		String dataNasc = lerStr();
		Validacao.Confere_nome(dataNasc);
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		System.out.print("\nEmail:");
		String email= lerStr();
		System.out.print("\nCPF:");
		String cpf = lerStr();
		System.out.print("\nTelefone");
		String telefone = lerStr();
		Condutor condutor = new Condutor(cpf, LocalDate.parse(dataNasc), nome, endereco, telefone, email);
	}

	public static Seguradora lerSeguradora(){
        //lê uma seguradora e instancia
		System.out.print("\nCriar Seguradora");
		System.out.print("\nNome:");
		String nome = lerStr();
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		System.out.print("\nTelefone:");
		String telefone= lerStr();
		System.out.print("\nEmail:");
		String email = lerStr();
		System.out.print("\nCNPJ:");
		String cnpj = lerStr();
		Seguradora seguradora = new Seguradora(nome, telefone, email, endereco, cnpj);
		Seguradora.listaSeguradora.add(seguradora);
		return seguradora;
	}

	public static void lerSeguroPf(){ 
        //lê uma seguradora e instancia
		System.out.print("\nCriar Seguro");
		System.out.print("\nNome do cliente PF:");
		String cliente = lerStr();
		System.out.print("\nId:");
		int id = lerInt();
		System.out.print("\nData de início:(no formato ano-mes-dia, exemplo: 2004-01-25)");
		String dataini = lerStr();
		System.out.print("\nData de fim:(no formato ano-mes-dia, exemplo: 2004-01-25)");
		String datafim = lerStr();
		System.out.print("\nSeguradora:");
		String seguradoraString = lerStr();
		Seguro seguro = new SeguroPF(id, LocalDate.parse(dataini), LocalDate.parse(datafim), Seguradora.buscarSeguradora(seguradoraString), lerVeiculo(Seguradora.buscarSeguradora(seguradoraString)), buscarClientePF(cliente));
		Seguradora.buscarSeguradora(seguradoraString).getListaSeguros().add(seguro);
	}

	public static Frota lerFrota(Veiculo veiculo){
		System.out.print("\nCriar Frota");
		System.out.print("\nCodigo:");
		String codigo = lerStr();
		Frota frota = new Frota(codigo);
		frota.getListaVeiculos().add(veiculo);
		return frota;
	}

	public static void lerSeguroPJ(){ 
        //lê uma seguradora e instancia
		System.out.print("\nCriar Seguro");
		System.out.print("\nNome do cliente PF:");
		String cliente = lerStr();
		System.out.print("\nId:");
		int id = lerInt();
		System.out.print("\nData de início:(no formato ano-mes-dia, exemplo: 2004-01-25)");
		String dataini = lerStr();
		System.out.print("\nData de fim:(no formato ano-mes-dia, exemplo: 2004-01-25)");
		String datafim = lerStr();
		System.out.print("\nSeguradora:");
		String seguradoraString = lerStr();
		Seguro seguro = new SeguroPJ(id, LocalDate.parse(dataini), LocalDate.parse(datafim), Seguradora.buscarSeguradora(seguradoraString), lerFrota(lerVeiculo(Seguradora.buscarSeguradora(seguradoraString))), buscarClientePJ(cliente));
		Seguradora.buscarSeguradora(seguradoraString).getListaSeguros().add(seguro);
	}

	public static Veiculo lerVeiculo(Seguradora seguradora){
        //lê um veiculo e instancia
		System.out.print("\nCriar Veiculo");
		System.out.print("\nPlaca:");
		String placa = lerStr();
		System.out.print("\nMarca:");
		String marca = lerStr();
		System.out.print("\nModelo:");
		String modelo= lerStr();
		System.out.print("\nAno de Fabrocacao:");
		int ano = lerInt();
		Veiculo veiculo = new Veiculo(placa, marca, modelo, ano);
		System.out.print("\nQuem é o dono do carro?(digitar o nome do ciente)\n");
		String dono = lerStr();
		if(seguradora.buscarCliente(dono) instanceof ClientePF){
			buscarClientePF(dono).getListaVeiculos().add( veiculo);
		}
		listaVeiculo.add(veiculo);
		return veiculo;
	}

	public static boolean lerSinistro(Seguradora seguradora){
		System.out.print("\nQual é o nome do dono do carro para gerar o sinistro?\n");
		String dono = lerStr();
		System.out.print("\nQual é a placa carro para gerar o sinistro?\n");
		String carro = lerStr();
        //lê um sinistro e instancia
		System.out.print("\nCriar Sinistro");
		System.out.print("\nData:");
		String data = lerStr();
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		System.out.print("\nCondutor:");
		String condutor = lerStr();
		System.out.print("\nId do seguro:");
		int id = lerInt();
		Sinistro sinistro = new Sinistro(data, endereco, buscarSeguro(id, seguradora) , buscarCondutor(condutor, buscarSeguro(id, seguradora)));
		buscarCondutor(condutor, buscarSeguro(id, seguradora)).adicionarSinistro(sinistro);
		return true;
	}

	public static void main (String[] args) {
		Seguradora seguradora = lerSeguradora();
		lerCondutor(seguradora);
		lerSeguroPJ();
		lerSeguroPf();
		lerClientePF(seguradora);
		lerVeiculo(seguradora);

		lerClientePJ(seguradora);
		lerVeiculo(seguradora);

        //System.out.print("\nLista clientes pJ:");
		lerSinistro(seguradora);

		
		


		MenuOperacoes descricao = null;
		SubmenuOpcoes subdescricao = null;
		while (descricao != MenuOperacoes.SAIR){
		
			System.out.print("\nQual operação deseja realisar?\n");
		for(MenuOperacoes menu: MenuOperacoes.values()){
			System.out.print("\n-"+ menu + "\n");
		}
		descricao = MenuOperacoes.valueOf(lerStr());	


			switch (descricao)
			{ case CADASTROS:
				System.out.print("\nVocê clicou em " + descricao + "\nQual operação deseja realisar?\n");
			for(SubmenuOpcoes submenu: MenuOperacoes.CADASTROS.getSubmenu()){
				System.out.print("\n-"+ submenu + "\n");}
			subdescricao = SubmenuOpcoes.valueOf(lerStr());	;
				switch (subdescricao)
				{ 
					case CADASTRAR_CLIENTEPF:
						lerClientePF(seguradora);
					break;

					case CADASTRAR_CLIENTEPJ:
						lerClientePJ(seguradora);
					break;

					case CADASTRAR_SEGURADORA:
						seguradora = lerSeguradora();
						System.out.println("Você entrou em uma noma seguradora\n");
					break;

					case CADASTRAR_VEICULO:
						lerVeiculo(seguradora);
					break;

					case CADASTRAR_SEGUROPF:
						lerSeguroPf();
					break;

					case CADASTRAR_SEGUROPJ:
						lerSeguroPJ();
					break;

					case CADASTRAR_FROTA:
						System.out.print("\nPlaca:");
						String placa = lerStr();
						lerFrota(buscarVeiculo(placa));
					break;

					case CADASTRAR_CONDUTOR:
						lerCondutor(seguradora);
					break;

					case VOLTAR:
					
					break;

				
				}
			break;

			case LISTAR:
				System.out.print("\nVocê clicou em " + descricao + "\nQual operação deseja realisar?\n");
			for(SubmenuOpcoes submenu: MenuOperacoes.LISTAR.getSubmenu()){
				System.out.print("\n-"+ submenu + "\n");}
				subdescricao = SubmenuOpcoes.valueOf(lerStr());	
				switch (subdescricao)
					{ 
						case LISTAR_CLIENTES:
							System.out.print("\n PF ou PJ?\n");
							String tipo = lerStr();
							if(tipo == "PF"){
							seguradora.listarClientes("PF");
							}
							else
							seguradora.listarClientes("PJ");
						break;

						case VOLTAR:
						
						break;											
					}
				break;

				case EXCLUIR:
					System.out.print("\nVocê clicou em " + descricao + "\nQual operação deseja realisar?");
					for(SubmenuOpcoes submenu: MenuOperacoes.EXCLUIR.getSubmenu()){
						System.out.print("\n-"+ submenu + "\n");
					}
					subdescricao = SubmenuOpcoes.valueOf(lerStr());	
					switch (subdescricao)
					{ 
						case EXCLUIR_CLIENTE:
							System.out.print("\nQual o nome do cliente?");
							String dono = lerStr();
							seguradora.removerCliente(dono);
						break;



						

						case VOLTAR:
						
						break;
						
				
					}
				break;

				case GERAR_SINISTRO:
					lerSinistro(seguradora);
						
				break;

				case TRANSFERIR_SEGURO:
				System.out.print("\nQual o nome de quem vai dar sua lista?");
				String nome = lerStr();
				System.out.print("\nQuual o nome de quem vai receber a lista?");
				String nome2 = lerStr();
					
				break;

				
				
		
		}
	}
	}
}

