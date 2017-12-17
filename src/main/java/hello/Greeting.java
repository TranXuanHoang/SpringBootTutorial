package hello;

/**
 * This class models a message used to response to
 * a /greeting request.
 * 
 * @author Tran Xuan Hoang
 */
public class Greeting {
	private final long id;

	private final String content;

	public Greeting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}