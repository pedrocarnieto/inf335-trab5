package br.unicamp.ic.inf335.inf335_trab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoBeanTest {
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
	void testCompareToVazio() {
		ProdutoBean produto1 = new ProdutoBean("ABC123", "Palio", "0km", 31233.14, "RJ");
		ProdutoBean produto2 = new ProdutoBean();
		
		// Compara os valores dos produtos quando produto2 é vazio
		assertDoesNotThrow(() -> produto1.compareTo(produto2));
	}
	
	@Test
	void testCompareToDoisVazio() {
		ProdutoBean produto1 = new ProdutoBean();
		ProdutoBean produto2 = new ProdutoBean();
		
		// Compara os valores dos produtos quando produto2 é vazio
		assertDoesNotThrow(() -> produto1.compareTo(produto2));
	}

	@Test
	void testCompareToMenor() {
		ProdutoBean produto1 = new ProdutoBean("ABC123", "Palio", "0km", 31233.14, "RJ");
		ProdutoBean produto2 = new ProdutoBean("DEF456", "Geladeira", "GelaRapido", 5345.49, "AC");
		
		// Compara os valores dos produtos quando valor produto1 é maior do que o valor do produto2
		assertEquals(produto1.compareTo(produto2), 1);
	}
	
	@Test
	void testCompareToMaior() {
		ProdutoBean produto1 = new ProdutoBean("ABC143", "Calculo 1", "Academico", 313.14, "ES");
		ProdutoBean produto2 = new ProdutoBean("DEF456", "Geladeira", "GelaRapido", 5345.49, "AC");
		
		// Compara os valores dos produtos quando valor produto1 é menor do que o valor do produto2
		assertEquals(produto1.compareTo(produto2), -1);
	}
	
	@Test
	void testCompareToIgual() {
		ProdutoBean produto1 = new ProdutoBean("ABC143", "Calculo 1", "Academico", 353.14, "ES");
		ProdutoBean produto2 = new ProdutoBean("ABC144", "Calculo 2", "Academico", 353.14, "AM");
		
		// Compara os valores dos produtos quando valor produto1 é igual ao valor do produto2
		assertEquals(produto1.compareTo(produto2), 0);
	}

}
