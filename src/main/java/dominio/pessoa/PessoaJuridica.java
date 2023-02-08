package dominio.pessoa;

import dominio.estruturaSocietaria.EstruturaSocietaria;

public interface PessoaJuridica extends Pessoa {
    EstruturaSocietaria getEstruturaSocietaria();

    String getCNPJ();

    String getRazaoSocial();

    void setRazaoSocial(String razaoSocial);

    void setCNPJ(String CNPJ);

    void addSocio(Pessoa pessoa);
}
