package pas.ctp.bluemix.melbwater;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Utils
{

    public static String getSensorLocations()
    {
        String url = "https://data.melbourne.vic.gov.au/resource/ygaw-6rzq.json";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<String> response = null;

        response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String result = response.getBody();

        return result;
    }

    public static String getPedCount(String sensorId)
    {
        String url = "https://data.melbourne.vic.gov.au/resource/mxb8-wn4w.json?sensor_id=%s";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<String> response = null;

        response =
                restTemplate.exchange(String.format
                        (url, sensorId), HttpMethod.GET, entity, String.class);

        String result = response.getBody();

        return result;
    }
}
