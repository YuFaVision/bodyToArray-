# Apache ShenYu Body to Array Plugin

这是一个 Apache ShenYu 网关的自定义插件，用于将请求体转换为数组格式。

## 功能特性

- 自动将单个 JSON 对象转换为数组
- 保持原数组格式不变
- 可通过配置文件开关控制插件启用/禁用
- 兼容 Spring Boot 2.7+ 和 ShenYu 2.6+

## 项目结构

```
/workspace
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── apache
    │   │           └── shenyu
    │   │               └── plugin
    │   │                   └── body
    │   │                       └── to
    │   │                           └── array
    │   │                               ├── BodyToArrayPlugin.java
    │   │                               └── BodyToArrayPluginConfiguration.java
    │   └── resources
    │       └── META-INF
    │           └── spring.factories
    └── test
        └── java
            └── org
                └── apache
                    └── shenyu
                        └── plugin
                            └── body
                                └── to
                                    └── array
                                        └── BodyToArrayPluginTest.java
```

## 构建和安装

### 使用 Maven 构建

```bash
mvn clean package
```

构建成功后，JAR 文件将位于 `target/shenyu-plugin-body-to-array-1.0.0.jar`

## 部署方式

### 方式一：静态部署（适合首次开发测试）

1. 修改 `shenyu-bootstrap` 模块的 `pom.xml`，添加此插件作为依赖
2. 重新打包并启动 ShenYu 网关

### 方式二：动态部署（推荐，无需重启网关）

#### 配置文件监听模式

在 `shenyu-bootstrap` 的 `application.yml` 中配置插件监听目录：

```yaml
shenyu:
  plugin:
    ext-plugin:
      path: /path/to/your/plugins
```

将 JAR 文件放入配置的目录，网关会自动加载。

#### Admin 界面上传模式

1. 登录 ShenYu-Admin 管理界面
2. 进入 **插件管理** -> **插件处理**
3. 点击 "上传插件Jar" 按钮上传 JAR 文件

## 配置说明

在 `shenyu-bootstrap` 的配置文件中添加：

```yaml
shenyu:
  plugins:
    body-to-array:
      enabled: true
```

## ShenYu-Admin 后台配置

### 1. 创建插件

1. 进入 **基础配置** -> **插件管理**
2. 点击 "添加插件"
3. 插件名称填写：`bodyToArray`（必须与代码中 `named()` 方法返回值完全一致）

### 2. 配置选择器

1. 在 `bodyToArray` 插件下创建选择器
2. 配置目标接口路径（如：`/data-out/lichangrongxj/aqfxfxdy`）

### 3. 配置规则

1. 在选择器下创建具体规则
2. 设置生效的请求路径等匹配条件
3. 启用插件

## 技术栈

- Java 11
- Maven
- Apache ShenYu 2.6.1
- Spring Boot 2.7.18
