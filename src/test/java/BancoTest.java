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

        socio1.addBem(new BemImovelImp(10L));
        socio1.addBem(new BemImovelImp(10L));
        socio2.addBem(new BemImovelImp(10L));
        socio2.addBem(new BemImovelImp(10L));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);

        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(40L, Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()).longValue());
    }

    @Test
    public void deveRetornarOTotalDeBensImoveisDeUmaEmpresaIncluindoSeuProprioBem(){
        EstruturaSocietaria estrutura = new EstruturaSocietariaImp();

        var empresa = new PessoaJuridicaImp();
        var socio1 = new PessoaFisicaImp();
        var socio2 = new PessoaJuridicaImp();

        socio1.addBem(new BemImovelImp(10L));
        socio1.addBem(new BemImovelImp(10L));
        socio2.addBem(new BemImovelImp(10L));
        socio2.addBem(new BemImovelImp(10L));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);

        empresa.addBem(new BemImovelImp(10L));
        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(50L, Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()).longValue());
    }

    @Test
    public void deveRetornarOTotalDeBensImoveisDeUmaEmpresaIncluindoSeuProprioBemEElaMesmaComoSocia(){
        EstruturaSocietaria estrutura = new EstruturaSocietariaImp();

        var empresa = new PessoaJuridicaImp();
        var socio1 = new PessoaFisicaImp();
        var socio2 = new PessoaJuridicaImp();

        empresa.addBem(new BemImovelImp(10L));
        socio1.addBem(new BemImovelImp(10L));
        socio1.addBem(new BemImovelImp(10L));
        socio2.addBem(new BemImovelImp(10L));
        socio2.addBem(new BemImovelImp(10L));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);
        estrutura.addSocio(empresa);

        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(50L, Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()).longValue());
    }
}
