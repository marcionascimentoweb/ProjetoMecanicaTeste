package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class RealizarCadastroFaleConosco {
	
		WebDriver driver; //Selenium WebDriver
	
		@Dado("^Acessar a página$")
		public void acessar_a_página() {
		    
			//Local do driver
			System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
			
			//abre o navegador
			driver = new ChromeDriver();
			
			//Maximizando o navegador
			driver.manage().window().maximize();
			
			//acessar a página de login de usuários
			driver.get("http://localhost:4200/faleconosco");
			
		}

		@Dado("^Informar o nome do cliente \"([^\"]*)\"$")
		public void informar_o_nome_do_cliente(String nome) {
		    driver.findElement(By.xpath("//*[@id=\"nome\"]")).sendKeys(nome);
		}

		@Dado("^Informar o email do cliente \"([^\"]*)\"$")
		public void informar_o_email_do_cliente(String email) {
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
		}

		@Dado("^Informar o telefone do cliente \"([^\"]*)\"$")
		public void informar_o_telefone_do_cliente(String telefone) {
			driver.findElement(By.xpath("//*[@id=\"tel\"]")).sendKeys(telefone);
		}

		@Dado("^Informar a mensagem desejada \"([^\"]*)\"$")
		public void informar_a_mensagem_desejada(String mensagem) {
		    driver.findElement(By.xpath("//*[@id=\"msg\"]")).sendKeys(mensagem);
		}

		@Quando("^Solicitar o envio do formulário$")
		public void solicitar_o_envio_do_formulário() {
			driver.findElement(By.xpath("//*[@id=\"gravar\"]")).click();
		}

		@Então("^Sistema envia o formulário$")
		public void sistema_envia_o_formulário() {
			String mensagem = driver.findElement(By.xpath("/html/body/app-root[1]/app-cadastrar-fale-conosco/section/article[2]/div/label[5]/p")).getText();
			assertEquals(mensagem, "Preenchido com Sucesso");
		
		try {
			//gerando evidencias
			File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\projetos\\Projeto_Mecanica_2020B\\testes\\evidencias"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		}

}
