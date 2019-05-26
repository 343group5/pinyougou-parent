package cn.itcast.core.pojo.specification;

import java.io.Serializable;

public class Specification implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String specName;

<<<<<<< HEAD
    /**
     * 名称
     */
    private String auditStatus;

=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

<<<<<<< HEAD
    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", specName=").append(specName);
<<<<<<< HEAD
        sb.append(", auditStatus=").append(auditStatus);
=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Specification other = (Specification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
<<<<<<< HEAD
            && (this.getSpecName() == null ? other.getSpecName() == null : this.getSpecName().equals(other.getSpecName())
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus())));
=======
            && (this.getSpecName() == null ? other.getSpecName() == null : this.getSpecName().equals(other.getSpecName()));
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpecName() == null) ? 0 : getSpecName().hashCode());
<<<<<<< HEAD
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
=======
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
        return result;
    }
}