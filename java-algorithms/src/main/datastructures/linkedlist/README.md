# Linked List

A linked list is a linear collection of data elements, whose order is not given by their physical 
placement in memory. Instead, each element points to the next. It is a data structure consisting of a collection of nodes 
which together represent a sequence. In its most basic form, each node contains: data, and a reference (i.e. a link) 
to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any position in the
sequence during iteration. More complex variants add additional links, allowing more efficient insertion or removal of nodes
at arbitrary positions. A drawback of linked lists is that access time is linear (and difficult to pipeline). 
Faster access, such as random access, is not feasible. Arrays have better cache locality compared to linked lists.

![Singly-linked-list](https://camo.githubusercontent.com/37013b59008ed49a6701968da6b182eb6a9d24c8/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f362f36642f53696e676c792d6c696e6b65642d6c6973742e737667)

## Advantages
* Can be easily inserted or removed without reallocation or reorganization of the entire structure.
* Allow insertion and removal of nodes at any point in the list.
* Linked list are dynamic, so the length of list can increase or decrease as necessary.
* Each node does not necessarily be contiguous physically in the memory.

## Disadvantages
* Use more memory than arrays because of the storage used by their pointers.
* Nodes in a linked list must be read in order from the beginning as linked lists are inherently sequential access.
* Nodes are stored noncontiguously, greatly increasing the time periods required to access individual elements within the list, especially with a CPU cache.
* Difficult reverse traversing. For instance, singly-linked lists are cumbersome to navigate backward and while doubly linked lists are somewhat easier to read, memory is consumed in allocating space for a back-pointer.

## Complexities
|Search|Prepend/Poll|Append/Pop|Insert/Delete|Space|
|:----:|:----------:|:---------|:-----------:|:---:|
|O(n)|O(1)|O(1) with tail<br>O(n) without tail|Search time + o(1)|O(n)|

## References
[Wikipedia - Linked List](https://en.wikipedia.org/wiki/Linked_list)
