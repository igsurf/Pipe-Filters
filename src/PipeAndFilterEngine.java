public class PipeAndFilterEngine {
    
    public static void main(String[] args) throws InterruptedException {
        Pipe<Integer> intPipe = new BlockingQueuePipe<>();
        Pipe<String> stringPipe = new BlockingQueuePipe<>();

        Filter<Integer, String> intToStringFilter = new IntToStringFilter();
        Filter<String, Void> printFilter = new PrintFilter();

        // Running filters in separate threads
        new Thread(() -> {
            try {
                intToStringFilter.process(intPipe, stringPipe);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                printFilter.process(stringPipe, null);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Feeding data to the first filter
        for (int i = 0; i < 10; i++) {
            intPipe.put(i);
            Thread.sleep(1000); // Simulating time delay for data generation
        }
    }
}
