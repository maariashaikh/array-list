import java.util.*;

public class ArrayList<E> implements List<E>, Iterable<E>{
    private int currentSize = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private E[] elements;
    
    public ArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
    
    @Override
    public void insert(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, currentSize + 1);
        if ( isFullCapacity() ){
            increaseCapacity();
        }
        for(int k = currentSize-1 ; k >= i ; k --){
            elements[k + 1] = elements[k];
        }
        
        elements[i] = e;
        currentSize++;
    }
    
    @Override
    public E remove(int i) throws IndexOutOfBoundsException{
        checkIndex(i, currentSize );
        E oldElement = elements[i];
        for(int k = i ; k < currentSize - 1 ; k ++){
            elements[k] = elements[k + 1] ;
        }
        elements[ currentSize -1] = null;
        currentSize--;
        return oldElement;
    }
    
    private boolean isFullCapacity(){
        return currentSize == elements.length;
    }

    @Override
    public boolean isEmpty(){
        return currentSize == 0;
    }
    
    @Override
    public int getSize(){
        return currentSize;
    }

    /*
     When the array is full, instead of throwing an exception, we can replace the array with a larger one â€¦
    */
    private void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i, currentSize);
        return (E) elements[i];
    }
    
    @Override
    public void set (int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, currentSize);
        elements[i] = e;
    }
    
    private void checkIndex(int i, int n){
        if (i >= n || i < 0) {
            throw new IndexOutOfBoundsException("Illegal index : Index: " + i + ", Size " + n );
        }
    }
    
    @Override
    public void append(E e){
        if ( isFullCapacity() ) {
            increaseCapacity();
        }
        elements[currentSize++] = e;
    }
    
    // inner Iterator class
    private class ArrayListIterator implements Iterator<E>{
        private int i = 0;
        private boolean removable = false;
        
        @Override
        public boolean hasNext(){
            return i < currentSize;
        }
        
        @Override
        public E next() throws NoSuchElementException{
            if ( i == currentSize) {
                throw new NoSuchElementException("No next element");   
            }
            removable = true;
            return elements[ i++ ];
        }

        @Override
        public void remove() throws IllegalStateException{
            if ( !removable ) {
                throw new IllegalStateException("No element to remove");   
            }
            ArrayList.this.remove(i - 1);
            i--;
            removable = false;
        }
    }// end Iterator class
    
    @Override
    public Iterator<E> iterator(){
        return new ArrayListIterator();
    }
}
