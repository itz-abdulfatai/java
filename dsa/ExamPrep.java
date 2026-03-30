package dsa;

/**
 * PHASE 5: EXAM PREPARATION & REVISION GUIDE
 * ===========================================
 * 
 * TIME-OPTIMIZED SUMMARY FOR EXAM PRESSURE
 * 
 * This file contains:
 * ✓ Quick concept review
 * ✓ Decision trees (which pattern to use?)
 * ✓ Common mistakes you'll make on exam
 * ✓ Code snippets you MUST know
 * ✓ Edge cases and gotchas
 */

/**
 * ============ PART 1: QUICK CONCEPTS ============
 * 
 * ITERATOR PATTERN (Easy)
 * ─────────────────────
 * What: Safe traversal without knowing internal structure
 * When: YOU control iteration, do custom logic per element
 * Methods:
 *   - hasNext() → does another element exist?
 *   - next() → get next element
 *   - remove() → delete current element
 * 
 * Remember: You're like a driver; you decide where to go
 * 
 * VISITOR PATTERN (Medium)
 * ──────────────────────
 * What: Add operations without modifying data structure
 * When: SAME operation applied to ALL (or many) elements
 * Methods:
 *   - visit(Object) → process this element
 *   - isDone() → should we stop early?
 * 
 * Remember: Container is the host; visitors are guests
 * Guests do work; host just provides access
 * 
 * CONTAINER (Holds it all together)
 * ─────────────────────────────────
 * What: Data structure that accepts visitors and provides iterators
 * Methods:
 *   - accept(Visitor) → let the worker in
 *   - iterator() → give me a traversal handle
 *   - add(), getCount(), isEmpty(), purge()
 * 
 * Remember: Container is AGNOSTIC to operations
 * Doesn't care if you're printing, summing, searching, etc.
 */

/**
 * ============ PART 2: DECISION TREE ============
 * 
 * WHEN TO USE ITERATOR:
 * ┌─ Need to control iteration flow?
 * │  ├─ YES → Use Iterator
 * │  │  ├─ Example: Print every 3rd element
 * │  │  ├─ Example: Remove while iterating
 * │  │  ├─ Example: Stop on a condition
 * │  │
 * │  └─ NO → Consider Visitor
 * │
 * └─ Transform data into new structure?
 *    ├─ YES → Iterator (read, filter, write)
 *    └─ NO → Could be Visitor
 * 
 * WHEN TO USE VISITOR:
 * ┌─ Same operation on many elements?
 * │  ├─ YES → Use Visitor
 * │  │  ├─ Example: Sum all
 * │  │  ├─ Example: Print all
 * │  │  ├─ Example: Find first match
 * │  │
 * │  └─ NO → Use Iterator
 * │
 * └─ Want to add new operation without modifying container?
 *    ├─ YES → Visitor (Open/Closed Principle!)
 *    └─ NO → Either works, but Visitor is better design
 * 
 * QUICK CHEAT:
 * - Loop control? → Iterator
 * - Same job on all items? → Visitor
 * - Efficiency critical? → Visitor with isDone()
 * - Unsure? → Visitor is more powerful (can do iterator's job too)
 */

/**
 * ============ PART 3: CODE SNIPPETS ============
 * 
 * SNIPPET 1: Basic Iterator Usage
 * ─────────────────────────────
 * Iterator it = container.iterator();
 * while (it.hasNext()) {
 *     Object item = it.next();
 *     // Do something with item
 * }
 * 
 * SNIPPET 2: Safe Removal During Iteration
 * ─────────────────────────────────────────
 * Iterator it = container.iterator();
 * while (it.hasNext()) {
 *     Object item = it.next();
 *     if (shouldRemove(item)) {
 *         it.remove();  // ← NOT container.remove()!
 *     }
 * }
 * 
 * SNIPPET 3: Create Basic Visitor
 * ───────────────────────────────
 * public class MyVisitor implements Visitor {
 *     private SomeState state = initial;
 *     
 *     public void visit(Object obj) {
 *         // Update state
 *     }
 *     
 *     public boolean isDone() {
 *         return stateCondition;
 *     }
 *     
 *     public ResultType getResult() {
 *         return state;
 *     }
 * }
 * 
 * SNIPPET 4: Use Visitor
 * ─────────────────────
 * MyVisitor visitor = new MyVisitor();
 * container.accept(visitor);
 * ResultType result = visitor.getResult();
 * 
 * SNIPPET 5: Early Exit (Key Optimization!)
 * ─────────────────────────────────────────
 * public void visit(Object obj) {
 *     if (foundTarget(obj)) {
 *         result = obj;
 *         done = true;  // ← STOP!
 *     }
 * }
 * 
 * Effect: Container will stop calling visit() immediately!
 */

