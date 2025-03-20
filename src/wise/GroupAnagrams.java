package wise;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println("result: " + groupAnagrams.groupAnagrams(strs));
    }

    /**
     * Groups anagrams together by sorting each word and using it as a key in a HashMap.
     *
     * Time Complexity: O(n * k log k) where:
     *   - n is the number of words.
     *   - k is the average length of each word (due to sorting each word: O(k log k)).
     *
     * Space Complexity: O(n * k), since we store all words in a HashMap.
     *
     * Pros:
     * - Simple and easy-to-implement approach.
     * - Efficient for moderate input sizes.
     *
     * Cons:
     * - Sorting each word takes O(k log k), which could be expensive for very large words.
     * - HashMap requires extra space for storing sorted keys.
     *
     * Use Cases:
     * - Grouping words in dictionaries or spell-checking tools.
     * - Finding clusters of similar words in NLP applications.
     * - Reducing redundancy in large datasets with anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // Stores sorted word as key and anagram list as value

        for (String word : strs) {
            char[] chars = word.toCharArray(); // Convert word to character array
            Arrays.sort(chars); // Sort characters alphabetically to generate a unique key
            String sortedWord = new String(chars); // Convert back to string

            // If sorted word is not in the map, create a new list
            map.putIfAbsent(sortedWord, new ArrayList<>());

            // Add the original word to the corresponding anagram group
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values()); // Return list of grouped anagrams
    }
}
