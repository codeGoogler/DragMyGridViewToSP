package drg.yyh.cn.dragmygridviewtosp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import drg.yyh.cn.dragmygridviewtosp.adapter.DragAdapter2;
import drg.yyh.cn.dragmygridviewtosp.bean.DeviceValue;
import drg.yyh.cn.dragmygridviewtosp.provider.ServiceData;
import drg.yyh.cn.dragmygridviewtosp.spm.AcheManager;
import drg.yyh.cn.dragmygridviewtosp.view.DragMyGridView;

/**
 * 类功能描述：</br>
 * 单个GridVie拖拽效果测试类
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2017-07-19</br> 修改备注：</br>
 */
public class DragGridViewTestActivity extends AppCompatActivity {
    @Bind(R.id.drawGridView)
    DragMyGridView drawGridView;
    ArrayList<DeviceValue> deviceList;
    @Bind(R.id.back)
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_measure);
        ButterKnife.bind(this);
        loadData();
        initView();

    }

    private void initView() {
        back.setVisibility(View.VISIBLE);
        drawGridView.setMyGridVewFirstLine(true);
        DragAdapter2 mAdapter2 = new DragAdapter2(DragGridViewTestActivity.this,deviceList);
        drawGridView.setAdapter(mAdapter2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AcheManager.getInstance().saveDeviceValue(DragGridViewTestActivity.this,deviceList);
                finish();
            }
        });
    }

    private void loadData(){
        deviceList = ServiceData.dealDeviceList(DragGridViewTestActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AcheManager.getInstance().saveDeviceValue(DragGridViewTestActivity.this,deviceList);
    }

}
