public class MyStack<E> {
    private MyDoubleLinkedList list;

    public MyStack() {
        this.list = new MyDoubleLinkedList();
    }

    public E push(E element) {
       if(this.list.add(element)){
           return element;
       }
       return null;
    }

    public E peek() {
        if (!isEmpty()) {
            return (E) this.list.getTail();
        }
        return null;
    }

    public void display() {
        this.list.display();
    }
    public E remove() {
        if (!isEmpty()) {
            return (E) this.list.removeElementAtIndex(this.list.getSize() - 1);
        }
        return null;
        }

    public boolean isEmpty() {
        if (this.list.getSize() == 0){
            return true;
        }
        return false;
    }

    public int getSize(){
        return this.list.getSize();
    }

}
