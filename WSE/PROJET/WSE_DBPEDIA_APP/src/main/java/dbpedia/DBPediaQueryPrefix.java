package dbpedia;

/**
 * Created by sce on 09.01.2015.
 */
public enum DBPediaQueryPrefix {

    DB("PREFIX db: <http://dbpedia.org/resource/>"),
    ONTOLOGY("PREFIX onto: <http://dbpedia.org/ontology/>"),
    RDF("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"),
    RDFS("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"),
    FOAF("PREFIX foaf: <http://xmlns.com/foaf/0.1/>"),
    DBPEDIA("PREFIX dbpedia: <http://dbpedia.org/>"),
    DBPEDIA_PROP("PREFIX dbpprop: <http://dbpedia.org/property/>"),
    DC("PREFIX dc: <http://purl.org/dc/elements/1.1/>"),
    SKOS("PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"),
    YAGO("PREFIX yago: <http://dbpedia.org/class/yago/>"),
    DBPEDIA_RESSOURCE("PREFIX : <http://dbpedia.org/resource/>"),
    OWL("PREFIX dbpedia-owl: <http://www.w3.org/2002/07/owl#>"),
    XSD("PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>");

    public String prefix;

    DBPediaQueryPrefix(String prefix){
        this.prefix = prefix;
    }
}
