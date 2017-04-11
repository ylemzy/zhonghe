package application.fetch;

import application.uil.HashUtil;

public class TemplateHelper {

	public static Request firstPageRequest(String url, String categoryName, String webId){
		return new Request(url, Request.Type.PAGE,
				CATEGORY_ATT, categoryName,
				FIRST_PAGE_ATT, true).setWebId(webId);
	}

	public static Request newsRequest(String url, String categoryName, String webId){
		return new Request(url, Request.Type.NEWS,
				CATEGORY_ATT, categoryName).setWebId(webId);
	}

	public static Request newsRequest(String url, Request parent){
		return new Request(url, Request.Type.NEWS,
				CATEGORY_ATT, getCategoryAtt(parent)).setWebId(parent.getWebId());
	}

	public static Request pageRequest(String url, String categoryName, String webId){
		return new Request(url, Request.Type.PAGE,
				CATEGORY_ATT, categoryName).setWebId(webId);
	}

	public static Request pageRequest(String url, Request parent){
		return new Request(url, Request.Type.PAGE,
				CATEGORY_ATT, getCategoryAtt(parent)).setWebId(parent.getWebId());
	}

	public static String makeNewsId(String url, String webId){
		return HashUtil.MD5(url + webId) + "_" + webId;
	}

	public static boolean isNews(Request request){
		return request.getType() == Request.Type.NEWS;
	}

	public static boolean isPage(Request request){
		return request.getType() == Request.Type.PAGE;
	}

	public static boolean isFirstPage(Request request){
		return request.attr(FIRST_PAGE_ATT) != null;
	}

	public static String getCategoryAtt(Request request){
		return request.attr(CATEGORY_ATT);
	}

	private static String CATEGORY_ATT = "category";
	private static String FIRST_PAGE_ATT = "fp";

}
