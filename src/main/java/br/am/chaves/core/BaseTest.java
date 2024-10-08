package br.am.chaves.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.am.chaves.core.DriverFactory.getDriver;
import static br.am.chaves.core.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @Before
    public void inicializa(){
        getDriver().get("https://www.4devs.com.br/gerador_de_cpf");
    }

    @After
    public void finaliza() throws IOException {

        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

        if(Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }

}
