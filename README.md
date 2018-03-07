##简介
    简单的数据数据库存储代码，使用JDBC 完成数据库操作。项目中包含常见的单元测试框架Junit和slf4j日志框架。
##项目管理
    本项目使用maven管理。
##使用
    项目核心代码在包core中，测试时需根据本地环境，修改位于resources文件夹下的配置文件jdbc.properties和log4j.properties(主要修改日志文件路径，默认D:/log/project/)。测试文件为resources目录下的2017-09-19.csv文件。
    修改完配置文件后，直接在test包下运行单元测试代码CVS2MySqlTest。
##ps:
    因为数据项有三个，所以将字段item_value 设置为三个字段，分别为item_value1，item_value2，item_value。
    
    emmm
    修改菜鸟级错误
        1 SimpleDateFormat 非线程安全，所以不能声明为全局变量。也可以使用ThreadLocal来是之线程安全。
        2 BufferReader 没有关闭。
        3 完全不会Junit 然后强行使用。后面看了下文章，添加了个assert。如果插入成功，run方法会返回1否则返回0。

    pss:路漫漫其修远兮，吾将上下而求索。

