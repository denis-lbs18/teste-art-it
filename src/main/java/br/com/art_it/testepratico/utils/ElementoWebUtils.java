package br.com.art_it.testepratico.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe que trabalha com wait do WebElement, permitindo que o objeto esteja
 * clicável antes de executar o código.
 * 
 * @author Denis Luna Borges da Silva
 *
 */
;

public class ElementoWebUtils {
	private WebDriver driver;

	/**
	 * Construtor da classe, recebe o WebDriver das demais classes.
	 * 
	 * @param driver WebDriver escolhido para executar os testes
	 */
	public ElementoWebUtils(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * retorna o codigo HTML da página
	 * 
	 * @return o codigo HTML da página
	 */
	public String getCodigoHTML() {
		driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	/**
	 * Getter para o Driver do objeto.
	 * 
	 * @return o driver da classe
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * Método que acha a referência WebElement na página. Usufrui do recurso
	 * {@link WebDriverWait}: A cada x segundos definidos pela constante
	 * {@link TempoTimeouts}.TEMPOPOLLING, será efetuada uma busca pelo elemento
	 * clicável, em até y segundos, com timeout definido pela constante
	 * {@link TempoTimeouts}.TEMPOWAIT.
	 * 
	 * @param by o identificador By do elemento a ser encontrado
	 * @return WebElement encontrado na página através do By
	 */
	public WebElement elementoWebAchaElementoClicavel(By by) {
		WebElement elemento = (new WebDriverWait(this.getDriver(), 30)).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(by));

		return elemento;
	}

	/**
	 * Método que acha a referência WebElement na página. Usufrui do recurso
	 * {@link WebDriverWait}: A cada x segundos definidos pela constante
	 * {@link TempoTimeouts}.TEMPOPOLLING, será efetuada uma busca pelo elemento
	 * visível, em até y segundos, com timeout definido pela constante
	 * {@link TempoTimeouts}.TEMPOWAIT.
	 * 
	 * @param by o identificador By do elemento a ser encontrado
	 * @return WebElement encontrado na página através do By
	 */
	public WebElement elementoWebAchaElementoVisivel(By by) {
		WebElement elemento = new WebDriverWait(this.getDriver(), 30).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(by));

		return elemento;
	}

	/**
	 * Método que executa um Thread.sleep, efetuando uma pausa no teste.
	 * 
	 * @param l quantidade de milissegundos que o teste deve aguardar
	 */
	private void sleep(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Método que permite inserir texto em um input WebElement. Recebe como
	 * parâmetros o By do elemento e o texto a ser inserido.
	 * 
	 * @param by    o identificador By do elemento a ser selecionado
	 * @param texto o texto a ser inserido dentro do campo de texto
	 */
	public void elementoWebInsereTexto(By by, String texto) {
		this.sleep(2);
		this.elementoWebAchaElementoVisivel(by).sendKeys(texto);
	}

	/**
	 * Método que permite utilizar o método click() em um WebElement.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 */
	public void elementoWebClica(By by) {
		WebElement elemento = this.elementoWebAchaElementoVisivel(by);
		elemento.click();
	}

	/**
	 * Método que efetua um clique em um elemento, através de {@link Actions}.
	 * 
	 * @param by
	 */
	public void elementoWebClicaActions(By by) {
		WebElement elementoSVG = this.elementoWebAchaElementoVisivel(by);
		Actions acaoSVG = new Actions(this.getDriver());
		acaoSVG.moveToElement(elementoSVG).click().build().perform();
	}

	/**
	 * Método que limpa o texto do elemento web.
	 * 
	 * @param by o identificador By do elemento a ser selecionado
	 */
	public void elementoWebLimpa(By by) {
		this.sleep(1);
		this.elementoWebAchaElementoClicavel(by).clear();
	}
}