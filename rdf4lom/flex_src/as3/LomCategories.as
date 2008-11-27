package as3
{
	[Bindable]
	[RemoteClass(alias="fr.slcms.rdf4lom.LomCategories")]
	public class LomCategories
	{
		// General
		public var lomGIdentifier:Array = new Array();
		public var lomGTitle:Array = new Array();
		public var lomGLanguage:Array = new Array();
		public var lomGDescription:Array = new Array();
		public var lomGKeyword:Array = new Array();
		public var lomGCoverage:Array = new Array();
		public var lomGStructure:Array = new Array();
		public var lomGAggregationLevel:Array = new Array();
		
		// Life Cycle
		public var lomLVersion:Array = new Array();
		public var lomLStatus: Array = new Array();
		public var lomLContribute: Array = new Array();	
		
		// Meta-Metadata
		public var lomMIdentifier:Array = new Array();	
		public var lomMContribute:Array = new Array();
		public var lomMMetadataSchema:Array = new Array();
		public var lomMLanguage:Array = new Array();
	}
}