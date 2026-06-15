// 2095. Delete the Middle Node of a Linked List
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

// The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

// For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 

// Example 1:


// Input: head = [1,3,4,7,1,2,6]
// Output: [1,3,4,1,2,6]
// Explanation:
// The above figure represents the given linked list. The indices of the nodes are written below.
// Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
// We return the new list after removing this node. 
// Example 2:


// Input: head = [1,2,3,4]
// Output: [1,2,4]
// Explanation:
// The above figure represents the given linked list.
// For n = 4, node 2 with value 3 is the middle node, which is marked in red.
// Example 3:


// Input: head = [2,1]
// Output: [2]
// Explanation:
// The above figure represents the given linked list.
// For n = 2, node 1 with value 1 is the middle node, which is marked in red.
// Node 0 with value 2 is the only node remaining after removing node 1.


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



//  Approach 2: Fast and Slow Pointer (Optimal)

// This is the most common interview solution.

// Observation

// When:

// fast moves 2 steps
// slow moves 1 step

// Then when fast reaches the end,
// slow will be at the middle node.

// But to delete the middle node, we need the node before the middle.

// So maintain a prev pointer.

// Algorithm

// If list has only one node:

// return null

// Initialize:

// slow = head
// fast = head
// prev = null

// Traverse:

// while fast != null and fast.next != null
//     prev = slow
//     slow = slow.next
//     fast = fast.next.next
// After loop:
// slow → middle node
// prev → node before middle

// Delete:

// prev.next = slow.next
// Return head.
// Dry Run

// Input:

// 1 → 2 → 3 → 4

// Initial:

// prev = null
// slow = 1
// fast = 1
// Iteration 1
// prev = 1
// slow = 2
// fast = 3
// Iteration 2
// prev = 2
// slow = 3
// fast = null

// Stop.

// slow = 3 (middle)
// prev = 2

// Delete:

// prev.next = slow.next

// Result:

// 1 → 2 → 4


class Solution {
    public ListNode deleteMiddle(ListNode head) {
       
    // approach 1 
        //         // If only one node exists
        // if(head == null || head.next == null)
        //     return null;

        // // Count total nodes
        // int count = 0;
        // ListNode temp = head;

        // while(temp != null) {
        //     count++;
        //     temp = temp.next;
        // }

        // // Find middle position
        // int mid = count / 2;

        // // Move to node before middle
        // temp = head;

        // for(int i = 0; i < mid - 1; i++) {
        //     temp = temp.next;
        // }

        // // Delete middle node
        // temp.next = temp.next.next;

        // return head;

        // approach 2 optimal
        if(head == null || head.next == null)
        {
            return null;
        }
           
        ListNode slow= head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null)
        {
            prev=slow; //previous node of middle node
            slow= slow.next;
            fast= fast.next.next;
        }

        prev.next= slow.next;
        return head;
    
    }
}