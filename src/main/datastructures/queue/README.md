# Queue
Queue is a collection of entities that are maintained in a sequence with a behavior of FIFO (First In First Out).
By convention, the end of the sequence at which elements are added is called the back, tail, or rear of the queue,
and the end at which elements are removed is called the head or front of the queue, analogously to the words used
when people line up to wait for goods or services.

The operation of adding an element to the rear of the queue is known as enqueue,
and the operation of removing an element from the front is known as dequeue.
Other operations may also be allowed, often including a peek or front operation
that returns the value of the next element to be dequeued without dequeuing it.

![Queue](https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Data_Queue.svg/500px-Data_Queue.svg.png)

In a FIFO data structure, the first element added to the queue will be the first one to be removed.
This is equivalent to the requirement that once a new element is added, all elements that were added before
have to be removed before the new element can be removed.
A queue is an example of a linear data structure, or more abstractly a sequential collection.
Common implementations are circular buffers and linked lists.

In computer science, queues are used for a buffer. Another usage of queues is in the implementation of breadth-first search.

## Complexities
|Peek|Enqueue|Dequeue|Search|Space|
|----|:-----:|:-----:|:----:|:---:|
|O(1)|O(1)|O(1)|O(n)|O(n)|

## References
[Wikipedia - Queue](https://en.wikipedia.org/wiki/Queue_(abstract_data_type))
