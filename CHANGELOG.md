# 📜 变更日志 (CHANGELOG)

## [v1.0.0] - 2025-04-05

> **Initial Release**

### ✨ 新增功能

- feat(auth): 添加用户认证接口
- feat(login): 新增登录请求 DTO 类
- feat(jwt): 创建 JWT 工具类用于生成和验证令牌
- feat(course): 实现教师课程管理功能
- feat(student): 实现学生模块基础功能（选课、获取课表）

### 🐛 修复问题

- fix(course): 修复根据教师 ID 获取课程信息逻辑缺失
- fix(student): 修复根据学生 ID 获取课程信息逻辑缺失
- fix(duplicate): 遗漏了课程已被选择的异常处理
- fix(controller): 修改 @PathVariable 注解接收参数方式

### 🔧 更新改进

- chore(deps): 添加 Spring Boot Web 和 JWT 相关依赖
- refactor(dto): 删除重复构造方法以解决编译冲突
- docs: 完善 README.md 文档说明
