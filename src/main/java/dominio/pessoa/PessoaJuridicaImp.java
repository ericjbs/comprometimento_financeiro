package dominio.pessoa;

import java.util.ArrayList;
import java.util.List;

import dominio.bemImovel.BemImovel;
import dominio.estruturaSocietaria.EstruturaSocietaria;
import dominio.estruturaSocietaria.EstruturaSocietariaImp;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PessoaJuridicaImp extends DireitoDeBens implements PessoaJuridica{
    EstruturaSocietaria estruturaSocietaria;

    public EstruturaSocietaria getEstruturaSocietaria(){
        if(estruturaSocietaria.getSocios().contains(this)) {
            return estruturaSocietaria;
        } else {
            var novaEstrutura = new EstruturaSocietariaImp();
            var novosSocios = new ArrayList<Pessoa>();
            novosSocios.addAll(estruturaSocietaria.getSocios());
            novosSocios.add(this);
            novaEstrutura.setSocios(novosSocios);
            return novaEstrutura;
        }
    }
}
