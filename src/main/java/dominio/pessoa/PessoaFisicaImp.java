package dominio.pessoa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFisicaImp extends DireitoDeBens implements PessoaFisica {
    String nome;
    String CPF;
}
