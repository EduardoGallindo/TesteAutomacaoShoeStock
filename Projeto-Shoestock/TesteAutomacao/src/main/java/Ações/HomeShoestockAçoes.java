package Ações;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Elementos.HomeShoestockElementos;
import Util.Util;

public class HomeShoestockAçoes extends Util {

	WebDriver driver;
	WebDriverWait wait;

	public HomeShoestockAçoes(WebDriver driver) {
		this.driver = driver;
	}

	public void validarSite() {
		Assert.assertEquals("shoestock: Paixão por Sapatos | Loja de Calçados Online", driver.getTitle());
	}

	public void buscarProduto(List<String> produtos, int contadorProduto) throws InterruptedException {
		Thread.sleep(2000);
		String Produto = produtos.get(contadorProduto);
		preencheCampo(driver, HomeShoestockElementos.campoBuscar, Produto);
		try {
			click(driver, HomeShoestockElementos.submitBuscar);
		} catch (Exception e) {
			click(driver, HomeShoestockElementos.submitBuscarCarrinho);
		}
	}

	public void adicionarProdutoAoCarrinho(List<String> produtos, int contadorProduto) throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		String ProdutoMsg = produtos.get(contadorProduto);
		String Produto = ProdutoMsg.toLowerCase().replace(" ", "-");
		clickJS(driver, HomeShoestockElementos.validaProduto2(Produto));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomeShoestockElementos.botaoComprar));
		click(driver, HomeShoestockElementos.selecionarTamanho);
		click(driver, HomeShoestockElementos.botaoComprar);
		System.out.println("Produto " + ProdutoMsg + " adicionado ao carrinho.");
	}

	public void realizarLogin(String email, String senha) throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomeShoestockElementos.botaoContinuar));
		click(driver, HomeShoestockElementos.botaoContinuar);

		wait.until(ExpectedConditions.visibilityOfElementLocated(HomeShoestockElementos.campoEmail));
		preencheCampo(driver, HomeShoestockElementos.campoEmail, email);
		preencheCampo(driver, HomeShoestockElementos.campoSenha, senha);
		click(driver, HomeShoestockElementos.botaoLogin);
		System.out.println("Login realizado");

	}

	public void validarTelaPagamento() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomeShoestockElementos.sumarioPagamento));
		Assert.assertEquals("https://www.shoestock.com.br/checkout", driver.getCurrentUrl());
	}

	public void validarProdutosCarrinho(List<String> produtos) {
		wait = new WebDriverWait(driver, 5);
		for (String produto : produtos) {
			String ProdutoCarrinho = driver.findElement(HomeShoestockElementos.validaProdutoCarrinho(produto, 1))
					.getText();
			String ProdutoPedido = driver.findElement(HomeShoestockElementos.validaProdutoCarrinho(produto, 2))
					.getText();
			Assert.assertEquals(produto, ProdutoCarrinho);
			System.out.println("Carrinho com produto " + ProdutoCarrinho + " validado com sucesso.");
			Assert.assertEquals(produto, ProdutoPedido);
			System.out.println("Pedido com produto " + ProdutoPedido + " validado com sucesso.");
		}
	}

}
