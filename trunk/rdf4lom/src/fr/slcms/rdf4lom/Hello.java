/**
 * 
 */
package fr.slcms.rdf4lom;

import java.io.StringWriter;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;


/**
 * @author Radu
 *
 */
public class Hello {
 
	// some definitions
    static String tutorialURI  = "http://hostname/rdf/tutorial/";
    static String briansName   = "Brian McBride";
    static String briansEmail1 = "brian_mcbride@hp.com";
    static String briansEmail2 = "brian_mcbride@hpl.hp.com";
    static String title        = "An Introduction to RDF and the Jena API";
    static String date         = "23/01/2001";
    
    public String HiThere() {
    	try {
			System.out.print("IN here");
			// some definitions
			String personURI    = "http://somewhere/JohnSmith";
			String givenName    = "John";
			String familyName   = "Smith";
			String fullName     = givenName + " " + familyName;
			// create an empty model
			Model model = ModelFactory.createDefaultModel();
			
			// create the resource
			//   and add the properties cascading style
			Resource johnSmith 
			  = model.createResource(personURI)
			         .addProperty(VCARD.FN, fullName)
			         .addProperty(VCARD.N, 
			                      model.createResource()
			                           .addProperty(VCARD.Given, givenName)
			                           .addProperty(VCARD.Family, familyName));
			
			// now write the model in XML form to a file
			model.write(System.out);
			
			StringWriter out_test = new StringWriter();
			
			// now write the model in XML form to a file
			model.write(out_test, "RDF/XML-ABBREV");
			
			System.out.print(out_test.toString());
			return out_test.toString();
			//return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
    }
}
