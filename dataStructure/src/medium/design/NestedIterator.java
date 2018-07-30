package medium.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private int current = 0;
    private List<Integer> flat = new ArrayList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            List<Integer> content = new ArrayList<>();
            flat(nestedList.get(i), content);
            flat.addAll(content);
        }
        if (flat.size() == 0) {
            current = Integer.MAX_VALUE;
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        int result = flat.get(current);
        current++;
        return result;
    }

    @Override
    public boolean hasNext() {
        return current < flat.size();
    }

    private void flat(NestedInteger origin, List<Integer> list) {
        if (origin.isInteger()) {
            list.add(origin.getInteger());
            return;
        }
        for (int i = 0; i < origin.getList().size(); i++) {
            flat(origin.getList().get(i), list);
        }
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
