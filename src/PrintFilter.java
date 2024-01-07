class PrintFilter implements Filter<String, Void> {
    @Override
    public void process(Pipe<String> in, Pipe<Void> out) throws InterruptedException {
        while (true) {
            String data = in.take();
            System.out.println(data);
        }
    }
}