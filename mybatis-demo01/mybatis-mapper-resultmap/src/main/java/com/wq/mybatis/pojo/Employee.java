package com.wq.mybatis.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author wq
 * @Date 2019/2/1 12:29
 * @Version 1.0.0
 */
public class Employee {

    private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    private double sal;
    private double comm;
    private Integer deptNo;
    private Date hireDate;

    private Integer weekYear;

    public Employee() {
    }

    public Employee(Date hireDate) {
        this.hireDate = hireDate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        this.weekYear =  Integer.valueOf(sdf.format(new Date())) - Integer.valueOf(sdf.format(hireDate));
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getWeekYear() {
        return weekYear;
    }

    public void setWeekYear(Integer weekYear) {
        this.weekYear = weekYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptNo=" + deptNo +
                ", hireDate=" + hireDate +
                ", weekYear=" + weekYear +
                '}';
    }
}
