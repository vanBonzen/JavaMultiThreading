package cam.vanbonzen.education;

import cam.vanbonzen.education.threads.Counter;
import cam.vanbonzen.education.threads.CounterSynchronized;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class SynchronizedMultiThreading
{
    /**
     * Main Method
     *
     * @param args Default Program arguments
     */
    public static void main(String[] args) throws Exception
    {
        // region Not synchronized
        // Initialize new Counter Object
        Counter c = new Counter();

        // region Creating Threads for first Demo
        // First Thread inline
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 1; i <= 10000; i++)
                {
                    c.increment();
                }
            }
        });

        // Second Thread inline
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 1; i <= 10000; i++)
                {
                    c.increment();
                }
            }
        });
        // endregion

        // region Starting Threads
        t1.start();
        t2.start();
        // endregion

        // region Waiting for Threads to complete
        t1.join();
        t2.join();
        // endregion

        // Output should be 20000 but Threads collide
        System.out.println("Count: " + c.count);
        // endregion

        // region Synchronized
        CounterSynchronized c2 = new CounterSynchronized();

        // region Creating Threads for second Demo
        // Third Thread inline
        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 1; i <= 10000; i++)
                {
                    c2.increment();
                }
            }
        });

        // Forth Thread inline
        Thread t4 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 1; i <= 10000; i++)
                {
                    c2.increment();
                }
            }
        });
        // endregion

        // region Starting Threads
        t3.start();
        t4.start();
        // endregion

        // region Waiting for Threads to complete
        t3.join();
        t4.join();
        // endregion

        // Output now actually is 20000
        System.out.println("Count: " + c2.count);
        // endregion
    }
}
