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

    @Test
    @DisplayName("Must return 'txt', if 'input.txt' is given")
    void getFileExtensionForTxtFile() {
        File file = new File("input.txt");
        String expected = "txt";
        String actual = Converter.getFileExtension(file);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Must return 'mp3', if 'music.mp3' is given")
    void getFileExtensionForMp3File() {
        File file = new File("music.mp3");
        String expected = "mp3";
        String actual = Converter.getFileExtension(file);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Must return null string, if there is no extension")
    void getFileExtensionForNull() {
        File file = new File("nothing");
        String expected = "";
        String actual = Converter.getFileExtension(file);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Must return 5, if 5 is given in the file")
    void readSizeFormFileTest() {
        int expected = 5;
        String path = "Test.txt";
        int actual = Converter.readSizeFromFile(path);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Must return array {5, 4, 3, 2, 1}, if {1, 2, 3, 4, 5} is given in the file")
    void readArrayFromFileForFive() {
        int[] expected = {5, 4, 3, 2, 1};
        String path = "Test.txt";
        int[] actual = Converter.readArrayFromFile(5, path);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Must return array {3, 2, 3, 2}, if {3, 2, 3, 2} is given in the file")
    void readArrayFromFileForFour() {
        int[] expected = {3, 2, 3, 2};
        String path = "Test1.txt";
        int[] actual = Converter.readArrayFromFile(4, path);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Must return two-dimensional array with the last element {1, 2, 3}, if {3, 2, 1} is given")
    void sortForThree() {
        int[][] expected = {{2, 3, 1}, {1, 2, 3}};
        int[] inputArr = {3, 2, 1};
        int[][] actual = Converter.sort(inputArr);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Must return two-dimensional array with the last element {1, 2, 3, 4, 5}, if {5, 4, 3, 2, 1} is given")
    void sortForFive() {
        int[][] expected = {{4, 5, 3, 2, 1}, {3, 4, 5, 2, 1}, {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}};
        int[] inputArr = {5, 4, 3, 2, 1};
        int[][] actual = Converter.sort(inputArr);
        Assertions.assertArrayEquals(expected, actual);
    }

}
