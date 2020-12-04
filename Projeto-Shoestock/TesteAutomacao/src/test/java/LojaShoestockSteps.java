

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Ações.HomeShoestockAçoes;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LojaShoestockSteps {

	WebDriver driver;
	HomeShoestockAçoes home;
	List<String> produtos = new ArrayList<String>();
	int ContadorProduto = 0;
	String email = "testeautomacao@mailinator.com";
	String senha = "Automacao123";

	@Before
	public void inicializarCenário() {
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir + "\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		home = new HomeShoestockAçoes(driver);
	}

	@After
	public void finalizar() {
		driver.close();
		driver.quit();
	}

	@Dado("que acessei o site da Shoestock")
	public void que_acessei_o_site_da_shoestock() {
		driver.get("https://www.shoestock.com.br");
		home.validarSite();
	}

	@Dado("que quero comprar o produto {string}")
	public void que_quero_comprar_o_produto(String produto) {
		produtos.add(produto);
	}

	@Quando("buscar o produto")
	public void buscar_o_produto() throws InterruptedException {
		home.buscarProduto(produtos, ContadorProduto);
	}

	@Quando("adicionar o produto em meu carrinho")
	public void adicionar_o_produto_em_meu_carrinho() throws InterruptedException {
		home.adicionarProdutoAoCarrinho(produtos, ContadorProduto);
		ContadorProduto++;
	}

	@Então("vou realizar o login na minha conta")
	public void vou_realizar_o_login_na_minha_conta() throws InterruptedException {
		home.realizarLogin(email, senha);
	}

	@Então("seguir para a tela de pagamento")
	public void seguir_para_a_tela_de_pagamento() {
		home.validarTelaPagamento();
	}

	@Então("devo validar que os produtos selecionados estão no meu carrinho")
	public void devo_validar_que_os_produtos_selecionados_estão_no_meu_carrinho() {
		home.validarProdutosCarrinho(produtos);
	}
}
