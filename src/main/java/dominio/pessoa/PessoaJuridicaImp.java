package dominio.pessoa;

import dominio.estruturaSocietaria.EstruturaSocietaria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaJuridicaImp extends DireitoDeBens implements PessoaJuridica {
    EstruturaSocietaria estruturaSocietaria;
    String razaoSocial;
    String CNPJ;

    public PessoaJuridicaImp(EstruturaSocietaria estrutura) {
        this.estruturaSocietaria = estrutura;
    }

    public EstruturaSocietaria getEstruturaSocietaria() {
        return estruturaSocietaria;
    }

    @Override
    public void addSocio(Pessoa pessoa) {
        estruturaSocietaria.addSocio(pessoa);
    }
}
