# spring boot
## 一、what
  spring boot使你能快速跑起来spring的应用程序，因为它默认了许多框架的使用方式，使你不用再费时费力去纠结于框架的配置。
## 二、搭建一个简单spring boot
### 1、基本结构
- SpringbootApplication： 一个带有 main() 方法的类，用于启动应用程序
- SpringbootApplicationTests：一个空的 Junit 测试了，它加载了一个使用 Spring Boot 字典配置功能的 Spring 应用程序上下文
- application.properties：一个空的 properties 文件，可以根据需要添加配置属性
- pom.xml： Maven 构建说明文件
### 2、pom文件
- <parent>标签

有了这个，当前的项目才是 Spring Boot 项目，==spring-boot-starter-parent== 是一个特殊的 starter ，它用来提供相关的 Maven 默认依赖，使用它之后，常用的包依赖就可以省去 version 标签。
```
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.1.RELEASE</version>

		<relativePath /> <!-- lookup parent from repository -->
	</parent>
```
### 3、应用入口类*Application

@SpringBootApplication
=@Configuration+@EnableAutoConfiguration+@ComponentScan

@EnableAutoConfiguration: 让 Spring Boot 根据类路径中的 jar 包依赖为当前项目进行自动配置.
</br>*例如，添加了 spring-boot-starter-web 依赖，会自动添加 Tomcat 和 Spring MVC 的依赖，那么 Spring Boot 会对 Tomcat 和 Spring MVC 进行自动配置。*
</br>@SpringBootApplication:Spring Boot 还会自动扫描所在类的同级包以及下级包里的 Bean ，所以入口类建议就配置在 grounpID + arctifactID 组合的包名下
###  4、spring boot配置文件
Spring Boot 使用一个全局的配置文件 application.properties 或 application.yml，放置在【src/main/resources】目录或者类路径的 /config 下。
### 5、spring boot热部署
当发现任何类发生了改变，就会通过 JVM 类加载的方式，加载最新的类到虚拟机中，这样就不需要重新启动也能看到修改后的效果了。

```
<!-- 热部署 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>
```
## 三、spring boot的使用
### 1、支持jsp
- step1：修改pom文件增加对jsp的支持

```
<!-- servlet的依赖 -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>

		<!-- tomcat的依赖 -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
```
- step2：配置试图重定向 JSP 文件的位置（修改yml属性文件）

```
#第三种配置方法
student: 
  name3: caipch
  age3: 22

spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
```
- step3：写controller
- step4：写jsp
- step5：运行访问
### 2、集成hibernate
- step1：修改pom文件增加依赖

```
<!-- jpa：https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
			<version>2.1.1.RELEASE</version>
		</dependency>
		<!--oracle： https://mvnrepository.com/artifact/com.oracle/ojdbc6 -->
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc</artifactId>
			<version>6.0</version>
		</dependency>
```
- step2：在属性文件中增加数据库属性配置

```
#配置数据源
  datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@localhost:1521:orcl
    username: scott
    password: tiger
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  jackson:
    serialization:
      indent-output: true

```
- step3：写实体类
- step4：写dao类，继承JpaRepository
- step5：写controller，进行数据库的增加操作
- step6：启动spring boot并访问
