# Actividad: Diseño de Casos de Prueba con JUnit4

## Objetivo

El objetivo de esta actividad es que los estudiantes diseñen e implementen casos de prueba unitarios en **JUnit4** para validar el funcionamiento del método `validateIdentifier` definido en la clase `Identifier`. Además, deberán aplicar el criterio de **Particionamiento de Equivalencia** para identificar clases válidas e inválidas de entradas, y corregir identificadores inválidos para que se conviertan en válidos.

---

## Descripción del Código

La clase `Identifier` contiene un método `validateIdentifier(String s)` que valida si una cadena cumple con las reglas siguientes:

1. El identificador debe comenzar con una **letra** (mayúscula o minúscula).
2. Los caracteres siguientes (si los hay) pueden ser **letras o dígitos**.
3. La longitud total del identificador debe ser **de 1 a 5 caracteres** (inclusive).

Ejemplos:

- `"abc"` → Válido
- `"1de"` → Inválido (comienza con un dígito)
- `"abcdef"` → Inválido (más de 5 caracteres)

---

## Tareas

### 🧪 Parte 1: Análisis de Particiones

Identifica y describe en tu entrega las siguientes clases:

- **Particiones válidas** (identificadores que cumplen todas las condiciones)
- **Particiones inválidas**, incluyendo:
    - Identificadores que comienzan con un dígito
    - Identificadores que incluyen símbolos especiales
    - Identificadores con longitud mayor o menor a la permitida

Incluye al menos un ejemplo por clase.

---

### 🔬 Parte 2: Casos de Prueba en JUnit4

1. Crea una clase de prueba `IdentifierTest` usando **JUnit4**.
2. Escribe al menos **un caso de prueba por partición**.
3. Verifica si el resultado es el esperado (`true` para válidos, `false` para inválidos).

**Ejemplo de estructura en JUnit4:**

```java
    import org.junit.Test;
    import static org.junit.Assert.*;
    
    public class IdentifierTest {
    
        @Test
        public void testValidoBasico() {
            Identifier id = new Identifier();
            assertTrue(id.validateIdentifier("abc"));
        }
    
        @Test
        public void testInvalidoInicioDigito() {
            Identifier id = new Identifier();
            assertFalse(id.validateIdentifier("1de"));
        }
    
        // Agrega más pruebas aquí...
    }
```

🛠️ Parte 3: Corrección de Identificadores Inválidos
Para cada identificador inválido usado en los tests, escribe una versión corregida que cumpla con las reglas. Por ejemplo:

"1de" → "ade"

"ab-c" → "abc"

Incluye esta lista al final de tu archivo de pruebas o en un comentario dentro del código.

## Extra (Opcional)
Modifica el método validateIdentifier para mejorar su robustez y corrige errores si los encuentras. Justifica los cambios que realizas.