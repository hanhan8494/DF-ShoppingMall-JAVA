# Mall-ShopX 项目说明文档

## 项目简介

Mall-ShopX 是一个基于 Spring Boot 和 MyBatis 的电子商务平台项目，包含后台管理模块（Mall-web-admin）和小程序模块（Mall-applet）。项目采用 Maven 进行多模块管理，结构清晰，易于维护和扩展。

## 模块结构

项目包含以下四个主要模块：

- **Mall-web-admin**: 后台管理模块，提供用户管理、商品管理等功能。
- **Mall-applet**: 小程序模块，提供用户登录、商品浏览等功能。
- **Mall-common**: 公共模块，提供项目中公用的常量、工具类、异常处理等。
- **Mall-pojo**: 实体类模块，定义项目中的实体类和 DTO（数据传输对象）。

## 技术栈

- **Spring Boot**: 用于构建独立的、生产级别的 Spring 应用。
- **MyBatis**: 用于数据库操作。
- **MySQL**: 项目使用的数据库。
- **Redis**: 用于缓存和会话管理。
- **JWT**: 用于身份验证。
- **Swagger**: 用于 API 文档生成。
- **Lombok**: 简化实体类编写。
- **FastJSON**: 用于 JSON 序列化和反序列化。
- **Druid**: 数据库连接池。
- **PageHelper**: 分页插件。
- **AspectJ**: 面向切面编程。
- **Knife4j**: Swagger 的增强工具。
- **Poi**: 用于处理 Excel 文件。

## 模块说明

### Mall-web-admin

- **路径**: `Mall-ShopX/Mall-web-admin`
- **功能**: 提供后台管理功能，包括用户管理、商品管理等。
- **关键配置**:
  - `pom.xml`: 定义了模块的依赖和构建配置。
  - `application.yml`: Spring Boot 的配置文件。
  - `WebMvcConfiguration.java`: MVC 配置类。
  - `AdminController.java`, `CommodityController.java`, `UserController.java`: 控制器类。
  - `AdminMapper.java`, `CommodityMapper.java`, `UserMapper.java`: MyBatis 的 Mapper 接口。
  - `AdminService.java`, `CommodityService.java`, `UserService.java`: 服务接口及其实现类。

### Mall-applet

- **路径**: `Mall-ShopX/Mall-applet`
- **功能**: 提供小程序端的功能，如用户登录、商品浏览等。
- **关键配置**:
  - `pom.xml`: 定义了模块的依赖和构建配置。
  - `WebMvcConfiguration.java`: MVC 配置类。
  - `UserController.java`: 控制器类。
  - `JwtTokenRiderInterceptor.java`, `JwtTokenUserInterceptor.java`: JWT 拦截器。

### Mall-common

- **路径**: `Mall-ShopX/Mall-common`
- **功能**: 提供项目中公用的常量、工具类、异常处理等。
- **关键配置**:
  - `pom.xml`: 定义了模块的依赖和构建配置。
  - `JwtClaimsConstant.java`, `MessageConstant.java`: 常量类。
  - `BaseContext.java`: 上下文类。
  - `AccountLockedException.java`, `AccountNotFoundException.java`, `AddressBookBusinessException.java`, `BaseException.java`, `DeletionNotAllowedException.java`, `LoginFailedException.java`, `OrderBusinessException.java`, `PasswordEditFailedException.java`, `PasswordErrorException.java`, `SetmealEnableFailedException.java`, `ShoppingCartBusinessException.java`, `UserNotLoginException.java`: 自定义异常类。
  - `JacksonObjectMapper.java`: 自定义的 JSON 序列化/反序列化配置。
  - `AliOssProperties.java`, `JwtProperties.java`: 配置属性类。
  - `Result.java`: 统一响应结果类。
  - `AliOssUtil.java`, `JwtUtil.java`: 工具类。

### Mall-pojo

- **路径**: `Mall-ShopX/Mall-pojo`
- **功能**: 定义项目中的实体类和 DTO（数据传输对象）。
- **关键配置**:
  - `pom.xml`: 定义了模块的依赖和构建配置。
  - `AdminDTO.java`, `CommodityDTO.java`: DTO 类。
  - `Admin.java`, `Commodity.java`, `DityAll.java`, `DityAlls.java`, `DityUrl.java`, `DityUrls.java`: 实体类。
  - `AdminLoginVO.java`, `CommodityVO.java`, `DityVO.java`: VO 类。

## 构建和运行

### 环境要求

- JDK 17
- Maven 3.6+
- MySQL 5.7+
- Redis 6.0+

### 构建项目

在项目根目录下运行以下命令：

```bash
mvn clean install
```

### 运行项目

在 `Mall-web-admin` 和 `Mall-applet` 模块下分别运行以下命令：

```bash
mvn spring-boot:run
```

## API 文档

项目使用 Swagger 生成 API 文档，访问以下地址查看：

```
http://localhost:8080/swagger-ui.html
```

## 贡献指南

欢迎对项目进行贡献，请遵循以下步骤：

1. Fork 项目到你的 GitHub 账户。
2. 创建一个新的分支进行修改。
3. 提交你的修改并发起一个 Pull Request。
