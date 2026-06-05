# Java 学习之路 —— 永恒代码之火 🔥

从零开始的 Java SE 学习项目，包含 **6 个递进式模块**，覆盖 Java 基础语法到面向对象实战。

---

## 项目结构

```
demo1
├── 1/   Java 基础语法
├── 2/   数组 · 字符串 · 方法
├── 3/   ArrayList 集合 & ATM 系统
├── 4/   继承与多态
└── 5/   综合实战：超市员工薪资系统
```

---

## 模块简介

### 模块 1 —— Java 基础语法

| 文件 | 知识点 |
|------|--------|
| `AMTLS.java` | 变量定义、赋值、基本运算 |
| `Type.java` | 8 种基本数据类型 + String |
| `Ch.java` | 自动类型转换 & 强制类型转换 |
| `Sc.java` | Scanner 键盘输入 |
| `P.java` | 算术、关系、逻辑、三元等运算符 |
| `A001.java` | if / if-else / if-else if / 嵌套 |
| `A002.java` | switch 分支 + case 穿透现象 |
| `A003.java` | switch 穿透性的合理利用 |
| `A0012.java` | ATM 界面原型（if-else 综合） |
| `A013.java` | while / do-while / for 三种循环 |
| `Main.java` | ATM 系统 v1（开户 + 登录） |

### 模块 2 —— 数组 · 字符串 · 方法

| 文件 | 知识点 |
|------|--------|
| `Main.java` | 猜数字游戏（Random + while） |
| `A1.java` | 数组操作：最值/排序/平均值、方法封装 |
| `A2.java` | 回文字符串判断（双指针） |
| `A3.java` | 统计字符串中字母和数字个数 |
| `A4.java` | 手动实现大小写转换（ASCII） |
| `A006_Test_String.java` | String 类全面：创建方式、常用方法、常量池、不可变性 |
| `Airport.java` | 飞机票折扣计算（方法 + switch 表达式） |
| `ID.java` | 随机验证码生成（数字/大写/小写） |
| `mov.java` | 电影信息管理系统（对象数组 + 查找） |

### 模块 3 —— ArrayList 集合 & ATM 系统

| 文件 | 知识点 |
|------|--------|
| `ArrayListDemo1.java` | ArrayList 常用方法（增删改查） |
| `ArrayListTest2.java` | 遍历删除的正确姿势（正向回退 vs 倒序遍历） |
| `Main.java` | 正向遍历 vs 倒序遍历删除对比 |
| `ATM.java` | **完整版 ATM 系统**：开户、登录、存款、取款、转账、改密码、注销 |

### 模块 4 —— 继承与多态

| 文件 | 知识点 |
|------|--------|
| `People.java` | 父类定义（基类） |
| `Student.java` | 子类继承 + 方法重写 + 变量隐藏 |
| `Teacher.java` | 子类继承 + 方法重写 + 变量隐藏 |
| `Test.java` | **多态核心演示**：编译看左边，运行看右边（方法）；变量没有多态 |

### 模块 5 —— 综合实战：超市员工薪资系统

| 文件 | 知识点 |
|------|--------|
| `Main.java` | Person 父类 + Security/Cashier/StockClerk 三个子类 |

**类层次结构：**

```
Person（员工父类）
  ├── Security   —— 保安：底薪 3000 + 全勤 500
  ├── Cashier    —— 收银：底薪 3500 + 工时×20
  └── StockClerk —— 理货：底薪 3500 + 销售额×80
```

使用多态数组 `Person[]` 存储不同类型员工，动态绑定各自算薪方法。

---

## 环境要求

- **JDK**：17+（switch 表达式需要 Java 14+）
- **IDE**：IntelliJ IDEA（推荐）

## 运行方式

1. 用 IDEA 打开 `demo1` 目录
2. 展开对应模块的 `src` 目录
3. 右键任一 `.java` 文件的 `main` 方法 → Run

---

## 学习路线建议

```
模块 1 → 模块 2 → 模块 3 → 模块 4 → 模块 5
  ↓        ↓        ↓        ↓        ↓
 语法      数组     集合     继承     综合
 基础      方法     ATM     多态     实战
```

---

> 踏踏实实练好基本功，每一个大师都曾是初学者。
