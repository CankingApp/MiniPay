package com.canking.minipay;

import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * Created by changxing on 2017/9/20.
 */

public class Config implements Serializable {
    private String wechatTip, aliTip;
    @DrawableRes
    private int wechatQaImage, aliQaImage;
    private String aliZhiKey;//支付宝支付码，可从支付二维码中获取

    Config(Builder builder) {
        this.wechatQaImage = builder.wechatQaImage;
        this.aliQaImage = builder.aliQaImage;
        this.wechatTip = builder.wechatTip;
        this.aliTip = builder.aliTip;
        this.aliZhiKey = builder.aliZhiKey;
    }

    private Config() {
    }

    public String getWechatTip() {
        return wechatTip;
    }

    public String getAliTip() {
        return aliTip;
    }

    public int getWechatQaImage() {
        return wechatQaImage;
    }

    public int getAliQaImage() {
        return aliQaImage;
    }

    public String getAliZhiKey() {
        return aliZhiKey;
    }

    public static class Builder {
        private String wechatTip, aliTip;
        @DrawableRes
        private int wechatQaImage, aliQaImage;
        private String aliZhiKey;


        public Builder(String aliKey, @DrawableRes int qaAli, @DrawableRes int qaWechat) {
            wechatQaImage = qaWechat;
            aliQaImage = qaAli;
            aliZhiKey = aliKey;
        }

        public Builder setWechatTip(String tip) {
            wechatTip = tip;
            return this;
        }

        public Builder setAliTip(String tip) {
            aliTip = tip;
            return this;
        }

        public Config build() { // 构建，返回一个新对象
            return new Config(this);
        }
    }
}
