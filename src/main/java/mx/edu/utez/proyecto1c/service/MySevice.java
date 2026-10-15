package mx.edu.utez.proyecto1c.service;

import mx.edu.utez.proyecto1c.controller.dto.RequestCalculadoraDTO;
import mx.edu.utez.proyecto1c.exception.customExceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class MySevice {

    public double calculadora(RequestCalculadoraDTO payload) {
        if(!payload.getOperacion().equals("DIVISION")
            && !payload.getOperacion().equals("MULTIPLICACION")
            && !payload.getOperacion().equals("RESTA")
            && !payload.getOperacion().equals("SUMA")){
            throw new BadRequestException("La operacion no es valida");
        }
        double resultado = 0;

        switch (payload.getOperacion()) {
            case "MULTIPLICACIÓN":
                resultado = payload.getNum1() * payload.getNum2();
                break;
            case "SUMA":
                resultado = payload.getNum1() + payload.getNum2();
                break;
            case "RESTA":
                resultado = payload.getNum1() - payload.getNum2();
                break;
            case "DIVISIÓN":
                if (payload.getNum2() == 0) {
                    throw new IllegalArgumentException("No se puede dividir entre cero");
                }
                resultado = payload.getNum1() / payload.getNum2();
                break;
            default:
                throw new IllegalArgumentException("Operación no válida: " + payload.getOperacion());
        }

        return resultado;
    }
}