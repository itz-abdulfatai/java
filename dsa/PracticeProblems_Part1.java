package dsa;

/**
 * PHASE 3: PRACTICE PROBLEMS - Section 1
 * =======================================
 * 
 * BEFORE LOOKING AT SOLUTIONS:
 * 1. Read the problem
 * 2. Identify: Is this Iterator or Visitor?
 * 3. Write pseudocode
 * 4. Implement
 * 5. Test
 * 6. THEN check solution
 * 
 * ============= PROBLEM SET 1 =============
 * 
 * PROBLEM 1.1 (Easy - Iterator): Print Even Numbers
 * ---
 * Using the Iterator pattern, print only the EVEN numbers from container.
 * 
 * Input: Container with [1, 2, 3, 4, 5, 6, 7, 8]
 * Expected Output:
 *   2
 *   4
 *   6
 *   8
 * 
 * KEY CONCEPT: Iterator gives you control, so YOU decide what to print
 * 
 * ---
 * PROBLEM 1.2 (Easy - Visitor): Count Total Elements
 * ---
 * Create a visitor that counts total number of elements (should equal container.getCount())
 * 
 * Input: Container with [5, 10, 15, 20, 25]
 * Expected: Counter shown 5 elements
 * 
 * KEY CONCEPT: Visitor maintains state across multiple visits
 * 
 * ---
 * PROBLEM 1.3 (Medium - Visitor): Find First Negative Number
 * ---
 * Create a visitor that finds the FIRST negative number.
 * Uses early exit (isDone = true) for efficiency.
 * 
 * Input: Container with [5, -3, 10, -7, 20]
 * Expected: Returns -3 (not -7, because it's first)
 * 
 * KEY CONCEPT: isDone() can short-circuit the traversal
 * 
 * ---
 * PROBLEM 1.4 (Medium - Iterator + Logic): Collect Even Numbers
 * ---
 * Use iterator to collect even numbers into a separate new container
 * 
 * Input: Container A with [1, 2, 3, 4, 5, 6]
 * Expected: Container B with [2, 4, 6]
 * 
 * KEY CONCEPT: Combine iteration (read) with addition (write)
 * 
 * ---
 * PROBLEM 1.5 (Hard - Visitor with State): Remove Duplicates Count
 * ---
 * Create a visitor that counts how many UNIQUE elements exist
 * (Assumes NO duplicates in container for this version)
 * Use Set to track seen elements.
 * 
 * Input: Container with [1, 2, 3, 2, 1, 5] (with duplicates)
 * Expected: 4 unique elements (1, 2, 3, 5)
 * 
 * KEY CONCEPT: Visitor can use HashSet to track state across visits
 */

import java.util.HashSet;
import java.util.Set;

/**
 * ========== SOLUTION 1.1: Print Even Numbers ==========
 * 
 * APPROACH:
 * - Get iterator
 * - Loop while hasNext()
 * - Get each item
 * - Check if even (item % 2 == 0)
 * - Print if even
 * 
 * WHY ITERATOR?
 * - You control the loop (can skip items)
 * - You can print, modify, collect, etc.
 * 
 * TIME COMPLEXITY: O(n) where n = total items
 * SPACE COMPLEXITY: O(1) - no extra space
 */
public class PrintEvenNumbersSolution {
    public static void printEvenNumbers(Container container) {
        // STEP 1: Get the iterator (safe traversal mechanism)
        Iterator it = container.iterator();

        // STEP 2: Loop through all elements
        while (it.hasNext()) {
            // STEP 3: Get next element
            Object obj = it.next();

            // STEP 4: Check if even (type-safe)
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                if (num % 2 == 0) { // Even number
                    System.out.println(num);
                }
            }
        }
    }
}

// =================================================

/**
 * ========== SOLUTION 1.2: Count Total Elements ==========
 * 
 * Visitor that simply counts all visits
 * 
 * APPROACH:
 * - Maintain count variable
 * - Increment on each visit()
 * - Return count after container.accept()
 * 
 * WHY VISITOR?
 * - Container calls you for each item
 * - You accumulate state (count)
 * - Result is extracted after processing
 */
public class CountElementsVisitor implements Visitor {
    private int count = 0;

    @Override
    public void visit(Object object) {
        // Every visit = one element
        count++;
    }

    @Override
    public boolean isDone() {
        // Never stop early - count everything
        return false;
    }

    public int getCount() {
        return count;
    }

    // USAGE EXAMPLE:
    public static void main(String[] args) {
        ArrayContainer container = new ArrayContainer();
        container.add(1);
        container.add(2);
        container.add(3);

        CountElementsVisitor counter = new CountElementsVisitor();
        container.accept(counter);

        System.out.println("Total elements: " + counter.getCount());
        // Expected: 3
    }
}

