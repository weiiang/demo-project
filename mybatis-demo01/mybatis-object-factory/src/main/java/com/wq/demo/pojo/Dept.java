package com.wq.demo.pojo;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author wq
 * @Date 2019/1/31 10:37
 * @Version 1.0.0
 */
public class Dept {
    private int deptNo;
    private String dname;
    private String loc;
    private Boolean flag;
    private String country;

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", flag=" + flag +
                ", country='" + country + '\'' +
                '}';
    }
}
