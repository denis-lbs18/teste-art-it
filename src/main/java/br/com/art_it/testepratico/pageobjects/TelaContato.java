package br.com.art_it.testepratico.pageobjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaContato extends TelaBase {
	private By inputNome = By.id("fld_8768091_1");
	private By inputEnderecoEmail = By.id("fld_6009157_1");
	private By inputTelefone = By.id("fld_9033886_1");

	public TelaContato(WebDriver driver) {
		super(driver);
	}

	public void insereInputNome(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputNome, texto);
	}

	public void insereInputEnderecoEmail(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputEnderecoEmail, texto);
	}

	public void insereInputTelefone(String texto) {
		this.getElemento().elementoWebInsereTexto(this.inputTelefone, texto);
	}

	public void preencheDadosFicticios() {
		this.insereInputNome("Lorem Ipsum");
		this.insereInputEnderecoEmail("lipsum@quia.dolor.com");
		this.insereInputTelefone("11987654321");
		LocalDateTime dataHoraAtual = LocalDateTime.now();
		String nomeArquivo = "Evidencia" + dataHoraAtual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		this.tiraScreenShot(nomeArquivo);
	}
}
