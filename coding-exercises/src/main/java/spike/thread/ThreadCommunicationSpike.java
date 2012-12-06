package spike.thread;

public class ThreadCommunicationSpike {

    private boolean first = true;
    private boolean notified = false;

    public void getCurrentTemplateConfig() {
        System.out.println("entering...");

        if (!notified) {
            synchronized (this) {
                if (first) {
                    first = false;
                }
                else {
                    while (!notified) {
                        try {
                            wait();
                        }
                        catch (InterruptedException e) {
                            System.out.println(String.format("UNEXPECTED: %s", e));
                        }
                    }
                }
                notified = false;
            }
        }

        System.out.println("getting...");

        mockExternalServiceCall();

        synchronized (this) {
            notified = true;
            notify();
        }
    }

    private void mockExternalServiceCall() {
        throw new RuntimeException("Explosion!");
    }

}
