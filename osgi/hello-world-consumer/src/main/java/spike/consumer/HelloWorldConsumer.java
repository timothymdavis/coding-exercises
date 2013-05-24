package spike.consumer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import spike.provider.api.HelloWorldService;

/**
 * This is heavily influenced by Baptiste Wicht's http://www.baptiste-wicht.com/2010/07/osgi-hello-world-services/.
 */
public class HelloWorldConsumer implements ActionListener {

    private final HelloWorldService service;
    private final Timer timer;

    public HelloWorldConsumer(HelloWorldService service) {
        super();
        this.service = service;
        timer = new Timer(1000, this);
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        service.sayHello();
    }

}
