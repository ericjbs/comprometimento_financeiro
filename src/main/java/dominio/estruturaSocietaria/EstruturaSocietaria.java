package dominio.estruturaSocietaria;

import java.util.List;

import dominio.pessoa.Pessoa;

public interface EstruturaSocietaria {
    public List<Pessoa> getSocios();

    void addSocio(Pessoa pessoa);
}
