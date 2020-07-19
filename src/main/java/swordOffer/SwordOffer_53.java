package swordOffer;

/**
 * @ClassName SwordOffer_53
 * @Description: 第五十三题
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 * @Author UESTC-ZKX
 * @Date 2020/2/19
 **/
public class SwordOffer_53 {

    public boolean match(char[] str, char[] pattern) {
        // return isMatch(str, 0, pattern, 0);
        return String.valueOf(str).matches(String.valueOf(pattern));
    }

    /**
     * @param str     目标数组
     * @param i       目标数组当前下标
     * @param pattern 模式数组
     * @param j       模式数组当前下标
     * @return boolaen
     */
    private boolean isMatch(char[] str, int i, char[] pattern, int j) {
        // 终止条件
        // 字符串和模式串都为空
        if (i == str.length && j == pattern.length) {
            return true;
        }
        // 模式串为空
        else if (j == pattern.length) {
            return false;
        }
        // 模式串下一个字符是'*'
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*');
        if (next) {
            // 要保证i<str.length，否则越界
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return isMatch(str, i, pattern, j + 2) || isMatch(str, i + 1, pattern, j);
            } else {
                return isMatch(str, i, pattern, j + 2);
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return isMatch(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }

}
