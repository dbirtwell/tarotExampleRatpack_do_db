@GrabResolver("https://oss.jfrog.org/artifactory/repo")
@Grab(value = "org.ratpack-framework:ratpack-groovy:0.9.0-SNAPSHOT")

import org.ratpackframework.groovy.templating.TemplateRenderer
import static org.ratpackframework.groovy.RatpackScript.ratpack

ratpack {
    handlers {
	
	    // Only initialize this once
		def util = new TarotDeckUtil()

		// default route
        get {		
            get(TemplateRenderer).render "index.html", title: "Groovy Tarot Caster"		
        }
		
		// Actual dynamic part
		get ("tarot") {
			def card = util.randomCard()
            get(TemplateRenderer).render "tarot.html", name: card.name, meaning: card.meaning, image: "images\\$card.image"						
        }		
		
		get ("about") {
            get(TemplateRenderer).render "about.html", title: "Groovy Tarot Caster"		
		}

        assets "public"
    }
}


