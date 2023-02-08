package dominio.bemImovel;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BemImovelImp implements BemImovel {
    BigDecimal valor;
    String nome;

    public BemImovelImp(String nome, BigDecimal valor){
        this.nome = nome;
        this.valor = valor;
    }
}
