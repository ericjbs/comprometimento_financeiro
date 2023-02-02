package dominio.bemImovel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BemImovelImp implements BemImovel {
    Double valor;

    public BemImovelImp(Double valor){
        this.valor = valor;
    }
}
