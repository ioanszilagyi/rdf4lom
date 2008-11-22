/*
	This class is used to store all the static array collection variables 
	related to LOM Categories. 
*/
package as3
{
	import mx.collections.ArrayCollection;
	
	public final class DynCatArrays
	{
		public function DynCatArrays()
		{
			lomGIdentifier = new ArrayCollection();
			lomGTitle = new ArrayCollection();
			lomGLanguage = new ArrayCollection();
			lomGDescription = new ArrayCollection();
			lomGKeyword = new ArrayCollection();
			lomGCoverage = new ArrayCollection();
			lomGStructure = new ArrayCollection();
			lomGAggregationLevel = new ArrayCollection();
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
	}
}