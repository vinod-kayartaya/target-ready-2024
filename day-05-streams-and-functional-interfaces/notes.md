### Functional interface

- an interface with exactly 1 abstract method (excludes equals/hashCode)
- sometimes @FuncationalInterface is also used


### Most common functional interface used along with streams

- java.util.function.Predicate
    - boolean test(T t)
    - can be used as a condition to be checked against values in the collection
    - `n -> n%2 == 0`
    - [12, 123, 49, 93, 29, 33, 50, 502]
    - [true, false, false, false, false, false, true, true]

    - ["vinod", "vinay", "ramesh", "vijay", "shyam"]
    - name -> name.startsWith("vi")
    - [true, true, false, true, false]
    
    - emp -> emp.getGender().equalsIgnoreCase("male")

- java.util.function.Consumer
    - void accept(T t)
    - num -> System.out.println(num*num)
    - num -> System.out.println(num)
    - System.out::println