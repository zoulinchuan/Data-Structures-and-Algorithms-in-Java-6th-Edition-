import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author zoulinchuan
 * @Date 2024年09月01日 星期日 14:01
 * @description: ${description}
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new MyArrayList<>(3);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);

        arrayList.set(3, 4);

        arrayList.add(1, 99);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        System.out.println("indexOf: " + arrayList.indexOf(2));
        System.out.println("indexOf: " + arrayList.indexOf(5));
    }
}

class MyArrayList<E> implements List<E> {

    private int size;

    private E[] array;

    public MyArrayList(int length) {
        size = 0;
        array = (E[]) new Object[length];
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
        return (T[]) array;
    }

    @Override
    public boolean add(E e) {
        if (size >= array.length) {
            E[] bigger = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = e;
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
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        E oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if (size == array.length) {
            E[] bigger = (E[]) new Object[size + 1];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        // 1,3,4,5,null,null -> 1,3,3,4,5,null
        System.arraycopy(array, index, array, index + 1, array.length - (index + 1));
        array[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && (array[i] == o || array[i].equals(o))) {
                return i;
            }
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
}