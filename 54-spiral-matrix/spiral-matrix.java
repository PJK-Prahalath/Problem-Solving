class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        Map<String, String> nextDirection = new HashMap<>();
        nextDirection.put("top", "right");
        nextDirection.put("right", "bottom");
        nextDirection.put("bottom", "left");
        nextDirection.put("left", "top");

        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int rtop = 0, rbottom = m - 1, cleft = 0, cright = n - 1;
        String direction = "top";

        while (res.size() != m * n) {
            if (direction.equals("top")) {
                for (int j = cleft; j <= cright; j++) {
                    res.add(matrix[rtop][j]);
                }
                rtop++;
            } else if (direction.equals("right")) {
                for (int i = rtop; i <= rbottom; i++) {
                    res.add(matrix[i][cright]);
                }
                cright--;
            } else if (direction.equals("bottom")) {
                for (int j = cright; j >= cleft; j--) {
                    res.add(matrix[rbottom][j]);
                }
                rbottom--;
            } else if (direction.equals("left")) {
                for (int i = rbottom; i >= rtop; i--) {
                    res.add(matrix[i][cleft]);
                }
                cleft++;
            }
            direction = nextDirection.get(direction);
        }

        return res;
    }
}