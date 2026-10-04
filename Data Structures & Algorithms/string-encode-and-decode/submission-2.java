class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for (String str : strs) sb.append(str).append("`");
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> decode(String str) {
        int st = 0;
        List<String> ls = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '`') {
                ls.add(str.substring(st, i));
                st = i + 1;
            }
        }

        return ls;
    }
}
