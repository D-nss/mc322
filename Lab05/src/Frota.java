import java.util.ArrayList;

public class Frota{
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    public Frota(String code) {
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>() ;
    }  
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean addVeiculo(Veiculo veiculo){
        this.getListaVeiculos().add(veiculo);
        return true;
    }

    public boolean removeVeiculo(String veiculoPlaca){
        int i=0;
		for(Veiculo indice : listaVeiculos) {
			if(indice.getPlaca() == veiculoPlaca) {
				listaVeiculos.remove(i);
			}
			i++;
		}
        return true;
    }
}