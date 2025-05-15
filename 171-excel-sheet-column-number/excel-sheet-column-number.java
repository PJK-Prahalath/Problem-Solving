class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
		int i = 0;
		while (i < columnTitle.length() - 1) {
			int value = columnTitle.charAt(i) - 'A' + 1;
			int n = i;
			while (n < columnTitle.length()-1) {
				value *= 26;
				n++;
			}
			result += value;
			i++;
		}
		int value = columnTitle.charAt(i) - 'A' + 1;
		result += value;
		return result;
    }
}