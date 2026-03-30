package dsa;

/**
 * VISITOR PATTERN - Basic definition
 * 
 * SIMPLE EXPLANATION:
 * A Visitor is like a "worker" that performs operations on your data.
 * Instead of putting all operations INSIDE your data class,
 * you separate them into Visitor classes that "visit" each element.
 * 
 * BENEFIT: Easy to add new operations WITHOUT modifying data classes!
 * 
 * REAL-WORLD ANALOGY:
 * - No Visitor: Each hotel room must have cleaning, maintenance, security staff
 * - With Visitor: One contractor visits the room with different skills as needed
 * 
 * WHY IT MATTERS:
 * Want to add "print" operation? Create PrintVisitor.
 * Want to add "sum" operation? Create SumVisitor.
 * Hotel (data structure) never changes!
 * 
 * KEY PRINCIPLE: Let visitors come TO the data, not data going everywhere.
 */
public interface Visitor {
    
    /**
     * TECHNICAL: Process a single object
     * 
     * This method is called for EACH element in the container.
     * Implementation: Do whatever operation you need on this object.
     * 
     * Parameter: object - the current element being visited
     * Return: nothing - side effects happen (print, accumulate, transform, etc.)
     * 
     * PATTERN: Each element calls visitor.visit(this)
     * This is called the "double dispatch" technique
     */
    void visit(Object object);
    
    /**
     * TECHNICAL: Signal when to stop visiting
     * 
     * Returns: true when the visitor has completed its work
     * Used by containers to short-circuit iteration if needed
     * 
     * Example: "Search" visitor returns true when item is found
     * Result: Container stops iterating and returns early
     * 
     * Optimization: Instead of visiting all 1 million items,
     * stop at the 150th item when target is found!
     */
    boolean isDone();
}
