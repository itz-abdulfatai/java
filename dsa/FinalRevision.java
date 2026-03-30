package dsa;

/**
 * FINAL REVISION SUMMARY - MASTER THIS FOR EXAMS
 * ===============================================
 * 
 * This is the CONDENSED version.
 * If you have 30 minutes before exam: READ THIS FILE ONLY
 * If you have time: Read this, then practice problems
 * If memorizing: Learn these 3 concepts
 * 
 * STATUS: Everything below is 100% on exam
 */

/**
 * ════════════════════════════════════════════════════════
 * CONCEPT 1: ITERATOR PATTERN (35% of exam likely)
 * ════════════════════════════════════════════════════════
 * 
 * ONE SENTENCE: "I give you a safe cursor to walk through my data"
 * 
 * WHAT IT DOES:
 * - Container provides Iterator
 * - You call hasNext() → is there another item?
 * - You call next() → give me next item and move cursor
 * - You call remove() → delete this item safely
 * 
 * WHY IMPORTANT:
 * - Encapsulation: User doesn't touch internal array
 * - Safety: Iterator knows about indexes, handles removal
 * - Abstraction: Works for array, linked list, tree, etc.
 * 
 * CODE TEMPLATE:
 * ─────────────
 *   Iterator it = container.iterator();
 *   while (it.hasNext()) {
 *       Object item = it.next();
 *       // Use item
 *       if (shouldDelete(item)) {
 *           it.remove();  // ← Safe removal!
 *       }
 *   }
 * 
 * WHEN TO USE:
 * ✓ Need control over loop
 * ✓ Filtering items conditionally
 * ✓ Custom iteration logic
 * ✗ When just applying same operation to all items
 */

/**
 * ════════════════════════════════════════════════════════
 * CONCEPT 2: VISITOR PATTERN (35% of exam likely)
 * ════════════════════════════════════════════════════════
 * 
 * ONE SENTENCE: "Here are my items, do your job on each one"
 * 
 * WHAT IT DOES:
 * - You implement Visitor with visit(Object)
 * - Container calls visit() for each item
 * - Visitor maintains state (sum, count, found, etc.)
 * - After container done, you get your result
 * 
 * WHY IMPORTANT:
 * - Easy to add new operations (new Visitor class)
 * - Container never changes (Open/Closed Principle)
 * - Can short-circuit with isDone() for efficiency
 * - One pass can do multiple operations
 * 
 * CODE TEMPLATE:
 * ─────────────
 *   class MyVisitor implements Visitor {
 *       private State state = init;
 *       
 *       public void visit(Object obj) {
 *           // Update state based on obj
 *           state = operation(state, obj);
 *       }
 *       
 *       public boolean isDone() {
 *           return condition(state);  // Stop early?
 *       }
 *       
 *       public State getResult() {
 *           return state;
 *       }
 *   }
 *   
 *   MyVisitor v = new MyVisitor();
 *   container.accept(v);
 *   Result result = v.getResult();
 * 
 * WHEN TO USE:
 * ✓ Same operation on many items
 * ✓ Accumulating result (sum, count, max)
 * ✓ Adding new operations without modifying container
 * ✓ Need efficiency (combine multiple operations in 1 pass)
 * ✗ When you need custom iteration logic
 */

/**
 * ════════════════════════════════════════════════════════
 * CONCEPT 3: CONTAINER & ABSTRACT CONTAINER (20% of exam)
 * ════════════════════════════════════════════════════════
 * 
 * CONTAINER INTERFACE:
 * ───────────────────
 * Define contract: what every container MUST do
 * - Store items: add(), getCount()
 * - Cleanup: purge(), isEmpty()
 * - Give traversal: iterator()
 * - Accept visitors: accept(Visitor)
 * 
 * ABSTRACT CONTAINER:
 * ──────────────────
 * Provide common implementation
 * - isEmpty() = getCount() == 0  ← reused by all subclasses
 * - isFull() = false  ← most containers never full
 * 
 * Each subclass implements its own:
 * - HOW to store (array vs linked list)
 * - HOW to iterate (ArrayIterator vs ListIterator)
 * - HOW to accept visitors (loop through storage)
 * - WHAT it does is the SAME
 * 
 * BENEFIT: DRY principle (Don't Repeat Yourself)
 * ───────────────────────────────────────────
 * - Write isEmpty() once
 * - All subclasses use it
 * - 100 subclasses = write 1 time, use 100 times
 */

/**
 * ════════════════════════════════════════════════════════
 * THE BIG PICTURE: WHEN TO USE WHAT
 * ════════════════════════════════════════════════════════
 * 
 * QUESTION 1: Do you need custom iteration?
 * ─────────────────────────────────────────
 * YES → Use Iterator
 * ├─ "Print every 3rd element"
 * ├─ "Collect even numbers into new container"
 * ├─ "Remove while iterating"
 * └─ "Stop after finding 5 matches"
 * 
 * NO → Continue to question 2
 * 
 * 
 * QUESTION 2: Same operation on all/many items?
 * ──────────────────────────────────────────────
 * YES → Use Visitor
 * ├─ "Sum all numbers"
 * ├─ "Print all items"
 * ├─ "Find first match"
 * └─ "Count items"
 * 
 * NO → Probably neither, or use Iterator
 * 
 * 
 * SPECIAL CASE: Need multiple operations?
 * ────────────────────────────────────────
 * Multiple loops: ❌ O(3n)
 *   container.accept(counterVis);   // O(n)
 *   container.accept(summerVis);    // O(n)
 *   container.accept(maxFinderVis); // O(n)
 *   Total: O(3n) on 1M items = 3M operations
 * 
 * Composite visitor: ✓ O(n)
 *   container.accept(compositeVis); // O(n)
 *   // Get count, sum, max from single pass
 *   Total: O(n) on 1M items = 1M operations
 *   = 3x FASTER!
 */

