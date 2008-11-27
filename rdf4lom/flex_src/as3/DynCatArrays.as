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
	}
}