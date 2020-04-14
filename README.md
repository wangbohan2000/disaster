# 抢险救灾物资物流管理系统

## 目录结构介绍
```text
├── src # 源代码目录
│   ├── main # 主要源代码
│   │   ├── java # Java代码
│   │   │   └── cn
│   │   │       └── wbhan
│   │   │           └── disaster # 项目根包名 cn.wbhan.disaster
│   │   │               ├── config # Spring Boot 配置项
│   │   │               ├── controller # Spring MVC Controller
│   │   │               │   ├── admin 
│   │   │               │   ├── front
│   │   │               │   ├── manager
│   │   │               │   └── provider
│   │   │               ├── model # 存放实体类
│   │   │               │   ├── dto
│   │   │               │   └── vo
│   │   │               ├── repository # 存放持久层类
│   │   │               │   └── vo
│   │   │               ├── service # 存放业务逻辑类
│   │   │               └── util # 存放工具类
│   │   └── resources # 存放项目资源(除了源代码)
│   │       ├── mapper 存放MyBatis Mapper
│   │       ├── static 存放静态资源(静态html、css、js、img等)
│   │       └── templates 存放Thymeleaf模板资源
│   │           ├── admin
│   │           ├── error
│   │           ├── front
│   │           ├── manager
│   │           ├── provider
│   │           └── public
│   └── test # 存放测试类
│       └── java
│           └── cn
│               └── wbhan
│                   └── disaster
│                       ├── controller
│                       └── repository
└── target # 存放生成目标代码
    ├── classes
    │   ├── mapper
    │   └── templates
    │       ├── admin
    │       ├── error
    │       ├── front
    │       ├── manager
    │       ├── provider
    │       └── public
    └── test-classes
        └── cn
            └── wbhan
                └── disaster
                    └── repository

263 directories

```

## 如何使用

1. 项目依赖JDK8+，首先去官网下载JDK
    
    用浏览器打开https://www.oracle.com/java/technologies/javase-downloads.html
    
    或者点击[这里](https://www.oracle.com/java/technologies/javase-downloads.html)即可跳转到下载页面
    
    找到JDK8u241下载链接，点击即可。
    
    下载完成后会得到一个压缩包，解压到你想要的任意位置，我们把这个位置叫做JAVA_HOME
    例如：C:\Program Files\Java\JDK-1.8
    
    然后Windows系统按Win + Q打开搜索框搜索"path",打开环境变量编辑器，在下方
    的系统变量添加一个新项，名字叫做"JAVA_HOME"， 值是刚才解压的JDK路径。
    
    在已有的PATH环境变量添加一个子项，值为`%JAVA_HOME%\bin`。
    
    至此， JDK的配置告一段落。
    
2. 配置数据库

    用浏览器打开https://dev.mysql.com/downloads/mysql/
    
    或者点击[这里](https://dev.mysql.com/downloads/mysql/)即可跳转至下载页面
    
    下载自己电脑对应版本的MySQL按照官网或者百度上的指引一步一步安装即可，
    需要注意的是设置密码的时候不要选择增强型密码，要选择传统密码。
    
    正确安装完成后命令行是可以使用`mysql`命令的。我们的项目根目录下有一个setup.sql。
    将命令行切换到项目根目录下，使用命令
    ```shell script
    mysql -u<用户名> -p<密码> < setup.sql
    ```
   
   这样数据库的初始化工作就完成了
   
3. 部署项目

    切换到项目/target目录下。打开命令行，输入命令
    ```shell script
    javaw -jar disaster-1.0.0-beta.jar --server.port=<你想部署的端口>
    ```
   
    这里有两个注意事项
    - JDK和数据库必须成功部署。
    - 端口必须大于1024, 小于65534