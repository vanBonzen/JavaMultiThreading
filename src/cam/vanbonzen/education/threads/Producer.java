package cam.vanbonzen.education.threads;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class Producer implements Runnable
{
    private Q q;

    /**
     * Constructor
     * @param q primitive Object of Type Q
     */
    public Producer(Q q)
    {
        this.q = q;
        // Initialize and start new Thread
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    // region run() Method
    @Override
    public void run()
    {
        // Integer i to Cont upward
        int i = 0;

        // Infinite loop
        while (true)
        {
            // Producing the Number aka setting it
            q.setNumber(i++);
            try
            {
                // Produce every half second
                Thread.sleep(500);
            } catch (Exception ignored) { } // Ignoring all Exceptions for this Demo
        }
    }
    // endregion
}
