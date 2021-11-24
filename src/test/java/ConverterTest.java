import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "1, 4",
            "1, 5",
            "1, 6",
            "1, 7",
            "2, 1",
            "2, 3",
            "2, 4",
            "2, 5",
            "2, 6",
            "2, 7",
            "3, 1",
            "3, 2",
            "3, 4",
            "3, 5",
            "3, 6",
            "3, 7",
            "4, 1",
            "4, 2",
            "4, 3",
            "4, 5",
            "4, 6",
            "4, 7",
            "5, 1",
            "5, 2",
            "5, 3",
            "5, 4",
            "5, 6",
            "5, 7",
            "6, 1",
            "6, 2",
            "6, 3",
            "6, 4",
            "6, 5",
            "6, 7",
            "7, 1",
            "7, 2",
            "7, 3",
            "7, 4",
            "7, 5",
            "7, 6",
    })
    void testConvertCurrency(int choice, int output){
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertCurrency(choice, output, input);
        assertEquals(expected,actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "1, 4",
            "1, 5",
            "2, 1",
            "2, 3",
            "2, 4",
            "2, 5",
            "3, 1",
            "3, 2",
            "3, 4",
            "3, 5",
            "4, 1",
            "4, 2",
            "4, 3",
            "4, 5",
            "5, 1",
            "5, 2",
            "5, 3",
            "5, 4",
    })
    void testConvertLength(int choice, int output){
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertLength(choice, output, input);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "1, 4",
            "1, 5",
            "1, 6",
            "1, 7",
            "2, 1",
            "2, 3",
            "2, 4",
            "2, 5",
            "2, 6",
            "2, 7",
            "3, 1",
            "3, 2",
            "3, 4",
            "3, 5",
            "3, 6",
            "3, 7",
            "4, 1",
            "4, 2",
            "4, 3",
            "4, 5",
            "4, 6",
            "4, 7",
            "5, 1",
            "5, 2",
            "5, 3",
            "5, 4",
            "5, 6",
            "5, 7",
            "6, 1",
            "6, 2",
            "6, 3",
            "6, 4",
            "6, 5",
            "6, 7",
            "7, 1",
            "7, 2",
            "7, 3",
            "7, 4",
            "7, 5",
            "7, 6",
    })
    void testConvertTime(int choice, int output){
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertTime(choice, output, input);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "1, 4",
            "1, 5",
            "1, 6",
            "1, 7",
            "2, 1",
            "2, 3",
            "2, 4",
            "2, 5",
            "2, 6",
            "2, 7",
            "3, 1",
            "3, 2",
            "3, 4",
            "3, 5",
            "3, 6",
            "3, 7",
            "4, 1",
            "4, 2",
            "4, 3",
            "4, 5",
            "4, 6",
            "4, 7",
            "5, 1",
            "5, 2",
            "5, 3",
            "5, 4",
            "5, 6",
            "5, 7",
            "6, 1",
            "6, 2",
            "6, 3",
            "6, 4",
            "6, 5",
            "6, 7",
            "7, 1",
            "7, 2",
            "7, 3",
            "7, 4",
            "7, 5",
            "7, 6",
    })
    void testConvertSquare(int choice, int output){
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertSquare(choice, output, input);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "1, 4",
            "1, 5",
            "1, 6",
            "2, 1",
            "2, 3",
            "2, 4",
            "2, 5",
            "2, 6",
            "3, 1",
            "3, 2",
            "3, 4",
            "3, 5",
            "3, 6",
            "4, 1",
            "4, 2",
            "4, 3",
            "4, 5",
            "4, 6",
            "5, 1",
            "5, 2",
            "5, 3",
            "5, 4",
            "5, 6",
            "6, 1",
            "6, 2",
            "6, 3",
            "6, 4",
            "6, 5",
    })
    void testConvertVolume(int choice, int output){
        double rate = 100;
        double input = 1;
        double result = 0;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertVolume(choice, output, input);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "2, 1",
            "2, 3",
            "3, 1",
            "3, 2",
    })
    void testConvertSpeed(int choice, int output){
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertSpeed(choice, output, input);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "2, 1",
            "2, 3",
            "3, 1",
            "3, 2",
    })
    void testConvertTemperature(int choice, int output){
        double input = 1;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertTemperature(choice, output, input);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "1, 3",
            "1, 4",
            "1, 5",
            "1, 6",
            "2, 1",
            "2, 3",
            "2, 4",
            "2, 5",
            "2, 6",
            "3, 1",
            "3, 2",
            "3, 4",
            "3, 5",
            "3, 6",
            "4, 1",
            "4, 2",
            "4, 3",
            "4, 5",
            "4, 6",
            "5, 1",
            "5, 2",
            "5, 3",
            "5, 4",
            "5, 6",
            "6, 1",
            "6, 2",
            "6, 3",
            "6, 4",
            "6, 5",
    })
    void testConvertWeight(int choice, int output){
        char grad = 176;
        double input = 1;
        double result = 0;
        boolean expected = true;
        boolean actual;
        actual = Converter.convertWeight(choice, output, input);
        assertEquals(expected, actual);
    }
}
