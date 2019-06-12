package com.djt.ssmdemo.entity.sensorVo;

import java.util.Date;

/**
 * @author  dongjianting
 * 传感器值实体类
 */
public class SensorDateDataLog {
    /**
     * id
     */
    private String id;
    /**
     * 传感器id
     */
    private String sensorId;
    /**
     * 同步时间
     */
    private Date monitorDateTime;
    /**
     * 传感器的同步值
     */
    private String measureValue;
    /**
     * 值类型（x y 上游 下游）
     */
    private Integer measureType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Date getMonitorDateTime() {
        return monitorDateTime;
    }

    public void setMonitorDateTime(Date monitorDateTime) {
        this.monitorDateTime = monitorDateTime;
    }

    public String getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(String measureValue) {
        this.measureValue = measureValue;
    }

    public Integer getMeasureType() {
        return measureType;
    }

    public void setMeasureType(Integer measureType) {
        this.measureType = measureType;
    }
}
