package pas.ctp.bluemix.melbwater.beans;

public class Sensor
{
    private String sensorId;
    private String sensorloc;
    private String loctype;
    private String status;

    public Sensor()
    {
    }

    public Sensor(String sensorId, String sensorloc, String loctype, String status) {
        this.sensorId = sensorId;
        this.sensorloc = sensorloc;
        this.loctype = loctype;
        this.status = status;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorloc() {
        return sensorloc;
    }

    public void setSensorloc(String sensorloc) {
        this.sensorloc = sensorloc;
    }

    public String getLoctype() {
        return loctype;
    }

    public void setLoctype(String loctype) {
        this.loctype = loctype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorId=" + sensorId +
                ", sensorloc='" + sensorloc + '\'' +
                ", loctype='" + loctype + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
