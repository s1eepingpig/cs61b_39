public class test {
    public static void main(String[] args) {
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        LinkedListDeque.isEmpty();
        LinkedListDeque.addFirst(0);
        LinkedListDeque.addFirst(1);
        LinkedListDeque.addFirst(2);
        LinkedListDeque.addFirst(3);

        Integer integer = LinkedListDeque.removeLast();
        LinkedListDeque.printDeque();

        System.out.println(integer);

    }
}
