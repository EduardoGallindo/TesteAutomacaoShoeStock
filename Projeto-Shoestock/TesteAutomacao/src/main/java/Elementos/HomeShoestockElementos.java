package Elementos;

import org.openqa.selenium.By;

public class HomeShoestockElementos {
	public static final By campoBuscar = By.xpath("//input[contains(@id,'search')]");
	public static final By submitBuscar = By.xpath("//button[@title='Buscar']");
	public static final By submitBuscarCarrinho = By.xpath("//button[@class='search__button']");
	public static final By botaoComprar = By.xpath("//button[@id ='buy-button-now']");
	public static final By selecionarTamanho = By.xpath("(//a[@data-size='size-36'])[1]");
	public static final By botaoContinuar = By.xpath("//a[@qa-auto ='cart-buy-button']");
	public static final By campoEmail = By.xpath("//input[@id='username']");
	public static final By campoSenha = By.xpath("//input[@id='password']");
	public static final By botaoLogin = By.xpath("//button[@id='login-button']");
	public static final By sumarioPagamento = By.xpath("//h2[contains(@class,'summary-title') and text()='Pagamento']");

	public static By validaProduto(String produto) {
		By Produto = By.xpath("(//span[text()='" + produto + "'])[1]");
		return Produto;
	}

	public static By validaProduto2(String produto) {
		By Produto = By
				.xpath("(//a[contains(@href,'" + produto + "') and @class='item-card__description__product-name'])[1]");
		return Produto;
	}

	public static By validaProdutoCarrinho(String produto, int i) {
		By Produto = By
				.xpath("(//strong[contains(text(),'" + produto + "') and @class='product-name name'])[" + i + "]");
		return Produto;
	}

}
