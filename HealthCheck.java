


@Component
public class HealthCheck implements HealthIndicator {
  
    @Override
    public Health health() {

	URL siteURL = new URL("https://www.abhishekpal1814.com");


        int errorCode = check(); 
        if (errorCode != 0) {
            return Health.down()
              .withDetail("Error Code", "website is not available").build();
        }
        return Health.up().build();
    }
     
    public int check(URL siteURL) {
	
	HttpURLConnection connection = (HttpURLConnection)siteURL.openConnection();
	connection.setRequestMethod("GET");
	connection.connect();
	int code = connection.getResponseCode();
	
	if(code == 200)
		{
			return 0;
		}
		else {
			return 1;
		}
       
    }
}