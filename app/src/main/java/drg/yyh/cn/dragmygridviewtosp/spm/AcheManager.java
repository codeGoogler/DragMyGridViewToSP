package drg.yyh.cn.dragmygridviewtosp.spm;

import android.content.Context;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import drg.yyh.cn.dragmygridviewtosp.bean.ChannelItem;
import drg.yyh.cn.dragmygridviewtosp.bean.DeviceValue;

/**
 * 类功能描述：</br>
 * 数据库管理类
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2017-07-19</br> 修改备注：</br>
 */
public class AcheManager {
    private static  final String DEVICE_NAME_KEY = "com.yyh.mode.device.save";
    private static ACache aCache;
    private static  final String CHANNELITEM_KEY = "com.yyh.mode.channelitem.save";
    private static final AtomicReference<AcheManager> INSTANCE = new AtomicReference<AcheManager>();

    private AcheManager(){}
    //单例模式
    public static  AcheManager getInstance() {
        for (;;) {
            AcheManager current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new AcheManager();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }
    /**
     * 保存设备的model
     * @param context
     * @param modelList 要存放的list集合
     */
    public ArrayList<DeviceValue> saveDeviceValue(Context context, ArrayList<DeviceValue> modelList){
        if(aCache == null){
            aCache = ACache.get(context);

        }
        aCache.remove(DEVICE_NAME_KEY);
        aCache.put(DEVICE_NAME_KEY, modelList);
        return modelList;
    }
    /**
     * 获取设备的model
     * @param context
     */
    public    ArrayList<DeviceValue> getDeviceValue(Context context){
        if(aCache == null){
            aCache = ACache.get(context);
        }
        ArrayList<DeviceValue> modelList = (ArrayList<DeviceValue>) aCache.getAsObject(DEVICE_NAME_KEY);
        if(modelList == null) {
            modelList = new ArrayList<>();
        }
        return modelList;
    }
    /**
     * 保存设备的model
     * @param context
     * @param modelList 要存放的list集合
     */
    public ArrayList<ChannelItem> saveChannelItemUserValue(Context context, ArrayList<ChannelItem> modelList){
        if(aCache == null){
            aCache = ACache.get(context);

        }
        aCache.remove(CHANNELITEM_KEY);
        aCache.put(CHANNELITEM_KEY, modelList);
        return modelList;
    }
    /**
     * 获取设备的model
     * @param context
     */
    public    ArrayList<ChannelItem> getChannelItemUserValue(Context context){
        if(aCache == null){
            aCache = ACache.get(context);
        }
        ArrayList<ChannelItem> modelList = (ArrayList<ChannelItem>) aCache.getAsObject(CHANNELITEM_KEY);
        if(modelList == null) {
            modelList = new ArrayList<>();
        }
        return modelList;
    }
    /**
     * 保存设备的model
     * @param context
     * @param modelList 要存放的list集合
     */
    public ArrayList<ChannelItem> saveChannelItemOtherValue(Context context, ArrayList<ChannelItem> modelList){
        if(aCache == null){
            aCache = ACache.get(context);

        }
        aCache.remove(CHANNELITEM_KEY);
        aCache.put(CHANNELITEM_KEY, modelList);
        return modelList;
    }
    /**
     * 获取设备的model
     * @param context
     */
    public    ArrayList<ChannelItem> getChannelItemOtherValue(Context context){
        if(aCache == null){
            aCache = ACache.get(context);
        }
        ArrayList<ChannelItem> modelList = (ArrayList<ChannelItem>) aCache.getAsObject(CHANNELITEM_KEY);
        if(modelList == null) {
            modelList = new ArrayList<>();
        }
        return modelList;
    }


}
