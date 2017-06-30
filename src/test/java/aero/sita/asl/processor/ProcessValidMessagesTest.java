package aero.sita.asl.processor;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class ProcessValidMessagesTest {
	private ProcessValidMessages processor;

	/**
	 * SetUp.
	 */
	@Before
	public void setUp() {
		processor = new ProcessValidMessages();
	}

	/**
	 * tear down resources
	 */
	@After
	public void tearDown() {
		processor = null;
	}

	/**
	 * Test to check the method buildValidMessages.
	 */
	@Test
	public void testBuildValidMessages() {
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("file_name", "valid.txt");
		headers.put("correlation_id", "1000rtcuuh");
		MessageHeaders messageHeaders = new MessageHeaders(headers);
		Message<?> message = MessageBuilder.createMessage("43\n76\n92", messageHeaders);
		Message<?> output = (Message<?>) processor.buildValidMessages(message);
		Assert.assertEquals("211", output.getPayload().toString());
		Assert.assertEquals("valid.txt", output.getHeaders().get("file_name"));
		Assert.assertEquals("1000rtcuuh", output.getHeaders().get("correlation_id"));
	}
}
