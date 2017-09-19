package com.canking.minipay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by changxing on 2017/9/8.
 */

public class ZhiActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTitleTv, mSummeryTv;
    private static final int ZHI_WAY_WECHAT = 0;//weixin
    private int mZhiWay;
    private ViewGroup mQaView, mZhiBg;
    private ImageView mQaImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhi_activity);
        mTitleTv = (TextView) findViewById(R.id.zhi_title);
        mSummeryTv = (TextView) findViewById(R.id.zhi_summery);
        mQaView = (ViewGroup) findViewById(R.id.qa_layout);
        mZhiBg = (ViewGroup) findViewById(R.id.zhi_bg);
        mQaImage = (ImageView) findViewById(R.id.qa_image_view);
        mZhiBg.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.zhi_btn) {
            if (mZhiWay == ZHI_WAY_WECHAT) {
                WeZhi.startWeZhi(this, mQaView);
            } else {
                AliZhi.startAlipayClient(this, "apafm3kp91df7yo517");
            }
        } else if (v == mZhiBg) {
            if (mZhiWay == ZHI_WAY_WECHAT) {
                mZhiBg.setBackgroundResource(R.color.common_blue);
                mTitleTv.setText(R.string.ali_zhi_title);
                mSummeryTv.setText(R.string.ali_zhi_tip);
                mQaImage.setImageResource(R.drawable.ic_zhifubao);
            } else {
                mZhiBg.setBackgroundResource(R.drawable.common_bg);
                mTitleTv.setText(R.string.wei_zhi_title);
                mSummeryTv.setText(R.string.wei_zhi_tip);
                mQaImage.setImageResource(R.drawable.ic_weixin);
            }
            mZhiWay = ++mZhiWay % 2;

        }

    }
}
