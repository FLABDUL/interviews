package wise;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =
                new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringSet(s));
    }

    public int lengthOfLongestSubstringSet(String s) {
        //since need unique can use set
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {//cycle right
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);//left adjusted index 0
            }//doesnt exist charset
            else {//check existence repetitive char in hold
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));//left identical to right remove it
                    left++;//keep going till left not repition of right
                }
                //NOW IT IS UNIQUE woop
                charSet.add(s.charAt(right));
            }
        }//window slided all the way to right end
        return maxLength;
    }

/*
On time r and l pointers work linearly add/remove one n is length string
Omin(n,m) minimum of all unique to only some unique
pros hashet efficient, check duplicates constant
SW avoids nested loops
scalable large strings since linear
On space extra a bit for set, costly for algre input
extra data structure hashset
not in-place
non-ASCII chars constrained
 */

    public int lengthOfLongestSubstringMap(String s) {
        int n=s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for(int right = 0; right < n; right++){
            if(!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right))<left){//also check that map doesnt grab earlier repeated char
            charMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);//index 0 ajdusted
            } else {
                left = charMap.get(s.charAt(right)) + 1;//get next char
                charMap.put(s.charAt(right), right);//since duplicate
            }
        }
        return maxLength;
    }
    /*
    On time iterate once, left forward linear, at one time, at most once add/remove map
    Omin(n,m) space, all/some unique
    keeps track chars pro
    con additional structure charmap

     */
    public int lengthOfLongestSubstringIntArray(String s) {//most complicated to understand!
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];//max
        Arrays.fill(charIndex, -1);//-1 is sentinel value, guaranteed invalid index
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (charIndex[s.charAt(right)] >= left) {//within window
                left = charIndex[s.charAt(right)] + 1;//duplciate so move next
            }
            charIndex[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    /*
    On time once so length string
    O1 space size charindex is set 128
    no need HM/HS
    hardcoded array size
    extra space charindex array, not in-place
     */
}
