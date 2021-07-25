package com.caffeaulait.nowcoder;

public class nowcoder_24 {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label){
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return null;
        RandomListNode curr = pHead;
        while (curr != null){
            RandomListNode clone = new RandomListNode(curr.label);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        curr = pHead;
        while (curr!=null){
            curr.next.random = curr.random==null?null:curr.random.next;
            curr = curr.next.next;
        }

        curr = pHead;
        RandomListNode cloneHead = pHead.next;
        while (curr!=null){
            RandomListNode clone = curr.next;
            curr.next = clone.next;
            clone.next = clone.next==null?null:clone.next.next;
            curr = curr.next;
        }
        return cloneHead;
    }
}
