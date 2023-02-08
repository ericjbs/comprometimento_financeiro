package dominio.pessoa;

import java.util.ArrayList;
import java.util.List;

import dominio.bemImovel.BemImovel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Bens {
    private List<BemImovel> bens;

    public Bens() {
        this.bens = new ArrayList<>();
    }

    public void addBem(BemImovel bem) {
        bens.add(bem);
    }
}
