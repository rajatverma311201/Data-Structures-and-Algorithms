package utils;

public class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
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
        if (!(obj.getClass() == this.getClass())) {
            return false;
        }
        Pair<T, U> p = (Pair<T, U>) obj;
        return p.first == this.first && p.second == this.second;
    }

}
