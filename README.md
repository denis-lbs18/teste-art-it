# Projeto de avaliação prática

## Sobre
Este projeto serve como avaliação em um teste prático.

## Configuração do ambiente de desenvolvimento

Pré-requisitos

* [Java] 1.8
* [GIT] (https://git-for-windows.github.io/) versão mais atual é recomendada
* [Maven](http://pow.cx/) versão 3.2.1
* [Eclipse] versão mais atual

## Clone do projeto

Abra o prompt gitbash, entre na estrutura de sua workspace, apague as pastas existentes e digite o comando abaixo:

```sh
	git clone https://github.com/denis-lbs18/teste-art-it.git
```

## Configuração do WebDriver

Drivers recomendados:

* Chromedriver:

```sh
    https://sites.google.com/a/chromium.org/chromedriver/downloads
```
* Geckodriver (Firefox):

```sh
    https://github.com/mozilla/geckodriver/releases
```

* Baixe o driver do seu navegador escolhido (Firefox, Chrome, Safari, etc...) compatível com a versão instalada em sua máquina, e extraia os arquivos baixados para uma pasta de drivers.

* Crie uma variável de ambiente em seu sistema operacional chamada WebDrivers, apontada para a pasta onde estão os drivers baixados.

* Adicione na variável PATH do seu sistema operacional a variável WebDrivers, permitindo que todos os projetos de automação acessem o driver do navegador escolhido.

## Execução do projeto

Com o eclipse aberto, basta abrir a classe [b]CadastraCurriculo[/b], e executá-la como uma classe Java [i](Run > Run as > Java Application).[/i]

Caso não possua o eclipse, basta executar o Jar denominado CadastraCurriculo.jar, situado na raiz do diretório do projeto [i](java -jar CadastraCurriculo.jar)[/i].

## Evidência

A evidência do teste estará na pasta criada dentro da raiz do projeto, chamada "output". Para cada execução, será criado um arquivo de evidência do tipo PNG, com o nome "Evidência" + data e hora atual.