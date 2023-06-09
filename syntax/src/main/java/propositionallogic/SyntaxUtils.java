package propositionallogic;

public final class SyntaxUtils {
    static boolean isVariable(String str) {
        return str.length() > 0 &&
                str.charAt(0) >= 'p' &&
                str.charAt(0) <= 'z' &&
                (str.length() == 1 || isOnlyDigits(str.substring(1)));
    }

    static boolean isConstant(String str) {
        return str.equals("T") || str.equals("F");
    }

    static boolean isUnary(String str) {
        return str.equals("~");
    }

    static boolean isBinary(String str) {
        return str.equals("&") ||
                str.equals("|") ||
                str.equals("->");
    }

    private static boolean isOnlyDigits(String str) {
        return str.length() == 0 ||
                (str.charAt(0) >= '0' && str.charAt(0) <= '9' &&
                        isOnlyDigits(str.substring(1)));
    }
}
