package dominio.pessoa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFisicaImp extends Bens implements PessoaFisica {
    String nome;
    String CPF;
}
