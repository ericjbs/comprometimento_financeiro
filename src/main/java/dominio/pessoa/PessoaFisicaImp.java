package dominio.pessoa;

import java.util.ArrayList;
import java.util.List;

import dominio.bemImovel.BemImovel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Getter @Setter
public class PessoaFisicaImp implements PessoaFisica{
    private List<BemImovel> bens;

    public PessoaFisicaImp(){
        this.bens = new ArrayList<>();
    }

    @Override
    public void addBem(BemImovel bem) {
        bens.add(bem);
    }
}
