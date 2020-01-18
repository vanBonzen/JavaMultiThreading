package cam.vanbonzen.education.threads.helpers;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class Counter
{
    public int count;

    // Method with Thread collision
    public void increment()
    {
        count++;
    }
}
