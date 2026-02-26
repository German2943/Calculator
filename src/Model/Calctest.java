package Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class Calctest {

    @Test
    void testPostFix() {
        Calculator calc = new Calculator();
        String resultado = calc.inFixToPostFix("3+4*2").toString();

        assertEquals("342*+", resultado);
    }
}
