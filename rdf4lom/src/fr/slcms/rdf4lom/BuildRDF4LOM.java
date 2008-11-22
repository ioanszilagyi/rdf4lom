/**
 * This class will build the RDF4LOM
 */
package fr.slcms.rdf4lom;

import java.io.StringWriter;
import java.lang.reflect.Array;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;

/**
 * @author Radu
 *
 */
public class BuildRDF4LOM {

	public String ConstructRDF4LOM(LomCategories lomCategories) {
		for (int i=0; i<lomCategories.lomGInterface.length; i++) {
			System.out.print(lomCategories.lomGInterface[i][0]);
		}
		try {
			// create an empty model
			Model model = ModelFactory.createDefaultModel();
        
			String namespace = "http://www.semanticlearning.fr/lom_owl/";
			String lomResource = "http://www.semanticlearning.fr/lom/theresource/";
			
			// set the prefix for LOM here
			model.setNsPrefix("lom", namespace);
        
			// create the LOM
			// create global resources       
			Resource LOM = model.createResource(lomResource, model.createResource(model.expandPrefix("lom:Lom"))); 
            /////////////// GENERAL
            //////////////////////////
			Resource General = model.createResource(model.createResource(model.expandPrefix("lom:General")));
			LOM.addProperty(model.createProperty(model.expandPrefix("lom:hasElement")), General);
          
			Resource Identifier = model.createResource(model.createResource(model.expandPrefix("lom:Identifier")));
			General.addProperty(model.createProperty(model.expandPrefix("lom:isElementComponentOf")), Identifier);
            
			StringWriter out_test = new StringWriter();
		
			// now write the model in XML form to a file
			model.write(out_test, "RDF/XML-ABBREV");
		
			System.out.print(out_test.toString());
			
			return out_test.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
}