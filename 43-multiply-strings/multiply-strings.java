class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];

        // Multiply each digit and add to the result array
        for (int i = len1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;
                int sum = mul + result[i + j + 1]; // existing value at the position

                result[i + j] += sum / 10;        // carry
                result[i + j + 1] = sum % 10;     // remainder
            }
        }

        // Convert the result array to a string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}