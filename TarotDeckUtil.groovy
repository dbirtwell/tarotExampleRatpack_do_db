// A class to used do all the "work" to generate a Tarot Card
class TarotDeckUtil {

	def tarotCards = []
	
	// Initialize this only ONCE
	final def rand = new Random() 	
	//Random rand = new Random() 		
	final def max = 21	
	
	// Constructor loads the Tarot Deck
	TarotDeckUtil() {
		int cardNdx = 0
		new File("tarot.txt").eachLine { line ->	
			def columns = line.split(',')
			def tarotCard =  new DivinationItem (id:cardNdx, name: columns[0], meaning: columns[1], image: columns[2])
			tarotCards.add(tarotCard)
			cardNdx += 1		
		}
	}

	// Returns a new Rator Card (actually a DivinationItem)
	DivinationItem randomCard() {
		//return tarotCards[rand.nextInt(max+1)]
		// Groovy doesn't need a return, like Ruby
		tarotCards[rand.nextInt(max+1)]		
	}

}