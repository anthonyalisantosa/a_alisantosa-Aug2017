
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		String nospace = statement.trim();
		if (nospace.length() < 1) {
			response = "S A Y  S O M E T H I N G";
		} else if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} 
		
		/** 
		 *Bonus responses that reply to any form of "yes" and
		 *provides an optimistic response to users who are feeling
		 *down. :)
		 */
		else if (statement.toUpperCase().indexOf("YES") >= 0) {
			response = "I APPRECIATE YOUR OPTIMISM! :D";
			//KEEP IT WHOLESOME ^w^ 
		} else if (statement.indexOf("sad") >= 0) {
			response = "Sometimes feeling sad is okay. As Bob Ross put it,"
					+ "\n\"Gotta have a little sadness once in a while so you know"
					+ " when the good times come.\"";	
			
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		} 
		/**
		 * Teacher response checks the gender of the teacher and 
		 * responds with the correct pronoun.
		 */
		else if (statement.indexOf("Mr.") >= 0) {
			response = "He sounds really neat!";
		} else if (statement.indexOf("Ms.") >= 0
				|| statement.indexOf("Mrs.") >= 0
				|| statement.indexOf("Miss") >= 0) {
			response = "She sounds wonderful!";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		
		/**
		 * 'final' "finalizes" the variable and thus cannot be changed further. 
		 * 
		 * Math.random() chooses a number between 0 and 1.
		 * 
		 * whichResponse multiplies r with the number of responses and rounds it to 
		 * the nearest int. The result is responsible for NUMBER_OF_RESPONSES - 1
		 * possible responses.
		 */
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} 
		
		/**
		 * bonus random responses in case statement
		 * fails to pass the tests in getResponse.
		 */
		else if (whichResponse == 4) {
			response = "Wow!";
		} else if (whichResponse == 5) {
			response = "404 response not found.";
		}
		
		

		return response;
	}
}
