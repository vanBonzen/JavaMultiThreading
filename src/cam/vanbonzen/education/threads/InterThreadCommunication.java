package cam.vanbonzen.education.threads;

import cam.vanbonzen.education.threads.helpers.Consumer;
import cam.vanbonzen.education.threads.helpers.Producer;
import cam.vanbonzen.education.threads.helpers.Q;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class InterThreadCommunication
{
    public static void main(String[] args)
    {
        // Initialize Object Q
        Q q = new Q();

        // Creating new Producer and Consumer and passing them Q
        new Producer(q);
        new Consumer(q);
    }
}
