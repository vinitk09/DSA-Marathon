import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// [left, right] contains no duplicate characters after updating left.
// Never move left backwards when a previous occurrence is outside the window.
// Time: O(n) expected. Extra space: O(min(n, alphabet size)).
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c)) left = Math.max(left, lastSeen.get(c) + 1);
            lastSeen.put(c, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
