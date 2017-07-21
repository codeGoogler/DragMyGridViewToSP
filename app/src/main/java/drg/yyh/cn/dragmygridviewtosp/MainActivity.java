package drg.yyh.cn.dragmygridviewtosp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 类功能描述：</br>
 * 拖拽效果测试类
 * 博客地址：http://blog.csdn.net/androidstarjack
 * 公众号：终端研发部
 * @author yuyahao
 * @version 1.0 </p> 修改时间：2017-07-19</br> 修改备注：</br>
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.btn_dragview01)
    Button btn_dragview01;
    @Bind(R.id.btn_dragview02)
    Button btn_dragview02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn_dragview02.setOnClickListener(this);
        btn_dragview01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dragview01:
                startActivity(new Intent(MainActivity.this,DragGridViewTestActivity.class));
                break;
            case R.id.btn_dragview02:
                startActivity(new Intent(MainActivity.this,MultyGridViewActivity.class));
                break;
        }
    }
}
