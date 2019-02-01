# mybatis映射文件的$和#

示例SQL:

```xml
<select id="findList" resultType="Dept">
    select * from dept where dname = #{department}
</select>
```

转换后的SQL

```xml
[DEBUG] Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@49d3c823]
[DEBUG] ==>  Preparing: select * from dept where dname = ? 
[DEBUG] ==> Parameters: 部门名称(String)
[DEBUG] <==      Total: 5
```

示例SQL:

```xml
<select id="findList" resultType="Dept">
    select * from dept where dname = ${department}
</select>
```

转换后的SQL

```xml
[DEBUG] Setting autocommit to false on JDBC Connection [com.mysql.jdbc.JDBC4Connection@49d3c823]
[DEBUG] ==>  Preparing: select * from dept where dname = 部门名称 
[DEBUG] ==> Parameters: 
[DEBUG] <==      Total: 5
```

#{}:	采用预编译的方式,可以防止SQL注入

${}:	采用赋值的方式,无法防止SQL注入攻击

大多数的情况下都采用#{},但也有一些特殊的情况下使用${}

把dept数据拷贝到dept2

create table dept2

select * from dept



示例:对表的名字做动态更改

```xml
<select id="findDept2" resultType="Dept">
      select * from ${value}
 </select>
```

```xml
<select id="findDeptByValue2" resultType="Dept">
      select * from #{value}
</select>
```

