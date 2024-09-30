// https://leetcode.com/problems/design-a-stack-with-increment-operation/

class CustomStack {

    int[]stk;
    int size;
    int top;

    public CustomStack(int maxSize) {
        size = maxSize;
        stk = new int[maxSize];
        top = 0;
    }
    
    public void push(int x) {
        if(top<size){
            stk[top++] = x;
        }
    }
    
    public int pop() {
        if(top>0){
            return stk[--top];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int len=k;
        if(k>=size) len = size;
        for(int i =0;i<len;i++){
            stk[i] = stk[i]+val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */