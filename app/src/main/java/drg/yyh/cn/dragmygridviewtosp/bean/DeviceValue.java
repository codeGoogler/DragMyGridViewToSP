package drg.yyh.cn.dragmygridviewtosp.bean;

/**
 * 类功能描述：</br>
 *  DeviceValue类设备管理实体类
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2017-07-19</br> 修改备注：</br>
 */

public class DeviceValue implements BaseModel {
    private String devieName;
    private int deviceImg;
    private int statusIndex;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevieName() {
        return devieName;
    }

    public void setDevieName(String devieName) {
        this.devieName = devieName;
    }

    public int getDeviceImg() {
        return deviceImg;
    }

    public void setDeviceImg(int deviceImg) {
        this.deviceImg = deviceImg;
    }



    public int getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(int statusIndex) {
        this.statusIndex = statusIndex;
    }

    @Override
    public void parse() {

    }
}
