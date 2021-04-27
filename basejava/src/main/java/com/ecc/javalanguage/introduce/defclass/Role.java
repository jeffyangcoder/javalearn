package com.ecc.javalanguage.introduce.defclass;

public class Role {
    //数据成员
    private String roleName;
    private int dataType;
    private String roleDes;

    //构造方法
    public Role(String roleName, int dataType, String roleDes) {
        this.roleName = roleName;
        this.dataType = dataType;
        this.roleDes = roleDes;
    }

    //成员方法
    public void add() {
    }

    public void delete() {
    }

    public void infoDisplay() {
        System.out.println(roleName + "--" + dataType + "--" + roleDes);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getRoleDes() {
        return roleDes;
    }

    public void setRoleDes(String roleDes) {
        this.roleDes = roleDes;
    }

}
