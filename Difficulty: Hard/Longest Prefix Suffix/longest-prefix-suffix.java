class Solution {
    private void print(int[] arr){
        for(int it:arr){
            System.out.print(it+" ");
        }
        System.out.println("");
    }
    int getLPSLength(String s) {
        int n=s.length();
        int[] lps=new int[n];
        lps[0]=0;
        int prefix=0;int suffix=1;
        while(prefix<n && suffix<n){
            char ch1=s.charAt(prefix);
            char ch2=s.charAt(suffix);
            if(ch1==ch2){
                lps[suffix]=prefix+1;
                prefix++;
                suffix++;
            }
            else{
                if(prefix==0){
                    suffix++;
                }
                else{
                    prefix=lps[prefix-1];
                }
            }
        }
        //print(lps);
        return lps[n-1];
    }
}