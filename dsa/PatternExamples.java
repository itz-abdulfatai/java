package dsa;

/**
 * PHASE 2: COMPLETE TUTORIAL WITH EXAMPLES
 * ==========================================
 * 
 * LEARNING OBJECTIVES:
 * 1. See both Iterator AND Visitor patterns in action
 * 2. Understand when to use each pattern
 * 3. See real coded examples that actually work
 * 4. Build intuition about code separation
 * 
 * DISCLAIMER:
 * This is EXAMPLE code. Don't memorize it!
 * Run it, understand the OUTPUT, then explain it to someone.
 */

public class PatternExamples {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("DESIGN PATTERNS TUTORIAL - Complete Examples");
        System.out.println("=".repeat(60) + "\n");
        
        // Create a container and add some numbers
        ArrayContainer container = new ArrayContainer();
        Integer[] numbers = {5, 12, 8, 20, 3, 15, 7, 30};
        
        System.out.println("STEP 1: Create container and add numbers");
        System.out.println("Numbers: " + java.util.Arrays.toString(numbers));
        
        for (Integer num : numbers) {
            container.add(num);
        }
        System.out.println("Count: " + container.getCount() + "\n");
        
        // ===================================================
        // EXAMPLE 1: Iterator Pattern - Manual traversal
        // ===================================================
        System.out.println("-".repeat(60));
        System.out.println("EXAMPLE 1: Iterator Pattern");
        System.out.println("Purpose: Traverse container WITHOUT knowing internal structure\n");
        
        System.out.println("Code:");
        System.out.println("  Iterator it = container.iterator();");
        System.out.println("  while (it.hasNext()) {");
        System.out.println("      System.out.println(it.next());");
        System.out.println("  }\n");
        
        System.out.println("Output (using Iterator):");
        Iterator it = container.iterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }
        System.out.println();
        
        // ===================================================
        // EXAMPLE 2: Visitor Pattern - PrintVisitor
        // ===================================================
        System.out.println("-".repeat(60));
        System.out.println("EXAMPLE 2: Visitor Pattern - Print All");
        System.out.println("Purpose: Add operation WITHOUT modifying Container\n");
        
        System.out.println("Code:");
        System.out.println("  container.accept(new PrintVisitor());\n");
        
        System.out.println("Output (using PrintVisitor):");
        container.accept(new PrintVisitor());
        System.out.println();
        
        // ===================================================
        // EXAMPLE 3: Visitor Pattern - Sum
        // ===================================================
        System.out.println("-".repeat(60));
        System.out.println("EXAMPLE 3: Visitor Pattern - Sum All");
        System.out.println("Purpose: Accumulate result across all visits\n");
        
        System.out.println("Code:");
        System.out.println("  SumVisitor sumVisitor = new SumVisitor();");
        System.out.println("  container.accept(sumVisitor);");
        System.out.println("  System.out.println(\"Sum: \" + sumVisitor.getSum());\n");
        
        SumVisitor sumVisitor = new SumVisitor();
        container.accept(sumVisitor);
        System.out.println("Result: Sum = " + sumVisitor.getSum());
        System.out.println();
        
        // ===================================================
        // EXAMPLE 4: Visitor Pattern - Search (Early Exit)
        // ===================================================
        System.out.println("-".repeat(60));
        System.out.println("EXAMPLE 4: Visitor Pattern - Search with Early Exit");
        System.out.println("Purpose: Stop early when condition is met (EFFICIENCY!)\n");
        
        System.out.println("Code:");
        System.out.println("  SearchVisitor searchVisitor = new SearchVisitor(20);");
        System.out.println("  container.accept(searchVisitor);");
        System.out.println("  if (searchVisitor.isFound()) {");
        System.out.println("      System.out.println(\"Found: \" + searchVisitor.getFound());");
        System.out.println("  }\n");
        
        SearchVisitor searchVisitor = new SearchVisitor(20);
        container.accept(searchVisitor);
        if (searchVisitor.isFound()) {
            System.out.println("Result: Found element: " + searchVisitor.getFound());
        } else {
            System.out.println("Result: Element not found");
        }
        System.out.println();
        
        // ===================================================
        // EXAMPLE 5: Visitor Pattern - Count with Criteria
        // ===================================================
        System.out.println("-".repeat(60));
        System.out.println("EXAMPLE 5: Visitor Pattern - Count Matching Criteria");
        System.out.println("Purpose: Custom logic for each visit\n");
        
        System.out.println("Code:");
        System.out.println("  CountVisitor.CountCriteria evenCriteria = obj -> {");
        System.out.println("      Integer num = (Integer) obj;");
        System.out.println("      return num % 2 == 0;  // Even numbers");
        System.out.println("  };");
        System.out.println("  CountVisitor counter = new CountVisitor(evenCriteria);");
        System.out.println("  container.accept(counter);\n");
        
        CountVisitor.CountCriteria evenCriteria = obj -> {
            Integer num = (Integer) obj;
            return num % 2 == 0; // Lambda: Is it even?
        };
        CountVisitor counter = new CountVisitor(evenCriteria);
        container.accept(counter);
        System.out.println("Result: Even numbers count = " + counter.getCount());
        System.out.println();
        
        // ===================================================
        // EXAMPLE 6: Find Maximum
        // ===================================================
        System.out.println("-".repeat(60));
        System.out.println("EXAMPLE 6: Visitor Pattern - Find Maximum");
        System.out.println("Purpose: Maintain state across visits\n");
        
        System.out.println("Code:");
        System.out.println("  FindMaxVisitor maxVisitor = new FindMaxVisitor();");
        System.out.println("  container.accept(maxVisitor);");
        System.out.println("  System.out.println(\"Max: \" + maxVisitor.getMax());\n");
        
        FindMaxVisitor maxVisitor = new FindMaxVisitor();
        container.accept(maxVisitor);
        System.out.println("Result: Maximum = " + maxVisitor.getMax());
        System.out.println();
        
        // ===================================================
        // KEY INSIGHTS
        // ===================================================
        System.out.println("=".repeat(60));
        System.out.println("KEY INSIGHTS - What Did We Learn?");
        System.out.println("=".repeat(60));
        System.out.println("""
            1. ITERATOR PATTERN:
               - Manual control flow (you decide when to stop)
               - Good for: Sequential access, filtering
               - Example: "Give me items 5 through 10"
               
            2. VISITOR PATTERN:
               - Container controls flow (calls visitor for each item)
               - Good for: Operations across ALL items, early exit optimization
               - Example: "Sum all items" or "Find first match"
               
            3. SEPARATION OF CONCERNS:
               - Container: "I hold items and let visitors come"
               - Iterator: "I let you traverse safely"
               - Visitor: "I do something with your items"
               - Each focuses on ONE job!
               
            4. OPEN/CLOSED PRINCIPLE:
               - Container is CLOSED for modification (don't change it)
               - Container is OPEN for extension (add new visitors)
               - Want to print? New visitor.
               - Want to search? New visitor.
               - Container never changes!
               
            5. EFFICIENCY:
               - Visitors can short-circuit (isDone())
               - Instead of visiting 1,000,000 items, stop at 50
               - Big performance difference on large datasets!
            """);
    }
}
