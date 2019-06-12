package com.djt.ssmdemo.Vo.sensorgridVo;

import com.djt.ssmdemo.entity.sensorVo.SensorInfo;

import java.util.Map;

/**
 * @author  dongjianting
 * 传感器统计报表表格视图
 */
public class SensorGridVo extends SensorInfo {
    /**
     *每个传感器日期收集值Map
     */
    private Map<String,Object> sensorDateMap;

    public Map<String, Object> getSensorDateMap() {
        return sensorDateMap;
    }

    public void setSensorDateMap(Map<String, Object> sensorDateMap) {
        this.sensorDateMap = sensorDateMap;
    }
}
