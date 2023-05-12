package br.unicamp.ic.inf335.inf335_trab4;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnuncioBeanTest {
	private static int testNumber = 1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Teste inicializado");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Teste finalizado");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Antes do teste número = " + testNumber);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Após teste número = " + testNumber);
		testNumber++;
	}

	@Test
	void testGetValorNegativo() {
		ProdutoBean produto1 = new ProdutoBean("ABC123", "Calculadora", "Digital", 312.14, "RJ");
		ArrayList<URL> fotosUrl1 = new ArrayList<URL>();
		try {
			fotosUrl1.add(new URL("https://www.freephotos1.com"));
			fotosUrl1.add(new URL("https://www.getphotos1.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto1 = 1.352;
		
		AnuncioBean anuncio1 = new AnuncioBean(produto1, fotosUrl1, desconto1);
		assertFalse(anuncio1.getValor() > produto1.getValor());
	}
	
	@Test
	void testGetValorMaiorQuePermitido() {
		ProdutoBean produto1 = new ProdutoBean("ABC123", "Calculadora", "Digital", 312.14, "RJ");
		ArrayList<URL> fotosUrl1 = new ArrayList<URL>();
		try {
			fotosUrl1.add(new URL("https://www.freephotos1.com"));
			fotosUrl1.add(new URL("https://www.getphotos1.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto1 = -0.352;
		
		AnuncioBean anuncio1 = new AnuncioBean(produto1, fotosUrl1, desconto1);
		assertFalse(anuncio1.getValor() < 0);
	}
	
	@Test
	void testGetValorExato() {
		ProdutoBean produto1 = new ProdutoBean("ABC123", "Calculadora", "Digital", 100.00, "RJ");
		ArrayList<URL> fotosUrl1 = new ArrayList<URL>();
		try {
			fotosUrl1.add(new URL("https://www.freephotos1.com"));
			fotosUrl1.add(new URL("https://www.getphotos1.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto1 = 0.5;
		double valorEsperado = 50.0;
		
		AnuncioBean anuncio1 = new AnuncioBean(produto1, fotosUrl1, desconto1);
		assertEquals(anuncio1.getValor(), valorEsperado);
	}
}
