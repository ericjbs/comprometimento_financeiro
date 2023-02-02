package dominio.pessoa;

import java.util.List;

import dominio.bemImovel.BemImovel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PessoaFisicaImp implements PessoaFisica{
    List<BemImovel> bens;

    @Override
    public void addBem(BemImovel bem) {
        bens.add(bem);
    }
}
