public class main {

    public static void checkTwoList(MyDoubleLinkedList list1) {
//        MyDoubleLinkedList list2 = new MyDoubleLinkedList();
//        list2.add(1221);
//        list2.add(211);

        MyDoubleLinkedList list3 = new MyDoubleLinkedList();
        list3.add(121);
        list3.add(21);

        System.out.println(list1.addAll(3, list3));
        System.out.println();
        list1.display();
        System.out.println();
        list3.display();
        System.out.println();

        System.out.println("Size List 1 ->" + list1.getSize());
        System.out.println("Size List 2 ->" + list3.getSize());

        System.out.println("Head List 1 ->" + list1.getHead());
        System.out.println("Head List 2 ->" + list3.getHead());

        System.out.println("Tail List 1 ->" + list1.getTail());
        System.out.println("Tail List 2 ->" + list3.getTail());
    }

    public static void main(String[] args) {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.add(10);
        list.add(202);
        list.add(335);
        list.add(51);


        //       list.toArray();
//        list.add(0,654);
        checkTwoList(list);
//        System.out.println(list.remove(335));
//       list.display();
//        System.out.println(list.removeElementAtIndex(1));
//        System.out.println(list.set(1,11));
//        System.out.println(list.contains(4));
//        System.out.println("Index -> " + list.get(-1));
//        System.out.println("IndexOf -> " + list.indexOf(10));
//        System.out.println("LastIndexOf -> " + list.lastIndexOf(101));

//        LinkedList<Integer> s1 = new LinkedList<Integer>();
//        s1.add(1);
//        s1.add(2);
//
//        LinkedList<Integer> s2 = new LinkedList<Integer>();
//        s2.add(3);
//        s2.add(4);
//        s2.add(5);
//
//        s1.addAll(0,s2);
//
//        System.out.println(s1);
//        System.out.println();
//
//        System.out.println(s1.size());
//        System.out.println(s2.size());
//        System.out.println(s1.peekFirst());
//        System.out.println(s1.peekLast());
//        System.out.println(s2.peekFirst());
//        System.out.println(s2.peekLast());

        MyStack stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Element added -> " + stack.push(3));
        System.out.println("Peek element -> " + stack.peek());
        System.out.println("Stack size -> " + stack.getSize());
        System.out.println("Element removed -> " + stack.remove());
        System.out.println("Stack size -> " + stack.getSize());

        System.out.println("Element removed -> " + stack.remove());

        System.out.println("is stack empty? -> " + stack.isEmpty());

        stack.display();


    }
}
