package com.github.lcguerrerocovo;

// stack implementation using linkedlists

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Stack {

    private List<Integer> stack = new LinkedList<Integer>();

    public void push(Integer n) {
        stack.add(0,n);
    }

    public Integer pop() {
        if(!stack.isEmpty()) {
            return stack.remove(0);
        } return null;
    }

    public Integer min() {
        if(!stack.isEmpty()) {
            Integer[] array = stack.toArray(new Integer[stack.size()]);
            Arrays.sort(array);
            return array[0];
        } else return null;
    }

    public String toString() {
        return Arrays.deepToString(stack.toArray());
    }

}
