# DESIGN PATTERNS - VISUAL SUMMARY

## 1️⃣ ITERATOR PATTERN - Flow Diagram

```
┌─────────────────────────────────────────────────────┐
│  User wants to traverse container                    │
└─────────────────────┬───────────────────────────────┘
                      │
                      ▼
              get iterator()
                      │
                      ▼
         ┌────────────────────────────┐
         │   Iterator Interface       │
         │  ├─ hasNext(): boolean     │
         │  ├─ next(): Object         │
         │  └─ remove(): void         │
         └────────────┬───────────────┘
                      │
                      ▼
         ┌────────────────────────────┐
         │   while (hasNext())        │
         │   {                        │
         │     obj = next()           │
         │     // process obj         │
         │     if (delete!) remove()  │
         │   }                        │
         └────────────┬───────────────┘
                      │
                      ▼
              Traversal complete
```

**KEY POINT:** User has full control over iteration flow

---

## 2️⃣ VISITOR PATTERN - Flow Diagram

```
┌─────────────────────────────────────────────────────┐
│  User creates Visitor with specific operation        │
└─────────────────┬───────────────────────────────────┘
                  │
                  ▼
         ┌───────────────────────────────┐
         │   class MyVisitor             │
         │   (implements Visitor)        │
         │                               │
         │ ┌─────────────────────────┐   │
         │ │ visit(obj) {            │   │
         │ │   accumulate or check   │   │
         │ │   update state          │   │
         │ │ }                       │   │
         │ │                         │   │
         │ │ isDone() {              │   │
         │ │   return found;         │   │
         │ │ }                       │   │
         │ └─────────────────────────┘   │
         └───────────┬───────────────────┘
                     │
                     ▼
       container.accept(visitor)
                     │
         ┌───────────┴──────────────┐
         │                          │
         │ For each element:        │
         │ ├─ call visit(elem)      │
         │ ├─ call isDone()         │
         │ └─ if isDone()? STOP     │
         │                          │
         └───────────┬──────────────┘
                     │
                     ▼
           visitor.getResult()
                     │
                     ▼
              Result ready!
```

**KEY POINT:** Container controls iteration, visitor does work

---

## 3️⃣ CLASS HIERARCHY

```
Container Interface
│
├─ accept(Visitor v)      ← For visitor pattern
├─ iterator()             ← For iterator pattern
├─ add(Object)
├─ getCount()
└─ purge()
│
│
AbstractContainer (implements Container)
│
├─ int count              ← Shared by all subclasses
├─ isEmpty() {            ← Implemented once, used by all
│   return count == 0;
│ }
└─ isFull() {             ← Implemented once, used by all
    return false;
  }
│
│
ArrayContainer (extends AbstractContainer)
│
├─ Object[] items         ← How we store
├─ ArrayIterator iterator()
├─ void accept(Visitor v) {
│   for (int i = 0; i < count; i++) {
│     v.visit(items[i]);
│     if (v.isDone()) break;
│   }
│ }
└─ Internal class ArrayIterator
   ├─ hasNext()
   ├─ next()
   └─ remove()
```

---

## 4️⃣ VISITOR IMPLEMENTATIONS

```
Visitor Interface
├─ visit(Object)
└─ isDone()

Implementations:
├─ PrintVisitor
│  └─ Prints each element
│
├─ SumVisitor
│  ├─ Accumulates sum
│  └─ Returns sum
│
├─ SearchVisitor
│  ├─ Stops on match (isDone = true)
│  └─ Returns found element
│
├─ CountVisitor
│  ├─ Counts matching items
│  └─ Returns count
│
└─ FindMaxVisitor
   ├─ Tracks maximum seen
   └─ Returns maximum
```

---

## 5️⃣ DECISION TREE

