
package td_ws_sopa_consummer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the td_ws_sopa_consummer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloResponse_QNAME = new QName("http://blog.wsj.ict.mas/", "helloResponse");
    private final static QName _RemoveAuthor_QNAME = new QName("http://blog.wsj.ict.mas/", "removeAuthor");
    private final static QName _ListAuthors_QNAME = new QName("http://blog.wsj.ict.mas/", "listAuthors");
    private final static QName _Hello_QNAME = new QName("http://blog.wsj.ict.mas/", "hello");
    private final static QName _ListMessagesResponse_QNAME = new QName("http://blog.wsj.ict.mas/", "listMessagesResponse");
    private final static QName _ListAuthorsResponse_QNAME = new QName("http://blog.wsj.ict.mas/", "listAuthorsResponse");
    private final static QName _AddAuthorResponse_QNAME = new QName("http://blog.wsj.ict.mas/", "addAuthorResponse");
    private final static QName _ListMessages_QNAME = new QName("http://blog.wsj.ict.mas/", "listMessages");
    private final static QName _AddAuthor_QNAME = new QName("http://blog.wsj.ict.mas/", "addAuthor");
    private final static QName _RemoveAuthorResponse_QNAME = new QName("http://blog.wsj.ict.mas/", "removeAuthorResponse");
    private final static QName _AddMessage_QNAME = new QName("http://blog.wsj.ict.mas/", "addMessage");
    private final static QName _RemoveMessageResponse_QNAME = new QName("http://blog.wsj.ict.mas/", "removeMessageResponse");
    private final static QName _RemoveMessage_QNAME = new QName("http://blog.wsj.ict.mas/", "removeMessage");
    private final static QName _AddMessageResponse_QNAME = new QName("http://blog.wsj.ict.mas/", "addMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: td_ws_sopa_consummer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListAuthorsResponse }
     * 
     */
    public ListAuthorsResponse createListAuthorsResponse() {
        return new ListAuthorsResponse();
    }

    /**
     * Create an instance of {@link AddAuthorResponse }
     * 
     */
    public AddAuthorResponse createAddAuthorResponse() {
        return new AddAuthorResponse();
    }

    /**
     * Create an instance of {@link ListMessages }
     * 
     */
    public ListMessages createListMessages() {
        return new ListMessages();
    }

    /**
     * Create an instance of {@link AddAuthor }
     * 
     */
    public AddAuthor createAddAuthor() {
        return new AddAuthor();
    }

    /**
     * Create an instance of {@link RemoveAuthorResponse }
     * 
     */
    public RemoveAuthorResponse createRemoveAuthorResponse() {
        return new RemoveAuthorResponse();
    }

    /**
     * Create an instance of {@link AddMessageResponse }
     * 
     */
    public AddMessageResponse createAddMessageResponse() {
        return new AddMessageResponse();
    }

    /**
     * Create an instance of {@link AddMessage }
     * 
     */
    public AddMessage createAddMessage() {
        return new AddMessage();
    }

    /**
     * Create an instance of {@link RemoveMessageResponse }
     * 
     */
    public RemoveMessageResponse createRemoveMessageResponse() {
        return new RemoveMessageResponse();
    }

    /**
     * Create an instance of {@link RemoveMessage }
     * 
     */
    public RemoveMessage createRemoveMessage() {
        return new RemoveMessage();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link RemoveAuthor }
     * 
     */
    public RemoveAuthor createRemoveAuthor() {
        return new RemoveAuthor();
    }

    /**
     * Create an instance of {@link ListAuthors }
     * 
     */
    public ListAuthors createListAuthors() {
        return new ListAuthors();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link ListMessagesResponse }
     * 
     */
    public ListMessagesResponse createListMessagesResponse() {
        return new ListMessagesResponse();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link Auteur }
     * 
     */
    public Auteur createAuteur() {
        return new Auteur();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "removeAuthor")
    public JAXBElement<RemoveAuthor> createRemoveAuthor(RemoveAuthor value) {
        return new JAXBElement<RemoveAuthor>(_RemoveAuthor_QNAME, RemoveAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAuthors }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "listAuthors")
    public JAXBElement<ListAuthors> createListAuthors(ListAuthors value) {
        return new JAXBElement<ListAuthors>(_ListAuthors_QNAME, ListAuthors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListMessagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "listMessagesResponse")
    public JAXBElement<ListMessagesResponse> createListMessagesResponse(ListMessagesResponse value) {
        return new JAXBElement<ListMessagesResponse>(_ListMessagesResponse_QNAME, ListMessagesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAuthorsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "listAuthorsResponse")
    public JAXBElement<ListAuthorsResponse> createListAuthorsResponse(ListAuthorsResponse value) {
        return new JAXBElement<ListAuthorsResponse>(_ListAuthorsResponse_QNAME, ListAuthorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "addAuthorResponse")
    public JAXBElement<AddAuthorResponse> createAddAuthorResponse(AddAuthorResponse value) {
        return new JAXBElement<AddAuthorResponse>(_AddAuthorResponse_QNAME, AddAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "listMessages")
    public JAXBElement<ListMessages> createListMessages(ListMessages value) {
        return new JAXBElement<ListMessages>(_ListMessages_QNAME, ListMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAuthor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "addAuthor")
    public JAXBElement<AddAuthor> createAddAuthor(AddAuthor value) {
        return new JAXBElement<AddAuthor>(_AddAuthor_QNAME, AddAuthor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAuthorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "removeAuthorResponse")
    public JAXBElement<RemoveAuthorResponse> createRemoveAuthorResponse(RemoveAuthorResponse value) {
        return new JAXBElement<RemoveAuthorResponse>(_RemoveAuthorResponse_QNAME, RemoveAuthorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "addMessage")
    public JAXBElement<AddMessage> createAddMessage(AddMessage value) {
        return new JAXBElement<AddMessage>(_AddMessage_QNAME, AddMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "removeMessageResponse")
    public JAXBElement<RemoveMessageResponse> createRemoveMessageResponse(RemoveMessageResponse value) {
        return new JAXBElement<RemoveMessageResponse>(_RemoveMessageResponse_QNAME, RemoveMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "removeMessage")
    public JAXBElement<RemoveMessage> createRemoveMessage(RemoveMessage value) {
        return new JAXBElement<RemoveMessage>(_RemoveMessage_QNAME, RemoveMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blog.wsj.ict.mas/", name = "addMessageResponse")
    public JAXBElement<AddMessageResponse> createAddMessageResponse(AddMessageResponse value) {
        return new JAXBElement<AddMessageResponse>(_AddMessageResponse_QNAME, AddMessageResponse.class, null, value);
    }

}
