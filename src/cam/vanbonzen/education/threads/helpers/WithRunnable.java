package cam.vanbonzen.education.threads.helpers;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class WithRunnable implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("With Runnable: " + i);
            try
            {
                Thread.sleep(1);
            }
            catch (Exception ignored) { } // Ignoring all Exceptions for this Demo
        }
    }
}
