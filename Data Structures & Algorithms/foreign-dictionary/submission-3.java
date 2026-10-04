class Solution {
    public String foreignDictionary(String[] words) {
        int indegree[] = new int[26];
        HashSet<Character> hs = new HashSet<>();
        HashMap<Character, HashSet<Character>> hm = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) hs.add(ch);
        }
        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1];
            String s2 = words[i];
            if (s1.length() > s2.length() && s1.startsWith(s2))
                return "";
            int p = 0, q = 0;
            while (p < s1.length() && q < s2.length()) {
                if (s1.charAt(p) != s2.charAt(q)) {
                    hm.putIfAbsent(s1.charAt(p), new HashSet<>());

                    if (hm.get(s1.charAt(p)).add(s2.charAt(q))) {
                        indegree[s2.charAt(q) - 'a']++;
                    }
                    break;
                }
                p++;
                q++;
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> pq = new LinkedList<>();
        for (char x : hs) {
            if (indegree[x - 'a'] == 0)
                pq.offer(x);
        }
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            sb.append(ch);
            for (char x : hm.getOrDefault(ch, new HashSet<>())) {
                indegree[x - 'a']--;
                if (indegree[x - 'a'] == 0) {
                    pq.offer(x);
                }
            }
        }

        if (sb.length() != hs.size()) {
            return "";
        }
        return sb.toString();
    }
}
