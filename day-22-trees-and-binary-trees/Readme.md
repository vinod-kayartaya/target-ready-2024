# Trees and Binary Trees

## Introduction to Trees: Terminologies (Root, Node, Leaf, Parent, Child), Types of Trees

In computer science, a tree is a widely used data structure that resembles a hierarchical structure. It consists of nodes connected by edges. Each node has a value and zero or more child nodes. Trees are used to represent hierarchical relationships and are fundamental in various algorithms and applications, including file systems, databases, and compilers.

### Basic Terminologies:

1. **Node:** A fundamental building block of a tree that contains a value and references to its child nodes (if any).
2. **Root:** The topmost node in a tree. It is the starting point for traversing the tree and has no parent.
3. **Leaf:** A node with no children. It is at the bottom of the tree.
4. **Parent:** A node that has one or more child nodes.
5. **Child:** A node directly connected to another node when moving away from the root.

### Types of Trees:

1. **Binary Tree:** A binary tree is a tree in which each node can have at most two children, referred to as the left child and the right child.

2. **Binary Search Tree (BST):** A binary search tree is a type of binary tree where the value of each node's left child is less than the value of the parent node, and the value of each node's right child is greater than the value of the parent node. This property allows for efficient searching, insertion, and deletion operations.

3. **Balanced Tree:** A balanced tree is a tree in which the height difference between the left and right subtrees of any node is at most one. Examples include AVL trees, red-black trees, and B-trees. Balanced trees ensure that operations like insertion, deletion, and search have logarithmic time complexity, making them efficient.

4. **Full Binary Tree:** A full binary tree is a binary tree in which every node has either zero or two children. No node has only one child.

5. **Complete Binary Tree:** A complete binary tree is a binary tree in which all levels are completely filled, except possibly the last level, which is filled from left to right. Complete binary trees are typically used in heaps.

6. **Perfect Binary Tree:** A perfect binary tree is a binary tree in which all internal nodes have exactly two children, and all leaf nodes are at the same level.

7. **Degenerate Tree (or Pathological Tree):** A degenerate tree is a tree in which each parent node has only one associated child node. It essentially resembles a linked list rather than a tree structure.

## Introduction to Binary Trees: Definition, Properties, Operations (Traversal, Insertion, Deletion)

A binary tree is a hierarchical data structure in which each node has at most two children, referred to as the left child and the right child. Binary trees are widely used in computer science due to their simplicity and versatility. They serve as the foundation for many other data structures and algorithms.

### Definition:

A binary tree is defined recursively as a collection of nodes where each node has a value and two pointers, typically called `left` and `right`, pointing to its left and right children, respectively. The structure of a binary tree resembles a tree with branches growing downwards, where each node represents a branch point and the children represent the branches.

### Properties:

1. **Root Node:** The topmost node of the tree is called the root node. It serves as the starting point for traversing the tree.

2. **Parent Node:** Any node in the tree except the root node has a parent node, which is the node directly above it.

3. **Child Nodes:** Each node in a binary tree can have at most two children: a left child and a right child.

4. **Leaf Nodes:** Nodes that do not have any children are called leaf nodes. They are at the bottom level of the tree.

5. **Height:** The height of a binary tree is the length of the longest path from the root node to a leaf node. It represents the maximum number of edges between the root and a leaf.

6. **Depth (Level):** The depth (or level) of a node is the length of the path from the root node to that node. The root node has a depth of 0.

7. **Binary Tree Properties:** Binary trees can have different shapes and structures, ranging from skewed (unbalanced) to balanced trees. The balance of a tree significantly affects its performance in terms of operations such as search, insertion, and deletion.

### Operations:

1. **Traversal:** Traversal involves visiting all nodes of the binary tree in a specific order. Common traversal algorithms include:

   - Inorder Traversal: Visit left subtree, visit root, visit right subtree.
   - Preorder Traversal: Visit root, visit left subtree, visit right subtree.
   - Postorder Traversal: Visit left subtree, visit right subtree, visit root.

2. **Insertion:** Inserting a new node into a binary tree involves finding the appropriate position for the new node based on its value and adding it as a leaf node.
3. **Deletion:** Deleting a node from a binary tree requires handling three cases:
   - Node has no children: Simply remove the node.
   - Node has one child: Replace the node with its child.
   - Node has two children: Find the node's inorder successor (or predecessor), replace the node's value with the successor's value, and then delete the successor node.

### Kotlin Code Examples:

Let's implement basic operations for a binary tree in Kotlin:

```kotlin
class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTree {
    var root: TreeNode? = null

    // Inorder traversal
    fun inorderTraversal(node: TreeNode?) {
        if (node != null) {
            inorderTraversal(node.left)
            println(node.value)
            inorderTraversal(node.right)
        }
    }

    // Insertion
    fun insert(value: Int) {
        root = insertRecursive(root, value)
    }

    private fun insertRecursive(node: TreeNode?, value: Int): TreeNode {
        if (node == null) {
            return TreeNode(value)
        }

        if (value < node.value) {
            node.left = insertRecursive(node.left, value)
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value)
        }

        return node
    }

    // Deletion (not implemented here for brevity)
}
```

