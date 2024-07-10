// https://leetcode.com/problems/crawler-log-folder/

// using stack to keep track of path
class Solution {
    public int minOperations(String[] logs) {
        Stack<String> operations = new Stack<>();
        for(int i = 0;i<logs.length;i++){
            if(logs[i].equals("./")) continue;
            else if(logs[i].equals("../")){
                if(!operations.isEmpty()){
                    operations.pop();
                }
            }else{
                operations.push(logs[i]);
            }
        }
        return operations.size();
    }
}

class Solution2 {
    public int minOperations(String[] logs) {
        int operations = 0;
        for(int i = 0;i<logs.length;i++){
            if(logs[i].equals("./")) continue;
            else if(logs[i].equals("../")){
                if(operations>0){
                    operations--;
                }
            }else{
                operations++;
            }
        }
        return operations;
    }
}