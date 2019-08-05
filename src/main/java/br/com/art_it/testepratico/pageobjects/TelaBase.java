package br.com.art_it.testepratico.pageobjects;

import static br.com.art_it.testepratico.constants.Constantes.OUTPUT;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.art_it.testepratico.utils.ElementoWebUtils;

public class TelaBase {
	private WebDriver driver;
	private ElementoWebUtils elemento;

	public TelaBase(WebDriver driver) {
		this.driver = driver;
		this.elemento = new ElementoWebUtils(this.driver);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ElementoWebUtils getElemento() {
		return elemento;
	}

	protected void tiraScreenShot(String nomeArquivo) {
		try {
			TakesScreenshot source = (TakesScreenshot) this.getDriver();
			File scr = source.getScreenshotAs(OutputType.FILE);
			String nomeFinal = String.format("%1$s/%2$s.%3$s", OUTPUT, nomeArquivo, "png");
			System.out.println(nomeFinal);
			FileUtils.copyFile(scr, new File(nomeFinal));
		} catch (Exception ex) {
			System.out.println("Erro na escrita de arquivo de evidência.");
			System.out.println("Erro:" + ex.toString());
		}
	}

	public void fecha() {
		this.getDriver().quit();
	}
}
