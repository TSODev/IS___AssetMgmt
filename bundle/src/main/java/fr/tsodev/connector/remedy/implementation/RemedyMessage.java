package fr.tsodev.connector.remedy.implementation;


public class RemedyMessage {
	
	// {
	//	"messageType":"ERROR",
	//	"messageText":null,
	//	"messageAppendedText":"An entry with the product name and product manufacturer specified already exists.  Please enter a different product name or different product manufacturer",
	//	"messageNumber":1351706
	//	}
	
	private static String messageType;
	private static String messageText;
	private static String messageAppendedText;
	private static String messageNumber;
	
	public RemedyMessage(String Type, String Text, String AppendedText, String Number) {
		this.setMessageType(Type);
		this.setMessageText(Text);
		this.setMessageAppendedText(AppendedText);
		this.setMessageNumber(Number);
	}
	
	public void setMessageType(String Type) {
		RemedyMessage.messageType = Type;
	}
	
	public static String getMessageType() {
		return RemedyMessage.messageType;
	}
	

	public void setMessageText(String Text) {
		RemedyMessage.messageText = Text;
	}
	
	public String getMessageText() {
		return RemedyMessage.messageText;
	}
	
	public void setMessageAppendedText(String AppendedText) {
		RemedyMessage.messageAppendedText = AppendedText;
	}
	
	public String getMessageAppendedText() {
		return RemedyMessage.messageAppendedText;
	}
	
	public void setMessageNumber(String Number) {
		RemedyMessage.messageNumber = Number;
	}
	
	public String getMessageNumber() {
		return RemedyMessage.messageNumber;
	}
}