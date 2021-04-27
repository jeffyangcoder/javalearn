package com.ecc.javalanguage.dbconnect.preparedstatement.bean;

/**
 * @author yangshiwei
 * @Description
 * @date 2021/4/27-20:00
 */
public class Role {
    private int id;
    private String roleName;
    private int dataType;
    private String roleDes;

    public Role() {
        super();
    }

    public Role(int id, String roleName, int dataType, String roleDes) {
        this.id = id;
        this.roleName = roleName;
        this.dataType = dataType;
        this.roleDes = roleDes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", dataType=" + dataType +
                ", roleDes='" + roleDes + '\'' +
                '}';
    }
}
