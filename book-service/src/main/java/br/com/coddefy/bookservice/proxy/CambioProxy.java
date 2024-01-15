package br.com.coddefy.bookservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.coddefy.bookservice.response.Cambio;


@FeignClient(name = "CAMBIO-SERVICE")
public interface CambioProxy {
    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") Double amount, @PathVariable("from") String from, @PathVariable("to") String to);
}
