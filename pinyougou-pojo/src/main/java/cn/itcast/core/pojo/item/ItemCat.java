package cn.itcast.core.pojo.item;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.util.Objects;
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a

public class ItemCat implements Serializable {
    /**
     * 类目ID
     */
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类型id
     */
    private Long typeId;
<<<<<<< HEAD
=======
    //状态
    private String auditStatus;
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
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
        ItemCat other = (ItemCat) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()));
=======
    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public String toString() {
        return "ItemCat{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", auditStatus='" + auditStatus + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCat itemCat = (ItemCat) o;
        return Objects.equals(id, itemCat.id) &&
                Objects.equals(parentId, itemCat.parentId) &&
                Objects.equals(name, itemCat.name) &&
                Objects.equals(typeId, itemCat.typeId) &&
                Objects.equals(auditStatus, itemCat.auditStatus);
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        return result;
=======

        return Objects.hash(id, parentId, name, typeId, auditStatus);
>>>>>>> 73002f8a2a5c268dfdf18fd51c676b1f11ec052a
    }
}