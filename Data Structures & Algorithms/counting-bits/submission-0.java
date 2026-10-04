class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        
        arr[0]=0;
        if(n==0)return arr;
        arr[1]=1;
        if(n==1)return arr;
        arr[2]=1;
        if(n==2)return arr;

        for(int i=3;i<=n;i++){
            int k=0;
            while((1<<k)<=i)k++;
            int x=i-(1<<(k-1));
            arr[i]=arr[x]+1;
        }
        return arr;
    }
}
