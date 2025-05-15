class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        
        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);
        
        if (n < 6) {
            return Math.max(missingTypes, 6 - n);
        }
        
        int replace = 0, oneMod3 = 0, twoMod3 = 0;
        for (int i = 2; i < n; ) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
                int length = 2;
                while (i < n && password.charAt(i) == password.charAt(i - 1)) {
                    length++;
                    i++;
                }
                
                replace += length / 3;
                
                if (length % 3 == 0) {
                    oneMod3++;
                } else if (length % 3 == 1) {
                    twoMod3++;
                }
            } else {
                i++;
            }
        }
        
        if (n <= 20) {
            return Math.max(missingTypes, replace);
        }
        
        int delete = n - 20;
        
        replace -= Math.min(delete, oneMod3);
        replace -= Math.min((delete - oneMod3), twoMod3 * 2) / 2;
        replace -= Math.max(0, (delete - oneMod3 - 2 * twoMod3) / 3);
        
        return delete + Math.max(missingTypes, replace);
    }
}