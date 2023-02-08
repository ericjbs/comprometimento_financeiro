package dominio.banco;

import java.math.BigDecimal;

import dominio.estruturaSocietaria.EstruturaSocietaria;

public interface Banco {
    BigDecimal comprometimentoFinanceiro(EstruturaSocietaria estrutura);
}
