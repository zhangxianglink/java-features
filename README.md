## java9 - 17的一些新特性

### 未提到的特性
> 1. record 构建final class
> 2. 模块化构建
> 3. 垃圾处理器，javaPackage 等等一些底层特性

### 语法的特性
```java
1.  instanceof 简化语法
    老版本
    if (computer instanceof Computer){
        Computer c2=(Computer)computer;
        }
    新版本
    if (computer instanceof Computer c2) {}
    
2.  var 简化语法
final var stringMap = Map.of("k1", "v1", "k2", "v2", "k3", "v3");
    var 必须要初始化，用于局部变量，来简化阅读代码。（这就考验命名）
    java作为静态语言，成员变量，方法参数，方法类型等 无法使用var, 否则无法推断类型

3. switch 简化语法
        String dayOfWeek = switch (day) {
        case 0  -> {
        day ++ ;
        yield  String.valueOf(day);
        }
        case 1,2  -> "monday";
        default -> throw new IllegalAccessException("Invalid Option: " + day);
        };
  使用-> 表达式，没有break, 不会产生穿透执行,
  yield来替代return, 只在switch语法块使用。

4. try-with-resources 优化
        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        try(bw;osw;fos){}
   可以参数化，try可以自动调用clone() ,必须是Closeable, AutoCloseable接口的实现类
```