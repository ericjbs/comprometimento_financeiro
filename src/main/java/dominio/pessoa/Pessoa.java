package dominio.pessoa;

import java.util.List;

import dominio.bemImovel.BemImovel;

public interface Pessoa {
    List<BemImovel> getBens();
    void addBem(BemImovel bem);
}
