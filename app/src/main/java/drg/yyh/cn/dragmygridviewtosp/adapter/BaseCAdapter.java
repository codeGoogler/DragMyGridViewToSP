package drg.yyh.cn.dragmygridviewtosp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import drg.yyh.cn.dragmygridviewtosp.bean.DeviceValue;

/**
 * 类功能描述：</br>
 *  adapter基类
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2017-07-19</br> 修改备注：</br>
 */
public abstract class BaseCAdapter<T> extends BaseAdapter{
    List<T> list;
    private Context context;
    public  BaseCAdapter( Context context,List<T> list){
        this.list =list;
        this.context =context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public   void exchange(int dragPostion, int dropPostion){};
    public   void setShowDropItem(boolean show){};

}
