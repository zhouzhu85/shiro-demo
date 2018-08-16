package com.github.zhouzhu.shiro.dao;

import java.util.List;

/**
 * @ClassName: UserRunAsDao
 * @author:zhouzhu
 * @Date: 2018/8/14 10:32
 * @Version: V1.0
 */
public interface UserRunAsDao {
    public void grantRunAs(Long fromUserId,Long toUserId);
    public void revokeRunAs(Long fromUserId,Long toUserId);
    public boolean exists(Long fromUserId,Long toUserId);
    public List<Long> findFromUserIds(Long toUserId);
    public List<Long> findToUserIds(Long fromUserId);
}
