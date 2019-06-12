package com.djt.ssmdemo.entity.sensorVo;

/**
 * @author dongjianting
 * 传感器类型
 */
public class SensorType {
    /**
     * 传感器类型Id
     */
    private String id;
    /**
     * 传感器类型单位
     */
    private String sensorTypeUnit;
    /**
     * 传感器类型的名称
     */
    private String sensorTypeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSensorTypeUnit() {
        return sensorTypeUnit;
    }

    public void setSensorTypeUnit(String sensorTypeUnit) {
        this.sensorTypeUnit = sensorTypeUnit;
    }

    public String getSensorTypeName() {
        return sensorTypeName;
    }

    public void setSensorTypeName(String sensorTypeName) {
        this.sensorTypeName = sensorTypeName;
    }
}
