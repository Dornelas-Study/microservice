package br.com.coddefy.cambioservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.coddefy.cambioservice.model.Cambio;
import br.com.coddefy.cambioservice.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cambio")
@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;
    

    @Autowired
    private CambioRepository cambioRepository;

    @Operation(summary = "Find especific cambio by your ID")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to){
    	
    	var port = environment.getProperty("local.server.port");
    	var cambio = cambioRepository.findByFromAndTo(from, to);
    	
    	if (ObjectUtils.isEmpty(cambio))
    		throw new RuntimeException("Nenhum cambio encontrado!");
    	
    	var conversionFactor = cambio.getConversionFactor();
    	var convertedValue = conversionFactor.multiply(amount);
    	cambio.setEnvironment(port);
    	cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        return cambio;
    }
}
