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

2. 知识总结
   1. druid: https://www.bilibili.com/video/BV1ih411n7Ps/ 
   2. pageHelper: https://www.bilibili.com/video/BV1n3411q7FW/
   3. jwt token(b站: https://www.bilibili.com/video/BV1Zy4y1K7Cj/)
      1. 定义: 
      （JSON Web Token）用于在两方之间安全地传输信息。 它通常用于身份验证和信息交换
      2. 结构:JWT的结构包含三个部分，用点（.）分隔
         1. Header（头部）- 头部通常由两部分组成:
            1. token的类型 
            2. 签名算法(signature 部分的算法)
         2. Payload（有效载荷）:
            1. 载荷包含所谓的“声明（Claims）这些声明是关于实体（通常是用户）和其他数据的语句。
               (发行者（iss）、主题（sub）、接收者（aud）、到期时间（exp）、
                生效时间（nbf）和颁发时间（iat）)
         3. Signature（签名）:
            1. 为了创建签名部分，你必须采用编码后的header、编码后的payload、
            一个密钥，然后使用header中指定的算法进行签名
            2. 签名用于验证消息在传输过程中未被篡改,在使用私钥签名的情况下，用于验证发送者的身份。
      3. 特点:
        1.关键特性是它可以自包含:
      它可以携带所有必要的信息，无需回查询数据库。这使得JWT非常适合于分布式系统的单点登录（SSO）场景
      4. 实际场景:
         1.场景:JWT通常用于OAuth2.0流程中，用作访问令牌和刷新令牌
         2.流程:(Local Storage / Session Storage/cookies)
           1. 首次登录后，服务器会生成一个JWT，并将其返回给客户端
           2. 客户端随后在每次请求时将此JWT发送回服务器以验证其身份。
              由于JWT是自验证的，服务器可以快速确认用户身份而无需每次都查询数据库。
      5. 返回统一结果:
        包括对象信息以及响应码，目的是返回给前端开发人员
        interceptor to handle all exceptions
      6. 