This `BinaryTree` class provides basic operations such as insertion and inorder traversal. Deletion operation can be implemented similarly using appropriate algorithms.

These examples illustrate the fundamental concepts of binary trees and their operations in Kotlin. More complex operations and optimizations can be added based on specific requirements.

## Binary Tree Traversal: Inorder, Preorder, Postorder

Binary tree traversal algorithms are fundamental in understanding and manipulating binary trees. There are three common traversal methods: inorder, preorder, and postorder traversal. Let's explore each of them:

### 1. Inorder Traversal:

In inorder traversal, the nodes are visited in the following order:

1. Traverse the left subtree.
2. Visit the root node (access the root node data).
3. Traverse the right subtree.

In binary search trees (BST), inorder traversal results in visiting nodes in sorted order.

### 2. Preorder Traversal:

In preorder traversal, the nodes are visited in the following order:

1. Visit the root node.
2. Traverse the left subtree.
3. Traverse the right subtree.

### 3. Postorder Traversal:

In postorder traversal, the nodes are visited in the following order:

1. Traverse the left subtree.
2. Traverse the right subtree.
3. Visit the root node.

Each traversal method provides a different sequence of visiting nodes and is useful for various applications such as expression evaluation, constructing expression trees, and printing the tree in a specific format.

### Kotlin Code Examples:

Let's implement these traversal methods in Kotlin:

```kotlin
class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTree {
    var root: TreeNode? = null

    // Inorder Traversal
    fun inorderTraversal(node: TreeNode?) {
        if (node != null) {
            inorderTraversal(node.left)
            println(node.value)
            inorderTraversal(node.right)
        }
    }

    // Preorder Traversal
    fun preorderTraversal(node: TreeNode?) {
        if (node != null) {
            println(node.value)
            preorderTraversal(node.left)
            preorderTraversal(node.right)
        }
    }

    // Postorder Traversal
    fun postorderTraversal(node: TreeNode?) {
        if (node != null) {
            postorderTraversal(node.left)
            postorderTraversal(node.right)
            println(node.value)
        }
    }
}
```

These methods can be called on a binary tree instance to traverse the tree in the desired order:

```kotlin
val tree = BinaryTree()
// Assume the tree has been constructed
println("Inorder Traversal:")
tree.inorderTraversal(tree.root)

println("Preorder Traversal:")
tree.preorderTraversal(tree.root)

println("Postorder Traversal:")
tree.postorderTraversal(tree.root)
```

These examples demonstrate how to perform inorder, preorder, and postorder traversals on a binary tree in Kotlin. Each traversal method produces a different order of visiting nodes, which can be utilized based on the requirements of the application.

## Special types of Binary Trees: Binary Search Trees (BST), Balanced Binary Trees (AVL Trees)

Let's explore Binary Search Trees (BSTs) and Balanced Binary Trees, specifically AVL Trees.

### 1. Binary Search Trees (BSTs):

Binary Search Trees are a special type of binary tree where the value of each node in the left subtree is less than the value of the node, and the value of each node in the right subtree is greater than the value of the node. This property enables efficient searching, insertion, and deletion operations.

#### Operations:

- **Search:** Starting from the root node, compare the target value with the current node's value. If the target is less, move to the left child; if greater, move to the right child. Repeat until finding the target or reaching a null child.
- **Insertion:** Similar to searching, but when reaching a null child, insert the new node with the target value at that position.
- **Deletion:** Three cases need to be considered: node has no children, node has one child, and node has two children. The node's successor or predecessor can be used to replace the deleted node.

#### Complexity:

- The time complexity of search, insertion, and deletion operations in a balanced BST is O(log n) on average, where n is the number of nodes.

### 2. Balanced Binary Trees (AVL Trees):

AVL Trees are a type of self-balancing binary search tree, named after their inventors Adelson-Velsky and Landis. In AVL trees, the height difference between the left and right subtrees of every node (called the balance factor) is at most 1. This balancing property ensures that the tree remains balanced, preventing the tree from becoming skewed and maintaining optimal performance for operations.

#### Balancing Operations:

- **Rotation:** AVL trees use rotation operations to balance the tree when necessary. There are four types of rotations: left rotation, right rotation, left-right rotation (also known as double right rotation), and right-left rotation (also known as double left rotation).

- **Insertion and Deletion:** After performing insertion or deletion operations, the tree may become unbalanced. AVL trees use rotations to restore balance while maintaining the BST property.

#### Complexity:

- The time complexity of search, insertion, and deletion operations in AVL trees is O(log n) in the worst case, where n is the number of nodes. This is because AVL trees ensure that the height of the tree remains logarithmic.

### Kotlin Code Example:

Here's a basic implementation of a Binary Search Tree in Kotlin:

