class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-heap for projects based on capital requirements
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        // Max-heap for available projects based on profits
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        // Populate the min-heap with initial projects
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new Project(capital[i], profits[i]));
        }

        // Iterate k times to pick k projects
        for (int i = 0; i < k; i++) {
            // Move all projects we can afford to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            // If there are no affordable projects, break
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Pick the most profitable project
            w += maxProfitHeap.poll().profit;
        }

        return w;
    }

    // Helper class to represent a project with capital and profit
    static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}