/**
 * ============ PART 4: COMMON MISTAKES ============
 * 
 * MISTAKE 1: Calling iterator() but not using it
 * ──────────────────────────────────────────────
 * ❌ WRONG:
 *    Iterator it = container.iterator();
 *    container.accept(new SomeVisitor());  // Ignores iterator!
 * 
 * ✓ RIGHT:
 *    Iterator it = container.iterator();
 *    while (it.hasNext()) {
 *        Object item = it.next();
 *        // Use item
 *    }
 * 
 * 
 * MISTAKE 2: Calling it.remove() without next()
 * ──────────────────────────────────────────────
 * ❌ WRONG:
 *    Iterator it = container.iterator();
 *    it.remove();  // BOOM! No element to remove yet!
 * 
 * ✓ RIGHT:
 *    Iterator it = container.iterator();
 *    it.next();     // First call next() to position
 *    it.remove();   // Then remove the returned element
 * 
 * 
 * MISTAKE 3: Visitor that forgets isDone()
 * ────────────────────────────────────────
 * ❌ WRONG:
 *    public boolean isDone() {
 *        return false;  // Always returns false
 *    }
 *    // This visitor visits EVERYTHING even after finding target!
 * 
 * ✓ RIGHT:
 *    private boolean found = false;
 *    
 *    public void visit(Object obj) {
 *        if (matches(obj)) {
 *            result = obj;
 *            found = true;
 *        }
 *    }
 *    
 *    public boolean isDone() {
 *        return found;  // Returns true after finding!
 *    }
 * 
 * 
 * MISTAKE 4: Type casting without checking
 * ────────────────────────────────────────
 * ❌ WRONG:
 *    Integer num = (Integer) object;  // CRASH if not Integer!
 * 
 * ✓ RIGHT:
 *    if (object instanceof Integer) {
 *        Integer num = (Integer) object;
 *        // Safe now
 *    }
 * 
 * 
 * MISTAKE 5: Modifying container during iterator loop
 * ───────────────────────────────────────────────────
 * ❌ WRONG:
 *    while (it.hasNext()) {
 *        Object item = it.next();
 *        container.add(newItem);  // DANGEROUS!
 *        container.purge();       // EVEN WORSE!
 *    }
 * 
 * ✓ RIGHT:
 *    while (it.hasNext()) {
 *        Object item = it.next();
 *        if (deleteThis(item)) {
 *            it.remove();  // Only safe removal method
 *        }
 *    }
 * 
 * 
 * MISTAKE 6: Visitor that doesn't accumulate state
 * ────────────────────────────────────────────────
 * ❌ WRONG:
 *    public void visit(Object obj) {
 *        int local_sum = 0;  // New variable each call!
 *        local_sum += (Integer) obj;
 *    }
 *    // Result: sum is always last element only!
 * 
 * ✓ RIGHT:
 *    private long sum = 0;  // Instance variable!
 *    
 *    public void visit(Object obj) {
 *        sum += (Integer) obj;  // Updates persists
 *    }
 */

