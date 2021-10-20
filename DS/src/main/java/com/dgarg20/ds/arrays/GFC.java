package com.dgarg20.ds.arrays;

/**
 * Created by Deepanshu Garg on 27/10/20.
 */
class GFG
{

    // Node structure
    static class Node
    {
        int data;
        Node next;
    };

    static Node newNode(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;
        return node;
    }

    // Function to find the luckiest person
    static int alivesol(int Num)
    {
        if (Num == 1)
            return 1;

        // Create a single node circular
        // linked list.
        Node last = newNode(1);
        last.next = last;

        for (int i = 2; i <= Num; i++)
        {
            Node temp = newNode(i);
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }

        // Starting from first soldier.
        Node curr = last.next;

        // condition for evaluating the existence
        // of single soldier who is not killed.
        Node temp = new Node();
        while (curr.next != curr)
        {
            temp = curr;
            curr = curr.next;
            temp.next = curr.next;

            // deleting soldier from the circular
            // list who is killed in the fight.
            temp = temp.next;
            curr = temp;
        }

        // Returning the Luckiest soldier who
        // remains alive.
        int res = temp.data;

        return res;
    }

    // Driver code
    public static void main(String args[])
    {
        int N = 4;
        System.out.println( alivesol(N) );
        /*System.out.println( alivesol(100) );
        System.out.println( alivesol(64) );*/

        System.out.println( alivesol(72) );
        System.out.println( alivesol(19) );
        System.out.println( alivesol(29) );
        System.out.println( alivesol(29) );
        System.out.println( alivesol(31) );



    }
}