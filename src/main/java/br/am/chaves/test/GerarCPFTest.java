package br.am.chaves.test;

import br.am.chaves.core.BaseTest;
import br.am.chaves.page.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class GerarCPFTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void gerarCPF(){
        homePage.setCPFSemPontuacao();
        homePage.setEstado("AM");

        String cpfGerado = null;

        do{
            homePage.clicarGerarCPF();
            cpfGerado = homePage.obterNumeroCPF();
        }while(!cpfGerado.startsWith("7"));

        Assert.assertTrue(cpfGerado.startsWith("7"));
    }

}
