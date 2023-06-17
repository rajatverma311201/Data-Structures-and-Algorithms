package utils;

public class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T x, U y) {
        this.first = x;
        this.second = y;
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair<T, U> p = (Pair<T, U>) obj;
        return p.first == this.first && p.second == this.second;
    }

}
