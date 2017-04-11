package application.fetch;

import application.run.RequestQueueRunner;
import application.uil.JsonHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public abstract class AbstractTemplate implements Template {

	final int tryTimes = 3;

	private static final Logger logger = LogManager.getLogger();

	public abstract Category category(Category root) throws Exception;

	protected abstract News itemRequest(Request request) throws Exception;

	protected abstract boolean pageRequest(Request request) throws Exception;

	public Category category() throws Exception {
		Category root = new Category("root", rootUrl(), webId());
		category(root);
		return root;
	}

	@Override
	public Response page(Request request) throws Exception {
		if (!TemplateHelper.isPage(request)){
			throw new Exception("Not an page request");
		}
		return process(request);
	}

	@Override
	public Response item(Request request) throws Exception {
		if (!TemplateHelper.isNews(request)){
			throw new Exception("Not an news request");
		}
		return process(request);
	}

	@Override
	public void start(Category category) throws Exception{
		if (category.hasChildren()) {
			for (Category c : category.getChildren()) {
				start(c);
			}
		} else {
			if (category.isFetchable()) {
				addRequest(TemplateHelper.firstPageRequest(category.getLink(), category.getName(), webId()));
			}
		}
	}

	@Override
	public void start() throws Exception{
		logger.info("Start {}", this.webId());
		start(category());
	}

	@Override
	public void testFetch() throws Exception {
		start();
		RequestQueueRunner.getQueue().pullRun();
	}

	protected void addRequest(Request request) {
		RequestQueueRunner queue = RequestQueueRunner.getQueue();
		if (queue != null){
			queue.addRequest(request);
		}else{
			logger.info("Add request : {}", JsonHelper.toJSON(request));
		}
	}

	@Override
	public Response process(Request request) throws Exception {
		Response response = new Response();
		Request.Type type = request.getType();
		logger.debug("process:[{}]-{}", type, request.getURL());

		switch (type) {
		case PAGE:
			response.setBody(this.pageRequest(request));
			break;
		case NEWS:
			response.setBody(this.itemRequest(request));
			break;
		default:
		}

		return response;
	}


	protected Document get(String url) throws Exception{
		return get(url, tryTimes);
	}

	protected Document get(String url, int trys) throws Exception {
		Connection connection = Jsoup.connect(url);
		try {
			return connection.get();
		} catch (IOException e) {
			logger.error(e.getMessage());
			if (ensureUnavailable(e)) {
				throw e;
			}
			if (--trys != 0) {
				return get(url, trys);
			}
			throw e;//throw the last try error
		}
	}

	private boolean ensureUnavailable(Exception e){
		HttpStatusException httpStatusException  = null;
		if (e.getCause() instanceof HttpStatusException) {
			httpStatusException = (HttpStatusException) e.getCause();

		}else if (e instanceof HttpStatusException){
			httpStatusException = (HttpStatusException)e;
		}

		if (httpStatusException != null){
			int code = httpStatusException.getStatusCode();
			switch (code){
				case 404:
				case 410:
				case 500:
				case 501:
					return true;
			}
		}
		return false;
	}

	public String addParameter(String url, String name, Object value) {
		int left = url.indexOf("?"), right = url.indexOf("#");
		if (left == -1) {
			if (right == -1) {
				url = url + "?" + name + "=" + value;
			} else {
				url = url.substring(0, right) + "?" + name + "=" + value + url.substring(right);
			}
		} else {
			if (right == -1) {
				url = url + "&" + name + "=" + value;
			} else {
				url = url.substring(0, right) + "&" + name + "=" + value + url.substring(right);
			}
		}
		return url;
	}

	public String setParameter(String url, String name, Object value) {
		int left = url.indexOf("?"), right = url.indexOf("#");
		StringBuffer sb = new StringBuffer();
		if (left == -1) {
			sb.append(url).append("?").append(name).append("=").append(value);
		} else {
			String prefix = url.substring(0, left + 1);
			String query = "";
			String suffix = "";
			sb.append(prefix);
			if (right != -1) {
				suffix = url.substring(right);
				query = url.substring(left + 1, right);
			} else {
				query = url.substring(left + 1);
			}

			if (Strings.isBlank(query)) {
				sb.append(name).append("=").append(value);
			} else {
				String[] parms = query.split("&");
				for (String p : parms) {
					if (!p.startsWith(name + "=")) {
						sb.append(p).append("&");
					}
				}
				sb.append(name).append("=").append(value);
			}
			sb.append(suffix);
		}
		return sb.toString();
	}

	/**
	 *
	 * @param url
	 * @param name
	 * @return
	 */
	public String getParameter(String url, String name) {
		int left = url.indexOf("?"), right = url.indexOf("#");
		if (left != -1) {
			String query = right == -1 ? url.substring(left + 1) : url.substring(left + 1, right);
			String[] parms = query.split("&");
			for (String p : parms) {
				if (p.startsWith(name + "=")) {
					return p.substring((name + "=").length());
				}
			}
		}
		return null;
	}
}
