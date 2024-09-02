import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author zoulinchuan
 * @Date 2024年09月02日 星期一 22:08
 * @description:
 */
public class MyLinkedList<E> implements List<E> {


    private int size;

    public Node header;

    public MyLinkedList(){
        size = 0;
        header = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(header == null){
            this.header = new Node(e);
            size++;
            return true;
        }

        Node lastNode = header;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }

        lastNode.next = new Node(e);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node node = header;
        for (int j = 1; j < index ; j++){
            node = node.next;
        }

        E oldElement = node.next.data;
        node.next = node.next != null ? node.next.next : null;

        size--;
        return oldElement;
    }

    @Override
    public int indexOf(Object o) {
        Node node = header;
        int index = 0;
        while (node.next != null){
            if(o != null && o.equals(node.data)){
                return index;
            }
            node = node.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    class Node{
        private E data;
        private Node next;

        public Node(E data){
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