```
                    START
                     │
                     ▼
        Need iteration control?
        (filtering, conditions, etc.)
        ╱                       ╲
       YES                      NO
       │                        │
       ▼                        ▼
    Use Iterator        Same operation
                        on many items?
                        ╱              ╲
                      YES              NO
                       │               │
                       ▼               ▼
                   Use Visitor    Probably neither
                                  (or use Iterator)

    AFTER CHOOSING VISITOR:
    Large dataset?
    (1M+ items)
           │
      ┌────┴────┐
      YES       NO
      │         │
      ▼         ▼
    Add    Normal
  isDone() approach ok
    for
   early
   exit!
```

---

## 6️⃣ PERFORMANCE COMPARISON

### Scenario: Sum, Count, Max from same container

**Approach 1: Multiple Visitors (3 passes)**

```
Container size: 1,000,000 items

Pass 1: container.accept(sumVisitor)      → 1M operations
Pass 2: container.accept(countVisitor)    → 1M operations
Pass 3: container.accept(maxVisitor)      → 1M operations
                                            ─────────────
Total:                                      3M operations
```

**Approach 2: Composite Visitor (1 pass)**

```
Container size: 1,000,000 items

Pass 1: container.accept(compositeVisitor) {
          // update sum
          // update count
          // update max
        }                                  → 1M operations
                                            ─────────────
Total:                                      1M operations
```

**Speedup: 3x faster** ⚡

---

## 7️⃣ EARLY EXIT OPTIMIZATION

### Scenario: Find first number > 1000 in 1,000,000 numbers

**Without isDone() (finds at position 50)**

```
Container size: 1,000,000 items
Target: First item > 1000
Found at: Item #50

Loop:
visit(1)    → no match
visit(2)    → no match
visit(3)    → no match
...
visit(49)   → no match
visit(50)   → MATCH! isDone() returns true
visit(51)   ← NOT CALLED (stopped!)
visit(52)   ← NOT CALLED
...
visit(1M)   ← NOT CALLED

Actual operations: ~50
Expected (without optimization): 1,000,000
Speedup: 20,000x! 🚀
```

---

## 8️⃣ CORE PRINCIPLE: SEPARATION OF CONCERNS

```
┌──────────────────────────────────────────────┐
│  Container: "I hold items safely"            │
│  Job: Store, manage, provide access          │
│  Doesn't care: What operations happen        │
└──────────────────────────────────────────────┘

┌──────────────────────────────────────────────┐
│  Iterator: "I let you traverse safely"       │
│  Job: Provide cursor for manual navigation   │
│  Doesn't care: What you do with items        │
└──────────────────────────────────────────────┘

┌──────────────────────────────────────────────┐
│  Visitor: "I process items one by one"       │
│  Job: Apply operation to each item           │
│  Doesn't care: How container stores items    │
└──────────────────────────────────────────────┘

Each class has ONE responsibility ✓
Code is clean, testable, maintainable ✓
Easy to add new operations ✓
```

---

## 9️⃣ WHEN TO USE EACH PATTERN

| Pattern    | When                      | Example                  | Code Complexity |
| ---------- | ------------------------- | ------------------------ | --------------- |
| Iterator   | Need manual control       | For loop with conditions | Low             |
| Visitor    | Same operation many times | Sum all items            | Medium          |
| Composite  | Multiple operations       | Sum + Count + Max        | Medium          |
| Early Exit | Large dataset + search    | Find first match         | Medium          |

---

## 🔟 COMMON BUGS VS FIXES

| Bug                     | Problem            | Fix                            |
| ----------------------- | ------------------ | ------------------------------ |
| isDone() always false   | Visits everything  | Return true when condition met |
| Local var in visitor    | State resets       | Use instance variables         |
| it.remove() no next()   | Undefined behavior | Always call next() first       |
| Modify during iteration | Index corruption   | Use only it.remove()           |
| No type checking        | ClassCastException | Always use instanceof          |

---

## KEY TAKEAWAYS

✅ **Iterator** = User controls iteration flow
✅ **Visitor** = Container controls iteration flow  
✅ **Container** = Unified interface for any storage
✅ **Early Exit** = Massive optimization for searches
✅ **Composite** = Multiple operations in one pass
✅ **Separation** = Each class does one thing well

Master these → Ace the exam! 🎓
