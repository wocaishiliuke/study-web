# Servlet 

自定义servlet,并完成映射配置,交由servlet container管理；熟悉servlet生命周期方法

## 工程创建

#### Eclipse

- Preference->server->runtime environment,配置好Local Tomcat
- 创建Dynamic Web Project,生成web.xml,编译后的class文件可放在build/classes或WebContent/WEB-INF/classes(目录不存在时需要手动创建)

#### IDEA

- 配置Local Tomcat
- 创建Web Application项目，自动创建骨架，需要手动创建classes、lib目录。指定字节码文件位置和导包参考blog

## 内容说明

- Servlet1和Servlet2用于helloworld测试
- Servlet3用于测试Servlet的生命周期
- Servlet4用于测试ServletConfig
- Servlet5用于测试ServletContext
- Servlet6用于测试项目内读取文件（a、b、c、d文件）


## 要点
### HttpServlet
- 一般自定义与http协议有关的servlet，使用继承HttpServlet的方式，因为该类在Servlet接口基础上添加了一些与HTTP协议相关的处理方法，功能更强大
- HttpServlet抽象类继承自另一抽象类GenericServlet(与协议无关)
- HttpServlet覆写了父类的service(),在该方法中根据请求方式调用不同的doXxx()处理,所以一般只需重写doXxx()，不需要重写service()
- 注册servlet可以使用xml/注解两种配置方式，其中的url-pattern属于服务器端路径，绝对路径中不用包含项目名
- container会提供一个DefaultServlet匹配路径/，当其他所有servlet都匹配不到时，交由该缺省Servlet，如访问Tomcat中的静态图片/HTML
- 该缺省的Servlet在Tomcat的conf/web.xml中配置，任何自定义的servlet如果匹配路径设为/，都会替代DefaultServlet成为缺省Servlet

### ServletConfig
- A servlet configuration object used by a servlet container to pass information to a servlet during initialization
- 一个servletConfig与一个servlet对应：init(ServletConfig config)； 

### ServletContext
- 可作为一个项目级的容器：可以获取init参数，也可以操作普通attribute参数
- 可以获取该项目的项目路径、文件真实(被发布的硬盘)路径、文件类型
- Tomcat支持的文件类型在其配置文件/conf/web.xml中
