import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(int id, LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota,
            ClientePJ cliente) {
        super(id, dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }

    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
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

    public double  calcularValor() {
        int idade = (2023 -cliente.getDataFundacao().getYear());
        int total=0;
        for(Frota ind: cliente.getListaFrota()){
            total += ind.getListaVeiculos().size();
        }
        return CalcSeguro.VALOR_BASE.getFator() * (10 + (cliente.getQtdeFuncionarios()) /10) * (1 + 1/(idade+2))* (1+ 1/(total + 2))* (2 + super.getListaSinistros().size()/10)* (buscarCondutor(cliente.getNome()).getListaSinistros().size());
	}
    
}
