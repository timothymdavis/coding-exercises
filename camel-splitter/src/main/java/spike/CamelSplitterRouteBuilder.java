package spike;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.ERROR;
import static org.apache.camel.LoggingLevel.INFO;

@Component
public class CamelSplitterRouteBuilder extends RouteBuilder
{
    @Override
    public void configure() throws Exception
    {
        onException(Exception.class).handled(true)
            .log(ERROR, "An unexpected exception has occurred")
            .to("mock:error");

        from(endpoint("direct:route1"))
            .split(xpath("//SomeElement")).stopOnException()
                .log(INFO, "Splitting!")
                .throwException(new RuntimeException())
            .end()
            .log(INFO, "Successfully Finished!")
            .to("mock:success");
    }
}
