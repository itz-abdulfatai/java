package dsa;

/**
 * PRINTABLE EXAM CHEAT SHEET
 * ==========================
 * 
 * Print this page, keep in your pocket, read before exam
 * Size: One page only!
 * 
 * Contains: Absolute essentials only
 */

public class ExamCheatSheet {
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║          ITERATOR PATTERN QUICK REFERENCE                ║
    ╚═════════════════════════════════════════════════════════╝
    
    WHAT:     Safe traversal - user doesn't touch internal structure
    WHEN:     You need iteration control, filtering, special logic
    CODE:     Iterator it = container.iterator();
              while (it.hasNext()) {
                  Object item = it.next();
                  if (shouldDelete(item)) it.remove();
              }
    
    KEY METHODS:
    ✓ hasNext()    → true if another element exists
    ✓ next()       → get next element, advance position
    ✓ remove()     → delete last returned element (MUST call next() first!)
    
    GOTCHAS:
    ✗ calling remove() without next() first → CRASH!
    ✗ modifying container directly → corruption
    ✗ modifying while iterating (except via remove()) → broken
    
    ═════════════════════════════════════════════════════════════
    */
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║           VISITOR PATTERN QUICK REFERENCE                ║
    ╚═════════════════════════════════════════════════════════╝
    
    WHAT:     Add operations without modifying Container
    WHEN:     Same operation on many items, need state
    CODE:     class MyVisitor implements Visitor {
                  private int count = 0;  // ← instance var!
                  public void visit(Object obj) { count++; }
                  public boolean isDone() { return false; }
              }
              MyVisitor v = new MyVisitor();
              container.accept(v);
              result = v.getResult();
    
    KEY METHODS:
    ✓ visit(Object)    → called for each element
    ✓ isDone()         → return true to stop iteration
    
    PATTERN:
    ✓ Instance variables  → preserve state across visits
    ✗ Local variables     → reset each method call!
    ✓ Small methods       → keep visit() focused
    ✓ Extract result last → after container.accept() finishes
    
    OPTIMIZATION: Early Exit
      if (foundTarget(obj)) {
          result = obj;
          done = true;  // ← Container stops calling visit()
      }
    
    ═════════════════════════════════════════════════════════════
    */
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║         DECISION TREE: Which Pattern?                    ║
    ╚═════════════════════════════════════════════════════════╝
    
    Q1: Do you need CONTROL over iteration?
        (filter, skip, special stopping logic)
        
        YES → Use ITERATOR
        • "Print every 3rd element"
        • "Remove while iterating"
        • "Stop after 5 matches"
        • "Custom traversal order"
        
        NO → Go to Q2
    
    ─────────────────────────────────────────────────────────
    
    Q2: Same OPERATION on many items?
        (sum, count, find, transform)
        
        YES → Use VISITOR
        • "Sum all numbers"
        • "Count items"
        • "Find first match"
        • "Print all items"
        
        NO → Probably neither needed
    
    ─────────────────────────────────────────────────────────
    
    SPECIAL: Need to optimize (large data)?
        → Use isDone() in Visitor
        → Container stops early = massive speedup!
    
    ═════════════════════════════════════════════════════════════
    */
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║              CONTAINER PATTERN                           ║
    ╚═════════════════════════════════════════════════════════╝
    
    INTERFACE: Unified access to any data structure
    
    KEY METHODS:
    ✓ add(Object)              → add item
    ✓ getCount()               → how many items?
    ✓ isEmpty()                → no items?
    ✓ iterator()               → get traversal cursor
    ✓ accept(Visitor)          → let visitor process items
    ✓ purge()                  → remove all items
    
    DESIGN BENEFIT:
    • Change internal storage → code using Container stays same
    • Array → LinkedList → code works unchanged
    
    ═════════════════════════════════════════════════════════════
    */
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║              COMMON MISTAKES & FIXES                     ║
    ╚═════════════════════════════════════════════════════════╝
    
