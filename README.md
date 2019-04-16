# 大型电商平台商城--前后分离-->后端
###食用方式
环境需求：
	nginx：反向服务器
	ftpserver：图片、富文本、静态资源服务器
	mysql：数据储存
	maven：依赖注入
	tomcat*2：单机模拟tomcat集群
	redis*2：单机模拟redis分布式
	编辑工具最好是idea方便直接导入开跑
###功能模块
	用户模块、分类管理模块、商品管理模块
	购物车模块、收货地址管理模块、支付模块
	订单管理模块...
###技术点
	lombook优化代码, maven环境隔离, SpringMVC全局异常处理，
	单点登录:Cookie+Redis+Json+Filter实现单点登录
		 spring session 实现单点登录 
	redis分布式， spring mvc拦截器通一角色校验， 
	Spring Schedule定时关闭订单
	Spring Schedule+Redisson分布式锁构建分布式任务调度 ...

###注意事项
	nginx的配置、ftp服务器文件路径配置尽量保持一致、redis分布式下Ip.port
	tomcat集群下的IP.PORT最好参照/doc目录,以免意想不到的bug发生.

#####[前端开发中...](https://github.com/863944536/mmall-fe.git)