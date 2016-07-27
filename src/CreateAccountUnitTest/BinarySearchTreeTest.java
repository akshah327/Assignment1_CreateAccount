package CreateAccountUnitTest;

import org.junit.Test;
import utils.BinarySearchTree;

import static org.junit.Assert.*;

/**
 * Created by anujshah on 7/20/16.
 */
public class BinarySearchTreeTest
{
    private static final String ADD_EXPECTED_STRING_PREORDER = "List:\n 5\n 2\n 1\n 4\n 3\n 6\n 10\n 7\n 9\n 8\n";
    private static final String ADD_EXPECTED_STRING_INORDER = "List:\n 1\n 2\n 3\n 4\n 5\n 6\n 7\n 8\n 9\n 10\n";
    private static final String ADD_EXPECTED_STRING_POSTORDER = "List:\n 1\n 3\n 4\n 2\n 8\n 9\n 7\n 10\n 6\n 5\n";
    private static final String REMOVE_EXPECTED_STRING_PREORDER = "List:\n 4\n 2\n 1\n 3\n 6\n 10\n 7\n 9\n 8\n";


    @Test
    public void add() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        System.out.println("Tree preOrder:" + tree + "\n");
        assertEquals("add method failed", ADD_EXPECTED_STRING_PREORDER, tree.toString());
        tree.reset(2);
        System.out.println("Tree inOrder:" + tree + "\n");
        assertEquals("add method failed", ADD_EXPECTED_STRING_INORDER, tree.toString());
        tree.reset(3);
        System.out.println("Tree postOrder:" + tree + "\n");
        assertEquals("add method failed", ADD_EXPECTED_STRING_POSTORDER, tree.toString());
    }

    @Test
    public void remove() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        System.out.println("Tree preOrder:" + tree + "\n");
        tree.remove(5);
        tree.reset(1);
        System.out.println("Tree preOrder after remove:" + tree + "\n");
        assertEquals("remove method failed", REMOVE_EXPECTED_STRING_PREORDER, tree.toString());
    }

    @Test
    public void contains() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        System.out.println("Tree preOrder:" + tree + "\n");
        assertEquals("contains method failed", true, tree.contains(5));
        assertEquals("contains method failed", false, tree.contains(11));
    }

    @Test
    public void isEmpty() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals("isEmpty method failed", true, tree.isEmpty());
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        System.out.println("Tree preOrder:" + tree + "\n");
        assertEquals("isEmpty method failed", false, tree.isEmpty());
    }

    @Test
    public void size() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals("size method failed", 0, tree.size());
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        System.out.println("Tree preOrder:" + tree + "\n");
        assertEquals("size method failed", 10, tree.size());
    }

    @Test
    public void reset() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        System.out.println("Tree preOrder:" + tree + "\n");
        assertEquals("reset method failed", ADD_EXPECTED_STRING_PREORDER, tree.toString());
        tree.reset(2);
        System.out.println("Tree inOrder:" + tree + "\n");
        assertEquals("reset method failed", ADD_EXPECTED_STRING_INORDER, tree.toString());
        tree.reset(3);
        System.out.println("Tree postOrder:" + tree + "\n");
        assertEquals("reset method failed", ADD_EXPECTED_STRING_POSTORDER, tree.toString());
    }

    @Test
    public void get() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        assertEquals("add method failed", 5, tree.get(5));
        assertEquals("add method failed", null, tree.get(11));
    }

    @Test
    public void getNext() throws Exception
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(9);
        tree.add(8);
        tree.add(4);
        tree.add(3);
        tree.reset(1);
        assertEquals("getNext method failed", 5, tree.getNext(1));
        tree.reset(2);
        assertEquals("getNext method failed", 1, tree.getNext(2));
        tree.reset(3);
        assertEquals("getNext method failed", 1, tree.getNext(3));
    }

}