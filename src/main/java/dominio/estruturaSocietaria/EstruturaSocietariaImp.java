package dominio.estruturaSocietaria;

import java.util.List;

import dominio.pessoa.Pessoa;

public class EstruturaSocietariaImp implements EstruturaSocietaria {
    List<Pessoa> socios;

    @Override
    public List<Pessoa> getSocios() {
        return this.socios;
    }

    @Override
    public void addSocio(Pessoa pessoa){
        this.socios.add(pessoa);
    }
}
