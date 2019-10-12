# 那些高端、优雅的注解是怎么实现的
### 概述
这是一系列文章，通过`java`注解的详细解析，期望您以后看到注解不在感到神秘。不管是现在后台开发的`Spring`家族，还是移动端的各种框架。如大神`JakeWharton`的`butterknifte`、`Dagger2`等 。 注解随处可见，所以我们必须理解学会注解。
###介绍
首先我们会去搞清楚什么是注解？注解由那些元素组成？怎么去定义一个注解？注解为什么那么神奇的功效？它是怎么做到的？带着这些疑问我们从最简单的注解定义开始，然后去解析注解，最后通过两个实例完成自定义注解。为什么是两个例子呢？因为我们采用两种方式去解析注解--反射和`Annotaion Processing Tool`。反射是一种性能较低的解析方式，好在功能强大，但移动端不适合。所以我们使用一种不影响性能的解析方式-`Annotaion Processing Tool`。
说到这啰嗦点。`JakeWharton`大神的`butterknifte`也多少有使用反射的。


#### ButterKnife 到底有没有使用反射

在`ButterKnife`中使用`@InjectView`注解`View`。`ButterKnifeProcessor`生成一个`MyActivity$$ViewInjector`，但是在`ButterKnife`你不需要手动调用`new MyActivity$$ViewInjector()`来实例化一个`ButterKnife`注入的对象，而是使用`Butterknife.inject(activity)`。`ButterKnife`内部使用反射机制来实例化`MyActivity$$ViewInjector()`对象,这是怎么回事呢？不是说反射影响性能吗？大神为什么还要这么做呢？因为它不需要手动去创建对象，确实提高了开发者的开发速度。而且`ButterKnife`中有一个哈希表`HashMap`来缓存实例化过的对象。所以`MyActivity$$ViewInjector`只是使用反射机制实例化一次，第二次需要`MyActivity$$ViewInjector`的时候，就直接从哈希表中获得。所以大神这么做还是有大神的道理的。这里我们也看出来，没有最好的设计，只有最合适，永无止境。好不好，完全看你怎么用。下面是源码

```
try {  
    Class<?> injector = Class.forName(clsName + "$$ViewInjector");
} catch (ClassNotFoundException e) { ... }
```
### 自定义注解系列文章
- [那些高端、优雅的注解是怎么实现的<0> -- 注解的分类](https://www.jianshu.com/p/4d197be43cff)
- [那些高端、优雅的注解是怎么实现的 <1> -- 自定义注解语法](https://www.jianshu.com/p/6ec4912ed88c)
- [那些高端、优雅的注解是怎么实现的<2> -- 解析注解](https://www.jianshu.com/p/4c825744f946)
- [那些高端、优雅的注解是怎么实现的<3> - 可继承性@Inherited](https://www.jianshu.com/p/552690e45862)
- [那些高端、优雅的注解是怎么实现的<4> -- 使用Annotaion Processing Tool 解析注解](https://www.jianshu.com/p/2e7a3610ea11)
- [那些高端、优雅的注解是怎么实现的<5> --使用Annotaion Processing Tool 自定义注解](https://www.jianshu.com/p/1a0c23b34b6e)
- [那些高端、优雅的注解是怎么实现的<6> --自定义持久层框架-类 Hibernate](https://www.jianshu.com/p/782a791b91aa)

