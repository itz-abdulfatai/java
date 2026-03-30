package dsa;

/**
 * PHASE 1: FUNDAMENTALS
 * =======================
 * 
 * PROBLEM WE'RE SOLVING:
 * "I have an array of integers. I need to:
 *  - Print them all
 *  - Sum them all  
 *  - Find a specific number
 *  - Do this WITHOUT writing loops everywhere"
 * 
 * TRADITIONAL APPROACH (❌ Painful):
 * --------
 * for (int i = 0; i < array.length; i++) {
 *     System.out.println(array[i]);
 * }
 * 
 * for (int i = 0; i < array.length; i++) {
 *     sum += array[i];
 * }
 * 
 * // Again and again for every operation...
 * 
 * DESIGN PATTERN APPROACH (✅ Clean):
 * --------
 * Container accepts different visitors
 * Each visitor implements ONE operation
 * Container handles traversal
 * User just creates visitor and passes it
 * 
 * ===== SOLUTION: ArrayContainer =====
 */

import java.util.NoSuchElementException;

/**
 * ARRAY-BASED CONTAINER
 * 
 * IMPLEMENTATION DETAILS:
 * - Stores integers in internal array
 * - Grows dynamically (like ArrayList)
 * - Provides both Iterator AND Visitor patterns
 * 
 * LEARNING GOALS:
 * 1. See how to implement Container interface
 * 2. Understand how Iterator works with array data
 * 3. Understand how Visitor traverses all elements
 */
public class ArrayContainer extends AbstractContainer {

    // ===== INTERNAL DATA STRUCTURE =====
    // Hidden from users - they don't care about this!
    private Object[] items;
    private static final int DEFAULT_CAPACITY = 10;

    // ===== CONSTRUCTOR =====
    public ArrayContainer() {
        items = new Object[DEFAULT_CAPACITY];
        count = 0; // Initially empty
    }

    // ===== CORE CONTAINER OPERATIONS =====

    /**
     * ADD AN ITEM (basic operation all containers need)
     */
    public void add(Object item) {
        if (count == items.length) {
            // Array is full - resize (grow by 50%)
            Object[] newItems = new Object[items.length + items.length / 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        items[count] = item;
        count++;
    }

    /**
     * REMOVE ALL ITEMS
     * Implementation: Just reset count and clear array to allow garbage collection
     */
    @Override
    public void purge() {
        // Clear references so objects can be garbage collected
        for (int i = 0; i < count; i++) {
            items[i] = null;
        }
        count = 0;
    }

    // ===== ITERATOR PATTERN =====

    /**
     * Return an iterator for this container
     * User can then safely traverse without touching our internal array
     */
    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    /**
     * PRIVATE nested class: ArrayIterator
     * 
     * Why private? This is OUR implementation detail.
     * Users interact with Iterator interface, not this class directly.
     * 
     * WHY NESTED? This iterator is specifically for OUR container.
     * No point making it separate when it only works with ArrayContainer.
     */
    private class ArrayIterator implements Iterator {
        private int position = 0; // Current position in array

        @Override
        public boolean hasNext() {
            // Are there more elements after current position?
            return position < count;
        }

        @Override
        public Object next() {
            // Check boundary
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements!");
            }
            // Return current element and advance position
            return items[position++];
        }

        @Override
        public void remove() {
            // Remove last returned element (position-1)
            if (position == 0) {
                throw new IllegalStateException("Call next() first!");
            }
            // Shift all elements to fill the gap
            for (int i = position - 1; i < count - 1; i++) {
                items[i] = items[i + 1];
            }
            items[count - 1] = null;
            count--;
            position--; // Adjust position since we removed an element
        }
    }

    // ===== VISITOR PATTERN =====

    /**
     * Accept a visitor and have it process all elements
     * 
     * MECHANICS:
     * 1. Iterate through all elements
     * 2. Call visitor.visit(element) for each
     * 3. Check if visitor.isDone() - if true, stop early
     * 
     * BENEFIT: Container doesn't know what visitor does with elements!
     * Could be printing, summing, searching, transforming, etc.
     */
    @Override
    public void accept(Visitor v) {
        for (int i = 0; i < count; i++) {
            v.visit(items[i]);
            // Early exit if visitor is done
            if (v.isDone()) {
                break;
            }
        }
    }

    /**
     * Helper: Get element at index (for testing)
     */
    public Object get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return items[index];
    }
}
