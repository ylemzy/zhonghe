package application.fetch;

public interface Template {

	Category category() throws Exception;

	Response page(Request request) throws Exception;

	Response item(Request request) throws Exception;

	Response process(Request request) throws Exception;

	void start(Category category) throws Exception;

	void start() throws Exception;

	String webId();

	String rootUrl();

	//just for test template's functions
	void testFetch() throws Exception;
}
