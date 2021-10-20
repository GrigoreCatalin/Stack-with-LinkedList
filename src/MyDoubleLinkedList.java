public class MyDoubleLinkedList<E> {
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private int size;

    public MyDoubleLinkedList() {
    }

    public MyDoubleLinkedList(MyDoubleLinkedList list) {
        DoubleLinkedListNode copyHead = list.head;
        while (copyHead != null) {
            add(copyHead.value());
            copyHead = copyHead.next();
        }
    }

    public boolean add(E e) {
        DoubleLinkedListNode node = new DoubleLinkedListNode(e);
        if (head == null) {
            head = node;
            tail = head;
            this.size++;
        } else {
            tail.next(node);
            node.previous(tail);
            tail = tail.next();
            this.size++;
        }
        return true;
    }

    public boolean checkSize() {
        if (head == null) {
            System.out.println("The list is empty");
            return true;
        }
        return false;
    }

    public boolean checkIndex(int index) {
        if (index > this.size - 1 || index < 0) {
            head = null;
            System.out.println("Index is out of range.");
            return true;
        }
        return false;
    }

    public void add(int index, E newElement) {
        DoubleLinkedListNode it = head;
        int counter = 0;

        if (index == 0 && this.size == 0) { // cazul in care nu avem niciun element in lista
            add(newElement);
        } else if (index == 0 && this.size > 0) { // cazul in care index-ul este 0 si avem elemente in lista
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(newElement);
            newNode.next(head);
            head.previous(newNode);
            head = newNode;
            this.size++;
        } else if (index > size - 1) { // cazul in care index-ul depaseste size-ul
            System.out.println("IndexOutOfBoundsException");
            head = null;
            return;
        } else {                       // restul cazurilor (index > 0)
            while (counter < index - 1) {
                it = it.next;
                counter++;
            }
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(newElement);
            newNode.value = newElement;

            newNode.next(it.next);
            it.next.previous(newNode);
            it.next(newNode);
            newNode.previous(it);
            this.size++;
        }
    }

    public boolean contains(E e) {
        if (checkSize()) {
            return false;
        }
        DoubleLinkedListNode it = head;
        while (it != null) {
            if (it.value.equals(e)) {
                return true;
            }
            it = it.next;
        }
        return false;
    }

    public E get(int index) {
        if (checkIndex(index)) {
            return null;
        }

        int counter = 0;

        DoubleLinkedListNode it = head;
        while (counter < index) {
            counter++;
            it = it.next;
        }
        return it.value;
    }

    public int indexOf(E e) {
        if (checkSize()) {
            return -1;
        }
        DoubleLinkedListNode it = head;
        int counter = 0;

        while (it != null) {
            if (it.value.equals(e)) {
                return counter;
            }
            it = it.next;
            counter++;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        if (checkSize()) {
            return -1;
        }
        DoubleLinkedListNode it = tail;
        int counter = this.size - 1;

        while (it != null) {
            if (it.value.equals(e)) {
                return counter;
            }
            it = it.previous;
            counter--;
        }
        return -1;
    }

    public boolean remove(E e) {
        if (checkSize()) {
            return false;
        }
        if (head.value.equals(e)) { //cazul in care nodul sters este primul
            head = head.next;
            head.previous = null;
            this.size--;
            return true;
        }

        if (tail.value.equals(e)) { //cazul in care nodul sters este ultimul
            tail = tail.previous;
            tail.next = null;
            this.size--;
            return true;
        }

        DoubleLinkedListNode headIterator = head;

        while (headIterator.next != null) {  // restul cazurilor
            if (headIterator.next.value.equals(e)) {
                headIterator.next(headIterator.next.next);
                headIterator.next.previous(headIterator);
                this.size--;
                return true;
            }
            headIterator = headIterator.next;
        }
        return false;
    }


    public E removeElementAtIndex(int index) {
        if (checkIndex(index)) {
            return null;
        }

        DoubleLinkedListNode it = head;

        if (index == 0) { //cazul in care nodul sters este primul
            E removeElement = it.value;
            head = it.next;
            this.size--;
            return removeElement;
        } else if (index == this.size - 1) { //cazul in care nodul sters este ultimul
            E removeElement = tail.value;
            tail = tail.previous;
            tail.next = null;
            this.size--;
            return removeElement;
        }

        int counter = 0;

        while (it.next != null && counter < index - 1) { // restul cazurilor
            it = it.next;
            counter++;
        }

        E removeElement = it.next.value;
        it.next(it.next.next);

        it.next.previous(it);
        this.size--;

        return removeElement;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public E set(int index, E e) {
        if (checkIndex(index)) {
            return null;
        }

        int counter = 0;
        DoubleLinkedListNode it = head;

        if (index >= 0) {
            while (it != null && counter < index) {
                it = it.next;
                counter++;
            }
            return it.value = e;
        }
        return null;
    }

    public boolean addAll(MyDoubleLinkedList c) {
        if (c.checkSize()) {
            return false;
        }

        DoubleLinkedListNode it = this.tail;
        it.next(c.head);
        c.head.previous(it);
        this.tail = c.tail;

        this.size += c.size;
        return true;
    }

    public boolean addAll(int index, MyDoubleLinkedList c) {
        if (c == null){
            return false;
        }

        if (checkIndex(index)) {
            this.head = null;
            return false;
        }

        MyDoubleLinkedList copylist = new MyDoubleLinkedList(c);
        DoubleLinkedListNode it = this.head;


        if (index == 0) { //cazul in care lista este introdusa pe pozitia 0
            this.head = copylist.head;
            copylist.tail.next(it);
            it.previous(copylist.tail);
            this.size += copylist.size;
            return true;
        }

        int iterator1 = 0;

        while (iterator1 < index - 1) {
            it = it.next;
            iterator1++;
        }

        DoubleLinkedListNode it2 = it.next;

        it.next(copylist.head);
        copylist.head.previous(it);
        copylist.tail.next(it2);
        it2.previous(copylist.tail);
        this.size += copylist.size;

        return true;
    }

    public Object [] toArray() {
        Object [] array = new Object[this.size];
        DoubleLinkedListNode it = this.head;
        for (int i = 0; i < array.length; i++) {
            array[i] = (Object) it.value;
            it = it.next;
            System.out.print(array[i] + " ");
        }
        return array;
    }

    public int getSize() {
        return this.size;
    }

    public E getTail() {
        return this.tail.value;
    }

    public E getHead() {
        return this.head.value;
    }


    public void display() {
        DoubleLinkedListNode it = head;

        while (it != null) {
            E value = it.value();
            it = it.next;
            System.out.println(value);
        }
    }

    private class DoubleLinkedListNode {
        private E value;
        private DoubleLinkedListNode next;
        private DoubleLinkedListNode previous;

        public DoubleLinkedListNode(E value, DoubleLinkedListNode next, DoubleLinkedListNode previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public DoubleLinkedListNode(E value) {
            this(value, null, null);
        }

        public DoubleLinkedListNode() {
        }

        public void value(E value) {
            this.value = value;
        }

        public E value() {
            return value;
        }

        public DoubleLinkedListNode next() {
            return next;
        }

        public void next(DoubleLinkedListNode next) {
            this.next = next;
        }

        public DoubleLinkedListNode previous() {
            return previous;
        }

        public void previous(DoubleLinkedListNode previous) {
            this.previous = previous;
        }
    }
}
