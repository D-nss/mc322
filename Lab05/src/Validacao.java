public class Validacao {

    public static boolean validarCNPJ(String cnpj) {
        //valida a cnpj
		String novocnpj = cnpj.replace(".", "");
		novocnpj = novocnpj.replace("-", "");
		novocnpj = novocnpj.replace("/", "");
		int[] lista_1 = {5,4,3,2,9,8,7,6,5,4,3, 2};
		int[] lista_2 = {6,5,4,3,2,9,8,7,6,5,4,3, 2};
		if(novocnpj.length()!= 14) {
			return false;
		}
		int soma = 0;
		for (int i = 0; i<12; i++) {
			soma+= lista_1[i]*(novocnpj.charAt(i) -48);}
		soma = soma%11;
		if (soma <2 && novocnpj.charAt(12)!=0) {
			soma = 0;
			}
		else
			soma = 11-soma;
		if (soma != (novocnpj.charAt(12) - 48)) {
			return false;
		}
		
		soma= 0;
		
		for (int i = 0; i<13; i++) {
		soma+= lista_2[i]*(novocnpj.charAt(i) -48);}
		soma = soma%11;
		if (soma <2) {
			soma = 0;
			}
			else
				soma = 11-soma;
		if (soma != (novocnpj.charAt(13) - 48)) {
			return false;
		}
		return true;
	}
	
	public static void Confere_cnpj(String cnpj) {
        //informa se a cnpj e valida
		if(validarCNPJ(cnpj) == true) {
			System.out.println("Cnpj valido!");
		}
		else
			System.out.println("Cnpj invalido!");
	}

    public static boolean validarCPF(String cpf) {
        //valida o cpf
		String novocpf = cpf.replace(".", "");
		novocpf = novocpf.replace("-", "");
		if(novocpf.length()!= 11) {
			return false;
		}
		for(int u = 0; u<10; u++) {
			if(novocpf.charAt(u) != novocpf.charAt(u+1)) {
				break;}
			return false;
	}
		int soma = 0;
		int escalar = 10;
		for (int i = 0; i<9; i++) {
			if(novocpf.charAt(i)>57 || novocpf.charAt(i)<48) {
				return false;
			}
			soma+= escalar*(novocpf.charAt(i) -48);
			escalar--;}
		soma = soma*10%11;
		if (soma == 10 || soma == 0) {
			soma = 0;
			}
		if (soma != (novocpf.charAt(9) - 48)) {
			return false;
		}
		soma=0;
		escalar = 11;
		for (int i = 0; i<10; i++) {
			soma+= escalar*(novocpf.charAt(i) -48);
			escalar--;
			}
		soma = soma*10%(11);
		if (soma == 10 || soma == 0) {
			soma = 0;
			}
			if (soma != (novocpf.charAt(10) - 48)) {
				return false;
			}
			return true;
	}

	public static void Confere_cpf(String cpf) {
        //informa se o cpf e valido
		if(validarCPF(cpf) == true) {
			System.out.println("Cpf valido!");
		}
		else
			System.out.println("Cpf invalido!");
	}

    public static boolean validarnome(String nome){
        for (int i = 0; i<nome.length(); i++) {
			if((nome.charAt(i)>64 && nome.charAt(i)<91) || (nome.charAt(i)>96 && nome.charAt(i)<123)) 
				continue;
            else
            return false;	
    }
        return true;
  
    }

    public static void Confere_nome(String nome) {
        //informa se o cpf e valido
		if(validarnome(nome) == true) {
			System.out.println("Nome valido!");
		}
		else
			System.out.println("Nome invalido!");
	}

}
