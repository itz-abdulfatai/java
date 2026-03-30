package dsa;

/**
 * PHASE 4: ADVANCED PRACTICE PROBLEMS
 * ===================================
 * 
 * DIFFICULTY: Medium to Hard
 * 
 * These problems combine multiple concepts and require deeper thinking
 * about when to use Iterator vs Visitor vs combinations.
 * 
 * ============= PROBLEM SET 2 =============
 * 
 * PROBLEM 2.1 (Medium): Average of All Numbers
 * ---
 * Use a visitor to calculate the average of all numbers in container
 * 
 * Input: Container with [10, 20, 30, 40, 50]
 * Expected: Average = 30.0
 * 
 * HINT: Maintain both sum and count, then divide
 * 
 * ---
 * PROBLEM 2.2 (Medium): First Element That Passes Test
 * ---
 * Create a visitor that finds first element matching a condition
 * Example: First number > 15
 * 
 * Input: Container with [5, 10, 20, 15, 25]
 * Expected: Returns 20 (first one > 15)
 * 
 * TECHNIQUE: Use early exit for efficiency
 * 
 * ---
 * PROBLEM 2.3 (Medium-Hard): Transform All Elements
 * ---
 * Iterator approach: Read old container, transform, write to new one
 * Example: Double all numbers
 * 
 * Input: Container with [1, 2, 3, 4, 5]
 * Expected New Container: [2, 4, 6, 8, 10]
 * 
 * ---
 * PROBLEM 2.4 (Hard): Composite Visitor - Multiple Operations
 * ---
 * Create ONE visitor that does THREE things simultaneously:
 * - Count elements
 * - Sum all numbers  
 * - Find maximum
 * 
 * Instead of visiting 3 times, visit ONCE!
 * 
 * Input: Container with [5, 10, 15, 20]
 * Expected: count=4, sum=50, max=20
 * 
 * OPTIMIZATION: Single pass O(n) instead of O(3n)
 * 
 * ---
 * PROBLEM 2.5 (Hard): Remove While Iterating
 * ---
 * Use iterator.remove() to delete even numbers during iteration
 * DANGEROUS: Many solutions break because list changes during iteration
 * 
 * Input: Container with [1, 2, 3, 4, 5, 6]
 * Expected After: Container with [1, 3, 5]
 * 
 * WHY IT'S HARD:
 * - Must use iterator.remove(), not custom loops
 * - Index management gets tricky
 * - Position must be adjusted after removal
 */

/**
 * ========== SOLUTION 2.1: Average Calculator ==========
 * 
 * APPROACH:
 * - Track both sum and count during visits
 * - Handle non-numeric objects gracefully
 * - Divide sum by count after iteration
 * 
 * EDGE CASES:
 * - Empty container → getAverage() returns 0 (or NaN)
 * - Non-numeric elements → skip them
 * - No numeric elements → getAverage() returns 0
 */
public class AverageVisitor implements Visitor {
    private long sum = 0;
    private int count = 0; // Only count numeric items
    private boolean done = false;
    
    @Override
    public void visit(Object object) {
        if (object instanceof Number) {
            Number num = (Number) object;
            sum += num.longValue();
            count++;
        }
    }
    
    @Override
    public boolean isDone() {
        return done;
    }
    
    public double getAverage() {
        if (count == 0) {
            return 0.0; // No numeric elements
        }
        return (double) sum / count;
    }
}

// ===================================================

/**
 * ========== SOLUTION 2.2: First Match Visitor ==========
 * 
 * TECHNIQUE: Encapsulate the matching logic
 * Create interface for "what does matching mean?"
 * 
 * WHY THIS DESIGN?
 * One visitor class can find:
 * - First number > 10
 * - First string with length > 5
 * - First object that's not null
 * - Anything you can write as an expression!
 * 
 * FLEXIBILITY: Define criteria when creating visitor
 */
public class FirstMatchVisitor implements Visitor {
    
    // Interface: How to decide if object matches
    public interface Matcher {
        boolean matches(Object obj);
    }
    
    private Matcher matcher;
    private Object found = null;
    private boolean done = false;
    
    public FirstMatchVisitor(Matcher matcher) {
        this.matcher = matcher;
    }
    
