import java.math.BigDecimal;

import dominio.banco.Banco;
import dominio.bemImovel.BemImovelImp;
import dominio.estruturaSocietaria.EstruturaSocietaria;
import dominio.estruturaSocietaria.EstruturaSocietariaImp;
import dominio.pessoa.PessoaFisicaImp;
import dominio.pessoa.PessoaJuridicaImp;
import org.junit.Test;
import org.junit.Assert;

public class BancoTest {

    @Test
    public void deveRetornarOTotalDeBensImoveisDeUmaEmpresa(){
        EstruturaSocietaria estrutura = new EstruturaSocietariaImp();

        var empresa = new PessoaJuridicaImp();
        var socio1 = new PessoaFisicaImp();
        var socio2 = new PessoaJuridicaImp();

        socio1.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio1.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio2.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio2.addBem(new BemImovelImp(new BigDecimal("10.00")));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);

        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(new BigDecimal("40.00"), Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()));
    }

    @Test
    public void deveRetornarOTotalDeBensImoveisDeUmaEmpresaIncluindoSeuProprioBem(){
        EstruturaSocietaria estrutura = new EstruturaSocietariaImp();

        var empresa = new PessoaJuridicaImp();
        var socio1 = new PessoaFisicaImp();
        var socio2 = new PessoaJuridicaImp();

        socio1.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio1.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio2.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio2.addBem(new BemImovelImp(new BigDecimal("10.00")));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);

        empresa.addBem(new BemImovelImp(new BigDecimal("10.00")));
        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(new BigDecimal("50.00"), Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()));
    }

    @Test
    public void deveRetornarOTotalDeBensImoveisDeUmaEmpresaIncluindoSeuProprioBemEElaMesmaComoSocia(){
        EstruturaSocietaria estrutura = new EstruturaSocietariaImp();

        var empresa = new PessoaJuridicaImp();
        var socio1 = new PessoaFisicaImp();
        var socio2 = new PessoaJuridicaImp();

        empresa.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio1.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio1.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio2.addBem(new BemImovelImp(new BigDecimal("10.00")));
        socio2.addBem(new BemImovelImp(new BigDecimal("10.00")));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);
        estrutura.addSocio(empresa);

        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(new BigDecimal("50.00"), Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()));
    }
}
