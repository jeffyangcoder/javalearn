package com.ecc.javalanguage.aboutAnnotation;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/5/17-9:27
 */
@MyAnnotation(myTag = "Worker tag" ,myNum = 60)
public class Worker {
    private String name;
    private String no;

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", no='" + no + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Worker(String name, String no) {
        this.name = name;
        this.no = no;
    }

}
