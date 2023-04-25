import java.util.Scanner;
public class Lab03 {

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

	public static ClientePF lerClientePF(){
        //lê um clientepf e instancia
		System.out.print("\nCriar ClientePF");
		System.out.print("\nNome:");
		String nome = lerStr();
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
		System.out.print("\nData de nascimento (no formato ano-mes-dia, exemplo: 2004-01-25):");
		String dataNascimento = lerStr();
		ClientePF clientePf = new ClientePF(nome, endereco, dataLicenca, educacao, genero, classeEconomica, cpf, dataNascimento);
		return clientePf;
	}

	public static ClientePJ lerClientePJ(){
        //lê um clientepj e instancia
		System.out.print("\nCriar ClientePJ");
		System.out.print("\nNome:");
		String nome = lerStr();
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		System.out.print("\nCNPJ:");
		String cnpj = lerStr();
		System.out.print("\nData de fundacao(no formato ano-mes-dia, exemplo: 2004-01-25):");
		String datafun = lerStr();
		ClientePJ clientePj = new ClientePJ(nome, endereco, cnpj, datafun);
		return clientePj;
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
		return seguradora;
	}

	public static Veiculo lerVeiculo(){
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
		return veiculo;
	}

	public static boolean lerSinistro(Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        //lê um sinistro e instancia
		System.out.print("\nCriar Sinistro");
		System.out.print("\nData:");
		String data = lerStr();
		System.out.print("\nEndereco:");
		String endereco = lerStr();
		return seguradora.gerarSinistro(data, endereco, seguradora, veiculo, cliente);
	}

	public static void main (String[] args) {
		Seguradora seguradora = lerSeguradora();

		ClientePF clientePf = lerClientePF();
		System.out.print("\nConferindo cpf...");
		clientePf.Confere_cpf();
		System.out.print("\nCadastrando cliente...");
		seguradora.cadastrarCliente(clientePf);
        System.out.print(clientePf.toString());
		Veiculo v1 = lerVeiculo();
		System.out.print("\nSeu veiculo:");
		System.out.print(v1.toString());
		System.out.print("\nAdicionando veiculo....");
		clientePf.getListaVeiculos().add(v1);

		ClientePJ clientePj = lerClientePJ();
		System.out.print("\nConferindo cnpj...");
		clientePj.Confere_cnpj();
		System.out.print("\nCadastrando cliente...");
		seguradora.cadastrarCliente(clientePj);
        System.out.print(clientePj.toString());
		Veiculo v2 = lerVeiculo();
		System.out.print("\nAdicionando veiculo....");
		clientePj.getListaVeiculos().add(v2);

        System.out.print("\nLista clientes pJ:");
        System.out.print("\n" +seguradora.listarClientes("PJ"));
		System.out.print("\nLista clientes pf:");
		System.out.print("\n" +seguradora.listarClientes("PF"));
		System.out.print("\nRemovendo cliente...");
		seguradora.removerCliente(clientePf.getNome());
		System.out.print("\nLista clientes pf:");
		System.out.print("\n" +seguradora.listarClientes("PF"));

		ClientePF clientePf2 = lerClientePF();
		System.out.print("\nConferindo cpf...");
		clientePf2.Confere_cpf();
		System.out.print("\nCadastrando cliente...");
		seguradora.cadastrarCliente(clientePf2);
		Veiculo v3 = lerVeiculo();
		System.out.print("\nAdicionando veiculo....");
		clientePf2.getListaVeiculos().add(v3);
		lerSinistro(seguradora, v3, clientePf2);
		seguradora.visualizarSinistro(clientePf2.getNome());
		seguradora.listarSinistros();
	}
}

