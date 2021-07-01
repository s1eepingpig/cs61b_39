public class test {
    public static void main(String[] args) {
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque();
        LinkedListDeque.addFirst(0);
        LinkedListDeque.addFirst(1);
        LinkedListDeque.addFirst(2);
        LinkedListDeque.addFirst(3);
        LinkedListDeque.addFirst(4);
        LinkedListDeque.addFirst(5);
        LinkedListDeque.addFirst(6);
        LinkedListDeque.addFirst(7);
        LinkedListDeque.addFirst(8);
        Integer o = LinkedListDeque.removeFirst();
        System.out.println(o);
    }
}
