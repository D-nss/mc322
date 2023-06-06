import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;
    
    public SeguroPF(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo,
            ClientePF cliente) {
        super(id, dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public ClientePF getCliente() {
        return cliente;
    }
    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    public boolean desautorizarCondutor(String nome){
        int i=0;
		for(Condutor indice : getListaCondutores()) {
			if(indice.getNome() == nome) {
				indice.setAutorizar(false);
			}
			i++;
		}
				return true;
    }   

    public boolean autorizarCondutor(String nome){
        int i=0;
		for(Condutor indice : getListaCondutores()) {
			if(indice.getNome() == nome) {
				indice.setAutorizar(true);
			}
			i++;
		}
				return true;
    }
    
    public boolean gerarSinistro(String data, String endereco,Seguro seguro, Condutor condutor) {
        //gera um sinistro
		this.getListaSinistros().add(new  Sinistro (data, endereco, seguro, condutor));
		return true;
	}

    public Condutor buscarCondutor(String nome){
		for(Condutor ind: getListaCondutores()){
			if (ind.getNome().equals(nome))
				return ind;
			}
		return null;
	}

    public double calcularValor() {
        int idade = (2023 -cliente.getDataNascimento().getYear());
        return CalcSeguro.VALOR_BASE.getFator() *CalcSeguro.getFatoridade(idade) *(2 + super.getListaSinistros().size()/10)* (buscarCondutor(cliente.getNome()).getListaSinistros().size());
	}

}
