# myblog
java,blog

# java EE  实现 的我的博客系统

完全使用传统的servlet的形式，由于会出现多个servlet，在访问时进行拦截，url中写着类名和方法名然后通
过反射的方式实现
例如 fore-article-list 通过字符串截取
然后通过反射调用 Article类的list方法



