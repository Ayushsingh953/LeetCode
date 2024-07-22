// https://leetcode.com/problems/sort-the-people/

// Using custom Comparator
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] indices = new Integer[names.length];
        for(int i=0;i<names.length;i++){
            indices[i] = i;
        }
        Arrays.sort(indices,new Comparator<Integer>(){
            public int compare(Integer n1,Integer n2){
                return heights[n2]-heights[n1];
            }
        });
        String[] sortedNames = new String[names.length];
        int i=0;
        for(int indice:indices){
            sortedNames[i++] = names[indice];
        }
        return sortedNames;
    }
}

//Using map
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> heightToName = new HashMap<>();
        for(int i=0;i<names.length;i++){
            heightToName.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] sortedNames = new String[names.length];
        int j=0;
        for(int i=heights.length-1;i>=0;i--){
            sortedNames[j++] = heightToName.get(heights[i]);
        }
        return sortedNames;
    }
}

//using treeMap which sorts the map while entering data
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> heightToName = new TreeMap<>();
        for(int i=0;i<names.length;i++){
            heightToName.put(heights[i],names[i]);
        }
        String[] sortedNames = new String[names.length];
        int i=names.length-1;
        for(int height:heightToName.keySet()){
            sortedNames[i--] = heightToName.get(height);
        }
        return sortedNames;
    }
}

// using mergesort
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        mergesort(heights,names,0,names.length-1);
        return names;
    }
    public void mergesort(int[] heights,String[] names,int start,int end){
        if(start>=end) return;

        int mid = (start+end)/2;
        mergesort(heights,names,start,mid);
        mergesort(heights,names,mid+1,end);
        merge(heights,names,start,mid,end);
    }
    public void merge(int[] heights,String[] names,int start,int mid,int end){
        int l = mid-start+1;
        int r = end-mid;

        int[] leftHeight = new int[l];
        int[] rightHeight = new int[r];
        String[] leftName = new String[l];
        String[] rightName = new String[r];

        for(int i=0;i<l;i++){
            leftHeight[i] = heights[start+i];
            leftName[i] = names[start+i];
        }
        for(int j=0;j<r;j++){
            rightHeight[j] = heights[mid+1+j];
            rightName[j] = names[mid+1+j];
        }
        int i=0,j=0,k=start;
        while(i<l && j<r){
            if(leftHeight[i]>=rightHeight[j]){
                heights[k] = leftHeight[i];
                names[k] = leftName[i];
                i++;
            }else{
                heights[k] = rightHeight[j];
                names[k] = rightName[j];
                j++;
            }
            k++;
        }
        while(i<l){
            heights[k] = leftHeight[i];
            names[k] = leftName[i];
            i++;
            k++;
        }
        while(j<r){
            heights[k] = rightHeight[j];
            names[k] = rightName[j];
            j++;
            k++; 
        }
    }
}