/**
 * ════════════════════════════════════════════════════════
 * EXAM STRATEGY: CRITICAL PATTERNS
 * ════════════════════════════════════════════════════════
 * 
 * PATTERN 1: Early Exit with isDone()
 * ───────────────────────────────────
 * Scenario: Find first element > 50 in container of 1M items
 * 
 * Naive (❌ slow):
 *   SearchVisitor v = new SearchVisitor(50);
 *   container.accept(v);  // Visits all 1M items!
 * 
 * Smart (✓ fast):
 *   public void visit(Object obj) {
 *       if (matches(obj)) {
 *           found = obj;
 *           done = true;  // ← KEY LINE
 *       }
 *   }
 *   
 *   public boolean isDone() {
 *       return done;  // Container stops visiting!
 *   }
 *   // Now visits only ~2 items!
 * 
 * 10,000x FASTER!
 * 
 * ON EXAM: If they ask "optimize this", think isDone()
 * 
 * 
 * PATTERN 2: Safe Iterator Removal
 * ────────────────────────────────
 * Scenario: Remove all even numbers
 * 
 * Common mistake (❌ BROKEN):
 *   for (int i = 0; i < container.getCount(); i++) {
 *       if (isEven(container.get(i))) {
 *           container.remove(i);  // Breaks indexing!
 *           i--;  // Hacky, fragile
 *       }
 *   }
 * 
 * Correct way (✓ ROBUST):
 *   Iterator it = container.iterator();
 *   while (it.hasNext()) {
 *       if (isEven(it.next())) {
 *           it.remove();  // Iterator handles index management
 *       }
 *   }
 * 
 * ON EXAM: If they ask "remove during iteration", use it.remove()
 * 
 * 
 * PATTERN 3: Stateful Visitor (Accumulation)
 * ──────────────────────────────────────────
 * Scenario: Calculate sum of all numbers
 * 
 * Wrong pattern (❌ Each visit is isolated):
 *   public void visit(Object obj) {
 *       long sum = 0;  // ← NEW variable each call!
 *       sum += (Long) obj;
 *       store[0] = sum;  // Hack to persist
 *   }
 * 
 * Correct pattern (✓ State persists):
 *   private long sum = 0;  // ← INSTANCE variable
 *   
 *   public void visit(Object obj) {
 *       sum += (Long) obj;  // ← Accumulates across calls
 *   }
 * 
 * ON EXAM: If visitor needs to "remember", use instance variables
 */

/**
 * ════════════════════════════════════════════════════════
 * TESTING YOUR KNOWLEDGE: Quick Checks
 * ════════════════════════════════════════════════════════
 * 
 * Q1: What does hasNext() return?
 * A: true if there's an element to retrieve, false otherwise
 * 
 * Q2: When must you call next() before remove()?
 * A: Always! Container doesn't know what to remove without positioning
 * 
 * Q3: What triggers isDone() to stop iteration?
 * A: When isDone() returns true, container stops calling visit()
 * 
 * Q4: Can visitor methods be called on empty container?
 * A: Yes, they'll just do nothing (zero visits)
 * 
 * Q5: Can one visitor do multiple things?
 * A: Yes! Maintain multiple instance variables (composite pattern)
 * 
 * Q6: Is container affected by visitor state?
 * A: No! Visitor has its own state, container just hosts it
 * 
 * Q7: What if all elements are the same type?
 * A: Still use instanceof (defensive programming)
 * 
 * Q8: Can iterator traverse backwards?
 * A: Standard iterator doesn't - design would need backward-specific iterator
 * 
 * Q9: Performance: O(n) or O(1) for finding first element?
 * A: O(n) worst case, O(1) best case, average depends on position
 * 
 * Q10: Should container know what visitors do?
 * A: NO! That's the whole point - separation of concerns
 */

/**
 * ════════════════════════════════════════════════════════
 * YOUR 60-SECOND CHEAT SHEET (If you really have 60 sec!)
 * ════════════════════════════════════════════════════════
 * 
 * Iterator:
 *   hasNext() → any more?
 *   next() → get next
 *   remove() → delete current
 * 
 * Visitor:
 *   visit(obj) → process this
 *   isDone() → shall we stop?
 * 
 * When:
 *   Custom control? → Iterator
 *   Same operation? → Visitor
 *   Optimize search? → isDone() = true when found
 *   Safe removal? → it.remove()
 * 
 * Remember:
 *   Container closed, extended by visitors
 *   Iterator controls flow, Visitor doesn't
 *   State in instance variables, not local
 * 
 * Performance:
 *   Multiple visitors = O(kn) where k = number of operations
 *   Composite visitor = O(n) regardless of k
 *   Early exit = massive speedup for large datasets
 */

public class FinalRevision {
    // This entire file is your exam cheat sheet
    // Print it, read it before exam, got this! 💪
}
