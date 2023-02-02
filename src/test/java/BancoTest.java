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

        socio1.addBem(new BemImovelImp(10.00));
        socio1.addBem(new BemImovelImp(10.00));
        socio2.addBem(new BemImovelImp(10.00));
        socio2.addBem(new BemImovelImp(10.00));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);

        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(40.00, Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()).doubleValue(),0);
    }

    @Test
    public void deveRetornarOTotalDeBensImoveisDeUmaEmpresaIncluindoSeuProprioBem(){
        EstruturaSocietaria estrutura = new EstruturaSocietariaImp();

        var empresa = new PessoaJuridicaImp();
        var socio1 = new PessoaFisicaImp();
        var socio2 = new PessoaJuridicaImp();

        socio1.addBem(new BemImovelImp(10.00));
        socio1.addBem(new BemImovelImp(10.00));
        socio2.addBem(new BemImovelImp(10.00));
        socio2.addBem(new BemImovelImp(10.00));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);

        empresa.addBem(new BemImovelImp(10.00));
        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(50.00, Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()).doubleValue(),0);
    }

    @Test
    public void deveRetornarOTotalDeBensImoveisDeUmaEmpresaIncluindoSeuProprioBemEElaMesmaComoSocia(){
        EstruturaSocietaria estrutura = new EstruturaSocietariaImp();

        var empresa = new PessoaJuridicaImp();
        var socio1 = new PessoaFisicaImp();
        var socio2 = new PessoaJuridicaImp();

        empresa.addBem(new BemImovelImp(10.00));
        socio1.addBem(new BemImovelImp(10.00));
        socio1.addBem(new BemImovelImp(10.00));
        socio2.addBem(new BemImovelImp(10.00));
        socio2.addBem(new BemImovelImp(10.00));

        estrutura.addSocio(socio1);
        estrutura.addSocio(socio2);
        estrutura.addSocio(empresa);

        empresa.setEstruturaSocietaria(estrutura);

        Assert.assertEquals(50.00, Banco.comprometimentoFinanceiro(empresa.getEstruturaSocietaria()).doubleValue(),0);
    }
}
