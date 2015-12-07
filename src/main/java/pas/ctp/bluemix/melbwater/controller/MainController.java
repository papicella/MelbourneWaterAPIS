package pas.ctp.bluemix.melbwater.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pas.ctp.bluemix.melbwater.Utils;
import pas.ctp.bluemix.melbwater.beans.PedCount;
import pas.ctp.bluemix.melbwater.beans.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController
{
    protected static Logger logger = Logger.getLogger(MainController.class);
    private static final JsonParser parser = JsonParserFactory.getJsonParser();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSensors (Model model) throws Exception
    {
        String jsonString = Utils.getSensorLocations();

        List<Object> jsonList = parser.parseList(jsonString);
        List<Sensor> sensors = new ArrayList<Sensor>();

        for (Object item: jsonList)
        {
            Map m = (Map) item;
            sensors.add(new Sensor((String)m.get("sensorid"),
                                   (String)m.get("sensorloc"),
                                   (String)m.get("loctype"),
                                   (String)m.get("status")));

        }

        model.addAttribute("sensorsSize", sensors.size());
        model.addAttribute("sensors", sensors);

        return "main";
    }

    @RequestMapping(value = "/pedcount", method = RequestMethod.GET)
    public String showPedCount (Model model,
                                @RequestParam(value="sensorId") String sensorId) throws Exception
    {
        String jsonString = Utils.getPedCount(sensorId);

        List<Object> jsonList = parser.parseList(jsonString);
        List<PedCount> pedcounts = new ArrayList<PedCount>();

        for (Object item: jsonList)
        {
            Map m = (Map) item;
            pedcounts.add(new PedCount((String)m.get("daet_time"),
                                       (String)m.get("qv_market_peel_st"),
                                       (String)m.get("sensor_id"),
                                       (String)m.get("sensor_name")));
        }

        model.addAttribute("pedcountsSize", pedcounts.size());
        model.addAttribute("pedcounts", pedcounts);

        return "pedcount";
    }
}