    @Override
    public void visit(Object object) {
        // If already found something, don't visit anymore
        if (done) {
            return;
        }
        
        // Check if this object matches criteria
        if (matcher.matches(object)) {
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
    
    // USAGE EXAMPLE:
    public static void main(String[] args) {
        ArrayContainer container = new ArrayContainer();
        for (int i = 5; i <= 25; i += 5) {
            container.add(i);
        }
        
        // Find first number > 15
        FirstMatchVisitor.Matcher matcher = obj -> {
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                return num > 15;
            }
            return false;
        };
        
        FirstMatchVisitor visitor = new FirstMatchVisitor(matcher);
        container.accept(visitor);
        
        if (visitor.isFound()) {
            System.out.println("First match: " + visitor.getFound());
            // Expected: 20
        }
    }
}

// ===================================================

/**
 * ========== SOLUTION 2.3: Transform Using Iterator ==========
 * 
 * PATTERN: Iterator for smart transformation
 * 
 * STEPS:
 * 1. Get iterator from source
 * 2. For each element (using hasNext/next)
 * 3. Transform the element
 * 4. Add to new container
 * 5. Return new container
 * 
 * WHY ITERATOR HERE?
 * - You're doing if/filtering/conditional logic
 * - Natural control flow within loop
 * - Easy to see input → output transformation
 */
public class DoubleAllNumbers {
    public static Container doubleAll(Container source) {
        ArrayContainer result = new ArrayContainer();
        
        Iterator it = source.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                // TRANSFORMATION: Multiply by 2
                result.add(num * 2);
            }
        }
        
        return result;
    }
}

// ===================================================

/**
 * ========== SOLUTION 2.4: Composite Visitor ==========
 * 
 * ADVANCED: Do MULTIPLE jobs in ONE visitor pass
 * 
 * BENEFIT:
 * - Visit container once: iterate 5 items
 * - Get 3 results simultaneously
 * - Instead of: iterate 5, iterate 5, iterate 5 = 15 visits
 * 
 * PERFORMANCE:
 * - Traditional: O(3n) - three separate visits
 * - Composite: O(n) - single pass
 * - For large n, makes HUGE difference
 * 
 * WHEN TO USE:
 * - Need multiple stats from same data
 * - Performance is critical (large datasets)
 * - All operations use same traversal
 */
public class CompositeStatsVisitor implements Visitor {
    
    // Three different statistics maintained simultaneously
    private int count = 0;
    private long sum = 0;
    private Comparable max = null;
    private boolean done = false;
    
    @Override
    public void visit(Object object) {
        // OPERATION 1: Count
        count++;
        
        // OPERATION 2: Sum (only numbers)
        if (object instanceof Number) {
            Number num = (Number) object;
            sum += num.longValue();
        }
        
        // OPERATION 3: Find max (only comparables)
        if (object instanceof Comparable) {
            Comparable comparable = (Comparable) object;
            if (max == null || comparable.compareTo(max) > 0) {
                max = comparable;
            }
        }
    }
    
    @Override
    public boolean isDone() {
        return done;
    }
    
    // GETTERS for all three results
    public int getCount() { return count; }
    public long getSum() { return sum; }
    public Comparable getMax() { return max; }
    
    public void printStats() {
        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
    }
}

// ===================================================

/**
 * ========== SOLUTION 2.5: Remove While Iterating ==========
 * 
 * CRITICAL TECHNIQUE: Safe removal using iterator.remove()
 * 
 * WHY TRICKY?
 * If you modify container while iterating:
 * - Indices shift
 * - You might skip elements
 * - You might get duplicates
 * - Classic bug in coding interviews!
 * 
 * SOLUTION: Use iterator.remove()
 * - Iterator knows about internal structure
 * - It handles index management
 * - Contracts: call next() first, then remove()
 * 
 * PATTERN:
 *   while (hasNext()) {
 *       if (shouldDelete(next())) {
 *           remove();  // ← Must use iterator's remove
 *       }
 *   }
 */
public class RemoveEvenNumbers {
    public static void removeAllEven(Container container) {
        Iterator it = container.iterator();
        
        while (it.hasNext()) {
            Object obj = it.next();
            
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                
                if (num % 2 == 0) {  // If even
                    it.remove();      // Safe removal!
                }
            }
        }
    }
    
    // TEST EXAMPLE:
    public static void main(String[] args) {
        ArrayContainer container = new ArrayContainer();
        for (int i = 1; i <= 6; i++) {
            container.add(i);
        }
        
        System.out.println("Before: " + container.getCount() + " elements");
        
        removeAllEven(container);
        
        System.out.println("After: " + container.getCount() + " elements");
        // Expected: Before = 6, After = 3
        
        // Print remaining (should be 1, 3, 5)
        Iterator it = container.iterator();
        System.out.println("Remaining:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
