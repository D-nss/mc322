import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
    private final String cpf;
	private LocalDate dataNasc;
    private String nome;
	private String endereco;
    private String telefone;
    private String email;
    private ArrayList<Sinistro> listaSinistros;
    private boolean autorizar;
    
    public Condutor(String cpf, LocalDate dataNasc, String nome, String endereco, String telefone, String email) {
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.autorizar = false;
    }

    public boolean getAutorizar() {
        return autorizar;
    }

    public void setAutorizar(boolean autorizar) {
        this.autorizar = autorizar;
    }

    public String getCpf() {
        return cpf;
    }
    public LocalDate getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public void adicionarSinistro(Sinistro sinistro){
        this.listaSinistros.add(sinistro);
    }
}
