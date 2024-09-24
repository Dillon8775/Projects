package mathgame;

public class Option<T> {
    private T value;

    public Option(T value) {
        this.value = value;
    }

    public T get() {
       return this.value;
    }

    public void set(T value) {
        this.value = value;
    }
}