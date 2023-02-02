package dominio.bemImovel;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BemImovelImp implements BemImovel {
    BigDecimal valor;

    public BemImovelImp(BigDecimal valor){
        this.valor = valor;
    }
}
