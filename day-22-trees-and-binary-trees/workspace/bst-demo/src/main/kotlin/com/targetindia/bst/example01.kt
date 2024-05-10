package com.targetindia.bst



fun readInt(prompt: String): Int {
    print(prompt)
    try {
        return readln().toInt()
    } catch (e: Exception) {
        throw RuntimeException("please retry with an integer")
    }
}

class TreeNode(var key: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinarySearchTree {
    var root: TreeNode? = null

    fun insert(key: Int) {
        root = insertRecursive(root, key)
    }

    private fun insertRecursive(node: TreeNode?, key: Int): TreeNode {
        if (node == null) {
            // println("creating a new node for $key ")
            return TreeNode(key)
        }

        if (key < node.key) {
            // println("traversing left tree for $key")
            node.left = insertRecursive(node.left, key)
        } else if (key > node.key) {
            // println("traversing right tree for $key")
            node.right = insertRecursive(node.right, key)
        } else {
            println("duplicate key $key, not inserted.")
        }

        return node
    }

    fun inOrderTraversal() {
        println("In order traversal of the BST: ")
        inOrderTraversalRecursive(root)
        println()
    }

    private fun inOrderTraversalRecursive(node: TreeNode?) {
        if (node != null) {
            inOrderTraversalRecursive(node.left)
            print("${node.key}, ")
            inOrderTraversalRecursive(node.right)
        }
    }

    fun preOrderTraversal() {
        println("In order traversal of the BST: ")
        preOrderTraversalRecusrive(root)
        println()
    }

    private fun preOrderTraversalRecusrive(node: TreeNode?) {
        if (node != null) {
            print("${node.key}, ")
            preOrderTraversalRecusrive(node.left)
            preOrderTraversalRecusrive(node.right)
        }
    }


    fun postOrderTraversal() {
        println("In order traversal of the BST: ")
        postOrderTraversalRecusrive(root)
        println()
    }

    private fun postOrderTraversalRecusrive(node: TreeNode?) {
        if (node != null) {
            postOrderTraversalRecusrive(node.left)
            postOrderTraversalRecusrive(node.right)
            print("${node.key}, ")
        }
    }

    fun display() {
        displayRecursive(root, 0)
    }

    private fun displayRecursive(node: TreeNode?, level: Int) {
        if (node != null) {
            displayRecursive(node.right, level + 1)
            println(" ".repeat(level * 4) + node.key)
            displayRecursive(node.left, level + 1)
        }
    }

    fun findMinimumKey(): Int {
        var curr = root
        while (curr?.left != null) {
            curr = curr.left
        }
        return curr!!.key
    }

    fun findMaximumKey(): Int {
        var curr = root
        while (curr?.right != null) {
            curr = curr.right
        }
        return curr!!.key
    }

    fun search(searchKey: Int): Boolean {
        return searchRecursive(root, searchKey)
    }

    private fun searchRecursive(node: TreeNode?, searchKey: Int): Boolean {
        if (node == null) {
            return false
        }
        if (node.key == searchKey) {
            return true
        }

        return if (searchKey < node.key) {
            searchRecursive(node.left, searchKey)
        } else {
            searchRecursive(node.right, searchKey)
        }
    }

    fun minimumDepth(): Int {
        return minimumDepthRecursive(root)
    }

    private fun minimumDepthRecursive(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = minimumDepthRecursive(node.left)
        val rightDepth = minimumDepthRecursive(node.right)
        if (leftDepth == 0 || rightDepth == 0) {
            return 1 + leftDepth + rightDepth
        }
        return 1 + minOf(leftDepth, rightDepth)
    }


    fun maximumDepth(): Int {
        return maximumDepthRecursive(root)
    }

    private fun maximumDepthRecursive(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = maximumDepthRecursive(node.left)
        val rightDepth = maximumDepthRecursive(node.right)
        if (leftDepth == 0 || rightDepth == 0) {
            return 1 + leftDepth + rightDepth
        }
        return 1 + maxOf(leftDepth, rightDepth)
    }

    fun delete(key: Int) {
        root = deleteRecursive(root, key)
    }

    private fun deleteRecursive(node: TreeNode?, key: Int): TreeNode? {
        var rootVar = node
        if (rootVar == null) return null

        if (key < rootVar.key) {
            rootVar.left = deleteRecursive(rootVar.left, key)
        } else if (key > rootVar.key) {
            rootVar.right = deleteRecursive(rootVar.right, key)
        } else {
            // found the key to delete  --> key == rootVar.key
            // 1. it is a leaf node
            // 2. has a single child (left or right)


            if (rootVar.left == null) {
                // no child on left side, not sure on the right side
                return rootVar.right
            } else if (rootVar.right == null) {
                // left child exists; right side no child
                return rootVar.left
            } else {
                // 3. has 2 children
                // find the inorder successor (smallest node in the right subtree)
                rootVar.key = minValue(rootVar.right!!) // find the minimum value to be deleted
                rootVar.right = deleteRecursive(rootVar.right, rootVar.key)

                // or inorder predecessor (largest node in the left subtree)
                // PS: we are not doing this approach
            }
        }
        return rootVar
    }

    private fun minValue(node: TreeNode): Int {
        var min = node.key
        var curr = node
        while (curr.left != null) {
            min = curr.left!!.key
            curr = curr.left!!
        }
        return min
    }
}

fun main() {
    val bst = BinarySearchTree()

    val keys = arrayOf(10, 20, 12, 29, 30, 15, 9, 16, 25, 22, 27, 34, 31, 8, 7, 6)
    for (key in keys) {
        bst.insert(key)
    }

    do {
        println("BST options: ")
        println("0. Exit")
        println("1. Insert")
        println("2. In-order traversal")
        println("3. Pre-order traversal")
        println("4. Post-order traversal")
        println("5. Find the minimum key")
        println("6. Find the maximum key")
        println("7. Display")
        println("8. Search for a key")
        println("9. Minimum depth")
        println("10. Maximum depth")
        println("11. Delete")
        println("12. Display all leaf nodes") // assignment task
        println("13. Display all nodes at a given level") // assignment task
        println("14. Delete a subtree at a node") // assignment task
        // explore red-black tree // assignment task
        // identify the time-complexity for each of these methods // assignment task

        val choice = readInt("Enter your choice: ")

        when (choice) {
            0 -> println("Exiting...")
            1 -> {
                val key = readInt("Enter key to insert: ")
                bst.insert(key)
            }

            2 -> bst.inOrderTraversal()
            3 -> bst.preOrderTraversal()
            4 -> bst.postOrderTraversal()
            5 -> println("Minimum key is ${bst.findMinimumKey()}")
            6 -> println("Minimum key is ${bst.findMaximumKey()}")
            7 -> bst.display()
            8 -> {
                val searchKey = readInt("Enter key to search: ")
                if (bst.search(searchKey)) {
                    println("$searchKey is found in the tree")
                } else {
                    println("$searchKey is not found in the tree")
                }
            }

            9 -> println("Minimum depth is ${bst.minimumDepth()}")
            10 -> println("Maximum depth is ${bst.maximumDepth()}")
            11 -> {
                val key = readInt("Enter key to delete: ")
                bst.delete(key)
            }
        }


    } while (choice != 0)
}