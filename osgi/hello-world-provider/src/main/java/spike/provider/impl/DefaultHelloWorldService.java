package spike.provider.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spike.provider.api.HelloWorldService;

/**
 * This is heavily influenced by Baptiste Wicht's http://www.baptiste-wicht.com/2010/07/osgi-hello-world-services/.
 */
public class DefaultHelloWorldService implements HelloWorldService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void sayHello() {
        logger.info("Hello World!");
    }

}
