// https://leetcode.com/problems/take-gifts-from-the-richest-pile/

public class Solution {

    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;

        List<Integer> sortedGifts = new ArrayList<>();
        for (int gift : gifts) {
            sortedGifts.add(gift);
        }
        Collections.sort(sortedGifts);

        for (int i = 0; i < k; i++) {
            int maxElement = sortedGifts.get(n - 1);
            sortedGifts.remove(n - 1);

            int sqrtElement = (int) Math.floor(Math.sqrt(maxElement));

            int spotOfSqrt = Collections.binarySearch(sortedGifts, sqrtElement);

            if (spotOfSqrt < 0) {
                spotOfSqrt = -(spotOfSqrt + 1);
            }

            sortedGifts.add(spotOfSqrt, sqrtElement); 
        }

        long numberOfRemainingGifts = 0;
        for (int gift : sortedGifts) {
            numberOfRemainingGifts += gift;
        }

        return numberOfRemainingGifts;
    }
}