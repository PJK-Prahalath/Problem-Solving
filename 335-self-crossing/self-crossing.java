class Solution {
    public boolean isSelfCrossing(int[] distance) {
      
        if (distance.length < 4) {
            return false; // A path with less than 4 distances can't cross itself.
        }
        
        for (int i = 3; i < distance.length; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                // Case 1: Fourth segment crosses the first segment.
                return true;
            }
            
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                // Case 2: Fifth segment crosses the first segment.
                return true;
            }
            
            if (i >= 5 && distance[i - 2] >= distance[i - 4] && distance[i - 1] <= distance[i - 3] &&
                distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                // Case 3: Sixth segment crosses the first segment.
                return true;
            }
        }
        
        return false; // No self-crossing path found.
    }
  
}