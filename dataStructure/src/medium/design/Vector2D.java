package medium.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> vec2d;
    private int currentFirst;
    private int currentSecond;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = new ArrayList<>();
        for (List<Integer> item : vec2d) {
            if (item != null && item.size() > 0) {
                this.vec2d.add(item);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            if (currentSecond == vec2d.get(currentFirst).size()) {//溢出该行
                currentSecond = 0;
                currentFirst++;
                return next();
            } else {
                int result = vec2d.get(currentFirst).get(currentSecond);
                currentSecond++;
                return result;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasNext() {
        if (vec2d.size() == 0) {
            return false;
        }
        if (currentFirst < vec2d.size()) {
            if (currentFirst < vec2d.size() - 1) {
                return true;
            } else {
                if (currentSecond < vec2d.get(currentFirst).size()) {
                    return true;
                }
            }
        }
        return false;
    }
}
