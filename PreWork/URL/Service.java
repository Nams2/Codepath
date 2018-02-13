

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;


@Path("/")
public class Service {

	private static final String symbols = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom random = new SecureRandom();
	
	protected Map<String, E> container = new HashMap<>();

	@GET
	@Path("/{shortUrl}")
	public Response redirect(@Context UriInfo uriInfo, @PathParam("shortUrl") String shortUrl) {
		URLInfo urlInfo = getByShortUrl(uriInfo.getBaseUri() + shortUrl);
		if (urlInfo != null) {
			//return Response.seeOther(URI.create(urlInfo.getUrl())).status(urlInfo.getRedirectType()).build();
			Response.status(201).entity(Helper.generateURLResponse(urlInfo.getShortUrl())).build();
			return Response.status(302).build();
		}

		return Response.status(404).build();
	}

	public URLInfo getByShortUrl(String shortUrl) {
		for (String key : container.keySet())
			if (container.get(key).getShortUrl().equals(shortUrl))
				return container.get(key);
		return null;
	}

	public static String generateURLResponse(String shortUrl) {
		return "{\"shortUrl\":\"" + shortUrl + "\"}";
	}

	public void createURL(URLInfo urlInfo) {
		conatiner.put(urlInfo.getUrl(), urlInfo);
		QueryRunner.update("insert into URLS (URL, SHORT_URL) " +
				"values (\"" + urlInfo.getUrl() + "\",\"" + urlInfo.getShortUrl() + "\")");
	}

	public static String generateStatisticResponse(Map<String, URLInfo> urls) {
		StringBuilder sb = new StringBuilder("{");
		for (String key : urls.keySet())
			sb.append("\"").append(urls.get(key).getUrl()).append("\":\"").append(urls.get(key).getCounter())
					.append("\",");

		return sb.length() == 1 ? "" : sb.deleteCharAt(sb.length() - 1).append("}").toString();
	}

	public static String generateRandomString(Integer len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(symbols.charAt(random.nextInt(symbols.length())));

		return sb.toString();
	}

	@POST
	@Path("/{url}/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAccount(@Context UriInfo uriInfo, @PathParam("url") String url, @PathParam("id") String id) {

		URLInfo existing = container.get(url);

		if (existing == null) {
			urlInfo.setShortUrl(uriInfo.getBaseUri() + generateRandomString(6));
			urlInfo.setUrl(url);
			createURL(urlInfo);
			return Response.status(201).entity(generateURLResponse(urlInfo.getShortUrl())).build();
		} else if(conatiner.containsKey(id)) {
			return Response.status(409).entity(generateURLResponse(urlInfo.getShortUrl())).build();
		} else {
			return Response.status(429).entity(generateURLResponse(urlInfo.getShortUrl())).build();
		}
	}

}
