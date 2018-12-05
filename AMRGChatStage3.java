import javax.swing.JOptionPane;

public class AMRGChatStage3 {

	public static void main(String[] args) {
		// Asking the user to set the length of the array (to be used to store topics)
		int arrayLength = Integer
				.parseInt(JOptionPane.showInputDialog("How many topics would you like to talk about?"));

		// Input validation
		while (arrayLength <= 0) {
			arrayLength = Integer
					.parseInt(JOptionPane.showInputDialog("Error! Please enter a number greater than zero"));
		}

		// Setting up the topic array with user-defined length
		String[] chatArray = new String[arrayLength];

		// Asking the user to enter topics into the array
		int i = 0;
		while (i < arrayLength) {
			chatArray[i] = JOptionPane.showInputDialog("Please enter topic " + i);
			i++;
		}

		// Chat phase message
		JOptionPane.showMessageDialog(null, "Beginning chat phase...");

		// Beginning discussion by displaying entered topics
		String display = "";
		int a = 0;
		while (a < arrayLength) {
			display = display + chatArray[a] + ", ";
			a++;
		}
		String chatAnswer = JOptionPane.showInputDialog("Tell me more about " + display + "...");

		// Chat Phase (Contained in while loop)
		int arrayValue = 0, loopCounter = 0;
		String surprise = "";
		while (chatAnswer != null) {
			// Surprise check
			if (chatAnswer.contains("!")) {
				surprise = "Well there you go! ";
			} else {
				surprise = "";
			}
			// Keyword check
			if (chatAnswer.contains(chatArray[arrayValue])) {
				chatAnswer = JOptionPane
						.showInputDialog(surprise + "Tell me more about " + chatArray[arrayValue] + "...");
			} else {
				arrayValue++;
				if (arrayValue >= arrayLength) {
					arrayValue = 0;
					loopCounter++;

					// No keywords detected
					if (loopCounter > arrayLength) {
						loopCounter = 0;
						chatAnswer = JOptionPane.showInputDialog(
								surprise + "That's interesting but tell me more about " + display + "...");
					}
				}
			}
		}
		// Goodbye message
		JOptionPane.showMessageDialog(null, "Thanks for chatting!");
	}
}