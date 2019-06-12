package com.djt.ssmdemo.dao.sensorechartDao;

import com.djt.ssmdemo.entity.sensorVo.SensorInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dongjianting
 * 船闸传感器echart视图dao
 */
@Repository
public interface NavigationLockSensorEchartDAO {
    /**
     *根据船闸传感器得到的表格信息
     * @param 查询条件（船闸id，传感器类型，日期，分页条件）
     * @return
     */
    List<SensorInfo> selectNavigationLockSensorGridInfo();

    /**
     * 根据船闸传感器得到的个数
     *@param 查询条件（船闸id，传感器类型，日期，分页条件）
     * @return
     */
    int selectNavigationLockSensorGridCount();

}
