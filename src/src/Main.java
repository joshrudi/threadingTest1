public class Main {

    public static void main(String[] args) {

        ExampleThread process = new ExampleThread(10);
        process.start();

        try {
            Thread.sleep(7500);
        } catch (Exception e) {
            System.out.println("Error in Thread Sleep");
        }

        System.out.println("MainThread Complete");
        process.stopThread();
    }
}

class ExampleThread extends Thread {

    private int seconds;
    private volatile boolean active;

    ExampleThread(Integer... seconds) {

        this.seconds = seconds[0];
        active = true;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        super.run();
        startThread();
    }

    private void startThread() {

        for(int i = 0; i < seconds; i++) {

            if (!active) { System.out.println("Thread Stopped"); return; }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error in Thread Sleep");
            }

            System.out.println("Process " + i + " completed");
        }

        System.out.println("ExampleThread Complete");
    }

    public void stopThread() {

        active = false;
    }
}