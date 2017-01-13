package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class HelloWorldSpeechlet implements Speechlet {
	private static final Logger log = LoggerFactory.getLogger(HelloWorldSpeechlet.class);

	@Override
	public void onSessionStarted(final SessionStartedRequest request, final Session session) throws SpeechletException{
		log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
	}

	@Override
	public SpeechletResponse onLaunch(final LaunchRequest request, final Session session) throws SpeechletException{
		log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
		return getWelcomeResponse();
	}

	@Override
	public SpeechletResponse onIntent(final IntentRequest request, final Session session) throws SpeechletException{
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

		Intent intent = request.getIntent();
		String intentName = (intent != null) ? intent.getName() : null;

		if ("HelloWorldIntent".equals(intentName)){
			return getHelloResponse();
		} else if ("AMAZON.HelpIntent".equals(intentName)){
			return getHelpResponse();
		} else {
			throw new SpeechletException("Invalid Intent");
		}
	}

	@Override
	public void onSessionEnded(final SessionEndedRequest request, final Session session) throws SpeechletException {
		log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(), session.getSessionid());
	}

	private SpeechletResponse getWelcomeResponse(){
		String speechText = "Welcome to the Alexa Skills Kit, you can say hello";

		SimpleCard card - new SimpleCard();
		card.setTitle("HellowWorld");
		card.setContent(speechText);

		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.set(speechText);

		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(speech);

		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}

	private SpeechletResponse getHelloResponse(){
		String speechText = "Hello World";

		SimpleCard card = new SimpleCard();
		card.setTitle("HelloWorld");
		card.setContent(speechText);

		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		return SpeechletResponse.newTellTesponse(speech, card);
	}

	private SpeechletResponse getHelpResponse(){
		String speechText = "You can say 'Hello' to me";

		SimpleCard card = new SimpleCard();
		card.setTitle("HelloWorld")
		card.setContent(speechText)

		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(speech);

		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}

}