/*
	This class is used to store all the static array collection variables 
	related to LOM Categories. 
*/
package as3
{
	import mx.collections.ArrayCollection;
	
	public final class DynCatArrays
	{
		public static function ReNewDynCatArrays():void {
			// General
			lomGIdentifier.removeAll();
			lomGTitle.removeAll();
			lomGLanguage.removeAll();
			lomGDescription.removeAll();
			lomGKeyword.removeAll();
			lomGCoverage.removeAll();
			lomGStructure.removeAll();
			lomGAggregationLevel.removeAll();
			
			// Life Cycle
			lomLVersion.removeAll();
			lomLStatus.removeAll();
			lomLContribute.removeAll();
			
			// Meta-Metadata
			lomMIdentifier.removeAll();
			lomMContribute.removeAll();
			lomMMetadataSchema.removeAll();
			lomMLanguage.removeAll();
			
			// Technical
			lomTFormat.removeAll();
			lomTSize.removeAll();
			lomTLocation.removeAll();
			lomTRequirement.removeAll();
			lomTInstallationRemarks.removeAll();
			lomTOtherPlatformRequirements.removeAll();
			lomTDuration.removeAll();
			
			// Edicational
			lomEEducational.removeAll();
			
			// Rights
			lomRCost.removeAll();
			lomRCopyrightAndOtherRestrictions.removeAll();
			lomRDescription.removeAll();
			
			// Relation
			lomRRelation.removeAll();
		}
		
		// General
		/// Identifier
		public static var lomGIdentifier:ArrayCollection = new ArrayCollection();
		/// Title
		public static var lomGTitle:ArrayCollection = new ArrayCollection();
		/// Language
		public static var lomGLanguage:ArrayCollection = new ArrayCollection();
		/// Description
		public static var lomGDescription:ArrayCollection = new ArrayCollection();
		/// Keyword
		public static var lomGKeyword:ArrayCollection = new ArrayCollection();				
		/// Coverage
		public static var lomGCoverage:ArrayCollection = new ArrayCollection();
		/// Structure
		public static var lomGStructure:ArrayCollection = new ArrayCollection();
		/// Aggregation Level
		public static var lomGAggregationLevel:ArrayCollection = new ArrayCollection();
		
		// Life Cycle
		/// Version
		public static var lomLVersion:ArrayCollection = new ArrayCollection();
		/// Status
		public static var lomLStatus:ArrayCollection = new ArrayCollection();
		/// Contribute
		public static var lomLContribute:ArrayCollection = new ArrayCollection();
		
		// Meta-Metadata
		/// Identifier
		public static var lomMIdentifier:ArrayCollection = new ArrayCollection();
		/// Contribute
		public static var lomMContribute:ArrayCollection = new ArrayCollection();
		/// MetadataSchema
		public static var lomMMetadataSchema:ArrayCollection = new ArrayCollection();
		/// Language
		public static var lomMLanguage:ArrayCollection = new ArrayCollection();
		
		// Technical
		/// Format
		public static var lomTFormat:ArrayCollection = new ArrayCollection();
		/// Size
		public static var lomTSize:ArrayCollection = new ArrayCollection();
		/// Location
		public static var lomTLocation:ArrayCollection = new ArrayCollection();
		/// Requirement
		public static var lomTRequirement:ArrayCollection = new ArrayCollection();			
		/// Installation Remarks
		public static var lomTInstallationRemarks:ArrayCollection = new ArrayCollection();
		/// Other Platform Requirements
		public static var lomTOtherPlatformRequirements:ArrayCollection = new ArrayCollection();
		/// Duration
		public static var lomTDuration:ArrayCollection = new ArrayCollection();		
		
		// Educational
		public static var lomEEducational:ArrayCollection = new ArrayCollection();
		
		// Rights
		/// Cost
		public static var lomRCost:ArrayCollection = new ArrayCollection();
		/// Copyright And Other Restrictions
		public static var lomRCopyrightAndOtherRestrictions:ArrayCollection = new ArrayCollection();
		/// Descriotion
		public static var lomRDescription:ArrayCollection = new ArrayCollection();

		// Relation
		public static var lomRRelation:ArrayCollection = new ArrayCollection();
	}
}