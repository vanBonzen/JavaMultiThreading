package cam.vanbonzen.education.threads;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class Q
{
    private int number;
    private boolean valueSet = false;

    synchronized void setNumber(int a)
    {
        while (valueSet)
        {
            try
            {
                // Waiting to get notified
                wait();
            } catch (Exception ignored) { }
        }
        this.number = a;
        System.out.println("Set: " + number);
        valueSet = true;
        // Notify Consumer Thread
        notify();
    }

    synchronized void printNumber()
    {
        while (!valueSet)
        {
            try
            {
                wait();
            } catch (Exception ignored) { }
        }
        System.out.println("Get: " + number);
        valueSet = false;
        // Notify Producer Thread
        notify();
    }
}
