##简介
    简单的数据数据库存储代码，使用JDBC 完成数据库操作。项目中包含常见的单元测试框架Junit和slf4j日志框架。
##项目管理
    本项目使用maven管理。
##使用
    项目核心代码在包core中，测试时需根据本地环境，修改位于resources文件夹下的配置文件jdbc.properties和log4j.properties(主要修改日志文件路径，默认D:/log/project/)。测试文件为resources目录下的2017-09-19.csv文件。
    修改完配置文件后，直接在test包下运行单元测试代码CVS2MySqlTest。