package dsa;

/**
 * VISITOR IMPLEMENTATIONS - Common Operations
 * ============================================
 * 
 * Each class below solves ONE specific problem.
 * Same container, different visitors = different operations!
 * Want a new operation? Create new Visitor. Done!
 * 
 * KEY PRINCIPLE: Add operations without touching ArrayContainer code!
 */

/**
 * ======= VISITOR 1: PRINT VISITOR =======
 * 
 * OPERATION: Print all elements
 * 
 * SIMPLE EXAMPLE:
 * Container has: [5, 10, 15, 20]
 * 
 * Traditional way:
 *   for (int i = 0; i < array.length; i++) {
 *       System.out.println(array[i]);
 *   }
 * 
 * Visitor way:
 *   container.accept(new PrintVisitor());
 * 
 * BENEFIT: Container code never changes.
 * Want to print with different format? New PrintVisitor variant!
 */
public class PrintVisitor implements Visitor {
    
    private boolean done = false;
    
    @Override
    public void visit(Object object) {
        // Simple: just print the object
        System.out.println(object);
    }
    
    @Override
    public boolean isDone() {
        // Never stop early - print everything
        return done;
    }
}

// ==================================================

/**
 * ======= VISITOR 2: SUM VISITOR =======
 * 
 * OPERATION: Sum all integers in container
 * 
 * TECHNICAL DETAIL:
 * Container holds Objects (could be anything)
 * This visitor only works with Numbers
 * It accumulates a sum as it visits
 * 
 * WHY IMPORTANT:
 * - Shows how visitors maintain state (sum)
 * - Shows type checking during visit
 * - Shows how to retrieve result after visit completes
 */
public class SumVisitor implements Visitor {
    
    private long sum = 0; // Accumulator
    private boolean done = false;
    
    @Override
    public void visit(Object object) {
        // Type check: only sum if it's a Number
        if (object instanceof Number) {
            Number num = (Number) object;
            sum += num.longValue();
        }
        // If not a number, skip it (ignore silently)
    }
    
    @Override
    public boolean isDone() {
        // Never stop early - need to sum ALL numbers
        return done;
    }
    
    /**
     * RETRIEVAL: After visitor completes, caller can get result
     * This is the "result extraction" pattern
     */
    public long getSum() {
        return sum;
    }
}

// ==================================================

/**
 * ======= VISITOR 3: SEARCH VISITOR =======
 * 
 * OPERATION: Find first element that matches criteria
 * 
 * KEY INSIGHT:
 * When target is found, set isDone() = true
 * This tells container to STOP visiting (efficiency!)
 * 
 * BENEFIT:
 * Instead of visiting all 1,000,000 items,
 * stop at item #42 when we find the target
 * 
 * TIME COMPLEXITY:
 * Worst case: O(n) - must check all items
 * Best case: O(1) - found immediately
 * Average: O(n/2) - found somewhere in middle
 */
public class SearchVisitor implements Visitor {
    
    private Object target; // What we're looking for
    private Object found = null; // What we found (if anything)
    private boolean done = false; // Stop when found
    
    public SearchVisitor(Object target) {
        this.target = target;
    }
    
    @Override
    public void visit(Object object) {
        // Check if this object matches our target
        if (object != null && object.equals(target)) {
            found = object;
            done = true; // Signal container to stop!
        }
    }
    
    @Override
    public boolean isDone() {
        return done;
    }
    
    public Object getFound() {
        return found;
    }
    
    public boolean isFound() {
        return found != null;
    }
}

// ==================================================

/**
 * ======= VISITOR 4: COUNT VISITOR =======
 * 
 * OPERATION: Count elements matching specific criteria
 * 
 * MORE ADVANCED: Takes an interface to define what "matches"
 * This allows ONE visitor to count many different things
 * 
 * PATTERN: Strategy pattern inside Visitor!
 */
public class CountVisitor implements Visitor {
    
    private int count = 0;
    private CountCriteria criteria;
    private boolean done = false;
    
    // Interface: How to judge if an item should be counted
    public interface CountCriteria {
        boolean matches(Object object);
    }
    
    public CountVisitor(CountCriteria criteria) {
        this.criteria = criteria;
    }
    
    @Override
    public void visit(Object object) {
        // Use criteria to decide if count this object
        if (criteria.matches(object)) {
            count++;
        }
    }
    
    @Override
    public boolean isDone() {
        return done; // Usually count everything
    }
    
    public int getCount() {
        return count;
    }
}

// ==================================================

/**
 * ======= VISITOR 5: FIND_MAX VISITOR =======
 * 
 * OPERATION: Find maximum value in container
 * 
 * REAL-WORLD USE:
 * - Find most expensive product
 * - Find longest name
 * - Find latest timestamp
 * 
 * TYPE HANDLING:
 * Works with any Comparable objects
 * Returns null if container is empty
 */
public class FindMaxVisitor implements Visitor {
    
    private Comparable max = null;
    private boolean done = false;
    
    @Override
    public void visit(Object object) {
        if (object instanceof Comparable) {
            Comparable comparable = (Comparable) object;
            
            // First element is always the max so far
            if (max == null) {
                max = comparable;
            } else {
                // Compare with current max
                // compareTo returns: negative if less, 0 if equal, positive if greater
                if (comparable.compareTo(max) > 0) {
                    max = comparable;
                }
            }
        }
    }
    
    @Override
    public boolean isDone() {
        return done; // Visit everything to find true maximum
    }
    
    public Comparable getMax() {
        return max;
    }
}
