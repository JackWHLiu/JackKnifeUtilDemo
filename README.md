# JackKnifeDemo的官方使用教程
此Demo基于jackknife的master-SNAPSHOT代码编写。在版本迭代的过程中难免会有API的更新，如有错误，请批评指出。如牵扯到API的版本
问题，请自行阅读源码调试。或者，联系作者QQ:924666990，备注jackknife。

## 常见问题：
### 1.我在生产环境中可以使用master-SNAPSHOT的代码吗？
---------------------
不建议。master-SNAPSHOT为最新提交的代码，可能还在调试中，不能保证稳定性。
### 2.为什么jackknife-ioc2和jackknife-multiproxy使用不了
---------------------
使用apt功能在高版本gradle下需要配置，如使用jackknife-ioc2就需要以下配置。
javaCompileOptions {
    annotationProcessorOptions {
        includeCompileClasspath = true
    }
}
