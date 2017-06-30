package aero.sita.asl.processor;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * Prepare content for the output message and build message with new content.
 * 
 * @author praveen.khare
 *
 */
public class ProcessValidMessages {

    /**
     * Method to process the input payload and generate the result. 
     * Will send new payload to the output channel.
     * 
     * @param message , not null.
     * @return Object , never null.
     */
    public Object buildValidMessages(Message<?> message) {
        String content = getPayloadData(message.getPayload().toString());
        Message<String> output = MessageBuilder.withPayload(content).copyHeaders(message.getHeaders()).build();
        return output;
    }

    /**
     * Read the content from the input. Will sum each line and add to result.
     * 
     * @param payload , not null.
     * @return the sum of the lines, never null.
     */
    private String getPayloadData(String payload) {
        long sum = 0;
        String[] lines = payload.split("\n");
        for (String line : lines) {
            sum = sum + Long.valueOf(line.trim());
        }
        return String.valueOf(sum);
    }
}
