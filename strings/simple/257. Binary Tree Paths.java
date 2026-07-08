// 257. Binary Tree Paths
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return all root-to-leaf paths in any order.

// A leaf is a node with no children.

// Example 1:

// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]
// Example 2:

// Input: root = [1]
// Output: ["1"]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    // List to store all root-to-leaf paths
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        // Start DFS from the root with an empty path
        dfs(root, "");
`
        return ans;
    }

    // Recursive DFS function
    public void dfs(TreeNode node, String path) {

        // Base case: if node is null, return
        if (node == null) {
            return;
        }

        // If this is the first node (root), don't add "->"
        if (path.equals("")) {
            path = String.valueOf(node.val);
        } else {
            // Append current node value to the existing path
            path = path + "->" + node.val;
        }

        // If current node is a leaf, store the completed path
        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }

        // Traverse left subtree
        dfs(node.left, path);

        // Traverse right subtree
        dfs(node.right, path);
    }
}

// Example
// 1
// / \
// 2 3
// \
// 5

// Initially

// ans = []
// Step 1

// binaryTreePaths(root) is called.

// dfs(root, "");

// becomes

// dfs(1, "");

// Current

// node = 1
// path = ""
// ans = []
// Step 2

// Check

// if(node == null)

// Is node null?

// No

// Continue.

// Step 3

// Execute

// if(path.equals(""))

// Current

// path = ""

// True.

// So

// path = String.valueOf(node.val);

// becomes

// path = "1"

// Current values

// node = 1
// path = "1"
// ans = []
// Step 4

// Check

// if(node.left==null && node.right==null)

// Node 1

// left = 2
// right = 3

// Not a leaf.

// So continue.

// Step 5

// Execute

// dfs(node.left,path);

// means

// dfs(2,"1");

// Now Java pauses the current function.

// It jumps into a new function.

// New Function Call
// dfs(2,"1")

// Current

// node = 2
// path = "1"
// ans = []
// Check null

// Node exists.

// Continue.

// Update path

// Current path

// 1

// Execute

// path = path + "->" + node.val;

// becomes

// 1->2

// Current

// node = 2
// path = "1->2"
// ans = []
// Is node 2 leaf?
// left = null
// right = 5

// No.

// Continue.

// Execute
// dfs(node.left,path);

// becomes

// dfs(null,"1->2");
// New Function Call
// dfs(null,"1->2")

// Current

// node = null

// Execute

// if(node==null)

// True.

// Immediately

// return;

// Function ends.

// Control goes back to

// dfs(2,"1->2")
// Back at node 2

// Java has already finished

// dfs(node.left,path);

// Now it executes the next line

// dfs(node.right,path);

// Right child is

// 5

// So call

// dfs(5,"1->2");
// New Function

// Current

// node = 5
// path = "1->2"
// ans = []
// Null?

// No.

// Update path

// Current

// 1->2

// After

// path=path+"->"+node.val;

// becomes

// 1->2->5

// Current

// node = 5
// path = "1->2->5"
// ans = []
// Is leaf?
// left = null
// right = null

// Yes.

// Execute

// ans.add(path);

// Now

// ans

// [
// "1->2->5"
// ]

// Execute

// return;

// Function ends.

// Return to node 2

// Current function

// dfs(2,"1->2")

// Both recursive calls are finished.

// Nothing left.

// Execute

// return;

// Node 2 finishes.

// Return to node 1

// Remember we had paused here

// dfs(1,"");

// Java had already executed

// dfs(node.left,path);

// Now it executes

// dfs(node.right,path);

// Right child is

// 3

// Call

// dfs(3,"1");

// Notice something important.

// The path is

// 1

// NOT

// 1->2->5

// because every recursive call has its own copy of path.

// New Function

// Current

// node = 3
// path = "1"
// ans

// [
// "1->2->5"
// ]
// Update path
// 1->3
// Leaf?

// Yes.

// Execute

// ans.add(path);

// Now

// ans

// [
// "1->2->5",
// "1->3"
// ]

// Return.

// Return to node 1

// Both recursive calls finished.

// Return.

// binaryTreePaths()

// Now

// return ans;

// Final answer

// [
// "1->2->5",
// "1->3"
// ]
// Entire Call Stack
// dfs(1,"")

// path="1"

// │
// ├──────── dfs(2,"1")
// │
// │ path="1->2"
// │
// │ ├──── dfs(null,"1->2")
// │ │
// │ │ return
// │ │
// │ └──── dfs(5,"1->2")
// │
// │ path="1->2->5"
// │
// │ ans.add("1->2->5")
// │
// │ return
// │
// │ return
// │
// └──────── dfs(3,"1")

// path="1->3"

// ans.add("1->3")

// return

// return
// 🌟 The one concept that makes recursion "click"

// Every time you call:

// dfs(node.left, path);

// Java creates a completely new function call with its own local variables
// (node and path). The current function pauses until that new call finishes.
// Only after it returns does Java execute:

// dfs(node.right, path);

// So the execution order is always:

// Process the current node.
// Explore the entire left subtree.
// Return to the current node.
// Explore the entire right subtree.
// Return to the parent.

// Once this "pause → recurse → return → continue" flow becomes clear, almost
// every recursive tree problem becomes much easier.

// My recommendation: Draw the call stack on paper exactly as shown above while
// stepping through the code. This single exercise is often what turns recursion
// from confusing into understandable.