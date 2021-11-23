import java.util.Scanner;
public class Converter {
    public static Scanner scanner = new Scanner(System.in);

    static final int MIN_ANYTHING = 1;
    static final int MAX_CURRENCY = 8;
    static final int MAX_LENGTH = 6;
    static final int MAX_TIME = 8;
    static final int MAX_SQUARE = 8;
    static final int MAX_VOLUME = 7;
    static final int MAX_SPEED = 4;
    static final int MAX_TEMPERATURE = 4;
    static final int MAX_WEIGHT = 7;

    public static int getChoice(int MAX_CHOICE, int MIN_CHOICE) {
        int choice = 0;
        boolean isIncorrect;
        do {
            isIncorrect = false;
            System.out.print("Выберите величину ввода:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели неподходящий код величины");
                isIncorrect = true;
            }
            if (!isIncorrect && (choice < MIN_CHOICE) || (choice > MAX_CHOICE)) {
                System.out.println("Вы ввели неподходящий код величины");
                choice = 0;
                isIncorrect = true;
            }
        } while (isIncorrect);
        return choice;
    }

    public static int getOutput(int MAX_OUTPUT, int MIN_OUTPUT, int choice) {
        int output = 0;
        boolean isIncorrect;
        do {
            isIncorrect = false;
            System.out.print("Выберите величиу вывода:");
            try {
                output = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели неподходящий код величины");
                isIncorrect = true;
            }
            if (!isIncorrect && (output < MIN_OUTPUT) || (output > MAX_OUTPUT)) {
                System.out.println("Вы ввели неподходящий код величины");
                output = 0;
                isIncorrect = true;
            }
            if (!isIncorrect && choice == output) {
                System.out.println("Та же величина не может быть конвертирована");
                isIncorrect = true;
            }
        } while (isIncorrect);
        return output;
    }

    public static double getInput(String inType) {
        double input = 0;
        boolean isIncorrect;
        do {
            isIncorrect = false;
            System.out.print("Введите число для конвертации из " + inType);
            try {
                input = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели неподходящее число");
                isIncorrect = true;
            }
            if (!isIncorrect && (input < 0)) {
                System.out.println("Вы ввели неподходяще число");
                input = 0;
                isIncorrect = true;
            }
        } while (isIncorrect);
        return input;
    }

    public static double getResult(double rate, double input){
        return input * rate;
    }


    public static void Currency() {
        char us_dollar_sym = 36;
        char pound_sym = 163;
        char euro_sym = 8364;
        char yen_sym = 165;
        char bel_rub_sym = 8381;
        char rus_rub_sym = 8381;
        char zloty_sym = 90;

        // Интерфейс

        System.out.println("Вы выбрали конвертацию валют.");
        System.out.println("Используйте следующие коды для ввода выбранной валюты:");
        System.out.println(" 1 - Американский доллар \n 2 - Евро \n 3 - Английский фунт \n 4 - Японская йена \n 5 - Белорусский рубль \n 6 - Российский рубль \n 7 - Польский злотый \n 8 - Завершить конвертацию валют \n");

        //Ввод первой валюты и проверка

        int choice = getChoice(MAX_CURRENCY, MIN_ANYTHING);
        if (choice == 8)
            return;

        String inType = "";

        switch (choice) {
            case 1 -> inType = "Американский доллар >> " + us_dollar_sym;
            case 2 -> inType = "Евро >> " + euro_sym;
            case 3 -> inType = "Английский фунт >> " + pound_sym;
            case 4 -> inType = "Японская йена >> " + yen_sym;
            case 5 -> inType = "Белорусский рубль >> " + bel_rub_sym;
            case 6 -> inType = "Российский рубль >> " + rus_rub_sym;
            case 7 -> inType = "Польский злотый >> " + zloty_sym;
        }

        //Ввод второй валюты и проверка
        int output = getOutput(MAX_CURRENCY, MIN_ANYTHING, choice);
        if (output == 8)
            return;

        //Ввод сумма перевода и проверка
        double input = getInput(inType);

        //Конвертация величин
        boolean isCorrect = convertCurrency(choice, output, input);
        if (isCorrect)
            System.out.print("");
    }

    public static boolean convertCurrency(int choice, int output, double input){
        char us_dollar_sym = 36;
        char pound_sym = 163;
        char euro_sym = 8364;
        char yen_sym = 165;
        char bel_rub_sym = 8381;
        char rus_rub_sym = 8381;
        char zloty_sym = 90;

        String us_dollar = "Американский доллар";
        String pound = "Английский фунт";
        String yen = "Японская йена";
        String euro = "Евро";
        String bel_rub = "Белорусский рубль";
        String rus_rub = "Российский рубль";
        String zloty = "Польский злотый";

        double result;
        double rate;
        switch (choice) {
            //Доллар во все валюты
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 0.852988;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, euro, euro_sym, result);
                    }
                    case 3 -> {
                        rate = 0.732562;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, pound, pound_sym, result);
                    }
                    case 4 -> {
                        rate = 109.633;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, yen, yen_sym, result);
                    }
                    case 5 -> {
                        rate = 2.50223;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, bel_rub, bel_rub_sym, result);
                    }
                    case 6 -> {
                        rate = 72.8849;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, rus_rub, rus_rub_sym, result);
                    }
                    case 7 -> {
                        rate = 3.94333;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Американский доллар в %s = %s%.2f\n", us_dollar_sym, zloty, zloty_sym, result);
                    }
                }
            }
            //Евро во все валюты
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1.1728;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Евро в %s = %s%.2f\n", euro_sym, us_dollar, euro_sym, result);
                    }
                    case 3 -> {
                        rate = 0.792648;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Евро в %s = %s%.2f\n", euro_sym, pound, pound_sym, result);
                    }
                    case 4 -> {
                        rate = 136.708;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Евро в %s = %s%.2f\n", euro_sym, yen, yen_sym, result);
                    }
                    case 5 -> {
                        rate = 2.9394;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Евро в %s = %s%.2f\n", euro_sym, bel_rub, bel_rub_sym, result);
                    }
                    case 6 -> {
                        rate = 84.875;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Евро в %s = %s%.2f\n", euro_sym, rus_rub, rus_rub_sym, result);
                    }
                    case 7 -> {
                        rate = 4.6131;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Евро в %s = %.2f\n", euro_sym, zloty, result);
                    }
                }
            }
            //Английский фунт во все валюты
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1.60972;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Английский фунт в %s = %.2f\n", pound_sym, us_dollar, result);
                    }
                    case 2 -> {
                        rate = 1.26161;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Английский фунт в %s = %.2f\n", pound_sym, euro, result);
                    }
                    case 4 -> {
                        rate = 172.511;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Английский фунт в %s = %.2f\n", pound_sym, yen, result);
                    }
                    case 5 -> {
                        rate = 3.4181;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Английский фунт в %s = %.2f\n", pound_sym, bel_rub, result);
                    }
                    case 6 -> {
                        rate = 99.0681;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Английский фунт в %s = %.2f\n", pound_sym, rus_rub, result);
                    }
                    case 7 -> {
                        rate = 5.4007;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Английский фунт в %s = %.2f\n", pound_sym, zloty, result);
                    }
                }
            }
            //Йена во все валюты
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.00932574;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Японская йена %s = %.2f\n", yen_sym, us_dollar, result);
                    }
                    case 2 -> {
                        rate = 0.00730615;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Японская йена %s = %.2f\n", yen_sym, euro, result);
                    }
                    case 3 -> {
                        rate = 0.00579135;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Японская йена %s = %.2f\n", yen_sym, pound, result);
                    }
                    case 5 -> {
                        rate = 0.022;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Японская йена в %s = %.2f\n", yen_sym, bel_rub, result);
                    }
                    case 6 -> {
                        rate = 65.16;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Японская йена в %s = %.2f\n", yen_sym, rus_rub, result);
                    }
                    case 7 -> {
                        rate = 0.036;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Японская йена в %s = %.2f\n", yen_sym, zloty, result);
                    }
                }
            }
            //Бел руб во все валюты
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.3987;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, us_dollar, result);
                    }
                    case 2 -> {
                        rate = 0.342;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, euro, result);
                    }
                    case 3 -> {
                        rate = 0.29;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, pound, result);
                    }
                    case 4 -> {
                        rate = 44.74;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, yen, result);
                    }
                    case 6 -> {
                        rate = 29.025;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, rus_rub, result);
                    }
                    case 7 -> {
                        rate = 1.58;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Белорусский рубль в %s = %.2f\n", bel_rub_sym, zloty, result);
                    }
                }
            }
            // Рос руб во все валюты
            case 6 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.0137;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, us_dollar, result);
                    }
                    case 2 -> {
                        rate = 0.012;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, euro, result);
                    }
                    case 3 -> {
                        rate = 0.0102;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, pound, result);
                    }
                    case 4 -> {
                        rate = 1.5347;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, yen, result);
                    }
                    case 5 -> {
                        rate = 0.034;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, bel_rub, result);
                    }
                    case 7 -> {
                        rate = 0.055;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Российский рубль в %s = %.2f\n", rus_rub_sym, zloty, result);
                    }
                }
            }
            // Злотый во все валюты
            case 7 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.253;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Польский злотый в %s = %.2f\n", zloty_sym, us_dollar, result);
                    }
                    case 2 -> {
                        rate = 0.2166;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Польский злотый в %s = %.2f\n", zloty_sym, euro, result);
                    }
                    case 3 -> {
                        rate = 0.1852;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Польский злотый в %s = %.2f\n", zloty_sym, pound, result);
                    }
                    case 4 -> {
                        rate = 28.04;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Польский злотый в %s = %.2f\n", zloty_sym, yen, result);
                    }
                    case 5 -> {
                        rate = 0.6329;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Польский злотый в %s = %.2f\n", zloty_sym, bel_rub, result);
                    }
                    case 6 -> {
                        rate = 18.3435;
                        result = input * rate;
                        System.out.printf("%s" + input + " по курсу " + rate + " Польский злотый в %s = %.2f\n", zloty_sym, rus_rub, result);
                    }
                    default -> {
                    }
                }
            }
        }
        return true;
    }


    public static void Length() {
        // Интерфейс
        System.out.println("Вы выбрали перевод единиц длины");
        System.out.println("Используйте следующие коды для ввода выбранной единицы длины:");
        System.out.println(" 1 - Километры \n 2 - Метры \n 3 - Дециметры \n 4 - Сантиметры \n 5 - Миллиметры \n 6 - Завершить конвертацию единиц длины \n");

        //Ввод первой величины и проверка
        int choice = getChoice(MAX_LENGTH, MIN_ANYTHING);
        if (choice == 6)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Километры >> ";
            case 2 -> inType = "Метры >> ";
            case 3 -> inType = "Дециметры >> ";
            case 4 -> inType = "Сантиметры >> ";
            case 5 -> inType = "Миллиметры >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_LENGTH, MIN_ANYTHING, choice);
        if (output == 6)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        boolean isCorrect = convertLength(choice, output, input);
        if (isCorrect)
            System.out.print("");
    }

    public static boolean convertLength(int choice, int output, double input){
        double result;
        double rate;
        switch (choice) {
            //Километр во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Километр в метр: %f км = %.2f м\n", input, result);
                    }
                    case 3 -> {
                        rate = 10000;
                        result = input * rate;
                        System.out.printf("Километр в дециметр: %f км = %.0f дм\n", input, result);
                    }
                    case 4 -> {
                        rate = 100000;
                        result = input * rate;
                        System.out.printf("Километр в сантиметр: %f км = %.0f см\n", input, result);
                    }
                    case 5 -> {
                        rate = 1000000;
                        result = input * rate;
                        System.out.printf("Километр в миллиметр: %f км = %.0f мм\n", input, result);
                    }
                }
            }
            //Метр во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Метр в километр: %f м = %.3f км\n", input, result);
                    }
                    case 3 -> {
                        rate = 10;
                        result = input * rate;
                        System.out.printf("Метр в дециметр: %f м = %.2f дцм\n", input, result);
                    }
                    case 4 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Метр в сантиметр: %f м = %.2f см\n", input, result);
                    }
                    case 5 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Метр в миллиметр: %f м = %.2f мм\n", input, result);
                    }
                }
            }
            //Дециметр во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.0001;
                        result = input * rate;
                        System.out.printf("Дециметр в километр: %f дцм = %.4f км\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.1;
                        result = input * rate;
                        System.out.printf("Дециметр в метр: %f дцм = %.2f м\n", input, result);
                    }
                    case 4 -> {
                        rate = 10;
                        result = input * rate;
                        System.out.printf("Дециметр в сантиметр: %f дцм = %.2f см\n", input, result);
                    }
                    case 5 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Дециметр в миллиметр: %f дцм = %.2f мм\n", input, result);
                    }
                }
            }
            //Сантиметр во все величины
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.00001;
                        result = input * rate;
                        System.out.printf("Сантиметр в километр: %f см = %.5f км\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Сантиметр в метр: %f см = %.2f м\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.1;
                        result = input * rate;
                        System.out.printf("Сантиметр в децииметр: %f см = %.2f дцм\n", input, result);
                    }
                    case 5 -> {
                        rate = 10;
                        result = input * rate;
                        System.out.printf("Сантиметр в миллиметр: %f см = %.2f мм\n", input, result);
                    }
                }
            }
            //Миллиметр во все величины
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.000001;
                        result = input * rate;
                        System.out.printf("Миллиметр в километр: %f мм = %.6f км\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Миллиметр в метр: %f мм = %.3f м\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Миллиметр в децииметр: %f мм = %.2f дцм\n", input, result);
                    }
                    case 4 -> {
                        rate = 0.1;
                        result = input * rate;
                        System.out.printf("Миллиметр в сантиметр: %f мм = %.2f см\n", input, result);
                    }
                }
            }
        }
        return true;
    }


    public static void Time() {

        // Интерфейс
        System.out.println("Вы выбрали перевод единиц времени");
        System.out.println("Используйте следующие коды для ввода выбранной единицы времени:");
        System.out.println(" 1 - Года  \n 2 - Недели \n 3 - Дни \n 4 - Часы \n 5 - Минуты \n 6 - Секунды \n 7 - Миллисекунлы \n 8 - Заверщить конвертацию единиц времени");

        //Ввод первой величины и проверка
        int choice = getChoice(MAX_TIME, MIN_ANYTHING);
        if (choice == 8)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Годы >> ";
            case 2 -> inType = "Недели >> ";
            case 3 -> inType = "Дни >> ";
            case 4 -> inType = "Часы >> ";
            case 5 -> inType = "Минуты >> ";
            case 6 -> inType = "Секунды >> ";
            case 7 -> inType = "Миллисекунды >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_TIME, MIN_ANYTHING, choice);
        if (output == 8)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        boolean isCorrect = convertTime(choice, output, input);
        if (isCorrect)
            System.out.print("");
    }

    public static boolean convertTime(int choice, int output, double input){
        double rate;
        double result;
        switch (choice) {
            //Года во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 52.1428571;
                        result = input * rate;
                        System.out.printf("Года в недели: %f лет = %.2f недели\n", input, result);
                    }
                    case 3 -> {
                        rate = 365;
                        result = input * rate;
                        System.out.printf("Года в дни: %f лет = %.2f дней\n", input, result);
                    }
                    case 4 -> {
                        rate = 8760;
                        result = input * rate;
                        System.out.printf("Года в часы: %f лет = %.2f часов\n", input, result);
                    }
                    case 5 -> {
                        rate = 252600;
                        result = input * rate;
                        System.out.printf("Года в минуты: %f лет = %.2f минут\n", input, result);
                    }
                    case 6 -> {
                        rate = 31536000;
                        result = input * rate;
                        System.out.printf("Года в секунды: %f лет = %.2f секунд\n", input, result);
                    }
                    case 7 -> {
                        rate = 3.1536e10;
                        result = input * rate;
                        System.out.printf("Года в миллисекунды: %f лет = %.2f миллисекунды\n", input, result);
                    }

                }
            }
            //Недели во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.0191781;
                        result = input * rate;
                        System.out.printf("Недели в года: %f недель = %.3f лет\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.142857;
                        result = input * rate;
                        System.out.printf("Недели в дни: %f недель = %.2f дней\n", input, result);
                    }
                    case 4 -> {
                        rate = 168;
                        result = input * rate;
                        System.out.printf("Недели в часы: %f недель = %.2f часов\n", input, result);
                    }
                    case 5 -> {
                        rate = 10080;
                        result = input * rate;
                        System.out.printf("Недели в минуты: %f недель = %.2f минут\n", input, result);
                    }
                    case 6 -> {
                        rate = 604800;
                        result = input * rate;
                        System.out.printf("Недели в секунды: %f недель = %.2f секунд\n", input, result);
                    }
                    case 7 -> {
                        rate = 604800310;
                        result = input * rate;
                        System.out.printf("Недели в миллисекунды: %f недель = %.2f миллисекунды\n", input, result);
                    }

                }
            }
            //Дни во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.0027397;
                        result = input * rate;
                        System.out.printf("Дни в года: %f дней = %.4f лет\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.142857216;
                        result = input * rate;
                        System.out.printf("Дни в недели: %f дней = %.2f недель\n", input, result);
                    }
                    case 4 -> {
                        rate = 24;
                        result = input * rate;
                        System.out.printf("Дни в часы: %f дней = %.2f часов\n", input, result);
                    }
                    case 5 -> {
                        rate = 1440;
                        result = input * rate;
                        System.out.printf("Дни в минуты: %f дней = %.2f минут\n", input, result);
                    }
                    case 6 -> {
                        rate = 86400;
                        result = input * rate;
                        System.out.printf("Дни в секунды: %f дней = %.2f секунд\n", input, result);
                    }
                    case 7 -> {
                        rate = 86400044;
                        result = input * rate;
                        System.out.printf("Дни в миллисекунды: %f дней = %.2f миллисекунды\n", input, result);
                    }

                }
            }
            //Часы во все величины
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.000114;
                        result = input * rate;
                        System.out.printf("Часы в года: %f часов = %.4f лет\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.005952;
                        result = input * rate;
                        System.out.printf("Часы в недели: %f часов = %.3f недель\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.0417;
                        result = input * rate;
                        System.out.printf("Часы в дни: %f часов = %.2f дней\n", input, result);
                    }
                    case 5 -> {
                        rate = 60;
                        result = input * rate;
                        System.out.printf("Часы в минуты: %f часов = %.2f минут\n", input, result);
                    }
                    case 6 -> {
                        rate = 3600;
                        result = input * rate;
                        System.out.printf("Часы в секунды: %f часов = %.2f секунд\n", input, result);
                    }
                    case 7 -> {
                        rate = 3600000;
                        result = input * rate;
                        System.out.printf("Часы в миллисекунды: %f часов = %.2f миллисекунды\n", input, result);
                    }

                }
            }
            //Минуты во все величины
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1.902588493150695081e-6;
                        result = input * rate;
                        System.out.printf("Минуты в года: %f минут = %.7f лет\n", input, result);
                    }
                    case 2 -> {
                        rate = 9.920640000000052793e-5;
                        result = input * rate;
                        System.out.printf("Минуты в недели: %f минут = %.6f недель\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.00069;
                        result = input * rate;
                        System.out.printf("Минуты в дни: %f минут = %.4f дней\n", input, result);
                    }
                    case 4 -> {
                        rate = 0.01667;
                        result = input * rate;
                        System.out.printf("Минуты в часы: %f минут = %.2f часов\n", input, result);
                    }
                    case 6 -> {
                        rate = 60;
                        result = input * rate;
                        System.out.printf("Минуты в секунды: %f минут = %.2f секунд\n", input, result);
                    }
                    case 7 -> {
                        rate = 60000;
                        result = input * rate;
                        System.out.printf("Минуты в миллисекунды: %f минут = %.2f миллисекунды\n", input, result);
                    }

                }
            }
            //Секунды во все величины
            case 6 -> {
                switch (output) {
                    case 1 -> {
                        rate = 3.17e-8;
                        result = input * rate;
                        System.out.printf("Секунды в года: %f секунд = %.8f лет\n", input, result);
                    }
                    case 2 -> {
                        rate = 1.65e-6;
                        result = input * rate;
                        System.out.printf("Секунды в недели: %f секунд = %.6f недель\n", input, result);
                    }
                    case 3 -> {
                        rate = 1.157e-5;
                        result = input * rate;
                        System.out.printf("Секунды в дни: %f секунд = %.5f дней\n", input, result);
                    }
                    case 4 -> {
                        rate = 0.00028;
                        result = input * rate;
                        System.out.printf("Секунды в часы: %f секунд = %.4f часов\n", input, result);
                    }
                    case 5 -> {
                        rate = 0.017;
                        result = input * rate;
                        System.out.printf("Секунды в минуты: %f секунд = %.2f минут\n", input, result);
                    }
                    case 7 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Секунды в миллисекунды: %f секунд = %.2f миллисекунды\n", input, result);
                    }

                }
            }
            //Миллисекунды во все величины
            case 7 -> {
                switch (output) {
                    case 1 -> {
                        rate = 3.17098e-11;
                        result = input * rate;
                        System.out.printf("Миллисекунды в года: %f миллисекунд = %.11f лет\n", input, result);
                    }
                    case 2 -> {
                        rate = 1.653e-9;
                        result = input * rate;
                        System.out.printf("Миллисекунды в недели: %f миллисекунд = %.9f недель\n", input, result);
                    }
                    case 3 -> {
                        rate = 1.157e-8;
                        result = input * rate;
                        System.out.printf("Миллисекунды в дни: %f миллисекунд = %.8f дней\n", input, result);
                    }
                    case 4 -> {
                        rate = 2.78e-7;
                        result = input * rate;
                        System.out.printf("Миллисекунды в часы: %f миллисекунд = %.7f часов\n", input, result);
                    }
                    case 5 -> {
                        rate = 1.67e-5;
                        result = input * rate;
                        System.out.printf("Миллисекунды в минуты: %f миллисекунд = %.5f минут\n", input, result);
                    }
                    case 6 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Миллисекунды в секунды: %f миллисекунд = %.3f секунд\n", input, result);
                    }

                }
            }
        }
        return true;
    }


    public static void Square() {
        System.out.println("Вы выбрали перевод единиц площади");
        System.out.println("Используйте следующие коды для ввода выбранной единицы площади:");
        System.out.println(" 1 - Квадратный километры  \n 2 - Гектары \n 3 - Ары \n 4 - Квадратные метры \n 5 - Квадратные дециметры \n 6 - Квадратные сантиметры \n 7 - Квадратные миллиметры \n 8 - Завершить конвертацию единиц площади \n");

        int choice = getChoice(MAX_SQUARE, MIN_ANYTHING);
        if (choice == 8)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Квадратные километры >> ";
            case 2 -> inType = "Гектары >> ";
            case 3 -> inType = "Ары >> ";
            case 4 -> inType = "Квадратные метры >> ";
            case 5 -> inType = "Квадратные дециметры >> ";
            case 6 -> inType = "Квадратные сантиметры >> ";
            case 7 -> inType = "Квадратные миллиметры >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_SQUARE, MIN_ANYTHING, choice);
        if (output == 8)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        boolean isCorrect = convertSquare(choice, output, input);
        if (isCorrect)
            System.out.print("");

    }

    public static boolean convertSquare(int choice, int output, double input){
        double rate;
        double result;
        switch (choice) {
            //Квадратные километры во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Квадратные километры в Гектары: %f кв.км = %.2f гектаров\n", input, result);
                    }
                    case 3 -> {
                        rate = 1E4;
                        result = input * rate;
                        System.out.printf("Квадратные километры в Ары: %f кв.км = %.2f ар\n", input, result);
                    }
                    case 4 -> {
                        rate = 1E6;
                        result = input * rate;
                        System.out.printf("Квадратные километры в Квадратные метры: %f кв.км = %.0f кв.м\n", input, result);
                    }
                    case 5 -> {
                        rate = 1E8;
                        result = input * rate;
                        System.out.printf("Квадратный километры в Квадратные дециметры: %f кв.км = %.0f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        rate = 1E10;
                        result = input * rate;
                        System.out.printf("Квадратные километры в Квадратные сантиметры: %f кв.км = %.0f кв.см\n", input, result);
                    }
                    case 7 -> {
                        rate = 1E12;
                        result = input * rate;
                        System.out.printf("Квадратные километры в Квадратные миллиметры: %f кв.км = %.0f кв.мм\n", input, result);
                    }

                }
            }
            //Гектары во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Гектары в квадратные километры: %f гектаров = %.2f кв.км\n", input, result);
                    }
                    case 3 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Гектары в квадратные в Ары: %f гектаров = %.2f ар\n", input, result);
                    }
                    case 4 -> {
                        rate = 1E4;
                        result = input * rate;
                        System.out.printf("Гектары в квадратные метры: %f гектаров = %.2f кв.м\n", input, result);
                    }
                    case 5 -> {
                        rate = 1E6;
                        result = input * rate;
                        System.out.printf("Гектары в квадратные дециметры: %f гектаров = %.0f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        rate = 1E8;
                        result = input * rate;
                        System.out.printf("Гектары в квадратные сантиметры: %f гектаров = %.0f кв.см\n", input, result);
                    }
                    case 7 -> {
                        rate = 1E10;
                        result = input * rate;
                        System.out.printf("Гектары в квадратные миллиметры: %f гектаров = %.0f кв.мм\n", input, result);
                    }

                }
            }
            //Ары во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1E-4;
                        result = input * rate;
                        System.out.printf("Ары в квадратные километры: %f ар = %.4f кв.км\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Ары в гектары: %f ар = %.2f гектаров\n", input, result);
                    }
                    case 4 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Ары в квадратные метры: %f ар = %.2f кв.м\n", input, result);
                    }
                    case 5 -> {
                        rate = 1E4;
                        result = input * rate;
                        System.out.printf("Ары в квадратные дециметры: %f ар = %.2f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        rate = 1E6;
                        result = input * rate;
                        System.out.printf("Ары в квадратные сантиметры: %f ар = %.0f кв.см\n", input, result);
                    }
                    case 7 -> {
                        rate = 1E8;
                        result = input * rate;
                        System.out.printf("Ары в квадратные миллиметры: %f ар = %.0f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные метры во все велчины
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1E-6;
                        result = input * rate;
                        System.out.printf("Квадратные метры в квадратные километры: %f кв.м = %.6f кв.км\n", input, result);
                    }
                    case 2 -> {
                        rate = 1E-4;
                        result = input * rate;
                        System.out.printf("Квадратные метры в гектары: %f кв.м = %.4f гектаров\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Квадратные метры в ары: %f кв.м = %.2f ар\n", input, result);
                    }
                    case 5 -> {
                        rate = 10;
                        result = input * rate;
                        System.out.printf("Квадратные метры в квадратные дециметры: %f кв.м = %.2f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        rate = 1E4;
                        result = input * rate;
                        System.out.printf("Квадратные метры в квадратные сантиметры: %f кв.м = %.2f кв.см\n", input, result);
                    }
                    case 7 -> {
                        rate = 1E6;
                        result = input * rate;
                        System.out.printf("Квадратные метры в квадратные миллиметры: %f кв.м = %.0f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные дециметры во все велчины
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1E-8;
                        result = input * rate;
                        System.out.printf("Квадратные дециметры в квадратные километры: %f кв.дм = %.8f кв.км\n", input, result);
                    }
                    case 2 -> {
                        rate = 1E-6;
                        result = input * rate;
                        System.out.printf("Квадратные дециметры в гектары: %f кв.дм = %.6f гектаров\n", input, result);
                    }
                    case 3 -> {
                        rate = 1E-4;
                        result = input * rate;
                        System.out.printf("Квадратные дециметры в ары: %f кв.дм = %.4f ар\n", input, result);
                    }
                    case 4 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Квадратные дециметры в квадратные метры: %f кв.дм = %.2f кв.м\n", input, result);
                    }
                    case 6 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Квадратные дециметры в квадратные сантиметры: %f кв.дм = %.2f кв.см\n", input, result);
                    }
                    case 7 -> {
                        rate = 1E4;
                        result = input * rate;
                        System.out.printf("Квадратные дециметры в квадратные миллиметры: %f кв.дм = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные сантиметры во все велчины
            case 6 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1E-10;
                        result = input * rate;
                        System.out.printf("Квадратные сантиметры в квадратные километры: %f кв.см = %.10f кв.км\n", input, result);
                    }
                    case 2 -> {
                        rate = 1E-8;
                        result = input * rate;
                        System.out.printf("Квадратные сантиметры в гектары: %f кв.см = %.8f гектаров\n", input, result);
                    }
                    case 3 -> {
                        rate = 1E-6;
                        result = input * rate;
                        System.out.printf("Квадратные сантиметры в ары: %f кв.см = %.6f ар\n", input, result);
                    }
                    case 4 -> {
                        rate = 1E-4;
                        result = input * rate;
                        System.out.printf("Квадратные сантиметры в квадратные метры: %f кв.см = %.4f кв.м\n", input, result);
                    }
                    case 5 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Квадратные сантиметры в квадратные децииметры: %f кв.см = %.2f кв.дм\n", input, result);
                    }
                    case 7 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Квадратные сантиметры в квадратные миллиметры: %f кв.см = %.2f кв.мм\n", input, result);
                    }

                }
            }
            //Квадратные сантиметры во все велчины
            case 7 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1E-12;
                        result = input * rate;
                        System.out.printf("Квадратные миллиметры в квадратные километры: %f кв.мм = %.12f кв.км\n", input, result);
                    }
                    case 2 -> {
                        rate = 1E-10;
                        result = input * rate;
                        System.out.printf("Квадратные миллиметры в гектары: %f кв.мм = %.10f гектаров\n", input, result);
                    }
                    case 3 -> {
                        rate = 1E-8;
                        result = input * rate;
                        System.out.printf("Квадратные миллиметры в ары: %f кв.мм = %.8f ар\n", input, result);
                    }
                    case 4 -> {
                        rate = 1E-6;
                        result = input * rate;
                        System.out.printf("Квадратные миллиметры в квадратные метры: %f кв.мм = %.6f кв.м\n", input, result);
                    }
                    case 5 -> {
                        rate = 1E-4;
                        result = input * rate;
                        System.out.printf("Квадратные миллиметры в квадратные децииметры: %f кв.мм = %.4f кв.дм\n", input, result);
                    }
                    case 6 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Квадратные миллииметры в квадратные сантииметры: %f кв.мм = %.2f кв.см\n", input, result);
                    }

                }
            }
        }
        return true;
    }


    public static void Volume() {
        System.out.println("Вы выбрали перевод единиц объёма");
        System.out.println("Используйте следующие коды для ввода выбранной единицы объёма:");
        System.out.println(" 1 - Кубические метры  \n 2 - Кубические дециметры \n 3 - Кубические сантиметры \n 4 - Кубические миллиметры \n 5 - Литры \n 6 - Миллилитры \n 7 - Завершить конвертацию единиц объёма \n");

        int choice = getChoice(MAX_VOLUME, MIN_ANYTHING);
        if (choice == 7)
            return;

        String inType;
        switch (choice) {
            case 1 -> inType = "Кубические метры >> ";
            case 2 -> inType = "Кубические дециметры >> ";
            case 3 -> inType = "Кубические сантиметры >> ";
            case 4 -> inType = "Кубические миллиметры >> ";
            case 5 -> inType = "Литры >> ";
            case 6 -> inType = "Миллилитры >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_VOLUME, MIN_ANYTHING, choice);
        if (output == 7)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);
        //Конвертация
        boolean isCorrect = convertVolume(choice, output, input);
        if (isCorrect)
            System.out.print("");
    }

    public static boolean convertVolume(int choice, int output, double input){
        double rate;
        double result;
        switch (choice) {
            //Кубические метры во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Кубические метры в Кубические дециметры: %f куб.м = %.2f куб.дм\n", input, result);
                    }
                    case 3 -> {
                        rate = 1000000;
                        result = input * rate;
                        System.out.printf("Кубические метры в Кубические сантиметры: %f куб.м = %.0f куб.см\n", input, result);
                    }
                    case 4 -> {
                        rate = 1000000000;
                        result = input * rate;
                        System.out.printf("Кубические метры в Кубические миллиметры: %f куб.м = %.0f куб.мм\n", input, result);
                    }
                    case 5 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Кубические метры в Литры: %f куб.м = %.2f литров\n", input, result);
                    }
                    case 6 -> {
                        rate = 1000000;
                        result = input * rate;
                        System.out.printf("Кубические метры в Миллилитры: %f куб.м = %.0f миллилитров\n", input, result);
                    }
                }
            }
            //Кубические дециметры во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Кубические дециметры в Кубические метры: %f куб.дм = %.3f куб.м\n", input, result);
                    }
                    case 3 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Кубические дециметры в Кубические сантиметры: %f куб.дм = %.2f куб.см\n", input, result);
                    }
                    case 4 -> {
                        rate = 1000000;
                        result = input * rate;
                        System.out.printf("Кубические дециметры в Кубические миллиметры: %f куб.дм = %.0f куб.мм\n", input, result);
                    }
                    case 5 -> {
                        rate = 1;
                        result = input * rate;
                        System.out.printf("Кубические дециметры в Литры: %f куб.дм = %.2f литров\n", input, result);
                    }
                    case 6 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Кубические дециметры в Миллилитры: %f куб.дм = %.2f миллилитров\n", input, result);
                    }
                }
            }
            //Кубические сантиметры во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1e-6;
                        result = input * rate;
                        System.out.printf("Кубические сантиметры в Кубические метры: %f куб.см = %.6f куб.м\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Кубические сантиметры в Кубические дециметры: %f куб.см = %.3f куб.дм\n", input, result);
                    }
                    case 4 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Кубические сантиметры в Кубические миллиметры: %f куб.см = %.2f куб.мм\n", input, result);
                    }
                    case 5 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Кубические сантиметры в Литры: %f куб.см = %.3f литров\n", input, result);
                    }
                    case 6 -> {
                        rate = 1;
                        result = input * rate;
                        System.out.printf("Кубические сантиметры в Миллилитры: %f куб.см = %.2f миллилитров\n", input, result);
                    }
                }
            }
            //Кубические миллиметры во все величины
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1e-9;
                        result = input * rate;
                        System.out.printf("Кубические миллиметры в Кубические метры: %f куб.мм = %.9f куб.м\n", input, result);
                    }
                    case 2 -> {
                        rate = 1e-6;
                        result = input * rate;
                        System.out.printf("Кубические миллиметры в Кубические дециметры: %f куб.мм = %.6f куб.дм\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Кубические миллиметры в Кубические сантиметры: %f куб.мм = %.3f куб.см\n", input, result);
                    }
                    case 5 -> {
                        rate = 1e-6;
                        result = input * rate;
                        System.out.printf("Кубические миллиметры в Литры: %f куб.мм = %.6f литров\n", input, result);
                    }
                    case 6 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Кубические миллиметры в Миллилитры: %f куб.мм = %.3f миллилитров\n", input, result);
                    }
                }
            }
            //Литры во все величины
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Литры в Кубические метры: %f литров = %.3f куб.м\n", input, result);
                    }
                    case 2 -> {
                        rate = 1;
                        result = input * rate;
                        System.out.printf("Литры в Кубические дециметры: %f литров = %.2f куб.дм\n", input, result);
                    }
                    case 3 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Литры в Кубические сантиметры: %f литров = %.2f куб.см\n", input, result);
                    }
                    case 4 -> {
                        rate = 1000000;
                        result = input * rate;
                        System.out.printf("Литры в Кубические миллиметры: %f литров = %.0f куб.мм\n", input, result);
                    }
                    case 6 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Литры в Миллилитры: %f литров = %.2f миллилитров\n", input, result);
                    }
                }
            }
            //Литры во все величины
            case 6 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1e-6;
                        result = input * rate;
                        System.out.printf("Миллилитры в Кубические метры: %f миллилитров = %.6f куб.м\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Миллилитры в Кубические дециметры: %f миллилитров = %.3f куб.дм\n", input, result);
                    }
                    case 3 -> {
                        rate = 1;
                        result = input * rate;
                        System.out.printf("Миллилитры в Кубические сантиметры: %f миллилитров = %.2f куб.см\n", input, result);
                    }
                    case 4 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Миллилитры в Кубические миллиметры: %f миллилитров = %.2f куб.мм\n", input, result);
                    }
                    case 5 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Миллилитры в Литры: %f миллилитров = %.3f литров\n", input, result);
                    }
                }
            }
        }
        return true;
    }


    public static void Speed() {
        System.out.println("Вы выбрали перевод единиц скорости");
        System.out.println("Используйте следующие коды для ввода выбранной единицы скорости:");
        System.out.println(" 1 - Метры в секунду  \n 2 - Километры в час \n 3 - Километры в секунду \n 4 - Завершить конвертацию единиц скорости \n");

        int choice = getChoice(MAX_SPEED, MIN_ANYTHING);
        if (choice == 4)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Метры в секунду >> ";
            case 2 -> inType = "Километры в час >> ";
            case 3 -> inType = "Километры в секунду >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_SPEED, MIN_ANYTHING, choice);
        if (output == 4)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        boolean isCorrect = convertSpeed(choice, output, input);
        if (isCorrect)
            System.out.print("");
    }

    public static boolean convertSpeed(int choice, int output, double input){
        double result;
        double rate;
        switch (choice) {
            //Метры в секунду во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 3.6;
                        result = input * rate;
                        System.out.printf("М/с в км/ч: %f м/с = %.2f км/ч\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("М/с в км/с: %f м/с = %.3f км/с\n", input, result);
                    }
                }
            }
            //Километры в час во все велчины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.277778;
                        result = input * rate;
                        System.out.printf("Км/ч в м/с: %f км/ч = %.2f м/с\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.000277778;
                        result = input * rate;
                        System.out.printf("км/ч в км/с: %f км/ч = %.4f км/с\n", input, result);
                    }
                }
            }//Километры в секунду во все велчины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Км/с в м/с: %f км/с = %.2f м/с\n", input, result);
                    }
                    case 2 -> {
                        rate = 3600;
                        result = input * rate;
                        System.out.printf("км/с в км/ч: %f км/с = %.2f км/ч\n", input, result);
                    }
                }
            }
        }
        return true;
    }


    public static void Temperature() {

        System.out.println("Вы выбрали перевод единиц температуры");
        System.out.println("Используйте следующие коды для ввода выбранной единицы температуры:");
        System.out.println(" 1 - Градусы Цельсия  \n 2 - Градусы Фаренгейта \n 3 - Кельвины \n 4 - Завершить конвертацию единиц температуры \n");

        int choice = getChoice(MAX_TEMPERATURE, MIN_ANYTHING);
        if (choice == 4)
            return;

        String inType;
        switch (choice) {
            case 1 -> inType = "Градусы Цельсия >> ";
            case 2 -> inType = "Градусы Фаренгейта >> ";
            case 3 -> inType = "Кельвины >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_TEMPERATURE, MIN_ANYTHING, choice);
        if (output == 4)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        boolean isCorrect = convertTemperature(choice, output, input);
        if (isCorrect)
            System.out.print("");
    }

    public static boolean convertTemperature(int choice, int output, double input){
        double result;
        char grad = 176;
        switch (choice) {
            //Градусы Цельсия во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        result = (input * 9 / 5) + 32;
                        System.out.printf("Градусы Цельсия в Градусы Фаренгейта: %f %sC = %.2f %sF\n", input, grad, result, grad);
                    }
                    case 3 -> {
                        result = input + 273.15;
                        System.out.printf("Градусы Цельсия в Кельвины: %f %sC = %.2f K\n", input, grad, result);
                    }
                }
            }
            //Градусы Фаренгейта во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        result = (input - 32) * 5 / 9;
                        System.out.printf("Градусы Фаренгейта в Градусы Цельсия: %f %sF = %.2f %sC\n", input, grad, result, grad);
                    }
                    case 3 -> {
                        result = (input - 32) * 5 / 9 + 273.15;
                        System.out.printf("Градусы Фаренгейта в Кельвины: %f %sF = %.2f K\n", input, grad, result);
                    }
                }
            }
            //Кельвины во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        result = input - 273.15;
                        System.out.printf("Кельвины в Градусы Цельсия: %f K = %.2f %sC\n", input, result, grad);
                    }
                    case 2 -> {
                        result = (input - 273.15) * 9 / 5 + 32;
                        System.out.printf("Кельвины в Градусы Фаренгейта: %f K= %.2f %sF\n", input, result, grad);
                    }
                }
            }
        }
        return true;
    }


    public static void Weight() {
        System.out.println("Вы выбрали перевод единиц массы");
        System.out.println("Используйте следующие коды для ввода выбранной единицы массы:");
        System.out.println(" 1 - Тонны  \n 2 - Центнеры \n 3 - Килограммы \n 4 - Граммы \n 5 - Миллиграммы \n 6 - Фунты \n 7 - Завершить конвертацию единиц массы \n");

        int choice = getChoice(MAX_WEIGHT, MIN_ANYTHING);
        if (choice == 7)
            return;
        String inType;
        switch (choice) {
            case 1 -> inType = "Тонны >> ";
            case 2 -> inType = "Центнеры >> ";
            case 3 -> inType = "Килограммы >> ";
            case 4 -> inType = "Граммы >> ";
            case 5 -> inType = "Миллиграммы >> ";
            case 6 -> inType = "Фунты >> ";
            default -> {
                return;
            }
        }
        //Ввод второй величины и проверка
        int output = getOutput(MAX_WEIGHT, MIN_ANYTHING, choice);
        if (output == 7)
            return;

        //Ввод суммы перевода
        double input = getInput(inType);

        //Конвертация
        boolean isCorrect = convertWeight(choice, output, input);
        if (isCorrect)
            System.out.print("");
    }

    public static boolean convertWeight(int choice, int output, double input){
        double rate;
        double result;
        switch (choice) {
            //Тонны во все величины
            case 1 -> {
                switch (output) {
                    case 2 -> {
                        rate = 10;
                        result = input * rate;
                        System.out.printf("Тонны в Центнеры: %f тонн = %.2f центнеров\n", input, result);
                    }
                    case 3 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Тонны в Килограммы: %f тонн = %.2f кг\n", input, result);
                    }
                    case 4 -> {
                        rate = 1000000;
                        result = input * rate;
                        System.out.printf("Тонны в Граммы: %f тонн = %.0f г\n", input, result);
                    }
                    case 5 -> {
                        rate = 1000000000;
                        result = input * rate;
                        System.out.printf("Тонны в Миллиграммы: %f тонн = %.0f мг\n", input, result);
                    }
                    case 6 -> {
                        rate = 2204.62;
                        result = input * rate;
                        System.out.printf("Тонны в Фунты: %f тонн = %.2f фунтов\n", input, result);
                    }
                }
            }
            //Центнеры во все величины
            case 2 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.1;
                        result = input * rate;
                        System.out.printf("Центнеры в Тонны: %f центнеров = %.2f тонн\n", input, result);
                    }
                    case 3 -> {
                        rate = 100;
                        result = input * rate;
                        System.out.printf("Центнеры в Килограммы: %f центнеров = %.2f кг\n", input, result);
                    }
                    case 4 -> {
                        rate = 100000;
                        result = input * rate;
                        System.out.printf("Центнеры в Граммы: %f центнеров = %.0f г\n", input, result);
                    }
                    case 5 -> {
                        rate = 1e+8;
                        result = input * rate;
                        System.out.printf("Центнеры в Миллиграммы: %f центнеров = %.0f мг\n", input, result);
                    }
                    case 6 -> {
                        rate = 220.462;
                        result = input * rate;
                        System.out.printf("Центнеры в Фунты: %f центнеров = %.2f фунтов\n", input, result);
                    }
                }
            }
            //Килограммы во все величины
            case 3 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Килограммы в Тонны: %f кг = %.3f тонн\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.01;
                        result = input * rate;
                        System.out.printf("Килограммы в Центнеры: %f кг = %.2f центнеров\n", input, result);
                    }
                    case 4 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Килограммы в Граммы: %f кг = %.2f г\n", input, result);
                    }
                    case 5 -> {
                        rate = 1e+6;
                        result = input * rate;
                        System.out.printf("Килограммы в Миллиграммы: %f кг = %.0f мг\n", input, result);
                    }
                    case 6 -> {
                        rate = 2.20462;
                        result = input * rate;
                        System.out.printf("Килограммы в Фунты: %f кг = %.2f фунтов\n", input, result);
                    }
                }
            }
            //Граммы во все величины
            case 4 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1e-6;
                        result = input * rate;
                        System.out.printf("Граммы в Тонны: %f г = %.6f тонн\n", input, result);
                    }
                    case 2 -> {
                        rate = 1e-5;
                        result = input * rate;
                        System.out.printf("Граммы в Центнеры: %f г = %.5f центнеров\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Граммы в Килограммы: %f г = %.3f кг\n", input, result);
                    }
                    case 5 -> {
                        rate = 1000;
                        result = input * rate;
                        System.out.printf("Граммы в Миллиграммы: %f г = %.2f мг\n", input, result);
                    }
                    case 6 -> {
                        rate = 0.00220462;
                        result = input * rate;
                        System.out.printf("Граммы в Фунты: %f г = %.3f фунтов\n", input, result);
                    }
                }
            }
            //Миллиграммы во все величины
            case 5 -> {
                switch (output) {
                    case 1 -> {
                        rate = 1e-9;
                        result = input * rate;
                        System.out.printf("Миллиграммы в Тонны: %f мг = %.9f тонн\n", input, result);
                    }
                    case 2 -> {
                        rate = 1e-8;
                        result = input * rate;
                        System.out.printf("Миллиграммы в Центнеры: %f мг = %.8f центнеров\n", input, result);
                    }
                    case 3 -> {
                        rate = 1e-6;
                        result = input * rate;
                        System.out.printf("Миллиграммы в Килограммы: %f мг = %.6f кг\n", input, result);
                    }
                    case 4 -> {
                        rate = 0.001;
                        result = input * rate;
                        System.out.printf("Миллиграммы в Граммы: %f мг = %.3f г\n", input, result);
                    }
                    case 6 -> {
                        rate = 2.20462e-6;
                        result = input * rate;
                        System.out.printf("Миллиграммы в Фунты: %f мг = %.6f фунтов\n", input, result);
                    }
                }
            }
            //Фунты во все величины
            case 6 -> {
                switch (output) {
                    case 1 -> {
                        rate = 0.000453592;
                        result = input * rate;
                        System.out.printf("Фунты в Тонны: %f фунтов = %.4f тонн\n", input, result);
                    }
                    case 2 -> {
                        rate = 0.00453592;
                        result = input * rate;
                        System.out.printf("Фунты в Центнеры: %f фунтов = %.3f центнеров\n", input, result);
                    }
                    case 3 -> {
                        rate = 0.453592;
                        result = input * rate;
                        System.out.printf("Фунты в Килограммы: %f фунтов = %.2f кг\n", input, result);
                    }
                    case 4 -> {
                        rate = 453.592;
                        result = input * rate;
                        System.out.printf("Фунты в Граммы: %f фунтов = %.2f г\n", input, result);
                    }
                    case 5 -> {
                        rate = 453592;
                        result = input * rate;
                        System.out.printf("Фунты в Миллиграммы: %f фунтов = %.2f мг\n", input, result);
                    }
                }
            }
        }
        return true;
    }


    public static void printInterface(){
        System.out.println("\n***********************************************************************************");
        System.out.println("Используйте следующие коды для выбора величины для конвертации: \n 1 - Валюта \n 2 - Длина \n 3 - Время \n 4 - Площадь \n 5 - Объём \n 6 - Скорость \n 7 - Температура \n 8 - Масса \n 9 - Завершить программу \n");
    }

    public static int getDimension(){
        boolean isIncorrect;
        int choice = 0;
        do {
            isIncorrect = false;
            System.out.print("Выберите величину для конвертации:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вы ввели неподходящий код величины");
                isIncorrect = true;
            }
            if (!isIncorrect && (choice < 1) || (choice > 9)) {
                System.out.println("Вы ввели неподходящий код величины");
                choice = 0;
                isIncorrect = true;
            }
        } while (isIncorrect);
        return  choice;
    }

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в программу конвертации величин");
        boolean isTrue = true;
        do {
            printInterface();
            int choice = getDimension();
            switch (choice) {
                case 1 -> Currency();
                case 2 -> Length();
                case 3 -> Time();
                case 4 -> Square();
                case 5 -> Volume();
                case 6 -> Speed();
                case 7 -> Temperature();
                case 8 -> Weight();
                case 9 -> isTrue = false;
            }
        } while (isTrue);
        scanner.close();
    }
}