package cam.vanbonzen.education.threads.helpers;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class Consumer implements Runnable
{
    private Q q;

    /**
     * Constructor
     * @param q primitive Object of Type Q
     */
    public Consumer(Q q)
    {
        this.q = q;
        // Initialize and start new Thread
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    // region run() Method
    @Override
    public void run()
    {
        // Infinite loop
        while (true)
        {
            // Consuming q aka. printing the Number
            q.printNumber();
            try
            {
                // Consume every 5 seconds
                Thread.sleep(5000);
            }
            catch (Exception ignored) { } // ignoring all Exceptions for this Demo
        }
    }
    // endregion
}
