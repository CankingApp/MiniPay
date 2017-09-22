# MiniPay-免sdk实现微信／支付宝转账打赏功能

> A nice tool for mobile pay without Wechat or Ali sdk. 

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)


## 为什么要做这个项目？

安卓开发者都应该有一个属于自己的APP发布到市场，可以完善自己的技术站之外，加入广告，还可以有一份小收入。
但是这个年代，各家的应用市场是不欢迎带广告sdk的个人开发者应用的。还好我们可以用插件技术加入广告sdk，或者直接想一种方面实现打赏功能，让用户通过支付宝或微信转账到自己账户。

## 预览

[![Get it on Google Play](https://play.google.com/intl/en_us/badges/images/badge_new.png)](https://play.google.com/store/apps/details?id=com.canking.paydemo)

![home](https://github.com/CankingApp/MiniPay/blob/master/snapshot/home.png)![wechat](https://github.com/CankingApp/MiniPay/blob/master/snapshot/weixin.png)![ali](https://github.com/CankingApp/MiniPay/blob/master/snapshot/ali.png)

## 用法

[文档](http://www.canking.win/2017/09/21/minipay/)

### 基本配置准备
* 支付宝和微信二维码
* 解析支付宝二维码内容后缀字符（直接转账用）
* 引入MimiPay项目

### 添加项目引用Dependency

```
    dependencies {
	    compile 'com.sdsmdg.tastytoast:tastytoast:0.1.3'
    }
```


### 一行代码启动MiniPay入口

```
    MiniPayUtils.setupPay(this, config);
```

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2017 CankingApp

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
