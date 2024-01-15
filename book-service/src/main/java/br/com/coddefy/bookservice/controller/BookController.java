package br.com.coddefy.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coddefy.bookservice.model.Book;
import br.com.coddefy.bookservice.proxy.CambioProxy;
import br.com.coddefy.bookservice.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book")
@RestController
@RequestMapping("book-service")
public class BookController {
	 	@Autowired
	    private Environment environment;
	    

	    @Autowired
	    private BookRepository bookRepository;
	    
	    @Autowired
	    private CambioProxy cambioProxy;

	    @Operation(summary = "Find especific book by your ID")
	    @GetMapping(value = "/{id}/{currency}")
	    public Book getBook(@PathVariable Long id, @PathVariable String currency){
	    	
	    	var port = environment.getProperty("local.server.port");
	    	var book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Nenhum cambio encontrado!"));
	    	
	    	
	    	var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
	    	
	    	book.setEnvironment("Book Port: " + port + "Cambio Port: " + cambio.getEnvironment());
	    	book.setPrice(cambio.getConvertedValue());
	    	book.setCurrency(currency);
	        return book;
	    	//return new Book(1l, "Victor Dornelas", "Aprendendo Java", new Date(), Double.valueOf(13.51), currency, port);
	    }
	
}
