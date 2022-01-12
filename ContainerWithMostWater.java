/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
        let start = 0;
        let end = height.length - 1;
        let max = 0;

        while (start < end) {
        let currHeight = Math.min(height[start], height[end]);
        let currWater = currHeight * (end - start);
        if (currWater > max) {
        max = currWater;
        }
        if (height[start] > height[end])
        end--;
        else
        start++;
        }

        return max;
        };