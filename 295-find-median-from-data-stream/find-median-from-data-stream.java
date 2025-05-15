class MedianFinder {
    // Max-heap to store the smaller half of the numbers
    PriorityQueue<Integer> leftHeap;
    // Min-heap to store the larger half of the numbers
    PriorityQueue<Integer> rightHeap;
    // Variable to keep track of the current median
    double med;

    public MedianFinder() {
        // Initialize the leftHeap as a max-heap (reversed order)
        leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // Initialize the rightHeap as a min-heap (natural order)
        rightHeap = new PriorityQueue<>();
        // Initialize median as an arbitrary value, 1.0
        med = 1.0;
    }

    public void addNum(int num) {
        // Case 1: leftHeap has more elements than rightHeap
        if (leftHeap.size() > rightHeap.size()) {
            if (num < med) {
                // If the new number is less than the current median,
                // move the largest element from leftHeap to rightHeap
                // and add the new number to leftHeap
                rightHeap.offer(leftHeap.poll());
                leftHeap.offer(num);
            } else {
                // If the new number is greater than or equal to the median,
                // add it directly to the rightHeap
                rightHeap.offer(num);
            }
            // Update the median as the average of the two middle elements
            med = (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
        // Case 2: leftHeap and rightHeap have equal size
        else if (leftHeap.size() == rightHeap.size()) {
            if (num < med) {
                // If the new number is less than the current median,
                // add it to leftHeap, and update the median to the top of leftHeap
                leftHeap.offer(num);
                med = (double) leftHeap.peek();
            } else {
                // If the new number is greater than or equal to the median,
                // add it to rightHeap, and update the median to the top of rightHeap
                rightHeap.offer(num);
                med = (double) rightHeap.peek();
            }
        }
        // Case 3: rightHeap has more elements than leftHeap
        else {
            if (num > med) {
                // If the new number is greater than the current median,
                // move the smallest element from rightHeap to leftHeap
                // and add the new number to rightHeap
                leftHeap.offer(rightHeap.poll());
                rightHeap.offer(num);
            } else {
                // If the new number is less than or equal to the median,
                // add it directly to leftHeap
                leftHeap.offer(num);
            }
            // Update the median as the average of the two middle elements
            med = (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }

    public double findMedian() {
        // Return the current median
        return med;
    }
}