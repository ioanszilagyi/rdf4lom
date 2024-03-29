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

					// check if there is some values in Description tab
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

				// check if there is some values in Technical tab
				// ///////////// TECHNICAL
				// ////////////////////////
				if (isValueIn(lomCategories, "Technical")) {
					Resource Techincal = model
							.createResource(model.createResource(model
									.expandPrefix("lom:Technical")));
					LOM.addProperty(model.createProperty(model
							.expandPrefix("lom:hasElement")), Techincal);

					// check if there is some values in Format tab
					// Format
					if (isValueIn(lomCategories.lomTFormat)) {
						for (int i = 0; i < lomCategories.lomTFormat.length; i++) {
							Techincal.addProperty(model.createProperty(model
									.expandPrefix("lom:format")),
									lomCategories.lomTFormat[i]);
						}
					}

					// check if there is some values in Size tab
					// Size
					if (isValueIn(lomCategories.lomTSize)) {
						Techincal.addProperty(model.createProperty(model
								.expandPrefix("lom:size")),
								lomCategories.lomTSize[0]);
					}

					// check if there is some values in Location tab
					// Location
					if (isValueIn(lomCategories.lomTLocation)) {
						for (int i = 0; i < lomCategories.lomTLocation.length; i++) {
							Techincal.addProperty(model.createProperty(model
									.expandPrefix("lom:location")),
									lomCategories.lomTLocation[i]);
						}
					}

					// check if there is some values in Requirement tab
					// Requirement
					if (isValueIn(lomCategories.lomTRequierment)) {
						for (int i = 0; i < lomCategories.lomTRequierment.length; i++) {
							Resource Requirement = model.createResource(model
									.createResource(model
											.expandPrefix("lom:Requirement")));
							Techincal.addProperty(model.createProperty(model
									.expandPrefix("lom:isElementComponentOf")),
									Requirement);

							for (int j = 0; j < lomCategories.lomTRequierment[i].length; j++) {
								Resource OrComposite = model
										.createResource(model
												.createResource(model
														.expandPrefix("lom:OrComposite")));
								Requirement
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:isElementComponentOf")),
												OrComposite);

								OrComposite.addProperty(model
										.createProperty(model
												.expandPrefix("lom:type")),
										lomCategories.lomTRequierment[i][j][0]);
								OrComposite.addProperty(model
										.createProperty(model
												.expandPrefix("lom:name")),
										lomCategories.lomTRequierment[i][j][1]);
								OrComposite
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:minimumVersion")),
												lomCategories.lomTRequierment[i][j][2]);
								OrComposite
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:maximumVersion")),
												lomCategories.lomTRequierment[i][j][3]);

							}
						}
					}
				}

				// check if there is some values in Educational tab
				// ///////////// EDUCATIONAL
				// ////////////////////////
				if (isValueIn(lomCategories, "Educational")) {
					for (int i = 0; i < lomCategories.lomEEducational.length; i++) {
						Resource Educational = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Educational")));
						LOM.addProperty(model.createProperty(model
								.expandPrefix("lom:hasElement")), Educational);

						// check if there is some values in Interactivity Type
						// tab
						// Interactivity Type
						if (isValueIn(lomCategories.lomEEducational[i][0])) {
							Educational.addProperty(model.createProperty(model
									.expandPrefix("lom:interactivityType")),
									lomCategories.lomEEducational[i][0][0][0]);

						}

						// check if there is some values in Learning Resource
						// Type tab
						// Learning Resource Type
						if (isValueIn(lomCategories.lomEEducational[i][1])) {
							for (int j = 0; j < lomCategories.lomEEducational[i][1].length; j++) {
								Educational
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:learningResourceType")),
												lomCategories.lomEEducational[i][1][j][0]);
							}
						}

						// check if there is some values in Interactivity Level
						// tab
						// Interactivity Level
						if (isValueIn(lomCategories.lomEEducational[i][2])) {
							Educational.addProperty(model.createProperty(model
									.expandPrefix("lom:interactivityLevel")),
									lomCategories.lomEEducational[i][2][0][0]);

						}

						// check if there is some values in Semantic Density tab
						// Semantic Density
						if (isValueIn(lomCategories.lomEEducational[i][3])) {
							Educational.addProperty(model.createProperty(model
									.expandPrefix("lom:semanticDensity")),
									lomCategories.lomEEducational[i][3][0][0]);

						}

						// check if there is some values in Intended End User
						// Role tab
						// Intended End User Role
						if (isValueIn(lomCategories.lomEEducational[i][4])) {
							for (int j = 0; j < lomCategories.lomEEducational[i][4].length; j++) {
								Educational
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:intendedEndUserRole")),
												lomCategories.lomEEducational[i][4][j][0]);
							}
						}

						// check if there is some values in Context tab
						// Context
						if (isValueIn(lomCategories.lomEEducational[i][5])) {
							for (int j = 0; j < lomCategories.lomEEducational[i][5].length; j++) {
								Educational
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:context")),
												lomCategories.lomEEducational[i][5][j][0]);
							}
						}

						// check if there is some values in Typical Age Range
						// tab
						// Typical Age Range
						if (isValueIn(lomCategories.lomEEducational[i][6])) {
							for (int j = 0; j < lomCategories.lomEEducational[i][6].length; j++) {
								Educational
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:typicalAgeRange")),
												model
														.createLiteral(
																lomCategories.lomEEducational[i][6][j][0],
																lomCategories.lomEEducational[i][6][j][1]));
							}
						}

						// check if there is some values in Difficulty tab
						// Difficulty
						if (isValueIn(lomCategories.lomEEducational[i][7])) {
							Educational.addProperty(model.createProperty(model
									.expandPrefix("lom:difficulty")),
									lomCategories.lomEEducational[i][7][0][0]);

						}

						// check if there is some values in Typical Learning
						// Time tab
						// Typical Learning Time
						if (isValueIn(lomCategories.lomEEducational[i][8])) {
							Educational.addProperty(model.createProperty(model
									.expandPrefix("lom:typicalLearningTime")),
									lomCategories.lomEEducational[i][8][0][0]);

						}

						// check if there is some values in Description tab
						// Description
						if (isValueIn(lomCategories.lomEEducational[i][9])) {
							for (int j = 0; j < lomCategories.lomEEducational[i][9].length; j++) {
								Educational
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:description")),
												model
														.createLiteral(
																lomCategories.lomEEducational[i][9][j][0],
																lomCategories.lomEEducational[i][9][j][1]));
							}
						}

						// check if there is some values in Language tab
						// Language
						if (isValueIn(lomCategories.lomEEducational[i][10])) {
							for (int j = 0; j < lomCategories.lomEEducational[i][10].length; j++) {
								Educational
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:language")),
												lomCategories.lomEEducational[i][10][j][0]);
							}
						}
					}
				}

				// check if there is some values in Rights tab
				// ///////////// RIGHTS
				// ////////////////////////
				if (isValueIn(lomCategories, "Rights")) {
					Resource Rights = model.createResource(model
							.createResource(model.expandPrefix("lom:Rights")));
					LOM.addProperty(model.createProperty(model
							.expandPrefix("lom:hasElement")), Rights);

					// check if there is some values in Cost tab
					// Cost
					if (isValueIn(lomCategories.lomRCost)) {
						Rights.addProperty(model.createProperty(model
								.expandPrefix("lom:cost")),
								lomCategories.lomRCost[0]);
					}

					// check if there is some values in Copyright And Other
					// Restriction tab
					// Copyright And Other Restriction
					if (isValueIn(lomCategories.lomRCopyrightAndOtherRestriction)) {
						Rights
								.addProperty(
										model
												.createProperty(model
														.expandPrefix("lom:copyrightAndOtherRestriction")),
										lomCategories.lomRCopyrightAndOtherRestriction[0]);
					}

					// check if there is some values in Description tab
					// Description
					if (isValueIn(lomCategories.lomRDescription)) {
						for (int i = 0; i < lomCategories.lomRDescription.length; i++) {
							Rights
									.addProperty(
											model
													.createProperty(model
															.expandPrefix("lom:description")),
											model
													.createLiteral(
															lomCategories.lomRDescription[i][0],
															lomCategories.lomRDescription[i][1]));
						}
					}
				}

				// check if there is some values in Relation tab
				// ///////////// RELATION
				// ////////////////////////
				if (isValueIn(lomCategories, "Relation")) {
					for (int i = 0; i < lomCategories.lomRRelation.length; i++) {
						Resource Relation = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Relation")));
						LOM.addProperty(model.createProperty(model
								.expandPrefix("lom:hasElement")), Relation);

						// check if there is some values in Kind tab
						// Kind
						if (isValueIn(lomCategories.lomRRelation[i][0])) {
							Relation.addProperty(model.createProperty(model
									.expandPrefix("lom:kind")),
									lomCategories.lomRRelation[i][0][0][0][0]);
						}

						// check if there is some values in Resource tab
						// Resource
						if (isValueIn(lomCategories.lomRRelation[i][1])) {
							Resource CResource = model.createResource(model
									.createResource(model
											.expandPrefix("lom:Resource")));
							Relation.addProperty(model.createProperty(model
									.expandPrefix("lom:isElementComponentOf")),
									CResource);

							// Identifier
							if (isValueIn(lomCategories.lomRRelation[i][1][0])) {
								for (int j = 0; j < lomCategories.lomRRelation[i][1][0].length; j++) {
									Resource Identifier = model
											.createResource(model
													.createResource(model
															.expandPrefix("lom:Identifier")));
									CResource
											.addProperty(
													model
															.createProperty(model
																	.expandPrefix("lom:isElementComponentOf")),
													Identifier);

									Identifier
											.addProperty(
													model
															.createProperty(model
																	.expandPrefix("lom:catalog")),
													lomCategories.lomRRelation[i][1][0][j][0]);
									Identifier
											.addProperty(
													model
															.createProperty(model
																	.expandPrefix("lom:entry")),
													lomCategories.lomRRelation[i][1][0][j][1]);
								}
							}

							// Description
							if (isValueIn(lomCategories.lomRRelation[i][1][1])) {
								for (int j = 0; j < lomCategories.lomRRelation[i][1][1].length; j++) {
									CResource
											.addProperty(
													model
															.createProperty(model
																	.expandPrefix("lom:description")),
													model
															.createLiteral(
																	lomCategories.lomRRelation[i][1][1][j][0],
																	lomCategories.lomRRelation[i][1][1][j][1]));
								}
							}
						}
					}
				}

				// check if there is some values in Annotation tab
				// //////////// ANNOTATION
				// ////////////////////////
				if (isValueIn(lomCategories, "Annotation")) {
					for (int i = 0; i < lomCategories.lomAAnotation.length; i++) {
						Resource Annotation = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Annotation")));
						LOM.addProperty(model.createProperty(model
								.expandPrefix("lom:hasElement")), Annotation);

						// check if there is some values in Entity tab
						// Entity
						if (isValueIn(lomCategories.lomAAnotation[i][0])) {
							Annotation.addProperty(model.createProperty(model
									.expandPrefix("lom:entity")),
									lomCategories.lomAAnotation[i][0][0][0]);
						}

						// check if there is some values in Date tab
						// Date
						if (isValueIn(lomCategories.lomAAnotation[i][1])) {
							Annotation.addProperty(model.createProperty(model
									.expandPrefix("lom:date")),
									lomCategories.lomAAnotation[i][1][0][0]);
						}

						// check if there is some values in Description tab
						// Description
						if (isValueIn(lomCategories.lomAAnotation[i][2])) {
							for (int j = 0; j < lomCategories.lomAAnotation[i][2].length; j++) {
								Annotation
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:description")),
												model
														.createLiteral(
																lomCategories.lomAAnotation[i][2][j][0],
																lomCategories.lomAAnotation[i][2][j][1]));
							}
						}
					}
				}

				// check if there is some values in Classification tab
				// //////////// CLASSIFICATION
				// ////////////////////////
				if (isValueIn(lomCategories, "Classification")) {
					for (int i = 0; i < lomCategories.lomCClassification.length; i++) {
						Resource Classification = model.createResource(model
								.createResource(model
										.expandPrefix("lom:Classification")));
						LOM.addProperty(model.createProperty(model
								.expandPrefix("lom:hasElement")),
								Classification);

						// check if there is some values in Prupose tab
						// Prupose
						if (isValueIn(lomCategories.lomCClassification[i][0][0][0][0][0])) {
							Classification
									.addProperty(
											model
													.createProperty(model
															.expandPrefix("lom:entity")),
											lomCategories.lomCClassification[i][0][0][0][0][0][0]);
						}

						// check if there is some values in Taxon Path tab
						// Taxon Path
						if (isValueIn(lomCategories.lomCClassification[i][1])) {
							Resource TaxonPath = model.createResource(model
									.createResource(model
											.expandPrefix("lom:TaxonPath")));
							Classification
									.addProperty(
											model
													.createProperty(model
															.expandPrefix("lom:isElementComponentOf")),
											TaxonPath);

							// check if there is some values in Source tab
							// Source
							if (isValueIn(lomCategories.lomCClassification[i][1][0])) {
								for (int j = 0; j < lomCategories.lomCClassification[i][1][0].length; j++) {
									TaxonPath
											.addProperty(
													model
															.createProperty(model
																	.expandPrefix("lom:source")),
													lomCategories.lomCClassification[i][1][0][j][0][0][0]);
								}
							}

							// check if there is some values in Taxon tab
							// Taxon
							if (isValueIn(lomCategories.lomCClassification[i][1][1])) {
								for (int j = 0; j < lomCategories.lomCClassification[i][1][1].length; j++) {
									Resource Taxon = model
											.createResource(model
													.createResource(model
															.expandPrefix("lom:Taxon")));
									TaxonPath
											.addProperty(
													model
															.createProperty(model
																	.expandPrefix("lom:isElementComponentOf")),
													Taxon);

									// check if there is some values in Id tab
									// Id
									if (isValueIn(lomCategories.lomCClassification[i][1][1][j][0][0])) {
										Taxon
												.addProperty(
														model
																.createProperty(model
																		.expandPrefix("lom:id")),
														lomCategories.lomCClassification[i][1][1][j][0][0][0]);
									}

									// check if there is some values in Entry
									// tab
									// Entry
									if (isValueIn(lomCategories.lomCClassification[i][1][1][j][1][0])) {
										for (int k = 0; k < lomCategories.lomCClassification[i][1][1][j][1].length; k++) {
											Taxon
													.addProperty(
															model
																	.createProperty(model
																			.expandPrefix("lom:entry")),
															model
																	.createLiteral(
																			lomCategories.lomCClassification[i][1][1][j][1][k][0],
																			lomCategories.lomCClassification[i][1][1][j][1][k][1]));
										}
									}
								}
							}
						}

						// check if there is some values in Description tab
						// Description
						if (isValueIn(lomCategories.lomCClassification[i][2][0][0][0][0])) {
							for (int j = 0; j < lomCategories.lomCClassification[i][2].length; j++) {
								Classification
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:description")),
												model
														.createLiteral(
																lomCategories.lomCClassification[i][2][j][0][0][0][0],
																lomCategories.lomCClassification[i][2][j][0][0][0][1]));
							}
						}

						// check if there is some values in Keyword tab
						// Keyword
						if (isValueIn(lomCategories.lomCClassification[i][3][0][0][0][0])) {
							for (int j = 0; j < lomCategories.lomCClassification[i][3].length; j++) {
								Classification
										.addProperty(
												model
														.createProperty(model
																.expandPrefix("lom:keyword")),
												model
														.createLiteral(
																lomCategories.lomCClassification[i][3][j][0][0][0][0],
																lomCategories.lomCClassification[i][3][j][0][0][0][1]));
							}
						}
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
			// Techincal
			else if (isValueIn(lomCategories.lomTFormat))
				return true;
			else if (isValueIn(lomCategories.lomTSize))
				return true;
			else if (isValueIn(lomCategories.lomTLocation))
				return true;
			else if (isValueIn(lomCategories.lomTRequierment))
				return true;
			// Educational
			else if (isValueIn(lomCategories.lomEEducational))
				return true;
			// Rights
			else if (isValueIn(lomCategories.lomRCost))
				return true;
			else if (isValueIn(lomCategories.lomRCopyrightAndOtherRestriction))
				return true;
			else if (isValueIn(lomCategories.lomRDescription))
				return true;
			// Relation
			else if (isValueIn(lomCategories.lomRRelation))
				return true;
			// Annotation
			else if (isValueIn(lomCategories.lomAAnotation))
				return true;
			// Classification
			else if (isValueIn(lomCategories.lomCClassification))
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
			case Technical: {
				if (isValueIn(lomCategories.lomTFormat))
					return true;
				else if (isValueIn(lomCategories.lomTSize))
					return true;
				else if (isValueIn(lomCategories.lomTLocation))
					return true;
				else if (isValueIn(lomCategories.lomTRequierment))
					return true;
				else
					return false;
			}
			case Educational: {
				if (isValueIn(lomCategories.lomEEducational))
					return true;
				else
					return false;
			}
			case Rights: {
				if (isValueIn(lomCategories.lomRCost))
					return true;
				else if (isValueIn(lomCategories.lomRCopyrightAndOtherRestriction))
					return true;
				else if (isValueIn(lomCategories.lomRDescription))
					return true;
				else
					return false;
			}
			case Relation: {
				if (isValueIn(lomCategories.lomRRelation))
					return true;
				else
					return false;
			}
			case Annotation: {
				if (isValueIn(lomCategories.lomAAnotation))
					return true;
				else
					return false;
			}
			case Classification: {
				if (isValueIn(lomCategories.lomCClassification))
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

	/**
	 * This is used for all the values from a multidimensional array string
	 * 
	 * @param theCategory
	 * @return true if there is a non empty string into the array
	 */
	private Boolean isValueIn(String[][][] theCategory) {
		for (int i = 0; i < theCategory.length; i++) {
			for (int j = 0; j < theCategory[i].length; j++) {
				for (int k = 0; k < theCategory[i][j].length; k++) {
					if (!theCategory[i][j][k].isEmpty()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * This is used for all the values from a multidimensional array string
	 * 
	 * @param theCategory
	 * @return true if there is a non empty string into the array
	 */
	private Boolean isValueIn(String[][][][] theCategory) {
		for (int i = 0; i < theCategory.length; i++) {
			for (int j = 0; j < theCategory[i].length; j++) {
				for (int k = 0; k < theCategory[i][j].length; k++) {
					for (int m = 0; m < theCategory[i][j][k].length; m++) {
						if (!theCategory[i][j][k][m].isEmpty()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * This is used for all the values from a multidimensional array string
	 * 
	 * @param theCategory
	 * @return true if there is a non empty string into the array
	 */
	private Boolean isValueIn(String[][][][][] theCategory) {
		for (int i = 0; i < theCategory.length; i++) {
			for (int j = 0; j < theCategory[i].length; j++) {
				for (int k = 0; k < theCategory[i][j].length; k++) {
					for (int m = 0; m < theCategory[i][j][k].length; m++) {
						for (int n = 0; n < theCategory[i][j][k][m].length; n++) {
							if (!theCategory[i][j][k][m][n].isEmpty()) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * This is used for all the values from a multidimensional array string
	 * 
	 * @param theCategory
	 * @return true if there is a non empty string into the array
	 */
	private Boolean isValueIn(String[][][][][][][] theCategory) {
		for (int i = 0; i < theCategory.length; i++) {
			for (int j = 0; j < theCategory[i].length; j++) {
				for (int k = 0; k < theCategory[i][j].length; k++) {
					for (int m = 0; m < theCategory[i][j][k].length; m++) {
						for (int n = 0; n < theCategory[i][j][k][m].length; n++) {
							for (int o = 0; o < theCategory[i][j][k][m][n].length; o++) {
								for (int p = 0; p < theCategory[i][j][k][m][n][o].length; p++) {
									if (!theCategory[i][j][k][m][n][o][p]
											.isEmpty()) {
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}