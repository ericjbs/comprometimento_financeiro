package dominio.pessoa;

import java.util.ArrayList;
import java.util.List;

import dominio.bemImovel.BemImovel;
import dominio.estruturaSocietaria.EstruturaSocietaria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class PessoaJuridicaImp implements PessoaJuridica{
    List<BemImovel> bens;
    EstruturaSocietaria estruturaSocietaria;

    public PessoaJuridicaImp(){
        this.bens = new ArrayList<>();
    }

    @Override
    public void addBem(BemImovel bem) {
        this.bens.add(bem);
    }
}
