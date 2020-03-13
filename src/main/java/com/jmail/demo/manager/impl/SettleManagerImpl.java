package com.jmail.demo.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmail.demo.common.PageModel;
import com.jmail.demo.common.RemoteResult;
import com.jmail.demo.dao.KePRoleMapper;
import com.jmail.demo.dao.model.KePRole;
import com.jmail.demo.manager.SettleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zhangxs7 on 2017/6/22.
 */
@Component("settleManager")
public class SettleManagerImpl implements SettleManager {

    @Autowired
    private KePRoleMapper kePRoleMapper;
    @Autowired
    private PageHelper pageHelper;

    @Override
    public KePRole get1(Integer id) {
        return kePRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public RemoteResult<PageModel<KePRole>> queryPage(Page pageQuery, Map map) {
        RemoteResult<PageModel<KePRole>> result=new RemoteResult<>(true);
        pageHelper.startPage(pageQuery.getPageNum(),pageQuery.getPageSize());
        PageInfo<KePRole> hotKeys = PageHelper.startPage(pageQuery.getPageNum(),pageQuery.getPageSize())
                .doSelectPageInfo(()-> kePRoleMapper.querySelective(map));
        if(hotKeys==null|| hotKeys.getList()==null ||  hotKeys.getList().isEmpty()){
            return result.msg("未查询到数据").data(new PageModel());
        }
        PageModel<KePRole> dataPageModel=new PageModel<KePRole>(hotKeys);
        return result.data(dataPageModel);
    }
}
