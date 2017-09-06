# AvenueNet
AvenueNet 是一个基于 Retrofit 二次封装的网络请求库，使用 Rxjava 的链式调用方式，二次封装的目的是为了对数据做统一的处理，对 Retrofit 对象做管理，有点为业务而生的味道，并非纯正的网络请求库

## 完成进度
### 0.1 Bate 版本功能以及完成度
~~基本网络请求 (Done)~~

~~自动类型转换 (Done)~~

~~根据业务判断 Response 数据是否正确 (Done)~~

~~统一的异常处理 (Done)~~

~~切换 Json 为 fastJson (Done)~~

~~配置自定义拦截器 (Done)~~

~~配置 Api 模拟功能 (Done)~~

~~支持请求头缓存拦截器的全局配置，以及请求头缓存拦截器的局部设置 (Done)~~

支持缓存 (Todo)

支持 Cookie （Todo)

简单配置支持自定义 SSL （Todo）


### 预测 0.2Bate 版本功能预测
支持取消网络请求

优化Api调用方式

支持复杂 SSL 配置

因为本库是对 Retrofit 的封装，正在考虑是否要基于 Okhttp 重写并且支持要切换底层网络框架
