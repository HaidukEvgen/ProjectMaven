import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void testConvertCurrency1(){
        int choice = 1;
        int output = 2;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertCurrency(choice, output, input);
        assertEquals(expected,Converter.convertCurrency(choice, output, input) );
    }
    @Test
    void testConvertCurrency2(){
        int choice = 1;
        int output = 3;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertCurrency(choice, output, input);
        assertEquals(expected,Converter.convertCurrency(choice, output, input) );
    }@Test
    void testConvertCurrency3(){
        int choice = 1;
        int output = 4;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertCurrency(choice, output, input);
        assertEquals(expected,Converter.convertCurrency(choice, output, input) );
    }
    @Test
    void testConvertCurrency4(){
        int choice = 1;
        int output = 5;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertCurrency(choice, output, input);
        assertEquals(expected,Converter.convertCurrency(choice, output, input) );
    }
    @Test
    void testConvertCurrency5(){
        int choice = 1;
        int output = 6;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertCurrency(choice, output, input);
        assertEquals(expected,Converter.convertCurrency(choice, output, input) );
    }
    @Test
    void testConvertCurrency6(){
        int choice = 1;
        int output = 7;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertCurrency(choice, output, input);
        assertEquals(expected,Converter.convertCurrency(choice, output, input) );
    }
    @Test
    void testConvertLength(){
        int choice = 1;
        int output = 2;
        double input = 1;

        boolean expected = true;
        boolean actual;
        actual = Converter.convertLength(choice, output, input);
        assertEquals(expected, actual);
    }
    @Test
    void testConvertTime(){
        int choice = 1;
        int output = 2;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertTime(choice, output, input);
        assertEquals(expected, actual);
    }
    @Test
    void testConvertSquare(){
        int choice = 1;
        int output = 2;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertSquare(choice, output, input);
        assertEquals(expected, actual);
    }
        @Test
        void testConvertVolume(){
        int choice = 1;
        int output = 2;
        double rate = 100;
        double input = 1;
        double result = 0;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertSquare(choice, output, input);
        assertEquals(expected, actual);
    }
    @Test
    void testConvertSpeed(){
        int choice = 1;
        int output = 2;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertSpeed(choice, output, input);
        assertEquals(expected, actual);
    }
    @Test
    void testConvertTemperature(){
        int choice = 1;
        int output = 2;
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertTemperature(choice, output, input);
        assertEquals(expected, actual);
    }
    @Test
    void testConvertWeight(){
        int choice = 1;
        int output = 2;
        char grad = 176;
        double input = 1;
        double result = 0;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertWeight(choice, output, input);
        assertEquals(expected, actual);
    }

}
