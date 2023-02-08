import java.math.BigDecimal;

import dominio.banco.Banco;
import dominio.banco.BancoImp;
import dominio.bemImovel.BemImovelImp;
import dominio.estruturaSocietaria.EstruturaSocietaria;
import dominio.estruturaSocietaria.EstruturaSocietariaImp;
import dominio.pessoa.PessoaFisicaImp;
import dominio.pessoa.PessoaJuridica;
import dominio.pessoa.PessoaJuridicaImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BancoTest {
    private Banco banco;
    private PessoaJuridica empresaA;
    private PessoaJuridica empresaB;
    private PessoaJuridica empresaC;
    private PessoaJuridica empresaD;

    @Before
    public void criaEstrutura() {
        banco = new BancoImp();

        EstruturaSocietaria estruturaEmpresaA = new EstruturaSocietariaImp();
        EstruturaSocietaria estruturaEmpresaB = new EstruturaSocietariaImp();
        EstruturaSocietaria estruturaEmpresaC = new EstruturaSocietariaImp();
        EstruturaSocietaria estruturaEmpresaD = new EstruturaSocietariaImp();

        empresaA = new PessoaJuridicaImp(estruturaEmpresaA);
        empresaB = new PessoaJuridicaImp(estruturaEmpresaB);
        empresaC = new PessoaJuridicaImp(estruturaEmpresaC);
        empresaD = new PessoaJuridicaImp(estruturaEmpresaD);

        var pessoaFisica1 = new PessoaFisicaImp();
        var pessoaFisica2 = new PessoaFisicaImp();
        var pessoaFisica3 = new PessoaFisicaImp();
        var pessoaFisica4 = new PessoaFisicaImp();
        var pessoaFisica5 = new PessoaFisicaImp();

        empresaA.setCNPJ("93.168.352/0001-31");
        empresaB.setCNPJ("79.540.145/0001-35");
        empresaC.setCNPJ("15.478.411/0001-64");
        empresaD.setCNPJ("07.365.804/0001-33");

        empresaA.setRazaoSocial("EmpresaA");
        empresaB.setRazaoSocial("EmpresaB");
        empresaC.setRazaoSocial("EmpresaC");
        empresaD.setRazaoSocial("EmpresaD");

        pessoaFisica1.setNome("PessoaFisica1");
        pessoaFisica2.setNome("PessoaFisica2");
        pessoaFisica3.setNome("PessoaFisica3");
        pessoaFisica4.setNome("PessoaFisica4");
        pessoaFisica5.setNome("PessoaFisica5");

        pessoaFisica1.setCPF("630.459.480-14");
        pessoaFisica2.setCPF("100.900.260-04");
        pessoaFisica3.setCPF("221.645.140-17");
        pessoaFisica4.setCPF("371.957.320-61");
        pessoaFisica5.setCPF("977.202.050-57");

        // Bens das empresas
        empresaA.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        empresaB.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        empresaC.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        empresaD.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));

        // Bens das pessoas Fisicas
        pessoaFisica1.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        pessoaFisica1.addBem(new BemImovelImp("Bem2", new BigDecimal("10.00")));

        pessoaFisica2.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        pessoaFisica2.addBem(new BemImovelImp("Bem2", new BigDecimal("10.00")));

        pessoaFisica3.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        pessoaFisica3.addBem(new BemImovelImp("Bem2", new BigDecimal("10.00")));

        pessoaFisica4.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        pessoaFisica4.addBem(new BemImovelImp("Bem2", new BigDecimal("10.00")));

        pessoaFisica5.addBem(new BemImovelImp("Bem1", new BigDecimal("10.00")));
        pessoaFisica5.addBem(new BemImovelImp("Bem2", new BigDecimal("10.00")));


        // Socios
        empresaA.addSocio(pessoaFisica1);
        empresaA.addSocio(pessoaFisica2);
        empresaA.addSocio(empresaD);

        empresaB.addSocio(empresaA);
        empresaB.addSocio(pessoaFisica3);

        empresaC.addSocio(empresaA);
        empresaC.addSocio(empresaB);
        empresaC.addSocio(empresaC);
        empresaC.addSocio(pessoaFisica1);

        empresaD.addSocio(pessoaFisica4);
        empresaD.addSocio(pessoaFisica5);
        empresaD.addSocio(empresaC);
    }

    @Test
    public void compromissoFinanceiro_EmpresaA_ValorCorreto() {
        Assert.assertEquals(new BigDecimal("140.00"), banco.comprometimentoFinanceiro(empresaA.getEstruturaSocietaria()));
    }

    @Test
    public void compromissoFinanceiro_EmpresaB_ValorCorreto() {
        Assert.assertEquals(new BigDecimal("140.00"),  banco.comprometimentoFinanceiro(empresaB.getEstruturaSocietaria()));
    }

    @Test
    public void compromissoFinanceiro_EmpresaC_ValorCorreto() {
        Assert.assertEquals(new BigDecimal("140.00"),  banco.comprometimentoFinanceiro(empresaC.getEstruturaSocietaria()));
    }

    @Test
    public void compromissoFinanceiro_EmpresaD_ValorCorreto() {
        Assert.assertEquals(new BigDecimal("140.00"),  banco.comprometimentoFinanceiro(empresaD.getEstruturaSocietaria()));
    }
}
