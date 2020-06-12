package cn.wbhan.disaster.model.vo;

import cn.wbhan.disaster.model.User;

import java.util.Date;
import java.util.Objects;

public class DisasterLogisticVo {
    private Long id;
    private String title;
    private String details;
    private Date createDate;
    private User provider;
    private String expectGoodsName;
    private Double expectGoodsCnt;
    private String expectGoodsUnit;
    private String pass;
    private String status;

    public DisasterLogisticVo() {
    }

    public DisasterLogisticVo(Long id, String title, String details, Date createDate, User provider, String expectGoodsName, Double expectGoodsCnt, String expectGoodsUnit, String pass, String status) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.createDate = createDate;
        this.provider = provider;
        this.expectGoodsName = expectGoodsName;
        this.expectGoodsCnt = expectGoodsCnt;
        this.expectGoodsUnit = expectGoodsUnit;
        this.pass = pass;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DisasterLogisticVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", createDate=" + createDate +
                ", provider=" + provider +
                ", expectGoodsName='" + expectGoodsName + '\'' +
                ", expectGoodsCnt=" + expectGoodsCnt +
                ", expectGoodsUnit='" + expectGoodsUnit + '\'' +
                ", pass='" + pass + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisasterLogisticVo)) return false;
        DisasterLogisticVo that = (DisasterLogisticVo) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getDetails(), that.getDetails()) &&
                Objects.equals(getCreateDate(), that.getCreateDate()) &&
                Objects.equals(getProvider(), that.getProvider()) &&
                Objects.equals(getExpectGoodsName(), that.getExpectGoodsName()) &&
                Objects.equals(getExpectGoodsCnt(), that.getExpectGoodsCnt()) &&
                Objects.equals(getExpectGoodsUnit(), that.getExpectGoodsUnit()) &&
                Objects.equals(getPass(), that.getPass()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDetails(), getCreateDate(), getProvider(), getExpectGoodsName(), getExpectGoodsCnt(), getExpectGoodsUnit(), getPass(), getStatus());
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
