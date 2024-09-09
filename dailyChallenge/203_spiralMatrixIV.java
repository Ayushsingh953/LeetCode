// https://leetcode.com/problems/spiral-matrix-iv/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        int[][] mat = new int[m][n];
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                if(head!=null){
                    mat[top][i] = head.val;
                    head = head.next;
                }else{
                    mat[top][i] = -1;
                }
            }
            top++;

            for(int i=top;i<=bottom;i++){
                if(head!=null){
                    mat[i][right] = head.val;
                    head = head.next;
                }else{
                    mat[i][right] = -1;
                }
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    if(head!=null){
                        mat[bottom][i] = head.val;
                        head = head.next;
                    }else{
                        mat[bottom][i] = -1;
                    }
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    if(head!=null){
                        mat[i][left] = head.val;
                        head = head.next;
                    }else{
                        mat[i][left] = -1;
                    }
                }
                left++;
            }
        }

        return mat;
    }
}