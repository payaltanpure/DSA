class Solution {
    public int search(int[] nums, int target) {

        // in normal binary search : we comapre target with mid ele and then decide in
        // which half we will search the target as whole array is decided we need not to
        // check weather half is sorted or not
        // in rotated array binary search: first we check weather left half is sorted if
        // yes then check is target located in that half if no we go to search in right
        // half if that half is sorted
        // by checking this conditions always calculate new mid value as in every
        // condition either high changes or low changes
        // at end by doing this procedure repeatedly high low and mid will reach till
        // one index there is your target

        // Visual Example

        // Array:

        // [4,5,6,7,0,1,2]

        // Target:

        // 0
        // First iteration
        // low = 0
        // high = 6
        // mid = 3
        // nums[mid] = 7

        // Left half sorted?

        // nums[low] <= nums[mid]
        // 4 <= 7 yes

        // Left side:

        // [4,5,6,7]

        // Is target 0 inside?

        // 0 >= 4 ? no

        // So search right side.

        // low = mid + 1
        // Second iteration
        // low = 4
        // high = 6
        // mid = 5
        // nums[mid] = 1

        // Check left sorted:

        // nums[low] <= nums[mid]
        // 0 <= 1 yes

        // Left half:

        // [0,1]

        // Is target inside?

        // 0 >= 0 yes
        // 0 < 1 yes

        // So move left.

        // high = mid - 1
        // Third iteration
        // low = 4
        // high = 4
        // mid = 4
        // nums[mid] = 0

        // Found target.

        // Answer:

        // 4

        // int low = 0;
        // int high = nums.length - 1;

        // while (low <= high) {

        // int mid = low + (high - low) / 2;

        // // Target found
        // if (nums[mid] == target) {
        // return mid;
        // }

        // // Left half sorted
        // if (nums[low] <= nums[mid]) {

        // // Target lies in left half
        // if (target >= nums[low] && target < nums[mid]) {
        // high = mid - 1;
        // }
        // else {
        // low = mid + 1;
        // }
        // }

        // // Right half sorted
        // else {

        // // Target lies in right half
        // if (target > nums[mid] && target <= nums[high]) {
        // low = mid + 1;
        // }
        // else {
        // high = mid - 1;
        // }
        // }
        // }

        // return -1;

        // | Feature | Simple Binary Search | Rotated Sorted Array Search |
        // | ---------- | -------------------------------- | ---------------------------
        // |
        // | Array | Completely sorted | Rotated sorted |
        // | Example | `[1,2,3,4,5]` | `[4,5,1,2,3]` |
        // | Decision | Directly compare target with mid | First find sorted half |
        // | Logic | Target < mid → go left | Check which side is sorted |
        // | Complexity | `O(log n)` | `O(log n)` |
        // | Difficulty | Easy | Medium |

        // Simple Binary Search Logic

        // Example:

        // [1,2,3,4,5]

        // If:

        // target < nums[mid]

        // Go left.

        // Else go right.

        // Because whole array is sorted.

        // Rotated Binary Search Logic

        // Example:

        // [4,5,6,7,0,1,2]

        // Whole array is NOT sorted.

        // So first we check:

        // Which half is sorted?

        // Then decide where target may exist.

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // terget found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // left half sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // change the half, select left half only
                } else {
                    low = mid + 1; // change the half, select right half
                }
            } else
            // right half sorted
            {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // change the half , select right half only
                } else {
                    high = mid - 1; // change the half, seletct left half
                }
            }

        }
        return -1;
    }
}

// Normal Binary Search Algorithm

// Array must be sorted.

// Steps
// Set:
// low = 0
// high = n - 1
// Repeat while:
// low <= high
// Find middle:
// mid = low + (high - low) / 2
// If target found:
// return mid
// If target smaller than mid:
// high = mid - 1
// Else:
// low = mid + 1
// If not found:
// return -1
// Rotated Sorted Array Binary Search Algorithm
// Steps
// Set:
// low = 0
// high = n - 1
// Repeat while:
// low <= high
// Find middle:
// mid = low + (high - low) / 2
// If target found:
// return mid
// Check which half is sorted.
// If left half sorted:
// nums[low] <= nums[mid]
// If target lies inside left half:
// high = mid - 1
// Else:
// low = mid + 1
// Else right half sorted
// If target lies inside right half:
// low = mid + 1
// Else:
// high = mid - 1
// If not found:
// return -1
// Main Difference
// Normal Binary Search:
// Directly decide left/right

// Rotated Binary Search:
// First find sorted half, then decide