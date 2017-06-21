package ua.dubovslyi.week2;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int DEFAULT_CAPACITY = 10;
  //  ArrayList
    private Item[] arr;

    private int size;
    private int minsize;

    public RandomizedQueue() {
        this.arr = (Item[])new Object[DEFAULT_CAPACITY];
        this.minsize = DEFAULT_CAPACITY;

    }                // construct an empty randomized queue
    public boolean isEmpty()  {return size == 0; }
    // is the queue empty?
    public int size()  {return size;}
    // return the number of items on the queue
    public void enqueue(Item item){
        ensureArrSize();
        arr[size++] = item;
    }           // add the item

    public Item dequeue() {

        if(size()==0) throw new NoSuchElementException();

        if( size()*2 < minsize ){
            minsize = minsize-size();
            Item[] s = (Item[]) new Object[minsize];
            System.arraycopy(arr,0,s,0,size);
            this.arr =s;
        }
        int as = size-1;

        Item r =  arr[as];
        arr[--size] = null;

        return r;
    }
    // remove and return a random item

    public Item sample(){return arr[size-1];}


    private void ensureArrSize(){
        if(size() == minsize){
            minsize = size() *2;
            Item[] s = (Item[]) new Object[minsize];
            System.arraycopy(arr,0,s,0,size);
            this.arr =s;

        }

    }
    // return (but do not remove) a random item

    public Iterator<Item> iterator() {
        return new Itr();
    }

    /**
     * An optimized version of AbstractList.Itr
     */
    private class Itr implements Iterator<Item> {
        int cursor;       // index of next element to return
        int lastRet = size()-1; // index of last element returned; -1 if no such
        boolean iterator = false;



        public boolean hasNext() {

            return cursor != size;
        }


        public Item next() {

            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Item[] elementData = arr;
            cursor = i + 1;
            return  elementData[lastRet = i];
        }

        public void remove() {
           throw new UnsupportedOperationException();
        }




    }

    // return an independent iterator over items in random order
    public static void main(String[] args) {


      RandomizedQueue<String> i = new RandomizedQueue<>();
       i.enqueue("a");
        i.enqueue("b");
        i.enqueue("c");
        i.enqueue("c");
        i.dequeue();
        i.enqueue("d");
        i.dequeue();
        i.enqueue("d");
        i.dequeue();
        i.dequeue();


        for(String it : i){
            System.out.println(it);
        }

      /*  while(it.hasNext()) {
            String obj = (String)it.next();
            System.out.println(obj);
        }*/


}  // unit testing (optional)

}
