#
# Generates the skos:inScheme on skos:Concept
#
# @title skos:inScheme on skos:Concept
# @author Thomas Francart
# @tag dataset
#
PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX owl:  <http://www.w3.org/2002/07/owl#>
PREFIX skos: <http://www.w3.org/2004/02/skos/core#>
PREFIX xl:   <http://www.w3.org/2008/05/skos-xl#>
PREFIX dcat: <http://www.w3.org/ns/dcat#>
PREFIX dct:  <http://purl.org/dc/terms/>
PREFIX dc:   <http://purl.org/dc/elements/1.1/>
PREFIX vcard:<http://www.w3.org/2006/vcard/ns#>


INSERT {
	?x skos:inScheme ?o .
} WHERE {
	{
		{ ?x a owl:Class . }
		UNION
		{ ?x a rdfs:Class . }
	}
	?o a owl:Ontology .
	# Exclude OWL restrictions, etc.
	FILTER(!isBlank(?x)) .
}