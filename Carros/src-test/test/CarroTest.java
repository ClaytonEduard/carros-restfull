package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import junit.framework.TestCase;

class CarroTest extends TestCase {

	private CarroService carroService = new CarroService();

	@Test
	public void testListaCarros() {

		List<Carro> carros = carroService.getCarros();
		assertNotNull(carros);
		// Valida se encontrou algo
		assertTrue(carros.size() > 0);
		// Valida se encontrou o Tucker
		Carro tucker = carroService.findByName("Tucker 1948").get(0);
		assertEquals("Tucker 1948", tucker.getNome());
		// Valida se encontrou a Ferrari
		Carro ferrari = carroService.findByName("Ferrari FF").get(0);
		assertEquals("Ferrari FF", ferrari.getNome());
		// Valida se encontrou o Bugatti
		Carro bugatti = carroService.findByName("Bugatti Veyron").get(0);
		assertEquals("Bugatti Veyron", bugatti.getNome());
	}

	@Test
	public void testSalvarDeletarCarro() {
		Carro c = new Carro();
		c.setNome("Teste");
		c.setDesc("Teste Desc");
		c.setUrlFoto("url foto aqui");
		c.setUrlVideo("url foto aqui");
		c.setLatitude("lat");
		c.setLongitude("long");
		c.setTipo("tipo");
		carroService.save(c);

		// id do carro salvo
		Long id = c.getId();
		assertNotNull(id);

		// busca no banco de dados para confirmar que o carro foi salvo
		c = carroService.getCarro(id);
		assertEquals("Teste", c.getNome());
		assertEquals("Teste Desc", c.getDesc());
		assertEquals("url foto aqui", c.getUrlFoto());
		assertEquals("url foto aqui", c.getUrlVideo());
		assertEquals("lat", c.getLatitude());
		assertEquals("long", c.getLongitude());
		assertEquals("tipo", c.getTipo());

		// atualizar o carro

		c.setNome("Teste Update");
		carroService.save(c);

		// buscar carro novamente (vai estar atualizado)
		c = carroService.getCarro(id);

		assertEquals("Teste Update", c.getNome());

		// deletar o carro

		carroService.delete(id);

		// buscar novamente

		c = carroService.getCarro(id);

		// dessa vez o carro nao existe mais

		assertNull(c);

	}
}
