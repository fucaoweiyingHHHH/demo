package com.djt.ssmdemo.service.sensorService;


import com.djt.ssmdemo.Vo.R;

/**
 *  传感器统计报表服务层
 */
public interface AnSensorService {
    /**
     *根据查询条件查询出传感器的表格数据
     * @return
     */
    R selectAnSensorInfoList();
}
