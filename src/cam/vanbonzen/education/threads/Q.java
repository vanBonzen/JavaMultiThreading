package cam.vanbonzen.education.threads;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class Q
{
    // Integer Value witch can be set / printed
    private int number;
    // Boolean to lock / unlock access to Number
    private boolean valueSet = false;

    /**
     * Setting the number Attribute
     * @param a Integer with new Value of number
     */
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

    /**
     * Print Value of number Attribute
     */
    synchronized void printNumber()
    {
        while (!valueSet)
        {
            try
            {
                // Waiting to get notified
                wait();
            } catch (Exception ignored) { }
        }
        System.out.println("Get: " + number);
        valueSet = false;
        // Notify Producer Thread
        notify();
    }
}
