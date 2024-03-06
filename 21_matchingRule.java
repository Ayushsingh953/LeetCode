// https://leetcode.com/problems/count-items-matching-a-rule/

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        for(List<String> item:items){
            if(ruleKey.equals("type")){
                if(ruleValue.equals(item.get(0))){
                    count++;
                }
            }
           else if(ruleKey.equals("color")){
                if(ruleValue.equals(item.get(1))){
                    count++;
                }
            }
            else{
                if(ruleValue.equals(item.get(2))){
                    count++;
                }
            }
        }
        return count;
    }
}