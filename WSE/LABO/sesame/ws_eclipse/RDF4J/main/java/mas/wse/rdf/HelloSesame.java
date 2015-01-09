package mas.wse.rdf;

import java.io.File;

import info.aduna.iteration.Iterations;

import org.omg.CORBA.RepositoryIdHelper;
import org.openrdf.model.Model;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.LinkedHashModel;
import org.openrdf.model.vocabulary.FOAF;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.openrdf.model.vocabulary.XMLSchema;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.RepositoryResult;
import org.openrdf.repository.config.RepositoryConfigException;
import org.openrdf.repository.manager.RemoteRepositoryManager;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.Rio;
import org.openrdf.sail.memory.MemoryStore;

public class HelloSesame {

	static RepositoryConnection connection;
	
	public static void main(String[] args) throws RepositoryException, RDFHandlerException, RepositoryConfigException {
		/*
		Repository rep = new SailRepository(new MemoryStore());
		rep.initialize();
		*/
		Repository rep = initializeRepoRemote();
		connection = rep.getConnection();

		String namespace = "http://eia-fr.ch/";
		ValueFactory fctory = rep.getValueFactory();
		
		URI seb = fctory.createURI(namespace,"Seb");
		connection.add(seb, RDF.TYPE, FOAF.PERSON);
		connection.add(seb, RDFS.LABEL,fctory.createLiteral("Seb",XMLSchema.STRING));
		
		URI dave = fctory.createURI(namespace,"Dave");
		connection.add(dave, RDF.TYPE, FOAF.PERSON);
		connection.add(dave, RDFS.LABEL,fctory.createLiteral("Dave",XMLSchema.STRING));
		
		
		
		//getRepo();
		
		connection.close();
		
	}
	
	static void getRepo() throws RepositoryException, RDFHandlerException{
		RepositoryResult<Statement> comptes = connection.getStatements(null, null,null, true);
		
		while(comptes.hasNext()){
			
			System.out.println(comptes.next());
		}
		
		Model model = Iterations.addAll(comptes, new LinkedHashModel());
		model.setNamespace("rdf",RDF.NAMESPACE);
		model.setNamespace("rdfs",RDFS.NAMESPACE);
		model.setNamespace("xsd",XMLSchema.NAMESPACE);
		model.setNamespace("foaf",FOAF.NAMESPACE);
		model.setNamespace("http://eia-fr.ch","http://eia-fr.ch");
		Rio.write(model, System.out, RDFFormat.TURTLE);
	}
	
	static Repository initializeRepoLocal() throws RepositoryException{
		File datas = new File("datas");
		Repository repo = new SailRepository(new MemoryStore(datas));
		repo.initialize();
		return repo;
		
	}
	
	static Repository initializeRepoRemote() throws RepositoryException, RepositoryConfigException{
		String serverUrl = "http://localhost:8080/openrdf-sesame";
		RemoteRepositoryManager manager = new RemoteRepositoryManager(serverUrl);
		manager.initialize();
		
		Repository repo = manager.getRepository("MAS_WSE");
		repo.initialize();
		return repo;
		
	}
	
	

}