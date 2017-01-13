package helloworld;

import java.util.HashSet;
import java.until.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public final class HelloWorldSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {
	private static final Set<String> supportedApplicationIds = new HashSet<String>();
	static {
		supportedApplicationIds.add("amzn1.echo-sdk-ams.app.[unique-value-here]")
	}

	public HelloWorldSpeechletRequestStreamHandler(){
		super(new HelloWorldSpeechlet(), supportedApplicationIds)
	}
}