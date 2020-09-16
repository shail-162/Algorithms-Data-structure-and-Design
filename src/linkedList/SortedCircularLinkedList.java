package linkedList;
// Java implementation of the approach

/**
 * source: GeeksForGeeks
 */
public class SortedCircularLinkedList {

        // Node structure
        static class Node
        {
            Node next;
            int data;
        };

        // Function to create a node
        static Node create()
        {
            Node new_node = new Node();
            new_node.next = null;

            return new_node;
        }

        // Function to find and return the head
        static Node find_head(Node random)
        {
            // If the list is empty
            if (random == null)
                return null;

            Node var = random;

            // Finding the last node of the linked list
            // the last node must have the highest value
            // if no such element is present then all the nodes
            // of the linked list must be same
            while (!(var.data > var.next.data ||
                    var.next == random))
            {
                var = var.next;
            }

            // Return the head
            return var.next;
        }

        // Function to insert a new_node in the list
// in sorted fashion. Note that this function
// expects a pointer to head node as this can
// modify the head of the input linked list
        static Node sortedInsert(Node head_ref,
                                 Node new_node)
        {
            Node current = head_ref;

            // If the list is empty
            if (current == null)
            {
                new_node.next = new_node;
                head_ref = new_node;
            }

            // If the node to be inserted is the smallest
            // then it has to be the new head
            else if (current.data >= new_node.data)
            {

                // Find the last node of the list as it
                // will be pointing to the head
                while (current.next != head_ref)
                    current = current.next;
                current.next = new_node;
                new_node.next = head_ref;
                head_ref = new_node;
            }

            else
            {
                // Locate the node before the point of insertion
                while (current.next != head_ref &&
                        current.next.data < new_node.data)
                {
                    current = current.next;
                }
                new_node.next = current.next;
                current.next = new_node;
            }

            // Return the new head
            return head_ref;
        }

        // Function to print the nodes of the linked list
        static void printList(Node start)
        {
            Node temp;

            if (start != null)
            {
                temp = start;
                do
                {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                } while (temp != start);
            }
        }

        // Driver code
        public static void main(String args[])
        {

            int[] arr = { 12, 56, 2, 11, 1, 90 };
            int list_size, i;

            // Start with an empty linked list
            Node start = null;
            Node temp;

            // Create linked list from the given array
            for (i = 0; i < 6; i++)
            {

                // Move to a random node if it exists
                if (start != null)
                    for (int j = 0;
                         j < (Math.random() * 10); j++)
                        start = start.next;

                temp = create();
                temp.data = arr[i];
                start = sortedInsert(find_head(start), temp);
            }

            // Print the contents of the created list
            printList(find_head(start));
        }
    }