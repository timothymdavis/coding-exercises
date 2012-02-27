package spike;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelDslSplitterTest extends CamelSpringTestSupport
{
    @EndpointInject(uri = "mock:error")
    protected MockEndpoint errorEndpoint;

    @EndpointInject(uri = "mock:success")
    protected MockEndpoint successEndpoint;

    @Produce(uri = "direct:route1")
    protected ProducerTemplate template;

    @Override
    protected AbstractXmlApplicationContext createApplicationContext()
    {
        return new ClassPathXmlApplicationContext("camel-dsl-context.xml");
    }

    @Test
    public void ensureOnlyOneErrorOccurs() throws Exception
    {
        errorEndpoint.expectedMessageCount(1);
        successEndpoint.expectedMessageCount(0);

        template.sendBody("<Root><SomeElement/><SomeElement/><SomeElement/></Root>");

        errorEndpoint.assertIsSatisfied();
        successEndpoint.assertIsSatisfied();
    }
}
