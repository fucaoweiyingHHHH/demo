package com.djt.ssmdemo.entity.sensorVo;

/**
 * @author dongjianting
 * 船闸信息实体类
 */
public class NavigationLockInfo {
    /**
     * 船闸id
     */
    private String id;
    /**
     * 船闸名称
     */
    private String navigationLockName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNavigationLockName() {
        return navigationLockName;
    }

    public void setNavigationLockName(String navigationLockName) {
        this.navigationLockName = navigationLockName;
    }
}
