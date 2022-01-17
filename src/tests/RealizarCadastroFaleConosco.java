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
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class RealizarCadastroFaleConosco {
	
		WebDriver driver; //Selenium WebDriver
	
		@Dado("^Acessar a p�gina$")
		public void acessar_a_p�gina() {
		    
			//Local do driver
			System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
			
			//abre o navegador
			driver = new ChromeDriver();
			
			//Maximizando o navegador
			driver.manage().window().maximize();
			
			//acessar a p�gina de login de usu�rios
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

		@Quando("^Solicitar o envio do formul�rio$")
		public void solicitar_o_envio_do_formul�rio() {
			driver.findElement(By.xpath("//*[@id=\"gravar\"]")).click();
		}

		@Ent�o("^Sistema envia o formul�rio$")
		public void sistema_envia_o_formul�rio() {
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
