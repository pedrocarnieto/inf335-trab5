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

class AnuncianteBeanTest {
	private static AnuncianteBean anunciante = new AnuncianteBean();
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
		// Inicializa novamente o anunciante e reconstroi suas variaveis
		anunciante = new AnuncianteBean();
		
		String nome = "Casa digitalizada";
		String cPF = "123.456.789-12";
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		
		ProdutoBean produto1 = new ProdutoBean("ABC123", "Calculadora", "Digital", 312.14, "RJ");
		ArrayList<URL> fotosUrl1 = new ArrayList<URL>();
		try {
			fotosUrl1.add(new URL("https://www.freephotos1.com"));
			fotosUrl1.add(new URL("https://www.getphotos1.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto1 = 0.132;
		
		AnuncioBean anuncio1 = new AnuncioBean(produto1, fotosUrl1, desconto1);
		
		anuncios.add(anuncio1);
		
		ProdutoBean produto2 = new ProdutoBean("DEF456", "Geladeira", "GelaRapido", 5345.49, "AC");
		ArrayList<URL> fotosUrl2 = new ArrayList<URL>();
		try {
			fotosUrl2.add(new URL("https://www.freephotos2.com"));
			fotosUrl2.add(new URL("https://www.getphotos2.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto2 = 0.0571;
		
		AnuncioBean anuncio2 = new AnuncioBean(produto2, fotosUrl2, desconto2);
		
		anuncios.add(anuncio2);
		
		anunciante = new AnuncianteBean(nome, cPF, anuncios);
		System.out.println("Antes do teste número = " + testNumber);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Após teste número = " + testNumber);
		testNumber++;
	}
	
	@Test
	void testAddAnuncioTamanho() {
		// Cria novo anuncio para ser adicionado na lista de anuncios
		ProdutoBean produto3 = new ProdutoBean("FGH789", "Monitor", "LED", 866.29, "RN");
		ArrayList<URL> fotosUrl3 = new ArrayList<URL>();
		try {
			fotosUrl3.add(new URL("https://www.freephotos3.com"));
			fotosUrl3.add(new URL("https://www.getphotos3.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto3 = 0.0741;
				
		AnuncioBean anuncio3 = new AnuncioBean(produto3, fotosUrl3, desconto3);
				
		int numAnunciosAntesAdd = anunciante.getAnuncios().size();
				
		anunciante.addAnuncio(anuncio3);
				
		// Verifica se o tamanho da lista aumentou
		assertEquals(anunciante.getAnuncios().size(), numAnunciosAntesAdd + 1);
	}

	@Test
	void testAddAnuncio() {
		// Cria novo anuncio para ser adicionado na lista de anuncios
		ProdutoBean produto3 = new ProdutoBean("FGH789", "Monitor", "LED", 866.29, "RN");
		ArrayList<URL> fotosUrl3 = new ArrayList<URL>();
		try {
			fotosUrl3.add(new URL("https://www.freephotos3.com"));
			fotosUrl3.add(new URL("https://www.getphotos3.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto3 = 0.0741;
						
		AnuncioBean anuncio3 = new AnuncioBean(produto3, fotosUrl3, desconto3);
						
		int numAnunciosAntesAdd = anunciante.getAnuncios().size();
						
		anunciante.addAnuncio(anuncio3);
		
		// Verifica se o anuncio foi adicionado corretamente
		assertEquals(anunciante.getAnuncios().get(numAnunciosAntesAdd), anuncio3);
	}
	
	@Test
	void testRemoveAnuncioVazio() {
		// Nao podemos remover itens de lista vazia
		AnuncianteBean anunciante2 = new AnuncianteBean();
		assertDoesNotThrow(() -> anunciante2.removeAnuncio(0));	
	}
	
	@Test
	void testRemoveAnuncioNegativo() {
		// Nao podemos remover anuncios em indice negativo
		assertDoesNotThrow(() -> anunciante.removeAnuncio(-2));
	}
	
	@Test
	void testRemoveAnuncioMaior() {
		// Nao podemos remover anuncios de indice igual ou maior ao
		// tamanho da lista de anuncios
		int numAnuncios = anunciante.getAnuncios().size();
		assertDoesNotThrow(() -> anunciante.removeAnuncio(numAnuncios));
	}
	
	@Test
	void testRemoveAnuncioTamanho() {
		// Verifica se o tamanho da lista muda ao remover anuncio
		int numAnunciosAntesRem = anunciante.getAnuncios().size();
		anunciante.removeAnuncio(0);
		assertEquals(anunciante.getAnuncios().size(), numAnunciosAntesRem - 1);
	}

	@Test
	void testRemoveAnuncio() {
		// Verifica se o elemento removido ainda esta na lista de anuncios
		// Cria novo anuncio para ser adicionado na lista de anuncios
		ProdutoBean produto4 = new ProdutoBean("IJK321", "Celular", "Snapdragon", 3123.29, "MS");
		ArrayList<URL> fotosUrl4 = new ArrayList<URL>();
		try {
			fotosUrl4.add(new URL("https://www.freephotos4.com"));
			fotosUrl4.add(new URL("https://www.getphotos4.com"));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		double desconto4 = 0.026;
		
		AnuncioBean anuncio4 = new AnuncioBean(produto4, fotosUrl4, desconto4);
		
		int numAnunciosAntesRem = anunciante.getAnuncios().size();
		
		// Adiciona anuncio na lista e depois remove
		anunciante.addAnuncio(anuncio4);
		numAnunciosAntesRem = anunciante.getAnuncios().size();
		anunciante.removeAnuncio(numAnunciosAntesRem - 1);

		assertFalse(anunciante.getAnuncios().contains(anuncio4));
	}
	
	@Test
	void testValorMedioAnunciosVazio() {
		// Nao podemos calcular valor medio de lista vazia de anuncios
		AnuncianteBean anunciante2 = new AnuncianteBean();
		assertDoesNotThrow(() -> anunciante2.valorMedioAnuncios());	
	}
	
	@Test
	void testValorMedioAnunciosNegativo() {
		// Valor medio de anuncios nao pode ser negativo
		assertFalse(anunciante.valorMedioAnuncios() < 0);
	}
	
	@Test
	void testValorMedioAnuncios() {
		// Verifica calculo de valor medio de anuncios
		double valorProduto1 = anunciante.getAnuncios().get(0).getValor();
		double valorProduto2 = anunciante.getAnuncios().get(1).getValor();
		double valorMedio = (valorProduto1 + valorProduto2) / 2;
		assertEquals(anunciante.valorMedioAnuncios(), valorMedio);
	}
}
