
import java.util.Scanner;
public class Lab04 {

	public static String lerStr() {
        //lê uma string
		Scanner texto = new Scanner(System.in);
		String str;
		str =  texto.nextLine();
		return str;
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
		System.out.print("\nData Licenca (no formato ano-mes-dia, exemplo: 2004-01-25):");
		String dataLicenca = lerStr();
		System.out.print("\nEducacao:");
		String educacao = lerStr();
		System.out.print("\nGenero:");
		String genero = lerStr();
		System.out.print("\nClasse economica:");
		String classeEconomica = lerStr();
		System.out.print("\nCPF:");
		String cpf = lerStr();
		Validacao.Confere_cpf(cpf);
		System.out.print("\nData de nascimento (no formato ano-mes-dia, exemplo: 2004-01-25):");
		String dataNascimento = lerStr();
		ClientePF clientePf = new ClientePF(nome, endereco, dataLicenca, educacao, genero, classeEconomica, cpf, dataNascimento);
		seguradora.cadastrarCliente(clientePf);
		seguradora.calcularPrecoSeguroCliente(nome);
	}

	public static void lerClientePJ(Seguradora seguradora){
        //lê um clientepj e instancia
		System.out.print("\nCriar ClientePJ");
		System.out.print("\nNome:\n");
		String nome = lerStr();
		Validacao.Confere_nome(nome);
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		System.out.print("\nCNPJ:");
		String cnpj = lerStr();
		Validacao.Confere_cnpj(cnpj);
		System.out.print("\nData de fundacao(no formato ano-mes-dia, exemplo: 2004-01-25):");
		String datafun = lerStr();
		System.out.print("\nQuantidade de funcionarios:");
		int qtd = lerInt();
		ClientePJ clientePj = new ClientePJ(nome, endereco, cnpj, datafun, qtd);
		seguradora.cadastrarCliente(clientePj);
		seguradora.calcularPrecoSeguroCliente(nome);
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
		Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
		Seguradora.listaSeguradora.add(seguradora);
		return seguradora;
	}

	public static void lerVeiculo(Seguradora seguradora){
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
		seguradora.buscarCliente(dono).getListaVeiculos().add(veiculo);
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
		return seguradora.gerarSinistro(data, endereco, seguradora, seguradora.buscarCliente(dono).buscarVeiculo(carro) , seguradora.buscarCliente(dono));
	}

	public static void main (String[] args) {
		Seguradora seguradora = lerSeguradora();

		lerClientePF(seguradora);
		lerVeiculo(seguradora);

		lerClientePJ(seguradora);
		lerVeiculo(seguradora);

        System.out.print("\nLista clientes pJ:");
        seguradora.listarClientes("PJ");
		System.out.print("\nLista clientes pf:");
		seguradora.listarClientes("PF");
		lerSinistro(seguradora);
		seguradora.visualizarSinistro();
		lerSinistro(seguradora);
		seguradora.listarSinistros();
		seguradora.calcularReceita();
		


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

						case LISTAR_SINISTROS:
							seguradora.listarSinistros();
						break;

						case LISTAR_VEICULOS:
							seguradora.listarVeiculo();
						break;

						case VOLTAR:
						
						break;

						case Listar_Sinistro_por_Cliente:
							System.out.print("\nQuem é o dono do sinistro?\n");
							String dono = lerStr();
							seguradora.listarSinistrosCliente(dono);
						break;

						case Listar_Veiculo_por_Cliente:
							System.out.print("\nQuem é o dono do veiculo?\n");
							dono = lerStr();
							seguradora.listarVeiculosCliente(dono);
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

						case EXCLUIR_VEICULO:
							System.out.print("\nQual o nome do cliente dono do veículo?");
							String cliente = lerStr();
							System.out.print("\nQual a placa do veículo?");
							String placa = lerStr();
							seguradora.buscarCliente(cliente).removerVeiculo(placa);
						break;

						case EXCLUIR_SINISTRO:
							System.out.print("\nQual o numero de id?");
							int id = lerInt();
							seguradora.removerSinistro(id);
						break;

						case VOLTAR:
						
						break;
						
				
					}
				break;

				case CALCULAR_RECEITA:
					seguradora.calcularReceita();
						
				break;

				case GERAR_SINISTRO:
					lerSinistro(seguradora);
						
				break;

				case TRANSFERIR_SEGURO:
				System.out.print("\nQual o nome de quem vai dar sua lista?");
				String nome = lerStr();
				System.out.print("\nQuual o nome de quem vai receber a lista?");
				String nome2 = lerStr();
				seguradora.buscarCliente(nome2).setListaVeiculos(seguradora.buscarCliente(nome).getListaVeiculos());		
				break;

				
				
		
		}
	}
	}
}

