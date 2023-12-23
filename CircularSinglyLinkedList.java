public class CircularSinglyLinkedList<E>{
    private class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> tail = null;
    private int size;

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public E first(){
        if(isEmpty()){
            return null;
        }
        else{
            return tail.next.data;
        }
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        else{
            return tail.data;
        }
    }

    public void rotate(){
        if(isEmpty() == false){
            tail = tail.next;
        }
    }

    public void addFirst(E newData){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,null);
            tail = newNode;
            tail.next = tail;
        }
        else{
            Node<E> newNode = new Node<E>(newData,tail.next);
            tail.next = newNode;
        }
        size++;
    }

    public void addLast(E newData){
        if(isEmpty()){
            Node<E> newNode = new Node<E>(newData,null);
            tail = newNode;
            tail.next = tail;
        }
        else{
            Node<E> newNode = new Node<E>(newData,tail.next);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        else{
            E removed = tail.next.data;
            tail.next = tail.next.next;
            size--;
            return removed;
        }
    }

    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        else if(size == 1){
            E removed = tail.data;
            tail = null;
            size--;
            return removed;
        }
        else{
            E removed = tail.data;
            Node<E> temp = tail.next;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = tail.next;
            tail = temp;
            size--;
            return removed;
        }
    }

    public String toString(){
        String string = "";
        if(isEmpty()){
            return string;
        }
        else{
            string = string + " " + tail.next.data;
            Node<E> temp = tail.next.next;
            while(temp != tail.next){
                string = string + " " + temp.data;
                temp = temp.next;
            }
            return string;
        }
    }
}