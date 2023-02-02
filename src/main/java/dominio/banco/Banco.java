package dominio.banco;

import java.util.List;
import java.util.stream.Collectors;

import dominio.bemImovel.BemImovel;
import dominio.estruturaSocietaria.EstruturaSocietaria;

public interface Banco {
    static Double comprometimentoFinanceiro(EstruturaSocietaria estrutura){
        return estrutura.getSocios().stream()
            .flatMap(s -> s.getBens().stream())
            .map(b -> b.getValor())
            .reduce(0.0, Double::sum);
    }
}
