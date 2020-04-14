package cn.wbhan.disaster.model;

import java.util.Date;
import java.util.Objects;

public class User {
    private Long id;
    private String username;
    private String password;
    private Boolean enable;
    private Date createDate;
    private Role role;

    public User() {
    }

    public User(String username, String password, Boolean enable, Date createDate, Role role) {
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.createDate = createDate;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{"
                + "id="
                + id
                + ", username='"
                + username
                + '\''
                + ", password='"
                + password
                + '\''
                + ", enable="
                + enable
                + ", createDate="
                + createDate
                + ", role="
                + role
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId())
                && Objects.equals(getUsername(), user.getUsername())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getEnable(), user.getEnable())
                && Objects.equals(getCreateDate(), user.getCreateDate())
                && Objects.equals(getRole(), user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(), getUsername(), getPassword(), getEnable(), getCreateDate(), getRole());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
