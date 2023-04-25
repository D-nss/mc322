
public class Lab02 {
	public static void main (String[] args) {
		// cria cliente, valida o cpf e imprime os atributos
		Cliente cliente = new Cliente("Daniel", "509.306.788-18", "25012004", "Rua Saturnino", 19);
		cliente.Confere_cpf();
		System.out.println(cliente.toString());
		// cria seguradora e imprime os atributos
		Seguradora seguradora = new Seguradora("Carros", "950409855", "daniel@outlook", "Rua Saturnino");
		System.out.println(seguradora.toString());
		// cria veiculo e imprime os atributos
		Veiculo veiculo = new Veiculo("BRA2E19", "Fiat", "Uno");
		System.out.println(veiculo.toString());
		// cria seguradora e imprime os atributos
		Sinistro sinistro = new Sinistro("23/02/01", "Rua Saturnino");
		System.out.println(sinistro.toString());
		// muda o valor do cpf e valida ele
		cliente.setCpf("09909178930");
		cliente.Confere_cpf();
		System.out.println(cliente.toString());
	}
}
