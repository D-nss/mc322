public enum MenuOperacoes {
    
    CADASTROS("Cadastros", new SubmenuOpcoes[] {
        SubmenuOpcoes.CADASTRAR_CLIENTEPF,
        SubmenuOpcoes.CADASTRAR_CLIENTEPJ,
        SubmenuOpcoes.CADASTRAR_VEICULO,
        SubmenuOpcoes.CADASTRAR_SEGURADORA,
        SubmenuOpcoes.VOLTAR
}),
LISTAR("Listar", new SubmenuOpcoes[] {
        SubmenuOpcoes.LISTAR_CLIENTES,
        SubmenuOpcoes.LISTAR_SINISTROS,
        SubmenuOpcoes.LISTAR_VEICULOS,
        SubmenuOpcoes.VOLTAR,
        SubmenuOpcoes.Listar_Sinistro_por_Cliente,
        SubmenuOpcoes.Listar_Veiculo_por_Cliente
}),
EXCLUIR("Excluir", new SubmenuOpcoes[] {
        SubmenuOpcoes.EXCLUIR_CLIENTE,
        SubmenuOpcoes.EXCLUIR_VEICULO,
        SubmenuOpcoes.EXCLUIR_SINISTRO,
        SubmenuOpcoes.VOLTAR}),
GERAR_SINISTRO("Gerar Sinistro", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
TRANSFERIR_SEGURO("Transferir Seguro", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
CALCULAR_RECEITA("Calcular Receita", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
SAIR("Sair", new SubmenuOpcoes[] {});

//atributos
private final String descricao;
private final SubmenuOpcoes[] submenu;

//Construtor
MenuOperacoes(String descricao, SubmenuOpcoes[] submenu){
    this.descricao = descricao;
    this.submenu = submenu;
}

//getters
public String getDescricao() {
    return descricao;
}

public SubmenuOpcoes[] getSubmenu() {
    return submenu;
}
}
