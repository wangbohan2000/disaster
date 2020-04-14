package cn.wbhan.disaster.model;

import java.util.Date;
import java.util.Objects;

public class Disaster {
    private Long id;
    private String title;
    private String details;
    private Date createDate;
    private User provider;
    private String expectGoodsName;
    private Double expectGoodsCnt;
    private String expectGoodsUnit;
    private String pass;

    public Disaster() {
    }

    public Disaster(String title, String details, Date createDate, User provider, String expectGoodsName, Double expectGoodsCnt, String expectGoodsUnit) {
        this.title = title;
        this.details = details;
        this.createDate = createDate;
        this.provider = provider;
        this.expectGoodsName = expectGoodsName;
        this.expectGoodsCnt = expectGoodsCnt;
        this.expectGoodsUnit = expectGoodsUnit;
        this.pass = "暂未审批";
    }

    @Override
    public String toString() {
        return "Disaster{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", createDate=" + createDate +
                ", provider=" + provider +
                ", expectGoodsName='" + expectGoodsName + '\'' +
                ", expectGoodsCnt=" + expectGoodsCnt +
                ", expectGoodsUnit='" + expectGoodsUnit + '\'' +
                ", pass=" + pass +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disaster)) return false;
        Disaster disaster = (Disaster) o;
        return Objects.equals(getId(), disaster.getId()) &&
                Objects.equals(getTitle(), disaster.getTitle()) &&
                Objects.equals(getDetails(), disaster.getDetails()) &&
                Objects.equals(getCreateDate(), disaster.getCreateDate()) &&
                Objects.equals(getProvider(), disaster.getProvider()) &&
                Objects.equals(getExpectGoodsName(), disaster.getExpectGoodsName()) &&
                Objects.equals(getExpectGoodsCnt(), disaster.getExpectGoodsCnt()) &&
                Objects.equals(getExpectGoodsUnit(), disaster.getExpectGoodsUnit()) &&
                Objects.equals(getPass(), disaster.getPass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDetails(), getCreateDate(), getProvider(), getExpectGoodsName(), getExpectGoodsCnt(), getExpectGoodsUnit(), getPass());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public String getExpectGoodsName() {
        return expectGoodsName;
    }

    public void setExpectGoodsName(String expectGoodsName) {
        this.expectGoodsName = expectGoodsName;
    }

    public Double getExpectGoodsCnt() {
        return expectGoodsCnt;
    }

    public void setExpectGoodsCnt(Double expectGoodsCnt) {
        this.expectGoodsCnt = expectGoodsCnt;
    }

    public String getExpectGoodsUnit() {
        return expectGoodsUnit;
    }

    public void setExpectGoodsUnit(String expectGoodsUnit) {
        this.expectGoodsUnit = expectGoodsUnit;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
