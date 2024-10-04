package br.am.chaves.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static br.am.chaves.core.DriverFactory.getDriver;

public class HomePage {

    public void setCPFSemPontuacao(){
        getDriver().findElement(By.id("pontuacao_nao")).click();
    }

    public void setEstado(String uf){
        WebElement elemento = getDriver().findElement(By.id("cpf_estado"));
        Select combo = new Select(elemento);
        combo.selectByVisibleText(uf);
    }

    public void clicarGerarCPF(){
        getDriver().findElement(By.id("bt_gerar_cpf")).click();
    }

    public String obterNumeroCPF(){
        String cpfGerado = getDriver().findElement(By.id("texto_cpf")).getText();
        return cpfGerado;
    }

}
