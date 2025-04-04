# AOP Starter
本项目仅用于体验cursor,全由cursor自动生成，实现了一个简单的aop功能


这是一个基于Java 17和Spring Boot 3.0的AOP starter，提供了方法执行前后的日志记录功能。

## 技术栈

- Java 17
- Spring Boot 3.0.0 
- Spring AOP

## 使用方法

1. 在项目中添加依赖：

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>aop-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

2. 在需要记录日志的方法上添加 `@LogAspect` 注解：

```java
@LogAspect(
    description = "测试方法", 
    key = "test-method", 
    name = "测试功能"
)
public void testMethod() {
    // 方法实现
}
```

## 注解参数说明

`@LogAspect` 注解支持以下参数：

- `description`: 方法描述，用于记录方法的功能描述
- `key`: 键值，可用于方法的唯一标识或分类
- `name`: 名称，可用于方法的业务名称

所有参数均为可选，默认为空字符串。

## 功能说明

- 记录方法执行前的时间点
- 记录方法执行后的时间点
- 计算方法执行时长
- 输出方法描述信息和附加参数（key、name）
- 输出完整的类名和方法名

## 注意事项

- 该starter会自动配置，无需额外配置
- 项目使用Java 17特性，如var关键字和改进的时间API
- 基于Spring Boot 3.0的自动配置机制

## 实现亮点

- 使用`java.time`包的`Instant`和`Duration`替代传统的时间计算
- 采用Java 17的var关键字提高代码可读性
- 使用Spring Boot 3.0新的自动配置机制
- 支持自定义键值和名称，提高日志的灵活性 