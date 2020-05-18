# Stack
Stack is a data structure that has a behavior of LIFO (Last In First Out), with two principal operations:

* **Push**, which adds an element to the end of collection, and
* **Pop**, which removes the most recently added element.

The name "stack" for this data structure comes from the analogy to a set of physical items stacked on top of each other.
This structure makes it easy to take an item off the top of the stack, while getting to an item deeper in the stack
may require taking off multiple other items first.

Push and pop operations occur only at the top of the stack.
Stack can be implemented using singly linked list with a pointer to the top element.
Stack may be implemented to have a bounded capacity. If the stack is full and does not contain enough space 
to accept an entity to be pushed, the stack is then considered to be in an overflow state.
A stack is needed to implement depth-first search.

![Stack](https://upload.wikimedia.org/wikipedia/commons/b/b4/Lifo_stack.png)

## References
[Wikipedia - Stack](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))
