package dsa;

/**
 * ABSTRACT CONTAINER
 * 
 * BENEFIT OF ABSTRACT CLASS:
 * - Provides common implementation (getCount, isEmpty, isFull)
 * - All containers inherit these, avoiding code duplication
 * - Forces subclasses to implement data structure specifics
 * 
 * TEMPLATE: Each subclass decides:
 * - HOW to store (array, linked list, tree)
 * - HOW to iterate
 * - HOW to accept visitors
 * But WHAT operations do is same for all!
 */
public abstract class AbstractContainer implements Container {
    
    /** Instance variable: Track how many items are stored */
    protected int count;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        // Reusable logic: if count is 0, it's empty
        // No need to rewrite in every subclass!
        return getCount() == 0;
    }

    @Override
    public boolean isFull() {
        // Most containers (dynamic arrays, linked lists) are never full
        // Override this in subclasses if you have fixed capacity
        return false;
    }

    /** Subclass must implement: how to clear its specific data structure */
    @Override
    public abstract void purge();

    /** Subclass must implement: how to iterate through its elements */
    @Override
    public abstract Iterator iterator();
    
    /** Subclass must implement: how to let visitors process elements */
    @Override
    public abstract void accept(Visitor v);
}
