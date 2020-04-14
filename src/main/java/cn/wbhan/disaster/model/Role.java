package cn.wbhan.disaster.model;

import java.util.Objects;

public class Role {
    private Long id;
    private String name;
    private String nameCN;

    public Role() {
    }

    public Role(String name, String nameCN) {
        this.name = name;
        this.nameCN = nameCN;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name='" + name + '\'' + ", nameCN='" + nameCN + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId())
                && Objects.equals(getName(), role.getName())
                && Objects.equals(getNameCN(), role.getNameCN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNameCN());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }
}
