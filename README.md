# student2
学生管理系统(mybaits版)
 
b站：https://www.bilibili.com/video/BV1ng41197RM/?p=4&spm_id_from=pageDriver&vd_source=adfec93694fcaad375a7e872855f4d56

1. 错误总结
    1. 表与类中的某个属性不一致(eg: (user_name/username) &&(company_name/companyName))
       1. 解决方案
          1. mybatis中 
             1. 使用 XML 映射文件(在之后的sql查询中 select 中 改成 resultType="resultMap id")
                <resultMap id="yourResultMap" type="your.package.YourClass">
                 <result property="javaPropertyName" column="sqlColumnName"/>
                </resultMap>  
             2. Mybatis 配置文件中使用自动映射功能
              <settings>
                <setting name="mapUnderscoreToCamelCase" value="true"/>
              </settings>
          2. mybatis-plus中：
             @TableName 注解：用于指定实体类与数据库中的表名的对应关系。
             @TableField 注解：用于指定实体类属性与数据库表中列的映射关系。 
       
    2. 在.gitignore中加入了 .idea 为什么不生效 
       .gitignore  文件中的条目应该是 .idea/（注意斜杠），
       这表示忽略 .idea 目录。

    3. 