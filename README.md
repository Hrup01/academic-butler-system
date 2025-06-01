
---
# 📚 Academic Butler System

**Academic Butler System 是一个面向学术管理的综合系统，旨在简化教师、学生和管理员在课程管理与选课流程中的操作。该系统通过 RESTful API 提供高效、安全的服务，并支持基于 JWT 的身份验证。**

---

## 🌟 功能列表

- **🔐 用户认证与授权**
  - 支持教师、学生和管理员三种角色登录
  - 使用 JWT 进行无状态会话管理

- **📚 课程管理**
  - 教师可添加、修改、删除课程
  - 支持课程状态变更（如提交、审核、公开）

- **🎓 学生选课**
  - 学生可根据年级、专业选择公开课程
  - 系统自动检测重复选课并阻止无效操作

- **📊 信息查询**
  - 学生可查看个人课表
  - 教师可查看所授课程列表

- **⚙️ 系统配置**
  - 支持数据库连接配置（MySQL）
  - 可自定义 JWT 密钥及过期时间

- **📦 模块化设计**
  - 分为 Controller、Service、Mapper、Pojo 层级
  - 支持扩展新功能模块

- **🧪 单元测试**
  - 包含基础 Spring Boot 测试用例
  - 验证关键业务逻辑正确性

---

## ⚙️ 安装指南

### 环境要求

- Java 17 或以上版本
- Maven 3.8+
- MySQL 8.0+
- Spring Boot 3.x

### 安装步骤

1. **克隆项目到本地**

   ```bash
   git https://github.com/Hrup01/academic-butler-system.git
   cd academic-butler-system
   ```


2. **配置数据库**

   修改 [application.properties](file://C:\Users\14487\IdeaProjects\web-allcode\demo06-mybatis\target\classes\application.properties) 文件以适配你的 MySQL 数据库设置：

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/academic
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```


3. **构建项目**

   ```bash
   mvn clean install
   ```


4. **运行项目**

   ```bash
   mvn spring-boot:run
   ```


5. **访问接口文档（Swagger）**

   启动后，访问 https://apifox.com/apidoc/shared-7254fcfc-4541-42a0-848f-8b60ae882e3d 查看 API 接口详情。

---

## 📖 使用说明

### 基础用法示例

#### 登录接口 `/api/auth/login`

```json
POST /api/auth/login
Content-Type: application/json

{
"username": "student123",
"password": "password123",
"role": "STUDENT"
}

```


返回：

```json
{
  "code": 200,
  "message": "操作成功",
  "data": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```


#### 获取所有公开课程 `/api/courses`

```http
GET /api/courses
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```


返回：

```json
{
  "code": 200,
  "message": "操作成功",
  "data": [
    {
      "id": 1,
      "courseName": "高等数学",
      "teacherId": 101,
      "credit": 4.0,
      "status": 4
    }
  ]
}
```


### 配置说明

- **JWT 配置**
  - 修改 [application.properties](file://C:\Users\14487\IdeaProjects\web-allcode\demo06-mybatis\target\classes\application.properties) 中的以下字段：
    ```properties
    jwt.secret=your-secret-key
    jwt.expiration=300
    ```


- **数据库配置**
  - 确保 `t_user`, `t_student`, `t_teacher`, `t_course` 表已创建
  - 示例 SQL 脚本请参考数据库迁移工具或手动执行建表语句

---

## 🧪 单元测试

运行默认测试：

```bash
mvn test
```


查看测试覆盖率报告（可使用插件如 JaCoCo）：

```bash
mvn jacoco:report
```


---

## 📌 版本更新记录

详见 [CHANGELOG.md](CHANGELOG.md)


---

## 💬 联系我们

如有问题，请提交 Issue 或联系作者：  
📧 Email: 1448714441@qq.com  
🔗 github: https://github.com/Hrup01/academic-butler-system.git
--- 
