package dsa;

/**
 * ITERATOR PATTERN - Basic definition
 * 
 * SIMPLE EXPLANATION:
 * An Iterator is like a "remote control" for traversing a collection.
 * Instead of exposing your internal structure (array, linked list, etc.),
 * you give users a safe "cursor" to move through elements one by one.
 * 
 * BENEFIT: Users don't need to know HOW your data is stored inside!
 * 
 * REAL-WORLD ANALOGY:
 * - Array: You give someone your whole address book (exposed!)
 * - Iterator: You give them a bookmark to read pages in order (safe!)
 *
 * WHY IT MATTERS:
 * If you change from Array → LinkedList internally, users' code still works!
 */
public interface Iterator {
    
    /**
     * TECHNICAL: Check if there are more elements to process
     * 
     * Returns: true if next element exists
     * Key point: Allows safe boundary checking
     */
    boolean hasNext();
    
    /**
     * TECHNICAL: Get the next element and advance cursor
     * 
     * Returns: The next object in sequence
     * Precondition: hasNext() should return true (user's responsibility)
     * Exception: NoSuchElementException if no next element
     */
    Object next();
    
    /**
     * TECHNICAL: Remove the last element returned by next()
     * 
     * Optional operation - not always implemented
     * Use case: Safe removal during iteration
     * Warning: Only works after calling next(), not standalone
     */
    void remove();
}
