import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
// missing counts required occurrences, including duplicates in t.
// Expand until missing == 0, then shrink while the window remains valid.
// Time: O(s.length() + t.length()) expected. Extra space: O(distinct chars in t).
class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        int missing = t.length(), left = 0, bestStart = 0, bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                if (need.get(c) > 0) missing--;
                need.put(c, need.get(c) - 1);
            }
            while (missing == 0) {
                if (right - left + 1 < bestLength) {
                    bestStart = left;
                    bestLength = right - left + 1;
                }
                char removed = s.charAt(left++);
                if (need.containsKey(removed)) {
                    need.put(removed, need.get(removed) + 1);
                    if (need.get(removed) > 0) missing++;
                }
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}
