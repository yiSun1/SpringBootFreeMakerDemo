package com.jmail.demo.dao;

import com.jmail.demo.dao.model.KePRole;
import java.util.List;
import java.util.Map;

public interface KePRoleMapper {
    /**
     *  根据主键删除数据库的记录,ke_p_role
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,ke_p_role
     *
     * @param record
     */
    int insert(KePRole record);

    /**
     *  动态字段,写入数据库记录,ke_p_role
     *
     * @param record
     */
    int insertSelective(KePRole record);

    /**
     *  根据指定主键获取一条数据库记录,ke_p_role
     *
     * @param id
     */
    KePRole selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,ke_p_role
     *
     * @param record
     */
    int updateByPrimaryKeySelective(KePRole record);

    /**
     *  根据主键来更新符合条件的数据库记录,ke_p_role
     *
     * @param record
     */
    int updateByPrimaryKey(KePRole record);

    /**
     *  根据参数Map查询数据库记录,ke_p_role
     *
     * @param queryMap
     */
    List<KePRole> querySelective(Map queryMap);
}