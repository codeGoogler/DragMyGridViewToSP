package drg.yyh.cn.dragmygridviewtosp.provider;

import android.content.Context;

import java.util.ArrayList;

import drg.yyh.cn.dragmygridviewtosp.R;
import drg.yyh.cn.dragmygridviewtosp.bean.ChannelItem;
import drg.yyh.cn.dragmygridviewtosp.bean.DeviceValue;
import drg.yyh.cn.dragmygridviewtosp.spm.AcheManager;

/**
 * Created by Administrator on 2017/7/19/019.
 */
public class ServiceData {

    public static ArrayList<ChannelItem> loadUserList() {
        ArrayList<ChannelItem>  defaultUserChannels = new ArrayList<ChannelItem>();

        defaultUserChannels.add(new ChannelItem(1, "终端", 1, 1));
        defaultUserChannels.add(new ChannelItem(2, "研发部", 2, 1));
        defaultUserChannels.add(new ChannelItem(3, "于亚豪", 3, 1));
        defaultUserChannels.add(new ChannelItem(4, "娱乐", 4, 1));
        defaultUserChannels.add(new ChannelItem(5, "科技", 5, 1));
        defaultUserChannels.add(new ChannelItem(6, "体育", 6, 1));
        defaultUserChannels.add(new ChannelItem(7, "军事", 7, 1));
        return defaultUserChannels;

    }

    public static ArrayList<ChannelItem> loadOtherList(){
        ArrayList<ChannelItem>  defaultOtherChannels = new ArrayList<ChannelItem>();
        defaultOtherChannels.add(new ChannelItem(8, "财经", 1, 0));
        defaultOtherChannels.add(new ChannelItem(9, "汽车", 2, 0));
        defaultOtherChannels.add(new ChannelItem(10, "房产", 3, 0));
        defaultOtherChannels.add(new ChannelItem(11, "社会", 4, 0));
        defaultOtherChannels.add(new ChannelItem(12, "情感", 5, 0));
        defaultOtherChannels.add(new ChannelItem(13, "女人", 6, 0));
        defaultOtherChannels.add(new ChannelItem(14, "旅游", 7, 0));
        defaultOtherChannels.add(new ChannelItem(15, "健康", 8, 0));
        defaultOtherChannels.add(new ChannelItem(16, "美女", 9, 0));
        defaultOtherChannels.add(new ChannelItem(17, "游戏", 10, 0));
        defaultOtherChannels.add(new ChannelItem(18, "数码", 11, 0));
        return defaultOtherChannels;
    }

    /**
     * 获取要保存的数据
     */
    private static  ArrayList<DeviceValue>  saveDeviceValueList(){
        ArrayList<DeviceValue> list  = new ArrayList<>();

        DeviceValue deviceValue1 = new DeviceValue();
        deviceValue1.setDevieName("血压");
        deviceValue1.setStatusIndex(0);
        deviceValue1.setDeviceImg(R .drawable.small_blood_press);
        list.add(deviceValue1);

        DeviceValue deviceValue2 = new DeviceValue();
        deviceValue2.setDevieName("血糖");
        deviceValue2.setStatusIndex(1);
        deviceValue2.setDeviceImg(R.drawable.small_blood_sugar);
        list.add(deviceValue2);

        DeviceValue deviceValue3 = new DeviceValue();
        deviceValue3.setDevieName("体脂称");
        deviceValue3.setStatusIndex(2);
        deviceValue3.setDeviceImg(R.drawable.small_bodyfat);
        list.add(deviceValue3);

        DeviceValue deviceValue4 = new DeviceValue();
        deviceValue4.setDevieName("手环");
        deviceValue4.setStatusIndex(3);
        deviceValue4.setDeviceImg(R.drawable.small_brecelt);
        list.add(deviceValue4);

        DeviceValue deviceValue5= new DeviceValue();
        deviceValue5.setDevieName("血氧");
        deviceValue5.setStatusIndex(4);
        deviceValue5.setDeviceImg(R.drawable.small_oxygen);
        list.add(deviceValue5);


        DeviceValue deviceValue6= new DeviceValue();
        deviceValue6.setDevieName("体温");
        deviceValue6.setDeviceImg(R.drawable.small_teleperature);
        deviceValue6.setStatusIndex(5);
        list.add(deviceValue6);

        DeviceValue deviceValue7 = new DeviceValue();
        deviceValue7.setDevieName("心电图");
        deviceValue7.setStatusIndex(6);
        deviceValue7.setDeviceImg(R.drawable.small_heart_map);
        list.add(deviceValue7);

        DeviceValue deviceValue8 = new DeviceValue();
        deviceValue8.setDevieName("尿检");
        deviceValue8.setStatusIndex(7);
        deviceValue8.setDeviceImg(R.drawable.small_urine);
        list.add(deviceValue8);

        DeviceValue deviceValue9 = new DeviceValue();
        deviceValue9.setDevieName("汗液");
        deviceValue9.setStatusIndex(8);
        deviceValue9.setDeviceImg(R.drawable.small_sweat);
        list.add(deviceValue9);

        DeviceValue deviceValue10= new DeviceValue();
        deviceValue10.setDevieName("心率带");
        deviceValue10.setStatusIndex(9);
        deviceValue10.setDeviceImg(R.drawable.small_heart_rate);
        list.add(deviceValue10);

        DeviceValue deviceValue11= new DeviceValue();
        deviceValue11.setDevieName("体重称");
        deviceValue11.setStatusIndex(10);
        deviceValue11.setDeviceImg(R.drawable.small_body_height_and_weight);
        list.add(deviceValue11);

        return  list;
    }

