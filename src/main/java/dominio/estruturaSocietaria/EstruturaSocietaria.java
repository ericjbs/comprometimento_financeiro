package dominio.estruturaSocietaria;

import java.util.List;

import dominio.pessoa.Pessoa;

public interface EstruturaSocietaria {
    List<Pessoa> getSocios();

    void addSocio(Pessoa pessoa);
}