```kotlin
class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinarySearchTree {
    var root: TreeNode? = null

    fun insert(value: Int) {
        root = insertRecursive(root, value)
    }

    private fun insertRecursive(node: TreeNode?, value: Int): TreeNode {
        if (node == null) {
            return TreeNode(value)
        }

        if (value < node.value) {
            node.left = insertRecursive(node.left, value)
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value)
        }

        return node
    }

    // Other operations like search, delete can be implemented here
}
```

To implement an AVL Tree, you would extend this basic BST implementation with additional logic for balancing the tree after insertion and deletion operations, which involves rotations.

## Red-black tree

Red-Black Trees are another type of self-balancing binary search tree, like AVL trees, but with less strict balancing requirements. They were introduced by Rudolf Bayer in 1972 and later refined by Leonidas J. Guibas and Robert Sedgewick in 1978.

### Red-Black Trees:

Red-Black Trees are binary search trees that maintain balance through the use of colorings on the nodes. Each node is colored either red or black, and the tree must satisfy the following properties:

1. **Property 1:** Every node is either red or black.
2. **Property 2:** The root node is black.
3. **Property 3:** Every leaf (nil) is black.
4. **Property 4:** If a red node has children, then both children are black (no two red nodes can be adjacent).
5. **Property 5:** For each node, all simple paths from the node to descendant leaves contain the same number of black nodes. This property ensures that the longest path in the tree is no more than twice as long as the shortest path.

#### Balancing Operations:

- Red-Black Trees use a set of operations known as rotations and color flips to maintain balance during insertions and deletions.
- When inserting a node into a Red-Black Tree, the tree may violate one or more properties. Balancing operations are performed to restore the properties while preserving the binary search tree property.

#### Complexity:

- Red-Black Trees offer efficient worst-case time complexity for search, insertion, and deletion operations. Each operation has a time complexity of O(log n), where n is the number of nodes in the tree.

### Kotlin Code Example:

Here's a simplified implementation of a Red-Black Tree in Kotlin:

```kotlin
class TreeNode(var key: Int, var color: Int) {
    var parent: TreeNode? = null
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class RedBlackTree {
    var root: TreeNode? = null

    private val BLACK = 0
    private val RED = 1

    private fun leftRotate(x: TreeNode?) {
        val y = x!!.right
        x.right = y!!.left
        if (y.left != null) {
            y.left!!.parent = x
        }
        y.parent = x.parent
        if (x.parent == null) {
            root = y
        } else if (x == x.parent!!.left) {
            x.parent!!.left = y
        } else {
            x.parent!!.right = y
        }
        y.left = x
        x.parent = y
    }

    private fun rightRotate(x: TreeNode?) {
        val y = x!!.left
        x.left = y!!.right
        if (y.right != null) {
            y.right!!.parent = x
        }
        y.parent = x.parent
        if (x.parent == null) {
            root = y
        } else if (x == x.parent!!.right) {
            x.parent!!.right = y
        } else {
            x.parent!!.left = y
        }
        y.right = x
        x.parent = y
    }

    fun insert(key: Int) {
        val z = TreeNode(key, RED)
        var y: TreeNode? = null
        var x = root
        while (x != null) {
            y = x
            if (z.key < x.key) {
                x = x.left
            } else {
                x = x.right
            }
        }
        z.parent = y
        if (y == null) {
            root = z
        } else if (z.key < y.key) {
            y.left = z
        } else {
            y.right = z
        }
        z.left = null
        z.right = null
        z.color = RED
        insertFixup(z)
    }

    private fun insertFixup(z: TreeNode?) {
        var zVar = z
        while (zVar!!.parent != null && zVar.parent!!.color == RED) {
            if (zVar.parent == zVar.parent!!.parent!!.left) {
                val y = zVar.parent!!.parent!!.right
                if (y != null && y.color == RED) {
                    zVar.parent!!.color = BLACK
                    y.color = BLACK
                    zVar.parent!!.parent!!.color = RED
                    zVar = zVar.parent!!.parent
                } else {
                    if (zVar == zVar.parent!!.right) {
                        zVar = zVar.parent
                        leftRotate(zVar)
                    }
                    zVar!!.parent!!.color = BLACK
                    zVar.parent!!.parent!!.color = RED
                    rightRotate(zVar.parent!!.parent)
                }
            } else {
                val y = zVar.parent!!.parent!!.left
                if (y != null && y.color == RED) {
                    zVar.parent!!.color = BLACK
                    y.color = BLACK
                    zVar.parent!!.parent!!.color = RED
                    zVar = zVar.parent!!.parent
                } else {
                    if (zVar == zVar.parent!!.left) {
                        zVar = zVar.parent
                        rightRotate(zVar)
                    }
                    zVar!!.parent!!.color = BLACK
                    zVar.parent!!.parent!!.color = RED
                    leftRotate(zVar.parent!!.parent)
                }
            }
        }
        root!!.color = BLACK
    }
}
```

This is a simplified implementation of Red-Black Tree insertion in Kotlin, including left and right rotations and the insertion fixup algorithm to maintain the Red-Black Tree properties. This code demonstrates the core logic of Red-Black Trees but may require further refinement and expansion for a complete implementation.
