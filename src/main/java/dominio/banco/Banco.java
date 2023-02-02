package dominio.banco;

import java.math.BigDecimal;
import dominio.estruturaSocietaria.EstruturaSocietaria;

public interface Banco {
    static BigDecimal comprometimentoFinanceiro(EstruturaSocietaria estrutura){
        return estrutura.getSocios().stream()
            .flatMap(s -> s.getBens().stream())
            .map(b -> b.getValor())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