    MISTAKE 1: isDone() returns false always
    ❌ public boolean isDone() { return false; }
    ✓  private boolean found = false;
       public void visit(Object obj) { if (matches(obj)) found = true; }
       public boolean isDone() { return found; }
    
    MISTAKE 2: Local variable in visitor
    ❌ public void visit(Object obj) {
           int sum = 0;  // ← NEW each call!
           sum += obj;
       }
    ✓  private int sum = 0;  // ← INSTANCE var
       public void visit(Object obj) {
           sum += (Integer) obj;
       }
    
    MISTAKE 3: it.remove() without next()
    ❌ Iterator it = container.iterator();
       it.remove();  // ← No element positioned yet!
    ✓  Iterator it = container.iterator();
       if (it.hasNext()) {
           it.next();
           it.remove();
       }
    
    MISTAKE 4: Modifying container in loop
    ❌ while (it.hasNext()) {
           container.add(newItem);  // ← Dangerous!
       }
    ✓  while (it.hasNext()) {
           if (shouldDelete(it.next())) {
               it.remove();  // ← Only safe way
           }
       }
    
    MISTAKE 5: No instanceof check
    ❌ Integer num = (Integer) obj;  // ← Crash if not Integer!
    ✓  if (obj instanceof Integer) {
           Integer num = (Integer) obj;
       }
    
    ═════════════════════════════════════════════════════════════
    */
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║           CODE SNIPPETS TO REMEMBER                      ║
    ╚═════════════════════════════════════════════════════════╝
    
    SNIPPET 1: Basic Visitor Template
    ───────────────────────────────
    public class MyVisitor implements Visitor {
        private /* state */ result = /* init */;
        
        public void visit(Object object) {
            /* process object, update result */
        }
        
        public boolean isDone() {
            return /* should stop? */;
        }
        
        public /* ResultType */ getResult() {
            return result;
        }
    }
    
    SNIPPET 2: Using Visitor
    ────────────────────────
    MyVisitor v = new MyVisitor();
    container.accept(v);
    ResultType result = v.getResult();
    
    SNIPPET 3: Iterator with Filtering
    ──────────────────────────────────
    Iterator it = container.iterator();
    while (it.hasNext()) {
        Object item = it.next();
        if (passesFilter(item)) {
            process(item);
        }
    }
    
    SNIPPET 4: Safe Removal
    ──────────────────────
    Iterator it = container.iterator();
    while (it.hasNext()) {
        if (shouldRemove(it.next())) {
            it.remove();
        }
    }
    
    SNIPPET 5: Stateful Visitor
    ──────────────────────────
    public void visit(Object obj) {
        if (obj instanceof Number) {
            sum += ((Number) obj).longValue();
            count++;
        }
    }
    
    ═════════════════════════════════════════════════════════════
    */
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║              PERFORMANCE NOTES                           ║
    ╚═════════════════════════════════════════════════════════╝
    
    Early Exit Optimization:
    • Without isDone(): visits ALL 1,000,000 items = 1,000,000 ops
    • With isDone(): stops at item 50 = 50 ops
    • Speedup: 20,000x!
    
    Composite Visitor:
    • Three separate visitors: 3,000,000 ops
    • One composite: 1,000,000 ops
    • Speedup: 3x
    
    When does it matter?
    • Small data (100 items): Doesn't matter
    • Medium data (10,000 items): Might matter
    • Large data (1M+ items): HUGE difference!
    
    Think: "Will this run on big data?"
    → Yes? Then optimize with isDone() and composite
    → No? Simple approach fine
    
    ═════════════════════════════════════════════════════════════
    */
    
    /*
    ╔═════════════════════════════════════════════════════════╗
    ║              10-SECOND SUMMARY                           ║
    ╚═════════════════════════════════════════════════════════╝
    
    Iterator:    "I'll navigate" (YOU control loop)
    Visitor:     "You process" (Container calls your method)
    Container:   "I hold items and let you access them"
    
    When Iterator? Custom control needed
    When Visitor? Same op on many items
    
    KEY: isDone() stops iterations = OPTIMIZATION!
    
    ═════════════════════════════════════════════════════════════
    */
}
