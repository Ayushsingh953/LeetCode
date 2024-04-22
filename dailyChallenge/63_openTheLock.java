// https://leetcode.com/problems/open-the-lock/

class Solution {
    public int openLock(String[] deadends, String target) {
        Map<Character,Character> nextSlot = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );

        Map<Character,Character> prevSlot = Map.of(
             '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> pending = new LinkedList<>();
        int turns = 0;

        if(visited.contains("0000")){
            return -1;
        }
        pending.add("0000");
        visited.add("0000");

        while(!pending.isEmpty()){
            int curNodeCount = pending.size();
            for(int i=0;i<curNodeCount;i++){
                String curCombination = pending.poll();
                if(curCombination.equals(target)){
                    return turns;
                }
                for(int wheel=0;wheel<4;wheel++){
                    StringBuilder newCombination = new StringBuilder(curCombination);
                    newCombination.setCharAt(wheel,nextSlot.get(newCombination.charAt(wheel)));

                    if(!visited.contains(newCombination.toString())){
                        pending.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }

                    newCombination = new StringBuilder(curCombination);
                    newCombination.setCharAt(wheel,prevSlot.get(newCombination.charAt(wheel)));

                    if(!visited.contains(newCombination.toString())){
                        pending.add(newCombination.toString());
                        visited.add(newCombination.toString());
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}