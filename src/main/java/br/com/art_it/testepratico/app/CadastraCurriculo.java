package br.com.art_it.testepratico.app;

import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.art_it.testepratico.pageobjects.TelaContato;
import br.com.art_it.testepratico.pageobjects.TelaHomePage;

public class CadastraCurriculo {

	public static void main(String[] args) {
		TelaHomePage telaHomePage = new TelaHomePage(new FirefoxDriver());
		telaHomePage.abreURLTeste();
		TelaContato telaContato = telaHomePage.clicaMenuContato();
		telaContato.preencheDadosFicticios();
		telaContato.fecha();
	}
}
