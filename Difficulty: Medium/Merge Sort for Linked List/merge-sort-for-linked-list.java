/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
        
        //base case for recursion
        if (head == null || head.next == null) return head;
        Node mid = head, temp = head.next;
        
        while(temp != null && temp.next != null){
            mid = mid.next;
            temp = temp.next.next;
        }
        
        // dividing ll into 2
        Node head2 = mid.next;
        mid.next = null;
        
        Node left = mergeSort(head);
        Node right = mergeSort(head2);
        
        return merge(left, right);
    }
    private Node merge(Node left, Node right){
        Node dummy = new Node(0);
        Node head = dummy;
        
        while(left != null && right != null){
            if(left.data <= right.data){
                head.next = left;
                left = left.next;
            }
            else{
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if(left != null){
            head.next = left;
        }
        else head.next = right;
        
        return dummy.next;
    }
}