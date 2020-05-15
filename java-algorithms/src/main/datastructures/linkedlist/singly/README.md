# Singly Linked List
Singly linked list is a linked data structure that consists of a set of sequentially linked records called nodes.
Each node contains two fields: one link field (references to the next node in the sequence of nodes) and one data field.
The beginning and ending nodes' next link point to some kind of terminator, typically a sentinel node or null, 
to facilitate traversal of the list. One node link pointing to next node allows traversal of the list in one direction only.
Thus, keeping track of previous node is essential for deleting operation (unless node to delete is a first/last node).
Singly linked list can have either head node only or both head and tail nodes. 
In this example, singly linked list with both head and tail nodes is implemented.

![Singly-linked-list](https://camo.githubusercontent.com/37013b59008ed49a6701968da6b182eb6a9d24c8/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f362f36642f53696e676c792d6c696e6b65642d6c6973742e737667)

## Complexities
|Search|Prepend/Offer|Append/Pop|Insert/Delete|Traverse|Space|
|:----:|:-----------:|----------|:-----------:|:------:|:---:|
|O(n)|O(1)|O(1) with tail<br>O(n) without tail|Search time + O(1)|O(n<sup>2</sup>)|O(n)|

## References
[Wikipedia - Linked List](https://en.wikipedia.org/wiki/Linked_list)
