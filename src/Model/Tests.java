package Model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class Tests {
    Calculator c=new Calculator();
    @Test
    void testTokenizer() {
        // Arrange


        // Act
        ArrayList<Token> result = c.tokenizer("3.4+2");
        ArrayList<Token> expected=new ArrayList<>();
        expected.add(new Token(tokenType.NUMBER, "3.4"));
        expected.add(new Token(tokenType.PLUS, "+"));
        expected.add(new Token(tokenType.NUMBER, "2"));
        // Assert
        assertEquals(expected, result);
    }

}
