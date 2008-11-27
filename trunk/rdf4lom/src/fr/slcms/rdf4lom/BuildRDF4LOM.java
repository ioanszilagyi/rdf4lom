/**
 * This class will build the RDF4LOM
 */
package fr.slcms.rdf4lom;

import java.io.StringWriter;

import com.hp.hpl.jena.rdf.model.*;

/**
 * @author Radu
 * 
 */
public class BuildRDF4LOM {

	/**
	 * Used to change walk through LOM categories
	 * 
	 */
	private enum Categories {
		General, LifeCycle, MetaMetadata, Technical, Educational, Rights, Relation, Annotation, Classification
	};

	public String ConstructRDF4LOM(LomCategories lomCategories) {
		try {
			// verify if there is some information in the fields
			if (isValueIn(lomCategories)) {

				// create an empty model
				Model model = ModelFactory.createDefaultModel();

				String namespace = "http://www.semanticlearning.fr/lom_owl/";
				String lomResource = "http://www.semanticlearning.fr/lom/theresource/";

				// set the prefix for LOM here
				model.setNsPrefix("lom", namespace);

				// create the LOM
				// create global resources
				Resource LOM = model.createResource(lomResource, model
						.createResource(model.expandPrefix("lom:Lom")));

				// check if there is some values in General tab
				// ///////////// GENERAL
				// ////////////////////////
				if (isValueIn(lomCategories, "General")) {
					Resource General = model.createResource(model
							.createResource(model.expandPrefix("lom:General")));
					LOM.addProperty(model.createProperty(model
							.expandPrefix("lom:hasElement")), General);

					// check if there is some values in Identifier tab
					// Identifier
					if (isValueIn(lomCategories.lomGIdentifier)) {
						Resource Identifier = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Identifier")));
						General.addProperty(model.createProperty(model
								.expandPrefix("lom:isElementComponentOf")),
								Identifier);

						for (int i = 0; i < lomCategories.lomGIdentifier.length; i++) {
							Identifier.addProperty(model.createProperty(model
									.expandPrefix("lom:catalog")),
									lomCategories.lomGIdentifier[i][0]);
							Identifier.addProperty(model.createProperty(model
									.expandPrefix("lom:entry")),
									lomCategories.lomGIdentifier[i][1]);
						}
					}

					// check if there is some values in Title tab
					// Title
					if (isValueIn(lomCategories.lomGTitle)) {
						for (int i = 0; i < lomCategories.lomGTitle.length; i++) {
							General.addProperty(model.createProperty(model
									.expandPrefix("lom:title")), model
									.createLiteral(
											lomCategories.lomGTitle[i][0],
											lomCategories.lomGTitle[i][1]));
						}
					}

					// check if there is some values in Language tab
					// Language
					if (isValueIn(lomCategories.lomGLanguage)) {
						General.addProperty(model.createProperty(model
								.expandPrefix("lom:language")),
								lomCategories.lomGLanguage[0]);
					}

					// check if there is some values in Title tab
					// Description
					if (isValueIn(lomCategories.lomGDescription)) {
						for (int i = 0; i < lomCategories.lomGDescription.length; i++) {
							General.addProperty(model.createProperty(model
									.expandPrefix("lom:description")),
									lomCategories.lomGDescription[i]);
						}
					}

					// check if there is some values in Keyword tab
					// Keyword
					if (isValueIn(lomCategories.lomGKeyword)) {
						for (int i = 0; i < lomCategories.lomGKeyword.length; i++) {
							General.addProperty(model.createProperty(model
									.expandPrefix("lom:keyword")), model
									.createLiteral(
											lomCategories.lomGKeyword[i][0],
											lomCategories.lomGKeyword[i][1]));
						}
					}

					// check if there is some values in Coverage tab
					// Coverage
					if (isValueIn(lomCategories.lomGCoverage)) {
						for (int i = 0; i < lomCategories.lomGCoverage.length; i++) {
							General.addProperty(model.createProperty(model
									.expandPrefix("lom:coverage")), model
									.createLiteral(
											lomCategories.lomGCoverage[i][0],
											lomCategories.lomGCoverage[i][1]));
						}
					}

					// check if there is some values in Structure tab
					// Structure
					if (isValueIn(lomCategories.lomGStructure)) {
						General.addProperty(model.createProperty(model
								.expandPrefix("lom:structure")),
								lomCategories.lomGStructure[0]);
					}

					// check if there is some values in Aggregation Level tab
					// Aggregation Level
					if (isValueIn(lomCategories.lomGAggregationLevel)) {
						General.addProperty(model.createProperty(model
								.expandPrefix("lom:aggregationLevel")),
								lomCategories.lomGAggregationLevel[0]);
					}
				}

				// check if there is some values in Life Cycle tab
				// ///////////// LIFE CYCLE
				// ////////////////////////
				if (isValueIn(lomCategories, "LifeCycle")) {
					Resource LifeCycle = model
							.createResource(model.createResource(model
									.expandPrefix("lom:LifeCycle")));
					LOM.addProperty(model.createProperty(model
							.expandPrefix("lom:hasElement")), LifeCycle);

					// check if there is some values in Version tab
					// Version
					if (isValueIn(lomCategories.lomLVersion)) {
						for (int i = 0; i < lomCategories.lomLVersion.length; i++) {
							LifeCycle.addProperty(model.createProperty(model
									.expandPrefix("lom:version")), model
									.createLiteral(
											lomCategories.lomLVersion[i][0],
											lomCategories.lomLVersion[i][1]));
						}
					}

					// check if there is some values in Status tab
					// Status
					if (isValueIn(lomCategories.lomLStatus)) {
						LifeCycle.addProperty(model.createProperty(model
								.expandPrefix("lom:status")),
								lomCategories.lomLStatus[0]);
					}

					// check if there is some values in Contribute tab
					// Contribute
					if (isValueIn(lomCategories.lomLContribute)) {
						Resource Contribute = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Contribute")));
						LifeCycle.addProperty(model.createProperty(model
								.expandPrefix("lom:isElementComponentOf")),
								Contribute);

						for (int i = 0; i < lomCategories.lomLContribute.length; i++) {
							Contribute.addProperty(model.createProperty(model
									.expandPrefix("lom:role")),
									lomCategories.lomLContribute[i][0]);
							Contribute.addProperty(model.createProperty(model
									.expandPrefix("lom:entity")),
									lomCategories.lomLContribute[i][1]);
							Contribute.addProperty(model.createProperty(model
									.expandPrefix("lom:date")),
									lomCategories.lomLContribute[i][2]);
						}
					}
				}

				// check if there is some values in Meta-Metadata tab
				// ///////////// META-METADATA
				// ////////////////////////
				if (isValueIn(lomCategories, "MetaMetadata")) {
					Resource MetaMetadata = model.createResource(model
							.createResource(model
									.expandPrefix("lom:MetaMetadata")));
					LOM.addProperty(model.createProperty(model
							.expandPrefix("lom:hasElement")), MetaMetadata);

					// check if there is some values in Identifier tab
					// Identifier
					if (isValueIn(lomCategories.lomMIdentifier)) {
						Resource Identifier = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Identifier")));
						MetaMetadata.addProperty(model.createProperty(model
								.expandPrefix("lom:isElementComponentOf")),
								Identifier);

						for (int i = 0; i < lomCategories.lomMIdentifier.length; i++) {
							Identifier.addProperty(model.createProperty(model
									.expandPrefix("lom:catalog")),
									lomCategories.lomMIdentifier[i][0]);
							Identifier.addProperty(model.createProperty(model
									.expandPrefix("lom:entry")),
									lomCategories.lomMIdentifier[i][1]);
						}
					}

					// check if there is some values in Contribute tab
					// Contribute
					if (isValueIn(lomCategories.lomMContribute)) {
						Resource Contribute = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Contribute")));
						MetaMetadata.addProperty(model.createProperty(model
								.expandPrefix("lom:isElementComponentOf")),
								Contribute);

						for (int i = 0; i < lomCategories.lomMContribute.length; i++) {
							Contribute.addProperty(model.createProperty(model
									.expandPrefix("lom:role")),
									lomCategories.lomMContribute[i][0]);
							Contribute.addProperty(model.createProperty(model
									.expandPrefix("lom:entity")),
									lomCategories.lomMContribute[i][1]);
							Contribute.addProperty(model.createProperty(model
									.expandPrefix("lom:date")),
									lomCategories.lomMContribute[i][2]);
						}
					}

					// check if there is some values in Metadata Schema tab
					// Metadata Schema
					if (isValueIn(lomCategories.lomMMetadataSchema)) {
						for (int i = 0; i < lomCategories.lomMMetadataSchema.length; i++) {
							MetaMetadata.addProperty(model.createProperty(model
									.expandPrefix("lom:metadataSchema")),
									lomCategories.lomMMetadataSchema[i]);
						}
					}

					// check if there is some values in Language tab
					// Language
					if (isValueIn(lomCategories.lomMLanguage)) {
						MetaMetadata.addProperty(model.createProperty(model
								.expandPrefix("lom:language")),
								lomCategories.lomMLanguage[0]);
					}
				}

				// start writing the RDF
				StringWriter out_test = new StringWriter();

				// now write the model in XML form to a file
				model.write(out_test, "RDF/XML-ABBREV");

				System.out.print(out_test.toString());

				return out_test.toString();
			} else {
				return "Please fill the fields with data first!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	/**
	 * Verify all the categories to see if there is a non empty string If the
	 * return value is true the the RDF 4 LOM will be created else will not be
	 * created
	 * 
	 * @param lomCategories
	 * @return true if there is a non empty string into the all LOM categories
	 */
	private Boolean isValueIn(LomCategories lomCategories) {
		return isValueIn(lomCategories, null);
	}

	/**
	 * Verify all the categories to see if there is a non empty string If the
	 * return value is true the the RDF 4 LOM will be created else will not be
	 * created
	 * 
	 * @param lomCategories
	 * @param category
	 * @return true if there is a non empty string into the all LOM categories
	 */
	private Boolean isValueIn(LomCategories lomCategories, String category) {
		// if category is null then will check all the LOM categories
		if (category == null)
			// General
			if (isValueIn(lomCategories.lomGIdentifier))
				return true;
			else if (isValueIn(lomCategories.lomGTitle))
				return true;
			else if (isValueIn(lomCategories.lomGLanguage))
				return true;
			else if (isValueIn(lomCategories.lomGDescription))
				return true;
			else if (isValueIn(lomCategories.lomGKeyword))
				return true;
			else if (isValueIn(lomCategories.lomGCoverage))
				return true;
			else if (isValueIn(lomCategories.lomGStructure))
				return true;
			else if (isValueIn(lomCategories.lomGAggregationLevel))
				return true;
			// Life Cycle
			else if (isValueIn(lomCategories.lomLVersion))
				return true;
			else if (isValueIn(lomCategories.lomLStatus))
				return true;
			else if (isValueIn(lomCategories.lomLContribute))
				return true;
			// Meta-Metadata
			else if (isValueIn(lomCategories.lomMIdentifier))
				return true;
			else if (isValueIn(lomCategories.lomMContribute))
				return true;
			else if (isValueIn(lomCategories.lomMMetadataSchema))
				return true;
			else if (isValueIn(lomCategories.lomMLanguage))
				return true;
			else
				return false;
		else
			switch (Categories.valueOf(category)) {
			// check the General category
			case General: {
				if (isValueIn(lomCategories.lomGIdentifier))
					return true;
				else if (isValueIn(lomCategories.lomGTitle))
					return true;
				else if (isValueIn(lomCategories.lomGLanguage))
					return true;
				else if (isValueIn(lomCategories.lomGDescription))
					return true;
				else if (isValueIn(lomCategories.lomGKeyword))
					return true;
				else if (isValueIn(lomCategories.lomGCoverage))
					return true;
				else if (isValueIn(lomCategories.lomGStructure))
					return true;
				else if (isValueIn(lomCategories.lomGAggregationLevel))
					return true;
				else
					return false;
			}
			case LifeCycle: {
				if (isValueIn(lomCategories.lomLVersion))
					return true;
				else if (isValueIn(lomCategories.lomLStatus))
					return true;
				else if (isValueIn(lomCategories.lomLContribute))
					return true;
				else
					return false;
			}
			case MetaMetadata: {
				if (isValueIn(lomCategories.lomMIdentifier))
					return true;
				else if (isValueIn(lomCategories.lomMContribute))
					return true;
				else if (isValueIn(lomCategories.lomMMetadataSchema))
					return true;
				else if (isValueIn(lomCategories.lomMLanguage))
					return true;
				else
					return false;
			}
			default:
				return false;
			}
	}

	/**
	 * This is used for all the values from a normal array string
	 * 
	 * @param theCategory
	 * @return true if there is a non empty string into the array
	 */
	private Boolean isValueIn(String[] theCategory) {
		for (int i = 0; i < theCategory.length; i++) {
			if (!theCategory[i].isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This is used for all the values from a matrix array string
	 * 
	 * @param theCategory
	 * @return true if there is a non empty string into the array
	 */
	private Boolean isValueIn(String[][] theCategory) {
		for (int i = 0; i < theCategory.length; i++) {
			for (int j = 0; j < theCategory[i].length; j++) {
				if (!theCategory[i][j].isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
}