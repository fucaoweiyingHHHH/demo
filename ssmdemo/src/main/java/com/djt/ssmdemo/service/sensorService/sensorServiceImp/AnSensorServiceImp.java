package com.djt.ssmdemo.service.sensorService.sensorServiceImp;

import com.djt.ssmdemo.Vo.R;
import com.djt.ssmdemo.dao.sensorechartDao.NavigationLockSensorEchartDAO;

import com.djt.ssmdemo.entity.sensorVo.SensorInfo;
import com.djt.ssmdemo.service.sensorService.AnSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author dongjianting
 * 传感器报表页面业务处理实现类
 */
@Service
public class AnSensorServiceImp implements AnSensorService {
    @Autowired
    private NavigationLockSensorEchartDAO  navigationLockSensorEchartDAO;
    @Override
    public R selectAnSensorInfoList() {
       List<SensorInfo> sensorInfoList= navigationLockSensorEchartDAO.selectNavigationLockSensorGridInfo();
       int count= navigationLockSensorEchartDAO.selectNavigationLockSensorGridCount();
        for (SensorInfo sensorInfo:sensorInfoList
             ) {

        }
        return null;
    }
}
