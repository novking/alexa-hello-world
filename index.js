var APP_ID = undefinted;

var AlexaSkill = require('./AlexaSkill')

var HelloWorld = function() {
	AlexaSkill.call(this, APP_ID)
};

HelloWorld.prototype = Object.create(AlexaSkill.prototype);
HelloWorld.prototype.constructor = HelloWorld;

HelloWorld.prototype.eventHandlers.onSessionStarted = function (sessionStartedRequest, session){
	console.log("HelloWorld onSessionStarted requestId: " + sessionStartedRequest.requestId + ", sessionId: " + session.sessionId);
};

HelloWorld.prototype.onLaunch = function (launchRequest, session, response){
	console.log("HelloWorld onLaunch requestId: " + launchRequest.requestId + ", sessionId: " + session.sessionId);
	var speechOutput = "Welcome to the Alexa Skills Kit, you can say hello";
	var repromptText = "You can say hello";
	response.ask(speechOutput, repromptText);
};

HelloWorld.prototype.eventHandlers.onSessionEnded = function(sessionEndedRequest, session) {
	console.log("HelloWorld onSessionEnded requestId: " + sessionEndedRequest.requestId + ", sessionId: " + session.sessionId);
};

HelloWorld.prototype.intentHandlers = {
	"HelloWorldIntent" : function (intent, session, response) {
		response.tellWithCard("Hello World!", "Hellow World", "Hellow World!");
	}, 
	"AMAZON.HelpIntent": function (intent, session, response) {
		response.ask("You can say hello to me.", "You can say hello to me.");
	}
};

exports.handler = function (event, context) {
	var helloWorld = new HelloWorld();
	helloWorld.execute(event, context);
};