    /**
     * 先判断有没有数据，没有从网络上去请求
     * @param context
     * @return
     */
    public  static   ArrayList<DeviceValue> dealDeviceList(Context context){
        ArrayList<DeviceValue> list =  AcheManager.getInstance().getDeviceValue(context);
        if(list == null || list.size() == 0 ){
            list =   AcheManager.getInstance().saveDeviceValue(context,saveDeviceValueList());
        }
        return list;
    }

    public  static   ArrayList<DeviceValue> getRefreshDeviceList(Context context){
        ArrayList<DeviceValue> list =  AcheManager.getInstance().getDeviceValue(context);
        if(list == null || list.size() == 0 ){
            list =   AcheManager.getInstance().saveDeviceValue(context,saveDeviceValueList());
        }
        ArrayList<DeviceValue> listRefresh = new ArrayList<>();
        listRefresh.addAll(list.subList(0,4));
        DeviceValue deviceValue = new DeviceValue();
        deviceValue.setDevieName("更多");
        deviceValue.setDeviceImg(R.drawable.small_query_more);
        deviceValue.setType("queryMore");
        listRefresh.add(deviceValue);
        return listRefresh;
    }

    /**
     * 先判断有没有数据，没有从网络上去请求
     * @param context
     * @return
     */
    public static ArrayList<ChannelItem> dealChannelItemUserList(Context context){
        ArrayList<ChannelItem> list =  AcheManager.getInstance().getChannelItemUserValue(context);
        if(list == null || list.size() == 0 ){
            list =   AcheManager.getInstance().saveChannelItemUserValue(context,loadUserList());
        }
        return list;
    }
    /**
     * 先判断有没有数据，没有从网络上去请求
     * @param context
     * @return
     */
    public  static ArrayList<ChannelItem> dealChannelItemOtherList(Context context){
        ArrayList<ChannelItem> list =  AcheManager.getInstance().getChannelItemOtherValue(context);
        if(list == null || list.size() == 0 ){
            list =   AcheManager.getInstance().saveChannelItemOtherValue(context,loadUserList());
        }
        return list;
    }

    /*public  static   ArrayList<ChannelItem> getRefreshChannelItemList(Context context){
        ArrayList<ChannelItem> list =  AcheManager.getInstance().getChannelItemValue(context);
        if(list == null || list.size() == 0 ){
            list =   AcheManager.getInstance().saveChannelItemValue(context,loadOtherList());
        }
        ArrayList<ChannelItem> listRefresh = new ArrayList<>();
        listRefresh.addAll(list.subList(0,4));
        return listRefresh;
    }*/
}
