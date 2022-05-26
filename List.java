public interface List<E> {
    int getSize();
    boolean isEmpty();
    void insert(int i, E e) throws IndexOutOfBoundsException;
    E remove(int i) throws IndexOutOfBoundsException;
    E get(int i) throws IndexOutOfBoundsException;
    void set (int i, E e) throws IndexOutOfBoundsException;
    void append(E e);
}
