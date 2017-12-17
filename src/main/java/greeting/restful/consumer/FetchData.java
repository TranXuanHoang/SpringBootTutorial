package greeting.restful.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FetchData {
	private static final Logger log = LoggerFactory.getLogger(FetchData.class);

	@RequestMapping(value="/fetch-api-data")
	public Quote fetchData() {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

		log.info(quote.toString());

		return quote;
	}
}