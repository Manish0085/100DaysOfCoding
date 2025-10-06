package Day1;

public class Ques242 {

    // Valid Anagram
    public boolean method1(String s, String t){
        if (s.length() != t.length())
            return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < t.length(); j++) {
                if (sArr[i] == tArr[j]) {
                    tArr[i] = '#';
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return false;

        }
        return true;
    }

    public boolean method2(String s, String t){
        if (s.length() != t.length())
            return false;

        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int num: charCount){
            if (num != 0)
                return false;
        }
        return true;
    }

}
