package dominio.banco;

import dominio.estruturaSocietaria.EstruturaSocietaria;

public interface Banco {
    static Long comprometimentoFinanceiro(EstruturaSocietaria estrutura){
        return Long.MAX_VALUE;
    }
}
