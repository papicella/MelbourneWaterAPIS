package pas.ctp.bluemix.melbwater.beans;

public class PedCount
{
    private String dateAndTime;
    private String pedCount;
    private String sensorId;
    private String sensorName;

    public PedCount() {
    }

    public PedCount(String dateAndTime, String pedCount, String sensorId, String sensorName) {
        this.dateAndTime = dateAndTime;
        this.pedCount = pedCount;
        this.sensorId = sensorId;
        this.sensorName = sensorName;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getPedCount() {
        return pedCount;
    }

    public void setPedCount(String pedCount) {
        this.pedCount = pedCount;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    @Override
    public String toString() {
        return "PedCount{" +
                "dateAndTime='" + dateAndTime + '\'' +
                ", pedCount='" + pedCount + '\'' +
                ", sensorId='" + sensorId + '\'' +
                ", sensorName='" + sensorName + '\'' +
                '}';
    }
}
