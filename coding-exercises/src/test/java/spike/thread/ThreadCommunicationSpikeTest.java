package spike.thread;

import org.junit.Test;

public class ThreadCommunicationSpikeTest {

    @Test
    public void testGetCurrentTemplateConfig() throws Exception {
        final ThreadCommunicationSpike spike = new ThreadCommunicationSpike();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    spike.getCurrentTemplateConfig();
                }
                catch (RuntimeException e) {
                    System.out.println(String.format("RuntimeException: %s", e));
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.run();
        }
    }

}
