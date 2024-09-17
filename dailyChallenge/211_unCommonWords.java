// https://leetcode.com/problems/uncommon-words-from-two-sentences/

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> wordCount = new HashMap();
        for (String str: A.split(" "))
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
        for (String str: B.split(" "))
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);

        List<String> ans = new ArrayList<>();
        for (String str: wordCount.keySet())
            if (wordCount.get(str) == 1)
                ans.add(str);

        return ans.toArray(new String[ans.size()]);
    }
}