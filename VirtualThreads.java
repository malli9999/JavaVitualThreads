import java.lang.Thread;
import java.util.concurrent.Executors;

public class VirtualThreads {

    public static void main(String[] args) {
        System.out.println("This program is a demo for Virtual Threads in Java 21");

        /**
         * Thread thread = Thread.ofVirtual().unstarted(() -> {
         *             System.out.println("Virtual Thread started!");
         *         });
         *         thread.start();
         */

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                executor.submit(() -> {
                    System.out.println("Running in virtual thread: " + Thread.currentThread());
                });
            }
        }

    }


}
