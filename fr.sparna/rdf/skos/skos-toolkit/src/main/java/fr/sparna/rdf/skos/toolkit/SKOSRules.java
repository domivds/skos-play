package fr.sparna.rdf.skos.toolkit;

import java.util.Arrays;
import java.util.List;

import fr.sparna.rdf.sesame.toolkit.query.builder.SparqlQueryBuilder;
import fr.sparna.rdf.sesame.toolkit.query.builder.SparqlQueryBuilderList;

public class SKOSRules {

	public static List<String> LITE_RULESET = Arrays.asList(new String[] { 
			"rules/inferlite/S8.rq",
			"rules/inferlite/S7.rq",
			"rules/inferlite/S25.rq",
			"rules/inferlite/S22.rq",
			"rules/inferlite/S23.rq",
			"rules/inferlite/S26.rq",
			"rules/inferlite/S24-broader.rq",
			"rules/inferlite/S24-narrower.rq",
			"rules/inferlite/X1.rq",
	});
	
	public static List<String> OWL2SKOS_RULESET = Arrays.asList(new String[] { 
			"owl2skos/01-skos-Concept.ru",
			"owl2skos/02-skos-prefLabel.ru",
			"owl2skos/03-skos-broader-skos-narrower.ru",
			"owl2skos/04-skos-inScheme.ru",
			"owl2skos/05-skos-ConceptScheme.ru",
	});

	public static List<SparqlQueryBuilder> getRulesetLite() {
		return SparqlQueryBuilderList.fromResources(SKOSRules.class, LITE_RULESET);
	}
	
	public static List<SparqlQueryBuilder> getOWL2SKOSRuleset() {
		return SparqlQueryBuilderList.fromResources(SKOSRules.class, OWL2SKOS_RULESET);
	}
}
