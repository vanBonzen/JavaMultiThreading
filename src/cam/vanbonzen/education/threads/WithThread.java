package cam.vanbonzen.education.threads;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class WithThread extends Thread
{
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("With Thread: " + i);
            try
            {
                Thread.sleep(1);
            }
            catch (Exception ignored) { }
        }
    }
}
