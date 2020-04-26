package itjinxun.Jdbc.entity;

import itjinxun.Jdbc.annt.Column;
import itjinxun.Jdbc.annt.Table;

import java.util.Date;

@Table(value="student")
public class Student {
    @Column(value="s_id")
    private Integer s_id;
    @Column(value="s_name")
    private String s_name;
    @Column(value="s_age")
    private Date s_age;
    @Column(value="s_sex")
    private String s_sex;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Date getS_age() {
        return s_age;
    }

    public void setS_age(Date s_age) {
        this.s_age = s_age;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_age=" + s_age +
                ", s_sex='" + s_sex + '\'' +
                '}';
    }
}
