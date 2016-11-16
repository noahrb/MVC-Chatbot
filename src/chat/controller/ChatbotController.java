package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;

public class ChatbotController
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("Boaty McBoatFace");
		chatView = new ChatViewer();
	}
	
	public void start()
	{
		String response = chatView.collectResponse("What do you want to talk about today???");
		
		while(stupidBot.lengthChecker(response))
		{
			chatView.displayMessage(useChatbotCheckers(response));
			response = chatView.collectResponse("Oh, you are interested in " + response);
		}
	}
	
	public String useChatbotCheckers(String input)
	{
		String answer = "";
		
		if(stupidBot.contentChecker(input))
		{
			answer += "\nYou know my special secret\n";
		}		
		if(stupidBot.memeChecker(input))
		{
			answer += "\nI can has memes?\n";
		}
		if(stupidBot.politicalTopicChecker(input))
		{
			answer += "\nI love politics!\n";
		}
		if(stupidBot.inputHTMLChecker(input))
		{
			answer += "\nHTML IS LAMMMEEEEE\n";
		}
		if(input.length() == 0)
		{
			answer += "Sorry, I don't know about " + input;
		}
		
		if(!stupidBot.lengthChecker(answer))
		{
			answer += "Sorry, I don't know about " + input;
		}
		
		return answer;
	}
}
