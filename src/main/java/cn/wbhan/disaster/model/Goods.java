package cn.wbhan.disaster.model;

import java.util.Date;
import java.util.Objects;

public class Goods {
    private Long id;
    private String name;
    private Double cnt;
    private String unit;
    private Date createDate;
    private User provider;

    public Goods() {
    }

    public Goods(String name, Double cnt, String unit, Date createDate, User provider) {
        this.name = name;
        this.cnt = cnt;
        this.unit = unit;
        this.createDate = createDate;
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Goods{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", cnt="
                + cnt
                + ", unit='"
                + unit
                + '\''
                + ", createDate="
                + createDate
                + ", origin="
                + provider
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(getId(), goods.getId())
                && Objects.equals(getName(), goods.getName())
                && Objects.equals(getCnt(), goods.getCnt())
                && Objects.equals(getUnit(), goods.getUnit())
                && Objects.equals(getCreateDate(), goods.getCreateDate())
                && Objects.equals(getProvider(), goods.getProvider());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(), getName(), getCnt(), getUnit(), getCreateDate(), getProvider());
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

    public Double getCnt() {
        return cnt;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User origin) {
        this.provider = origin;
    }
}
