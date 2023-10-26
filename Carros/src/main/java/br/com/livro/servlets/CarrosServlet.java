package br.com.livro.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.livro.domain.Carro;
import br.com.livro.domain.CarroService;
import br.com.livro.domain.ListaCarros;
import br.com.livro.util.JAXBUtil;
import br.com.livro.util.ServletUtil;

@WebServlet("/carros/*")
public class CarrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarroService carroService = new CarroService();

	@SuppressWarnings("static-access")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Carro> carros = carroService.getCarros();
		ListaCarros lista = new ListaCarros();
		lista.setCarros(carros);
		// Gerar o XML
		/*
		 * JAXBUtil j = new JAXBUtil(); String xml = j.toXML(lista); //Escreve o XML na
		 * response do Servlet com a APPLICATION/XML ServletUtil.writeXML(resp, xml);
		 */

		// usando o Jettison
		// Gera o JSON
		/*
		 * String json = JAXBUtil.toJSON(lista); ///Escreve o XML na response do Servlet
		 * com a APPLICATION/XML ServletUtil.writeJSON(resp, json);
		 */

		// Usando o JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(lista);
		/// Escreve o XML na response do Servlet com a APPLICATION/XML
		ServletUtil.writeJSON(resp, json);
	}

}
