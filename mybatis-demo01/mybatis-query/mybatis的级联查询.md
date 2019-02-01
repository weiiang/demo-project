# mybatis的级联查询

## 一对多级联查询

​	SQL语句:

​	

```sql
SELECT
	dept.deptno dept_deptno,
	dname,
	loc,
	empno,
	ename,
	job,
	sal 
FROM
	dept
	JOIN emp ON dept.deptno = emp.deptno 
	where dept.deptno = #{deptno}
```

