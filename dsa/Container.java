package dsa;

/**
 * CONTAINER INTERFACE
 * 
 * SIMPLE EXPLANATION:
 * A Container is like a box that stores items and provides basic operations.
 * It's the "home" for data that can be visited or iterated over.
 * 
 * TECHNICAL DEFINITION:
 * Contract for any data structure that:
 * - Stores objects
 * - Allows visitors to access all elements
 * - Provides iteration capability
 * - Maintains element count and state
 * 
 * WHY INTERFACE?
 * So we can swap implementations (Array, LinkedList, Tree, etc.)
 * without changing code that uses containers!
 */
public interface Container {
    
    /** Get number of elements currently in container */
    int getCount();

    /** Check if container has no elements */
    boolean isEmpty();

    /** Check if container cannot accept more elements (capacity full) */
    boolean isFull();

    /** Remove all elements from container */
    void purge();

    /**
     * CORE VISITOR PATTERN: Accept a visitor to perform operations
     * 
     * MECHANICS:
     * Container iterates through all elements and calls visitor.visit(element)
     * If visitor.isDone() becomes true, container stops early
     * 
     * BENEFITS:
     * - Container doesn't care WHAT operation is being done
     * - New operations require new Visitor, NOT modifying Container
     * - Operations stay separate from data structure code
     */
    void accept(Visitor visitor);

    /**
     * ITERATOR PATTERN: Get safe traversal mechanism
     * 
     * Returns: Iterator object for this container
     * User iterates using hasNext() and next()
     * Safe: User never touches internal structure directly
     */
    Iterator iterator();
}
