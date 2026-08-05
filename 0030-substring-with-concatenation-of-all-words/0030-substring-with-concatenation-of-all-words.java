class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() == 0 || words.length == 0)
            return ans;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        int len = words[0].length();
        int total = len * words.length;

        for (int i = 0; i < len; i++) {
            int left = i;
            int count = 0;
            HashMap<String, Integer> temp = new HashMap<>();

            for (int j = i; j + len <= s.length(); j += len) {
                String word = s.substring(j, j + len);

                if (map.containsKey(word)) {
                    temp.put(word, temp.getOrDefault(word, 0) + 1);
                    count++;

                    while (temp.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + len);
                        temp.put(leftWord, temp.get(leftWord) - 1);
                        left += len;
                        count--;
                    }

                    if (count == words.length) {
                        ans.add(left);
                        String leftWord = s.substring(left, left + len);
                        temp.put(leftWord, temp.get(leftWord) - 1);
                        left += len;
                        count--;
                    }
                } else {
                    temp.clear();
                    count = 0;
                    left = j + len;
                }
            }
        }

        return ans;
    }
}