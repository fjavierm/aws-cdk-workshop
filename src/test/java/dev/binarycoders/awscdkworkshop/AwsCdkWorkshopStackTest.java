package dev.binarycoders.awscdkworkshop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AwsCdkWorkshopStackTest {
    private final static ObjectMapper JSON =
        new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Test
    public void testStack() throws IOException {
        /*

        Used on the initial example, not necessary for a more real one
        App app = new App();
        AwsCdkWorkshopStack stack = new AwsCdkWorkshopStack(app, "test");

        JsonNode actual = JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate());

        assertThat(actual.toString())
            .contains("AWS::SQS::Queue")
            .contains("AWS::SNS::Topic");
         */
    }
}
