class StockSpanner {
    Stack<Integer[]>st=new Stack<>();
    int ind;
    public StockSpanner() {
       st=new Stack<>();
       ind=-1;
    }
    
    public int next(int price) {
        ind++;
        while(!st.isEmpty() && st.peek()[1] <= price)
        {
            st.pop();
        }
        int span=ind-(st.isEmpty()?-1:st.peek()[0]);
        st.push(new Integer[]{ind,price});
        return span;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
