package meucci.tpsit.springboot1.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    @GetMapping("/")
    public String index(){

        return "Hello spring boot!" ;
    }

    @GetMapping("/persona")
    public Persona persona(){

        return new Persona("Paolo", "Rossi");
    }

    @GetMapping("/persone")
    public ArrayList<Persona> persone(){

        ArrayList<Persona> persone = new ArrayList<>();
        Persona p1 = new Persona("Pippo", "Paperino");
        Persona p2 = new Persona("Pluto", "Topolino");
        persone.add(p1);
        persone.add(p2);
        return persone;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "surname", defaultValue = "surname") String surname){
        return String.format("Hello, %s %s!", name, surname);
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        return String.format("Hello, %s!", name);
    }
}
