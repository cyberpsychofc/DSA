class RecentCounter {
    ArrayList<Integer> lst;
    public RecentCounter() {
        lst=new ArrayList<>();
    }
    
    public int ping(int t) {
        lst.add(t);
        int min=t-3000;
        int max=t;
        int count=lst.size();
        for(int i=0;i<lst.size();i++){
            if(lst.get(i)<min || lst.get(i)>max){
                count--;
            }
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */