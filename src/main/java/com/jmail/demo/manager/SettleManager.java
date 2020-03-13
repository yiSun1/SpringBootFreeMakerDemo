package com.jmail.demo.manager;

import com.github.pagehelper.Page;
import com.jmail.demo.common.PageModel;
import com.jmail.demo.common.RemoteResult;
import com.jmail.demo.dao.model.KePRole;

import java.util.Map;

/**
 * Created by zhangxs7 on 2017/6/22.
 */
public interface SettleManager {
    public KePRole get1(Integer id);

    RemoteResult<PageModel<KePRole>> queryPage(Page pageQuery, Map map);
}
