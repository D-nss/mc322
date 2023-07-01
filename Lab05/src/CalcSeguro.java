
public enum CalcSeguro {
    VALOR_BASE (10), FATOR_18_30 (1.25), FATOR_30_60 (1.0), FATOR_60_90 (1.5);

    private final double fator;
	
    CalcSeguro(double fator){
        this.fator = fator;
    }

    public double getFator() {
        return fator;
    }

    public static double getFatoridade(int idade){
        if(idade < 30)
            return FATOR_18_30.getFator();
        if(idade < 60)
            return FATOR_30_60.getFator();
        else 
            return FATOR_60_90.getFator();

    }
}
