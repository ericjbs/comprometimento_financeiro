package dominio.banco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dominio.bemImovel.BemImovel;
import dominio.estruturaSocietaria.EstruturaSocietaria;
import dominio.pessoa.Pessoa;
import dominio.pessoa.PessoaJuridica;

public class BancoImp implements Banco {
    @Override
    public BigDecimal comprometimentoFinanceiro(EstruturaSocietaria estrutura) {
        Comprometimento comprometimento = new Comprometimento();
        comprometimento.pessoas = new ArrayList<>();
        comprometimento.valor = (BigDecimal.ZERO);

        this.processa(comprometimento, estrutura);

        return comprometimento.valor;
    }

    private Comprometimento processa(Comprometimento comprometimento,
        EstruturaSocietaria estrutura) {

        for (int i = 0; i < estrutura.getSocios().size(); i++) {
            var socio = estrutura.getSocios().get(i);

            if (comprometimento.pessoas.contains(socio)) continue;

            comprometimento.pessoas.add(socio);

            // Se for uma pessoa juridica, percorre a estrutura societaria desse sócio, recursivamente, e acresce o valor do comprometimento
            if (socio instanceof PessoaJuridica) {
                comprometimento.valor = processa(comprometimento, ((PessoaJuridica) socio).getEstruturaSocietaria()).valor
                        .add(socio.getBens().stream().map(BemImovel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
            } else {
                // Se for pessoa física, não há estrutura societária, portanto não há recursividade
                comprometimento.valor = comprometimento.valor
                    .add(socio.getBens().stream().map(BemImovel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        }

        return comprometimento;
    }

    private static class Comprometimento {
        private BigDecimal valor;
        private List<Pessoa> pessoas;
    }
}
