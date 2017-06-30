package aero.sita.asl.processor;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ExecutorSubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;


public class CustomRouterTest {

	private static CustomRouter router;
	
	@BeforeClass
	public static void  setUp() {
		router = new CustomRouter();
	}
	
	@AfterClass
	public static  void destroy() {
		router = null;
	}
	
	/**
	 * Test with valid message payload.
	 * This with return two channels(output and processed).
	 */
	@Test
	public void testValidContent() {
		
		Message<String> msg = MessageBuilder.withPayload("43\n78\n22").build();
		MessageChannel outputChannel = new ExecutorSubscribableChannel();
		MessageChannel processedChannel = new ExecutorSubscribableChannel();
		router.setOutputChannel(outputChannel);
		router.setProcessedChannel(processedChannel);
		Collection<MessageChannel> targetChannels = router.determineTargetChannels(msg);
		Assert.assertEquals("Valid input with two target channels.", 2, targetChannels.size());
	}
	
	/**
	 * Test with invalid message payload.
	 * This with return only one channel(problem).
	 */
	@Test
	public void testInvalidContent() {
		
		Message<String> msg = MessageBuilder.withPayload("asdf").build();
		MessageChannel problemChannel = new ExecutorSubscribableChannel();
		router.setProblemChannel(problemChannel);
		Collection<MessageChannel> targetChannels = router.determineTargetChannels(msg);
		Assert.assertEquals("Invalid input with one problem target channels.", 1, targetChannels.size());
	}

}
