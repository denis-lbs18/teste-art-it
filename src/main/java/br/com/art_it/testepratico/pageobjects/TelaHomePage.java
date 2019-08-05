package br.com.art_it.testepratico.pageobjects;

import static br.com.art_it.testepratico.constants.Constantes.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaHomePage extends TelaBase {
	private By menuContato = By.xpath("//a[text()='Contato']");

	public TelaHomePage(WebDriver driver) {
		super(driver);
	}

	public TelaContato clicaMenuContato() {
		this.getElemento().elementoWebClica(this.menuContato);
		return new TelaContato(this.getDriver());
	}

	public void abreURLTeste() {
		this.getDriver().get(URL);
	}
}
