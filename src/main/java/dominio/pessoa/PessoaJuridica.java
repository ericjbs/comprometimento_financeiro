package dominio.pessoa;

import dominio.estruturaSocietaria.EstruturaSocietaria;
import dominio.estruturaSocietaria.EstruturaSocietariaImp;

public interface PessoaJuridica extends Pessoa {
    public EstruturaSocietaria getEstruturaSocietaria();
    public void setEstruturaSocietaria(EstruturaSocietaria estrutura);
}
