package com.jmail.demo.dao.model;

/**
 * 
 * KePRole
 * 数据库表：ke_p_role
 * @author zhangxs7
 * @date 2020-03-13 12:34:21
 */
public class KePRole {

    /**
     * 
     * 表字段 : ke_p_role.id
     */
    private Integer id;

    /**
     * role name
     * 表字段 : ke_p_role.name
     */
    private String name;

    /**
     * rank
     * 表字段 : ke_p_role.seq
     */
    private Integer seq;

    /**
     * role describe
     * 表字段 : ke_p_role.description
     */
    private String description;

    /**
     * 获取  字段:ke_p_role.id
     *
     * @return ke_p_role.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:ke_p_role.id
     *
     * @param id the value for ke_p_role.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 role name 字段:ke_p_role.name
     *
     * @return ke_p_role.name, role name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 role name 字段:ke_p_role.name
     *
     * @param name the value for ke_p_role.name, role name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 rank 字段:ke_p_role.seq
     *
     * @return ke_p_role.seq, rank
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置 rank 字段:ke_p_role.seq
     *
     * @param seq the value for ke_p_role.seq, rank
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取 role describe 字段:ke_p_role.description
     *
     * @return ke_p_role.description, role describe
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 role describe 字段:ke_p_role.description
     *
     * @param description the value for ke_p_role.description, role describe
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * ,ke_p_role
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", seq=").append(seq);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}