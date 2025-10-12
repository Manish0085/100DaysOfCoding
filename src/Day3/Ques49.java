package Day3;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Ques49 {


    // Group Anagrams
    public List<List<String>> method1(String[] strs){
        if(strs.length == 0)
            return new ArrayList<>();

        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i])
                continue;

            List<String> group = new ArrayList<>();
            visited[i] = true;
            group.add(strs[i]);
            for (int j = i+1; j < strs.length; j++) {
                if (!visited[i] && isAnagram(strs[i], strs[j])){
                    visited[j] = true;
                    group.add(strs[j]);
                }
            }

            ans.add(group);
        }
        return  ans;
    }

    public boolean isAnagram(String s1, String s2){
        if (s1.length() != s2.length())
            return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int[] count = new int[26];

        for (char ch: arr1){
            count[ch - 'a']++;
        }

        for (char ch: arr2){
            count[ch - 'a']--;
        }

        for (int num: count){
            if (num != 0)
                return false;
        }
        return true;
    }

    public List<List<String>> method2(String[] strs){
        if (strs.length == 0)
            return new ArrayList<>();

        String[] arr = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] ch =strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            arr[i] = s;
        }

        boolean[] visited = new boolean[strs.length];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if(visited[i])
                continue;

            List<String> group =  new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i+1; j < strs.length; j++) {
                if (!visited[i] && strs[i].equals(strs[j])){
                    visited[i] = true;
                    group.add(strs[j]);
                }
            }
            ans.add(group);
        }

        return ans;
    }


    public List<List<String>> method3(String[] strs){
        if (strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
