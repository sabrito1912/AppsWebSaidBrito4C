# Proyecto 1C

Repositorio de trabajos y prácticas desarrollados con Java y Spring Boot.

## Datos del alumno

- **Nombre:** Angel Said Brito Ibarra
- **Grado y grupo:** 4C
- **Carrera:** DS


## Cómo ejecutar el proyecto

Desde IntelliJ, ejecuta la clase `Proyecto1cApplication` y déjala corriendo.
El servidor queda disponible en `http://localhost:8080`.

## Trabajos

### Servicios REST: FizzBuzz y Fibonacci

Ambos servicios usan método GET con path-variable. La secuencia se imprime en la consola del servidor y la respuesta JSON contiene el nombre del alumno.

#### Cómo probarlos con Postman

1. Con el proyecto en ejecución, abre Postman y crea una nueva petición HTTP (**New** > **HTTP Request**).
2. Selecciona el método **GET**.
3. Escribe la URL del servicio y presiona **Send**.
4. Revisa la respuesta en la pestaña **Body** de Postman y la secuencia en la consola donde corre el proyecto.

#### Servicio 1: FizzBuzz

- **URL:** `GET http://localhost:8080/fizzbuzz/{n}`
- **Ejemplo:** `http://localhost:8080/fizzbuzz/5`
- **Consola:**

```
1
2
Fizz
4
Buzz
```

- **Respuesta en Postman:**

```json
{
  "respuesta": "Angel Said Brito Ibarra"
}
```

#### Servicio 2: Fibonacci

- **URL:** `GET http://localhost:8080/fibonacci/{n}`
- **Ejemplo:** `http://localhost:8080/fibonacci/6`
- **Consola:**

```
0
1
1
2
3
5
```

- **Respuesta en Postman:**

```json
{
  "respuesta": "Angel Said Brito Ibarra"
}
```