package com.djt.ssmdemo.entity.sensorVo;

import java.util.Date;

/**
 * @author dongjianting
 * 传感器实体类
 */
public class SensorInfo {
    /**
     * 传感器id
     */
    private String id;
    /**
     * 传感器名称
     */
    private String sensorName;
    /**
     * 传感器系数
     */
    private String sensorCoefficient;
    /**
     * 传感器埋地时间
     */
    private Date embementDate;
    /**
     * 传感器埋地高度
     */
    private String embementHeight;
    /**
     * 传感器单位
     */
    private String frequencyValue;
    /**
     * 传感器位置
     */
    private String locationInfo;
    /**
     * 传感器类型id
     */
    private String sensorTypeId;
    /**
     * 传感器船闸id
     */
    private String navigationLockId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorCoefficient() {
        return sensorCoefficient;
    }

    public void setSensorCoefficient(String sensorCoefficient) {
        this.sensorCoefficient = sensorCoefficient;
    }

    public Date getEmbementDate() {
        return embementDate;
    }

    public void setEmbementDate(Date embementDate) {
        this.embementDate = embementDate;
    }

    public String getEmbementHeight() {
        return embementHeight;
    }

    public void setEmbementHeight(String embementHeight) {
        this.embementHeight = embementHeight;
    }

    public String getFrequencyValue() {
        return frequencyValue;
    }

    public void setFrequencyValue(String frequencyValue) {
        this.frequencyValue = frequencyValue;
    }

    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    public String getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(String sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public String getNavigationLockId() {
        return navigationLockId;
    }

    public void setNavigationLockId(String navigationLockId) {
        this.navigationLockId = navigationLockId;
    }
}