/**
 * ============ PART 5: EDGE CASES ============
 * 
 * EDGE CASE 1: Empty Container
 * ─────────────────────────────
 * Iterator it = container.iterator();
 * System.out.println(it.hasNext());  // false
 * // next() call would throw exception
 * 
 * HANDLING:
 * - Always check hasNext() before calling next()
 * - Visitor automatically handles (visits nothing)
 * 
 * 
 * EDGE CASE 2: Single Element
 * ────────────────────────────
 * Iterator it = container.iterator();
 * if (it.hasNext()) {
 *     Object only = it.next();
 *     System.out.println(onlyIsNow.hasNext());  // false
 * }
 * 
 * 
 * EDGE CASE 3: Visitor finds nothing
 * ──────────────────────────────────
 * SearchVisitor sv = new SearchVisitor(999);
 * container.accept(sv);
 * if (!sv.isFound()) {
 *     System.out.println("Not in container");
 * }
 * 
 * 
 * EDGE CASE 4: Null elements
 * ──────────────────────────
 * container.add(null);
 * Iterator it = container.iterator();
 * Object item = it.next();  // Could be null!
 * 
 * HANDLING:
 * if (item == null) { /* handle null */
}***EDGE CASE 5:Container with mixed types*───────────────────────────────────────*container.add(5);*container.add("hello");*container.add(3.14);**Visitor visit order:Integer,String,Double*Must handle each type or use instanceof checks*/

/**
 * ============ PART 6: PERFORMANCE TIPS ============
 * 
 * OPTIMIZATION 1: Early Exit with isDone()
 * ─────────────────────────────────────────
 * Container size: 1,000,000
 * 
 * Without isDone():
 *   Visits all 1,000,000 items
 *   Time: O(n)
 * 
 * With isDone() (found at item 500):
 *   Stops after 500 visits
 *   Time: O(1) comparatively! ~0.05% of work
 * 
 * HUGE difference on large data!
 * 
 * 
 * OPTIMIZATION 2: CompositeVisitor
 * ────────────────────────────────
 * Need sum, count, max, min?
 * 
 * Wrong (3 passes):
 *   container.accept(sumVisitor);      // O(n)
 *   container.accept(countVisitor);    // O(n)
 *   container.accept(maxVisitor);      // O(n)
 *   Total: O(3n)
 * 
 * Right (1 pass):
 *   container.accept(compositeVisitor);  // O(n)
 *   Total: O(n)
 * 
 * For large n: 3x faster!
 * 
 * 
 * OPTIMIZATION 3: Iterator vs Visitor
 * ───────────────────────────────────
 * Simple loop with conditions? Use Iterator
 * You control flow → Can exit early, skip items, etc.
 * 
 * Same operation repeated? Use Visitor
 * Container controls flow → More efficient
 */

/**
 * ============ PART 7: QUICK EXAM PREP ============
 * 
 * THINGS YOU MUST KNOW:
 * 
 * 1. Iterator Contract:
 * boolean hasNext();
 * Object next();
 * void remove();
 * 
 * 2. Visitor Contract:
 * void visit(Object);
 * boolean isDone();
 * 
 * 3. Container Methods:
 * void accept(Visitor)
 * Iterator iterator()
 * int getCount()
 * void add(Object)
 * void purge()
 * 
 * 4. When Iterator? When Visitor?
 * → If you need control: Iterator
 * → If same job on many: Visitor
 * 
 * 5. Early Exit Pattern:
 * → In visitor: set done=true in isDone()
 * → Container checks isDone() after each visit
 * → If true, stops iteration
 * → HUGE optimization!
 * 
 * 6. Safe Removal:
 * → Only use it.remove()
 * → Never modify container in loop
 * → Always call next() before remove()
 * 
 * 7. Type Checking:
 * → Always use instanceof before casting
 * → Never assume type of objects
 * → Container can hold mixed types!
 * 
 * 8. State Accumulation:
 * → Instance variables = persist across visits
 * → Local variables = reset each method call
 * → Use instance vars for Visitor state!
 * 
 * 9. Open/Closed Principle:
 * → Add operations (new Visitors)
 * → Don't modify Container/Iterator
 * → Container closed for modification
 * → Open for extension (new Visitors)
 * 
 * 10. Performance Mindset:
 * → Normal approach often O(n)
 * → With isDone(): can be O(1) to O(n/2)
 * → Think big: 1M+ items?
 * → Then performance matters!
 * 
 * ====================================
 * 
 * IF YOU ONLY REMEMBER THREE THINGS:
 * 
 * 1. Iterator = "I'll navigate myself"
 * 2. Visitor = "Come process my items"
 * 3. Early exit with isDone() = "STOP after you find what you need"
 * 
 * You'll pass!
 * ====================================
 */

public class ExamPrep {
    // Stub class - this entire file is documentation
}
