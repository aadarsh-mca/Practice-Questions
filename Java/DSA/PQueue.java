package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PQueue {

    /**
     *                7¹
     *         6²            5³
     *     1⁴      2⁵    4⁶      3⁷ 
     * 
     *   ¹  ²  ³  ⁴  ⁵  ⁶  ⁷ 
     *  [7, 6, 1, 2, 5, 4, 3]
     * 
     *  1, 2, 3, 4, 5, 6, 7
     * 
     */
    
    private int[] heap;

    private int idx = -1;

    private int initialCapacity = 11;

    private int size = 0;

    public PQueue() {
        heap = new int[initialCapacity];
    }

    public void add(int data) {
        idx++;
        heap[idx] = data;
        size++;

        maxHeapifyUp(idx);
    }

    public int remove() {
        int peek = heap[0];

        swap(heap, 0, idx);
        heap[idx] = 0;
        idx--;
        size--;

        maxHeapifyDown(0);
        return peek;
    }

    /**
     * Heapify-Up
     * while adding new element in heap
     * 
     * @param idx
     */
    private void maxHeapifyUp(int idx) {
        int parent = (idx - 1) / 2;

        if(heap[parent] < heap[idx]) {
            swap(heap, parent, idx);

            maxHeapifyUp(parent);
        }
    }


    /**
     * Heapify-Up
     * while adding new element in heap
     * 
     * @param idx
     */
    private void maxHeapifyDown(int idx) {
        int largest = idx;

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if(left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if(right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if(largest == idx) {
            return;
        }

        swap(heap, idx, largest);

        maxHeapifyDown(largest);
    }
    
    /**
     * Converting Min Heap --> Max Heap
     * 
     * Simply performing max-heapify
     * 
     * @param nums
     * @return
     */
    public static int[] toMaxHeap(int[] nums) {
        int n = nums.length;

        for(int i = n/2-1; i >= 0; i--) {
            maxHeapify(nums, n, i);
        }

        return nums;
    }

    private static void maxHeapify(int[] nums, int n, int parent) {
        int largest = parent;

        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if(left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if(right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if(largest == parent) {
            return;
        }

        swap(nums, largest, parent);
        maxHeapify(nums, n, largest);
    }

    private static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }


    @Override
    public String toString() {
        String str = "[";
        for(int i=0; i<size; i++) {
            str += heap[i];
            if(i != size-1) {
                str += ", ";
            }
        }
        str += "]";

        return str;
    }
}
