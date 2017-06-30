package aero.sita.asl.processor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class ProcessedFileNameGeneratorTest {
	
private FilesGenerator generator;
	
	/**
	 * Setup the required resources.
	 */
	@Before
	public void setUp(){
		generator = new FilesGenerator();
	}
	
	/**
	 * Tidying up resources
	 */
	@After
	public void tearDown(){
		generator = null;
	}
	
	/**
	 * Test to verify the file name after the generator process.
	 */
	@Test
	public void testProcessedFile(){
		Message<?> message = MessageBuilder.withPayload("test messages").setHeader("file_name", "valid.txt").build();	
		generator.setFileExtension("PROCESSED");
		String generatedFileName = generator.generateFileName(message);
		Assert.assertEquals("The generated file name is .processed ", "valid.PROCESSED", generatedFileName);
	}
	
	/**
	 * Test to verify the file name after the generator process.
	 */
	@Test
	public void testOutputFile(){
		Message<?> message = MessageBuilder.withPayload("test messages").setHeader("file_name", "valid.txt").build();	
		generator.setFileExtension("OUTPUT");
		String generatedFileName = generator.generateFileName(message);
		Assert.assertEquals("The generated file name is .output ", "valid.OUTPUT", generatedFileName);
	}
}
