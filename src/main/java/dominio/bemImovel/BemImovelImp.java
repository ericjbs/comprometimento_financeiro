package dominio.bemImovel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BemImovelImp implements BemImovel {
    Long valor;

    public BemImovelImp(Long valor){
        this.valor = valor;
    }
}
