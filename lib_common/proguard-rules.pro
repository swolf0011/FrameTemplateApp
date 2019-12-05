# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


##############################基本混淆配置##############################
# 代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5
# 混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames
# 指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses
# 指定不去忽略非公共库的类成员
-dontskipnonpubliclibraryclassmembers
# 这句话能够使我们的项目混淆后产生映射文件
# 包含有类名->混淆后类名的映射关系
-verbose
# 不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。
-dontpreverify
# 保留Annotation不混淆 这在JSON实体映射时非常重要，比如fastJson
-keepattributes *Annotation*,InnerClasses,Signature,EnclosingMethod
# 避免混淆泛型
-keepattributes Signature
# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable
# 指定混淆是采用的算法，后面的参数是一个过滤器
# 这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !code/simplification/cast,!field/*,!class/merging/*
# 忽略警告
-ignorewarnings
# 设置是否允许改变作用域
-allowaccessmodification
# 把混淆类中的方法名也混淆了
-useuniqueclassmembernames
# apk 包内所有 class 的内部结构
-dump class_files.txt
# 未混淆的类和成员
-printseeds seeds_txt
# 列出从apk中删除的代码
-printusage unused.txt
# 混淆前后的映射
-printmapping mapping.txt
# 处理support包
-dontnote android.support.**
-dontwarn android.support.**




##############################不能使用混淆##############################

# 保留R下面的资源
-keep class **.R$* {*;}

#1、反射中使用的元素，需要保证类名、方法名、属性名不变，否则反射会有问题。
#2、最好不让一些bean 类混淆
#3、四大组件不能混淆，四大组件必须在 manifest 中注册声明，而混淆后类名会发生更改，这样不符合四大组件的注册机制。
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgent
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**
-keep public class * extends android.app.Fragment
-keep public class * extends android.view.view
-keep public class com.android.vending.licensing.ILicensingService

# 保留在Activity中的方法参数是view的方法，
# 这样以来我们在layout中写的onClick就不会被影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}
# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}
#保留Keep注解的类名和方法
-keep,allowobfuscation @interface android.support.annotation.Keep
-keep @android.support.annotation.Keep class *
-keepclassmembers class * {
    @android.support.annotation.Keep *;
}
#4、注解不能混淆，很多场景下注解被用于在进行时反射一些元素。
-keepattributes *Annotation*
#5、不能混淆枚举中的value和valueOf方法，因为这两个方法是静态添加到代码中进行，也会被反射使用，所以无法混淆这两种方法。应用使用枚举将添加很多方法，增加了包中的方法数，将增加 dex 的大小。
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#6、JNI 调用 Java 方法，需要通过类名和方法名构成的地址形成。
#7、Java 使用 Native 方法，Native 是C/C++编写的，方法是无法一同混淆的。
-keepclasseswithmembernames class * {
    native <methods>;
}
#8、JS 调用Java 方法
-keepattributes *JavascriptInterface*
#9、Webview 中 JavaScript 的调用方法不能混淆。注意：Webview 引用的是哪个包名下的。
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String);
}

#10、第三方可建议使用其自身混淆规则
#11、Parcelable 的子类和 Creator 的静态成员变量不混淆，否则会出现 android.os.BadParcelableExeception 异常。
#Serializable 接口类反序列化：
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep class * implements java.io.Serializable {
       static final long serialVersionUID;
       private static final java.io.ObjectStreamField[]   serialPersistentFields;
       private void writeObject(java.io.ObjectOutputStream);
       private void readObject(java.io.ObjectInputStream);
       java.lang.Object writeReplace();
       java.lang.Object readResolve();
}
-keepclassmembers class * implements java.io.Serializable {
   static final long serialVersionUID;
   private static final java.io.ObjectStreamField[] serialPersistentFields;
   !static !transient <fields>;
   private void writeObject(java.io.ObjectOutputStream);
   private void readObject(java.io.ObjectInputStream);
   java.lang.Object writeReplace();
   java.lang.Object readResolve();
}
#assume no side effects:删除android.util.Log输出的日志
-assumenosideeffects class android.util.Log {
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}



#12、Gson 的序列号和反序列化，其实质上是使用反射获取类解析的
-keep class com.google.gson.** {*;}
-keep class sun.misc.Unsafe {*;}
-keep class com.google.gson.stream.** {*;}
-keep class com.google.gson.examples.android.model.** {*;}
-keep class com.google.** {
    <fields>;
    <methods>;
}
-dontwarn class com.google.gson.**







