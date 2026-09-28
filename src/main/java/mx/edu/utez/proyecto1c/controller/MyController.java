package mx.edu.utez.proyecto1c.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    private final String NOMBRE_ALUMNO = "Angel Said Brito Ibarra";

    @GetMapping("/fizzbuzz/{n}")
    public Map<String, String> fizzbuzz(@PathVariable int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("respuesta", NOMBRE_ALUMNO);
        return respuesta;
    }

    @GetMapping("/fibonacci/{n}")
    public Map<String, String> fibonacci(@PathVariable int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("respuesta", NOMBRE_ALUMNO);
        return respuesta;
    }
}