package utils;

public class DocumentUtil {

    // CPF
    private static final int[] WEIGHT_SSN = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    // CNPJ
    private static final int[] WEIGHT_TFN = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int soma(int[] weight, char[] numbers, int length) {
        if (length <= 0) return 0;
        final int nIdx = length - 1;
        final int wIdx = weight.length > numbers.length ? length : nIdx;
        return (soma(weight, numbers, nIdx) + Character.getNumericValue(numbers[nIdx]) * weight[wIdx]);
    }

    private static int calcula(final String document, final int[] weight) {
        final char[] numbers = document.toCharArray();
        int sum = soma(weight, numbers, numbers.length);
        sum = 11 - (sum % 11);
        return sum > 9 ? 0 : sum;
    }

    private static boolean verifica(String tfn, int length, int[] weight) {
        final String number = tfn.substring(0, length);
        final int digit1 = calcula(number, weight);
        final int digit2 = calcula(number + digit1, weight);
        return tfn.equals(number + digit1 + digit2);
    }

    /**
     * Valida CPF
     */
    public static boolean eUmSSNValido(String ssn) {
        if (ssn == null || !ssn.matches("\\d{11}") || ssn.matches(ssn.charAt(0) + "{11}")) return false;
        return verifica(ssn, 9, WEIGHT_SSN);
    }

    /**
     * Valida CNPJ
     */
    public static boolean eUmTFNValido(String tfn) {
        if (tfn == null || !tfn.matches("\\d{14}")) return false;
        return verifica(tfn, 12, WEIGHT_TFN);
    }
}
