package dominio.estruturaSocietaria;

import java.util.ArrayList;
import java.util.List;

import dominio.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstruturaSocietariaImp implements EstruturaSocietaria {
    List<Pessoa> socios;

    public EstruturaSocietariaImp(){
        this.socios = new ArrayList<>();
    }

    @Override
    public void addSocio(Pessoa pessoa){
        this.socios.add(pessoa);
    }
}
