package cam.vanbonzen.education.threads;

import cam.vanbonzen.education.threads.helpers.WithRunnable;
import cam.vanbonzen.education.threads.helpers.WithThread;

/**
 * Multithreading Demo by Marcel Neuheiser @ Provadis GmbH
 *              for education purpose only
 */
public class MultiThreading
{
    /**
     * Main Method
     *
     * @param args Default Program arguments
     */
    public static void main(String[] args)
    {
        // region Starting new Threads using the Thread Class
        Thread withThread = new WithThread();
        // endregion

        // region Starting new Threads using the Runnable Interface
        WithRunnable t3 = new WithRunnable();
        Thread withRunnable = new Thread(t3);
        // endregion

        // region Starting new Threads using Lambda Expressions
        Runnable t5 = () ->
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println("With Lambda: " + i);
                try
                {
                    Thread.sleep(1);
                }
                catch (Exception ignored) { } // Ignoring all Exceptions for this Demo
            }
        };

        Thread withLambda = new Thread(t5);
        // endregion

        // region Starting all Threads
        withThread.start();
        withRunnable.start();
        withLambda.start();
        // endregion

        // region Wait until Threads have executed
        System.out.println("I am not waiting!");
        // Checking if Thread is running ATM
        System.out.println("Is withThread alive? " + withThread.isAlive());
        try
        {
            withThread.join();
            withRunnable.join();
            withLambda.join();
        }
        catch (InterruptedException ignored) { } // Ignoring all Exceptions for this Demo

        // Rechecking if Thread is running after join()
        System.out.println("Is withThread alive? " + withThread.isAlive());
        System.out.println("All Threads done executing!");
        // endregion

        // region Setting / getting the Name of a Thread
        WithRunnable t6 = new WithRunnable();
        // Assign with Creation
        Thread withRunnableAndName = new Thread(t6, "Runnable with Name");
        // Assign with Method
        withRunnableAndName.setName("Runnable with Name");
        System.out.println("Name of Thread: " + withRunnableAndName.getName());
        // endregion

        // region Setting / getting the Priority of a Thread
        Thread lambdaWithPriority = new Thread(withLambda);
        // Priority 1
        lambdaWithPriority.setPriority(Thread.MIN_PRIORITY);
        // Priority 5
        lambdaWithPriority.setPriority(Thread.NORM_PRIORITY);
        // Priority 10
        lambdaWithPriority.setPriority(Thread.MAX_PRIORITY);
        // Range [1, 2, ... , 10]
        lambdaWithPriority.setPriority(10);
        System.out.println("Priority: " + lambdaWithPriority.getPriority());
        // endregion
    }
}
