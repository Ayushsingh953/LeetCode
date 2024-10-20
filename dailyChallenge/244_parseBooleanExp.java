// https://leetcode.com/problems/parsing-a-boolean-expression/

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> s = new Stack<>();
        for(char ch:expression.toCharArray()){
            if(ch==')'){
                ArrayList<Character> exp = new ArrayList<>();

                while(s.peek()!='('){
                    exp.add(s.pop());
                }
                s.pop();
                char op = s.pop();

                char res = parse(op,exp);
                s.push(res);
            }
            else if(ch!=','){
                s.push(ch);
            }
        }

        return s.peek()=='t';
    }

    public char parse(char op,ArrayList<Character> val){
        if(op=='!'){
            return val.get(0)=='t' ? 'f' : 't';
        }

        if(op=='&'){
            for(char v:val){
                if(v=='f') return 'f';
            }
            return 't';
        }

        if(op=='|'){
            for(char v:val){
                if(v=='t') return 't';
            }
            return 'f';
        }

        return 'f';
    }
}