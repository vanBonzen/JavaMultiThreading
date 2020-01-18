package cam.vanbonzen.education.threads;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class Producer implements Runnable
{
    private Q q;

    public Producer(Q q)
    {
        this.q = q;
        // Initialize and start new Thread
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    @Override
    public void run()
    {
        int i = 0;

        while (true)
        {
            // Producing the Number aka setting it
            q.setNumber(i++);
            try
            {
                // Produce every half second
                Thread.sleep(500);
            } catch (Exception ignored) { }
        }
    }
}
