class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int v=pid.size();
        HashMap<Integer, List<Integer>> hm= new HashMap<>();
        for(int i=0;i<v;i++){
            int parent=ppid.get(i);
            int child=pid.get(i);
            hm.putIfAbsent(parent, new ArrayList<>());
            hm.get(parent).add(child);
        }
        Queue<Integer> q= new ArrayDeque<>();
        List<Integer> ls= new ArrayList<>();
        q.offer(kill);
        ls.add(kill);
        while(!q.isEmpty()){
            int x=q.poll();
            if(hm.containsKey(x)){
                for(int p: hm.get(x)){
                    ls.add(p);
                    q.offer(p);
                }
            }
        }
        return ls;
        
    }
}
