## java9 - 17的一些新特性

### 未提到的特性
> 1. record 构建final class
> 2. 模块化构建
> 3. 垃圾处理器，javaPackage 等等一些底层特性
 
### 打算完善的特性
> http2 网络编程一直没仔细看过，下次想整个大活儿

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

5. 接口使用private方法
         抽象类： 无法实例化，
                 依靠继承，子类实现所以抽象方法
                 抽象类可以内部实现方法，字段，
         之前的接口: 1. 接口不能包含成员变量
                   2. 接口只能声明方法，不能包含方法实现
                   3. 类实现接口，必须实现全部方法
         java8之后的版本：
                   接口不再是纯粹的协议规范
                   运行方法实现：default，static, private
                   子类实现所以抽象方法
```

### 文件API
```java
读取
Files.readString(path);
写入
Files.writeString(path1,replace,StandardOpenOption.APPEND);
文件比对，文件一致 -1， 不一致 >0
Files.mismatch(path, copy)
```

### http2 API 简单使用
```java
 final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder(URI.create("https://cn.bing.com/"))
                .header("name", "jacklove")
                .GET()
                .build();
 httpClient.send(request, HttpResponse.BodyHandlers.ofString());
```

### Optional 新api,日志对空指针异常的支持
```java
 Optional<Object> empty = Optional.empty();
or 方法 
        Supplier<T> ()->T
        empty.or( () -> Optional.of("msg") ).get()
ifPresentOrElse 方法 
        Consumer<T> T->void
        Runnable  void
        empty.ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("not Found"));
```

### 字符串API,文字框
```java
1. 读取文件的时候应该好用
Stream<String> lines = "a\nb\nc".lines();
2. formatted 方法
"my name is %s, my age is %d".formatted("will", 25)
3. 文字框
        String str = """
           line%d
                line%d
                     line%d
                """.formatted(1,2,3);
第一个“”“ 后面不允许有任何字符，就像html的textarea
```

### stream操作API
```java
1. 单个元素构成stream
Stream.ofNullable(5);
2. Predicate.not 替代无法使用negate 的环境，实现方式一致
public static boolean isEven(Integer integer){
        return  integer % 2 ==0;
        }
list1.stream().filter(Predicate.not(MyStream::isEven)).toList();
3. pridicate 为false时, 返回数据
 初始数据 1, 2, 3, 4, 5
        takeWhile(e -> e != 4) 返回之前数据 1，2，3
        dropWhile(e -> e < 4) 返回之后数据 4，5
4. iterate
        初始化一个元素
        Predicate 为false 迭代的层级
        UnaryOperator<T> T->T 针对上次迭代数据的操作
        Stream.iterate("z", e -> e.length() < 6, e -> e + "z").forEach(System.out::println);
返回结果
        z
        zz
        zzz
        zzzz
        zzzzz
```