// =================================================

/**
 * ========== SOLUTION 1.3: Find First Negative ==========
 * 
 * KEY TECHNIQUE: Early exit using isDone()
 * 
 * MECHANICS:
 * 1. Container visits first element
 * 2. Is it negative? If yes, set found=true and done=true
 * 3. Container checks isDone() → returns true
 * 4. Container STOPS iteration immediately!
 * 
 * EFFICIENCY GAIN:
 * - Without early exit: Check ALL N items
 * - With early exit: Check ~1 item (best case)
 * - Average: Check N/2 items
 * 
 * For a container with 1 MILLION items:
 * - Without optimization: 1,000,000 visits
 * - With optimization: ~5-20 visits (average)
 * = 1000x faster!
 */
public class FindFirstNegativeVisitor implements Visitor {
    private Integer found = null;
    private boolean done = false;

    @Override
    public void visit(Object object) {
        if (object instanceof Integer) {
            Integer num = (Integer) object;
            if (num < 0) {
                found = num;
                done = true; // Stop container from visiting more!
            }
        }
    }

    @Override
    public boolean isDone() {
        return done;
    }

    public Integer getFound() {
        return found;
    }
}

// =================================================

/**
 * ========== SOLUTION 1.4: Collect Even Numbers ==========
 * 
 * COMBINING PATTERNS:
 * - Use iterator to READ from source container
 * - Filter on the fly
 * - Add matching items to new container
 * 
 * WHY NOT USE VISITOR?
 * Could use visitor, but iterator is more natural here because:
 * - You're filtering (conditional logic in loop)
 * - You're writing to different container
 * - You have fine-grained control
 */
public class CollectEvenNumbers {
    public static Container collectEvenNumbers(Container source) {
        // Create new container for results
        ArrayContainer result = new ArrayContainer();

        // STEP 1: Get iterator from source
        Iterator it = source.iterator();

        // STEP 2: Iterate through source
        while (it.hasNext()) {
            Object obj = it.next();

            // STEP 3: Filter - only even numbers
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                if (num % 2 == 0) {
                    // STEP 4: Add to result container
                    result.add(num);
                }
            }
        }

        return result;
    }

    // TEST EXAMPLE:
    public static void main(String[] args) {
        ArrayContainer source = new ArrayContainer();
        for (int i = 1; i <= 6; i++) {
            source.add(i);
        }

        Container evenOnly = collectEvenNumbers(source);
        System.out.println("Original count: " + source.getCount());
        System.out.println("Even only count: " + evenOnly.getCount());
        // Expected: Original = 6, Even = 3 (contains 2, 4, 6)

        // Print the even numbers
        Iterator it = evenOnly.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

// =================================================

/**
 * ========== SOLUTION 1.5: Count Unique Elements ==========
 * 
 * ADVANCED VISITOR TECHNIQUE:
 * Visitor maintains a HashSet internally to track what we've seen
 * 
 * ALGORITHM:
 * 1. For each element visited:
 * - Check if already in set
 * - If not, add to set
 * 2. After all visits, return set size
 * 
 * TIME COMPLEXITY: O(n) - one visit per element
 * SPACE COMPLEXITY: O(u) - where u = unique count
 * 
 * EDGE CASES:
 * - Empty container → returns 0
 * - All duplicates → returns 1
 * - No duplicates → returns container.getCount()
 */
public class CountUniqueElementsVisitor implements Visitor {
    private Set<Object> uniqueElements = new HashSet<>();
    private boolean done = false;

    @Override
    public void visit(Object object) {
        // HashSet handles duplicates automatically
        // It only stores unique items
        if (object != null) {
            uniqueElements.add(object);
        }
    }

    @Override
    public boolean isDone() {
        return done; // Count everything
    }

    public int getUniqueCount() {
        return uniqueElements.size();
    }

    public Set<Object> getUniqueElements() {
        return uniqueElements;
    }

    // TEST EXAMPLE:
    public static void main(String[] args) {
        ArrayContainer container = new ArrayContainer();

        // Add with duplicates: [1, 2, 3, 2, 1, 5]
        Integer[] data = { 1, 2, 3, 2, 1, 5 };
        for (Integer num : data) {
            container.add(num);
        }

        CountUniqueElementsVisitor uniqueCounter = new CountUniqueElementsVisitor();
        container.accept(uniqueCounter);

        System.out.println("Total elements: " + container.getCount()); // 6
        System.out.println("Unique elements: " + uniqueCounter.getUniqueCount()); // 4
        System.out.println("Unique set: " + uniqueCounter.getUniqueElements()); // {1, 2, 3, 5}
    }
}
