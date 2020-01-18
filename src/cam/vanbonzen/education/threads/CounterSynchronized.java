package cam.vanbonzen.education.threads;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class CounterSynchronized
{
    public int count;

    public synchronized void increment()
    {
        count++;
    }
}
