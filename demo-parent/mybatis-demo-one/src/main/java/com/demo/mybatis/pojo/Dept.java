package com.demo.mybatis.pojo;

/**
 * @ClassName pojo
 * @Description TODO
 * @Author wq
 * @Date 2019/1/21 10:02
 * @Version 1.0.0
 */
public class Dept {

    private Integer id;
    private String loc;
    private String dname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
