/**
 * 
 */
package fr.slcms.rdf4lom;

/**
 * @author Radu
 *
 */
public class LomCategories {
	// General
	public String[][] lomGIdentifier;	
	public String[][] lomGTitle;
	public String[] lomGLanguage;
	public String[] lomGDescription;
	public String[][] lomGKeyword;
	public String[][] lomGCoverage;
	public String[] lomGStructure;
	public String[] lomGAggregationLevel;
	
	// Live Cycle
	public String[][] lomLVersion;	
	public String[] lomLStatus;
	public String[][] lomLContribute;
	
	// Meta-Metadata
	public String[][] lomMIdentifier;	
	public String[][] lomMContribute;
	public String[] lomMMetadataSchema;
	public String[] lomMLanguage;
	
	// Technical
	public String[] lomTFormat;	
	public String[] lomTSize;
	public String[] lomTLocation;
	public String[][][] lomTRequierment;
	public String[][] lomTInstalationRemarks;
	public String[][] lomTOtherPlathormRequrements;
	public String[][] lomTDuration;
	
	// Educational
	public String[][][][] lomEEducational;	
	
	// Rights
	public String[] lomRCost;
	public String[] lomRCopyrightAndOtherRestriction;
	public String[][] lomRDescription;
	
	// Relation
	public String[][][][][] lomRRelation;
}