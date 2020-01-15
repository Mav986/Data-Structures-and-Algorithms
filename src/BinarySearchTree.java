import java.util.*;
 
/**
 * FILE: 	BinarySearchTree.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Modified version of BinarySearchTree.java I submitted for Prac05
 */
public class BinarySearchTree<E>
{
    private TreeNode<E> root;

    /**
     * FILE: BinarySearchTree.TreeNode
     * AUTHOR: Kalon Shannon-Innes
     * ID: 18529687
     * UNIT: Data Structures and Algorithms
     * DATE: May 19, 2017
     * SOURCE: Unmodified version of BinarySearchTree.TreeNode I submitted for Prac05
     */
    private class TreeNode<N>
    {
        public String key;
        public N value;
        public TreeNode<N> leftChild;
        public TreeNode<N> rightChild;
         
        /**
         * NAME: Default Constructor
         * IMPORT: inKey (String)
         * IMPORT: inVal (Generic)
         * EXPORT: none
         * PURPOSE: Create a default TreeNode object
         */
        public TreeNode(String inKey, N inVal)
        {
            key = inKey;
            value = inVal;
            leftChild = null;
            rightChild = null;
        }
    }

    /**
     * NAME: BinarySearchTree
     * IMPORT: none
     * EXPORT: none
     * PURPOSE: Create a default BinarySearchTree
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * NAME: find
     * IMPORT: inKey (String)
     * EXPORT: found (Generic)
     * PURPOSE: Wrapper method to start the recursive find method
     */
    public E find(String inKey)
    {
        E found = rFind(inKey, root);
        return found;
    }

    /**
     * NAME: insert
     * IMPORT: inKey (String)
     * IMPORT: inVal (Generic)
     * EXPORT: none
     * PURPOSE: Wrapper method to start the recursive insert method
     */
    public void insert(String inKey, E inVal)
    {
        rInsert(inKey, inVal, root);
    }

    /**
     * NAME: delete
     * IMPORT: inKey (String)
     * EXPORT: none
     * PURPOSE: Wrapper method to start the recursive delete method
     */
    public void delete(String inKey)
    {
        rDelete(inKey, root);
    }

    /**
     * NAME: height
     * IMPORT: none
     * EXPORT: height (Integer)
     * PURPOSE: Wrapper method to start the recursive height method
     */
    public int height()
    {
    	int height = rHeight(root);
    	
        return height;
    }

    /**
     * NAME: rFind
     * IMPORT: inKey (String)
     * IMPORT: current (Generic TreeNode)
     * EXPORT: val (Generic)
     * PURPOSE: Recursive method to find a value in the BinarySearchTree
     */
    private E rFind(String inKey, TreeNode<E> current)
    {
        E val = null;
        String searchTerm = inKey.toLowerCase();

        if(current == null)
        {
            throw new NoSuchElementException("Key " + searchTerm + " not found");
        }

        else if(current.key.startsWith(searchTerm) || current.key.equals(searchTerm))
        {
            val = current.value;
        }

        else if(current.key.compareTo(searchTerm) < 0) 
        {

            val = rFind(searchTerm, current.leftChild);
        }

        else if(current.key.compareTo(searchTerm) > 0) 
        {

            val = rFind(searchTerm, current.rightChild);
        }
        return val;
    }

    /**
     * NAME: rInsert
     * IMPORT: inKey (String)
     * IMPORT: inVal (Generic)
     * IMPORT: current (Generic TreeNode)
     * EXPORT: insertedNode (Generic TreeNode)
     * PURPOSE: Recursive method to insert a generic value into a BinarySearchTree
     */
    private TreeNode<E> rInsert(String inKey, E inVal, TreeNode<E> current)
    {
        TreeNode<E> insertedNode = current;
        String searchTerm = inKey.toLowerCase();

        if(current == null)
        {
            TreeNode<E> newNode = new TreeNode<E>(searchTerm, inVal);
            insertedNode = newNode;
            
            if(root == null)
            {
                root = insertedNode;
            }
        }
        else if(searchTerm.equals(current.key))
        {
            throw new IllegalArgumentException("Key cannot be duplicate");
        }
        else if(current.key.compareTo(searchTerm) < 0)
        {
            current.leftChild = rInsert(searchTerm, inVal, current.leftChild);
        }
        else if(current.key.compareTo(searchTerm) > 0)
        {
            current.rightChild = rInsert(searchTerm, inVal, current.rightChild);
        }
         
        return insertedNode;
    }

    /**
     * NAME: rDelete
     * IMPORT: inKey (String)
     * EXPORT: updateNode (Generic TreeNode)
     * PURPOSE: Recursive method to delete a value from the BinarySearchTree
     */
    private TreeNode<E> rDelete(String inKey, TreeNode<E> current)
    {
        TreeNode<E> updateNode = current;
        String searchTerm = inKey.toLowerCase();
        
        if(current == null)
        {
            throw new IllegalArgumentException("Key not found in tree");
        }
        if(searchTerm.equals(current.key))
        {
            updateNode = deleteNode(searchTerm, current);
        }
        else if(current.key.compareTo(searchTerm) < 0)
        {
            current.leftChild = rDelete(searchTerm, current.leftChild);
        }
        else if(current.key.compareTo(searchTerm) > 0)
        {
            current.rightChild = rDelete(searchTerm, current.rightChild);
        }
         
        return updateNode;
    }

    /**
     * NAME: deleteNode
     * IMPORT: inKey (String)
     * IMPORT: node (Generic TreeNode)
     * EXPORT: updateNode (Generic TreeNode)
     * PURPOSE: Helper method to ensure the correct TreeNode is chosen to be promoted
     */
    private TreeNode<E> deleteNode(String inKey, TreeNode<E> node)
    {
        TreeNode<E> updateNode = null;

        if((node.leftChild == null) && (node.rightChild == null))
        {
            updateNode = null;
        }
        else if((node.leftChild != null) && (node.rightChild == null))
        {
            updateNode = node.leftChild;
        }
        else if((node.leftChild == null) && (node.rightChild != null))
        {
            updateNode = node.rightChild;
        }
        else
        {
            updateNode = promoteSuccessor(node.rightChild);            
            if(updateNode != node.rightChild)
            {
                updateNode.rightChild = node.rightChild;
            }
            updateNode.leftChild = node.leftChild;
        }
        return updateNode;
    }

    /**
     * NAME: promoteSuccessor
     * IMPORT: current (Generic TreeNode)
     * EXPORT: successor (Generic TreeNode)
     * PURPOSE: Promote a TreeNode to take the place of a deleted TreeNode
     */
    private TreeNode<E> promoteSuccessor(TreeNode<E> current)
    {
        TreeNode<E> successor = current;

        if(current.leftChild != null)
        {
            successor = promoteSuccessor(current.leftChild);
            if(successor == current.leftChild)
            {
                current.leftChild = successor.rightChild;
            }
        }
        return successor;
    }

    /**
     * NAME: rHeight
     * IMPORT: current (Generic TreeNode)
     * EXPORT: htSoFar (Integer)
     * PURPOSE: Calculate the height of the BinarySearchTree
     */
    private int rHeight(TreeNode<E> current)
    {
        int htSoFar;
        int leftHt;
        int rightHt;
         
        if(current == null)
        {
            htSoFar = -1;
        }
        else
        {
            leftHt = rHeight(current.leftChild);
            rightHt = rHeight(current.rightChild);
             
            if(leftHt > rightHt)
            {
                htSoFar = leftHt + 1;
            }
            else
            {
                htSoFar = rightHt + 1;
            }
        }
        return htSoFar;
    }
}