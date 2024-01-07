import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public interface Pipe<T> {
    void put(T obj) throws InterruptedException;
    T take() throws InterruptedException;
}

class BlockingQueuePipe<T> implements Pipe<T> {
    private BlockingQueue<T> queue = new LinkedBlockingQueue<>();

    @Override
    public void put(T obj) throws InterruptedException {
        queue.put(obj);
    }

    @Override
    public T take() throws InterruptedException {
        return queue.take();
    }
}
