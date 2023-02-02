package dominio.pessoa;

import java.util.ArrayList;
import java.util.List;

import dominio.bemImovel.BemImovel;
import dominio.estruturaSocietaria.EstruturaSocietaria;
import dominio.estruturaSocietaria.EstruturaSocietariaImp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class PessoaJuridicaImp implements PessoaJuridica{
    List<BemImovel> bens;
    EstruturaSocietaria estruturaSocietaria;

    public EstruturaSocietaria getEstruturaSocietaria(){
        // TODO: Isso cria uma inconsistencia no método, o requisito deve ser mudado para aceitar a empresa como parametro
        // Caso a empresa não seja socia dela mesma, para considerar seus bens, adiciono ela mesma na estrutura societaria
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

    public PessoaJuridicaImp(){
        this.bens = new ArrayList<>();
    }

    @Override
    public void addBem(BemImovel bem) {
        this.bens.add(bem);
    }
}
