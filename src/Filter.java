public interface Filter<I, O> {
    void process(Pipe<I> in, Pipe<O> out) throws InterruptedException;
}
