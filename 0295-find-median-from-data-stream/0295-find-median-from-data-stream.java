class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // smaller half, top = largest of small half
    private PriorityQueue<Integer> minHeap; // larger half, top = smallest of large half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        minHeap = new PriorityQueue<>();                            // min-heap (default)
    }

    public void addNum(int num) {
        // Step 1: always add to maxHeap first
        maxHeap.offer(num);

        // Step 2: move maxHeap's largest into minHeap (maintain ordering invariant)
        minHeap.offer(maxHeap.poll());

        // Step 3: rebalance sizes — maxHeap should have >= minHeap's size
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // odd total count — extra element is the median
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0; // even — average both tops
    }
}