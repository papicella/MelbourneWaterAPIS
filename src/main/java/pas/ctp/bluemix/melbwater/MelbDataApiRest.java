package pas.ctp.bluemix.melbwater;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/melbdata")
public class MelbDataApiRest
{
    private static final Logger log = LoggerFactory.getLogger(MelbDataApiRest.class);
    RestTemplate restTemplate = new RestTemplate();

    @ApiOperation(value = "pedCount", nickname = "pedCount")
    @RequestMapping(method = RequestMethod.GET, path="/pedcount/{sensor_id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String listPedCount
            (@PathVariable String sensor_id)
    {
        return Utils.getPedCount(sensor_id);
    }

    @ApiOperation(value = "sensorlocations", nickname = "sensorlocations")
    @RequestMapping(method = RequestMethod.GET, path="/sensorlocations")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String sensorLocations()
    {
        return Utils.getSensorLocations();
    }
}
