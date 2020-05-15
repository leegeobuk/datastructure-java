# Doubly Linked List
Doubly linked list is a linked data structure that consists of a set of sequentially linked records called nodes.
Each node contains three fields: two link fields (references to the previous and to the next node in the sequence of nodes) 
and one data field. The beginning and ending nodes' previous and next links, respectively, point to some kind of terminator,
typically a sentinel node or null, to facilitate traversal of the list. If there is only one sentinel node,
then the list is circularly linked via the sentinel node. It can be conceptualized as two singly linked lists
formed from the same data items, but in opposite sequential orders.

![doubly linked list image](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Doubly-linked-list.svg/1000px-Doubly-linked-list.svg.png)

The two node links allow traversal of the list in either direction. While adding or removing a node in a doubly linked list
requires changing more links than the same operations on a singly linked list, the operations are simpler
and potentially more efficient (for nodes other than first nodes) because there is no need to keep track of 
the previous node during traversal or no need to traverse the list to find the previous node, so that its link can be modified.

## Complexities
|Search|Prepend/Poll|Append/Pop|Insert/Delete|Space|
|:----:|:----------:|:---------|:-----------:|:---:|
|O(n)|O(1)|O(1) with tail<br>O(n) without tail|Search time + O(1)|O(n)|

## References
[Wikipedia - Doubly linked list](https://en.wikipedia.org/wiki/Doubly_linked_list)
