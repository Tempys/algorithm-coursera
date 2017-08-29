package ua.dubovslyi.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size;
    private EnumItem<Item> first;
    private EnumItem<Item> last;

    //LinkedList
    private static class EnumItem<Item> {
        Item item;
        EnumItem<Item> prevItem;
        EnumItem<Item> nextItem;

        public EnumItem(Item item, EnumItem<Item> prevItem, EnumItem<Item> nextItem) {
            this.item = item;
            this.prevItem = prevItem;
            this.nextItem = nextItem;
        }
    }

    public Deque() {
    }

    // construct an empty deque
    public boolean isEmpty() {
        return first == null;
    }

    // is the deque empty?
    public int size() {
        return size;
    }// return the number of items on the deque

    public void addFirst(Item item) {
        if(item == null) throw new IllegalArgumentException();

        if (isEmpty()) {
            first = new EnumItem<Item>(item, null, null);
            last = first;
        } else {
            first = new EnumItem<Item>(item, first, null);
            first.prevItem.nextItem = first;
        }

      size++;
    }          // add the item to the front

    public void addLast(Item item) {
        if(item == null) throw new IllegalArgumentException();
        if (isEmpty()) {
            addFirst(item);
        } else {
            size++;
            last = new EnumItem<Item>(item, null, this.last);
            EnumItem<Item> before = last.nextItem;
            before.prevItem=last;
        }



    }

    // add the item to the end
    public Item removeFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        Item preRem = this.first.item;
        if(size() == 1 ){
            last = null;
            first = null;
            size--;
        }

        if(size() > 1){
            this.first = first.prevItem;
            size--;
        }


        return preRem;
    }              // remove and return the item from the front

    public Item removeLast() {
        if(isEmpty()) throw new NoSuchElementException();

        Item preRem = this.last.item;

        if(size() == 1 ){
            last = null;
            first = null;
            size--;
        }

        if(size() > 1){
            this.last = last.nextItem;
            size--;
        }

        return preRem;
    }                 // remove and return the item from the end

    public Iterator<Item> iterator() {
        return new Arraylterator();
    }         // return an iterator over items in order from front to end


    private class Arraylterator implements Iterator<Item> { // Поддержка итерации по правилу LIFO,
        private int i = size();

        private EnumItem<Item> firstI;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
           // System.out.println(size());
          if(size == 0) throw new NoSuchElementException();

              i--;

            if(firstI == null){
                firstI = first;
                return first.item;
            }else{
                firstI = firstI.prevItem;
                return  firstI.item;
            }

        }

        public void remove() {
            throw new UnsupportedOperationException();

        }
        // unit testing (optional)
    }

    public static void main(String[] args) {



        Deque<String> deque = new Deque<>();
        deque.addFirst("ddddd");
        deque.addFirst("aaaaaa");
        deque.addFirst("ccccccc");

        Iterator it = deque.iterator();


        while(it.hasNext()) {
            String obj = (String)it.next();
            System.out.println(obj);
        }

    }
}
