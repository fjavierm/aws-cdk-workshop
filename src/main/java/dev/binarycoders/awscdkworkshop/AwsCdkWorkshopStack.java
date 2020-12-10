package dev.binarycoders.awscdkworkshop;

import com.github.eladb.dynamotableviewer.TableViewer;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;

public class AwsCdkWorkshopStack extends Stack {
    public AwsCdkWorkshopStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public AwsCdkWorkshopStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        /*
        Used on the initial example, not necessary for a more real one

        final Queue queue = Queue.Builder.create(this, "AwsCdkWorkshopQueue")
                .visibilityTimeout(Duration.seconds(300))
                .build();
        final Topic topic = Topic.Builder.create(this, "AwsCdkWorkshopTopic")
            .displayName("My First Topic Yeah")
            .build();
        topic.addSubscription(new SqsSubscription(queue));
        */

        final Function hello = Function.Builder.create(this, "HelloHandler")
            .runtime(Runtime.NODEJS_12_X) // execution environment
            .code(Code.fromAsset("lambda")) // code loaded from the "lambda" directory
            .handler("hello.handler") // file is "hello", function is "handler"
            .build();

        // Defines our hitcounter resource
        final HitCounter helloWithCounter = new HitCounter(this, "HelloHitCounter", HitCounterProps.builder()
            .downstream(hello)
            .build());

        // Defines an API Gateway REST API resource backed by our "hello" function
        LambdaRestApi.Builder.create(this, "Endpoint")
            // .handler(hello) // Hello example (no counter)
            .handler(helloWithCounter.getHandler())
            .build();

        // Defines a viewer for the HitCounts table
//        TableViewer.Builder.create(this, "ViewerHitCount")
//            .title("Hello Hits")
//            .table(helloWithCounter.getTable())
//            .build();
    }
}
