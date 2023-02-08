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

        ComprometimentoFinanceiro comprometimento = new ComprometimentoFinanceiro();
        comprometimento.pessoasConsideradas = new ArrayList<>();
        comprometimento.valor = (BigDecimal.ZERO);

        this.processaComprometimentoFinanceiro(comprometimento, estrutura);

        return comprometimento.valor;
    }

    private ComprometimentoFinanceiro processaComprometimentoFinanceiro(ComprometimentoFinanceiro comprometimento,
        EstruturaSocietaria estrutura) {

        for (int i = 0; i < estrutura.getSocios().size(); i++) {
            var pessoa = estrutura.getSocios().get(i);

            if (comprometimento.pessoasConsideradas.contains(pessoa)) continue;
            comprometimento.pessoasConsideradas.add(pessoa);

            // Se for uma pessoa juridica, percorre a estrutura societaria desse sócio, recursivamente, e acresce o valor do comprometimento
            if (pessoa instanceof PessoaJuridica) {
                comprometimento.valor = processaComprometimentoFinanceiro(comprometimento,
                        ((PessoaJuridica) pessoa).getEstruturaSocietaria()).valor
                    .add(pessoa.getBens().stream().map(BemImovel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
            } else {
                // Se for pessoa física, não há estrutura societária, portanto não há recursividade
                comprometimento.valor = comprometimento.valor.add(pessoa.getBens().stream()
                        .map(BemImovel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        }

        return comprometimento;
    }

    private class ComprometimentoFinanceiro {
        private BigDecimal valor;
        private List<Pessoa> pessoasConsideradas;
    }
}
