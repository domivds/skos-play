package fr.sparna.rdf.skos.toolkit;

import java.util.HashMap;

import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQueryResultHandlerException;

import fr.sparna.rdf.sesame.toolkit.query.SelectSparqlHelperBase;
import fr.sparna.rdf.sesame.toolkit.query.builder.SparqlQueryBuilderIfc;


/**
 * Return the list of all concepts without a broader, optionally ordered by their label in a given language.
 * 
 * @author Thomas Francart
 */
@SuppressWarnings("serial")
public abstract class GetConceptsWithNoBroaderHelper extends SelectSparqlHelperBase {
	
	/**
	 * @param orderByLang a 2-letters ISO-code of a language to order the list on the labels of this language,
	 * or null to disable ordering. 
	 */
	public GetConceptsWithNoBroaderHelper(String orderByLang) {
		super(new QueryBuilder(orderByLang, false));
	}
	
	public GetConceptsWithNoBroaderHelper(String orderByLang, final java.net.URI conceptScheme) {
		super(
				new QueryBuilder(orderByLang, ((conceptScheme != null)?true:false)),
				new HashMap<String, Object>() {{					
					if(conceptScheme != null) {
						// put("additionalCriteriaPredicate", (new ValueFactoryImpl()).createLiteral(SKOS.IN_SCHEME));
						put("additionalCriteriaObject", conceptScheme);
					}
				}}
		);
	}

	@Override
	public void handleSolution(BindingSet binding)
	throws TupleQueryResultHandlerException {
		Resource noBroader = (Resource)binding.getValue("concept");
		this.handleConceptWithNoBroader(noBroader);
	}
	
	protected abstract void handleConceptWithNoBroader(Resource noBroader)
	throws TupleQueryResultHandlerException;
	
	public static class QueryBuilder implements SparqlQueryBuilderIfc {

		private String orderByLang = null;
		private boolean additionalCriteria = false;

		public QueryBuilder(String orderByLang, boolean additionalCriteria) {
			super();
			this.orderByLang = orderByLang;
			this.additionalCriteria = additionalCriteria;
		}

		/**
		 * TODO : test also on narrowers
		 */
		@Override
		public String getSPARQL() {
			String sparql = "" +
					"SELECT DISTINCT ?concept"+"\n" +
					"WHERE {"+"\n" +
					"	?concept a <"+SKOS.CONCEPT+"> ."+"\n" +
					"	"+((this.additionalCriteria)?"   ?concept ?additionalCriteriaPredicate ?additionalCriteriaObject .":"")+"\n" +
					"	OPTIONAL { ?concept <"+SKOS.BROADER+">|^<"+SKOS.NARROWER+"> ?broader }"+"\n"+
					"	FILTER(!bound(?broader))"+"\n"+
					(
							(this.orderByLang != null)?
							"	OPTIONAL { ?concept <"+SKOS.PREF_LABEL+"> ?prefLabel . FILTER(langMatches(lang(?prefLabel), '"+this.orderByLang+"'))}"+"\n" +
							"}" +
							" ORDER BY ?prefLabel"
							:
							"}"
					);
					
			return sparql;
		}

	}
	
}
