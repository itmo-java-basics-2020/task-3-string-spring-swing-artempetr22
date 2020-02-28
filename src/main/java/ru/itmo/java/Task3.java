package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (Arrays.equals(inputArray, new int[]{}) || inputArray == null) return new int[]{};
        int lastNum = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; i--) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = lastNum;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (Arrays.equals(inputArray, new int[]{}) || inputArray == null) return 0;
        else if (inputArray.length == 1) return inputArray[0];
        else {
            Arrays.sort(inputArray);
            return inputArray[inputArray.length - 1] * inputArray[inputArray.length - 2];
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.equals("")) return 0;
        int counter = 0;
        for (char ch : input.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'b') counter++;
        }
        return (100 * counter) / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) return false;
        char[] temp = input.toLowerCase().toCharArray();
        for (int i = 0; i <= (input.length() / 2) - 1; i++) {
            if (!(temp[i] == temp[input.length() - 1 - i])) return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.equals("")) return "";

        String returnable = "";


        char[] temp = input.toCharArray();
        char prev = temp[0];
        int count = 1;
        for (int i = 1; i < temp.length ; i++) {
            if (temp[i] == prev) count++;
            else {
                returnable = (returnable + prev) + count;
                count = 1;
                prev = temp[i];
            }
        }
        returnable = (returnable + prev) + count;

        return returnable;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null||two == null||one.length()!=two.length()||one.equals("")||two.equals("")) return false;
        int[] oneCh = new int[3000];
        int[] twoCh = new int[3000];
        Arrays.fill(oneCh,0);
        Arrays.fill(twoCh,0);
        for (char ch: one.toCharArray()) {
            oneCh[(int)ch]++;
        }
        for (char ch: two.toCharArray()) {
            twoCh[(int)ch]++;
        }
        return Arrays.equals(oneCh, twoCh);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.equals("")) return false;
        int[] sCh = new int[3000];
        Arrays.fill(sCh,0);
        for (char ch: s.toCharArray()) {
            sCh[(int)ch]++;
            if (sCh[(int)ch] > 1) return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || Arrays.deepEquals(m, new int[][]{{}, {}}) || m[0].length == 0) return new int[][]{{}, {}};

        for (int i = 0; i < m.length; i++) {
            for (int j = i+1; j < m.length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }

        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings == new String[]{} || inputStrings.length == 0) return "";
        if (separator == null) separator = ' ';
        String returnable = inputStrings[0];
        for (int i = 1; i < inputStrings.length ; i++) {
            returnable = returnable + separator + inputStrings[i];
        }

        return returnable;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || inputStrings == new String[]{} || prefix == null || prefix == "") return 0;
        int counter = 0;
        for (int i = 0; i < inputStrings.length ; i++) {
            counter += (inputStrings[i].split(prefix).length - 1);
        }

        return counter;
    }
}
