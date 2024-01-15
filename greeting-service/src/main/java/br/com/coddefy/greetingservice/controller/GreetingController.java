package br.com.coddefy.greetingservice.controller;

import br.com.coddefy.greetingservice.config.GreetingConfiguration;
import br.com.coddefy.greetingservice.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration greetingConfiguration;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if(name.isEmpty())
            name = greetingConfiguration.getDefaultValue();
        return new Greeting(counter.incrementAndGet(), String.format(template, greetingConfiguration.getGreeting(), name));
    }
}
