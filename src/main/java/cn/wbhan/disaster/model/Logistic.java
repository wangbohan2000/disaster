package cn.wbhan.disaster.model;

import java.util.Date;
import java.util.Objects;

public class Logistic {
    private static final long DELIVER_TIME = 60 * 60 * 24 * 3;
    private Long id;
    private User manager;
    private User dest;
    private String status;
    private Date startTime;
    private Date endTime;
    private Goods goods;
    private Disaster disaster;

    public Logistic(User manager, User dest, String status, Date startTime, Goods goods, Disaster disaster) {
        this.manager = manager;
        this.dest = dest;
        this.status = status;
        this.startTime = startTime;
        this.endTime = Date.from(startTime.toInstant().plusSeconds(DELIVER_TIME));
        this.goods = goods;
        this.disaster = disaster;
    }

    @Override
    public String toString() {
        return "Logistic{" +
                "id=" + id +
                ", manager=" + manager +
                ", dest=" + dest +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", goods=" + goods +
                ", disaster=" + disaster +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Logistic)) return false;
        Logistic logistic = (Logistic) o;
        return Objects.equals(getId(), logistic.getId()) &&
                Objects.equals(getManager(), logistic.getManager()) &&
                Objects.equals(getDest(), logistic.getDest()) &&
                Objects.equals(getStatus(), logistic.getStatus()) &&
                Objects.equals(getStartTime(), logistic.getStartTime()) &&
                Objects.equals(getEndTime(), logistic.getEndTime()) &&
                Objects.equals(getGoods(), logistic.getGoods()) &&
                Objects.equals(getDisaster(), logistic.getDisaster());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getManager(), getDest(), getStatus(), getStartTime(), getEndTime(), getGoods(), getDisaster());
    }

    public Logistic() {
    }

    public static long getDeliverTime() {
        return DELIVER_TIME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getDest() {
        return dest;
    }

    public void setDest(User dest) {
        this.dest = dest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Disaster getDisaster() {
        return disaster;
    }

    public void setDisaster(Disaster disaster) {
        this.disaster = disaster;
    }
}
