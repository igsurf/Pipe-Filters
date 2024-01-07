class IntToStringFilter implements Filter<Integer, String> {
    @Override
    public void process(Pipe<Integer> in, Pipe<String> out) throws InterruptedException {
        while (true) {
            Integer number = in.take();
            String transformed = "Processed: " + number;
            out.put(transformed);
        }
    }
}