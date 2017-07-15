package com.cycloneboy.controller;

import com.cycloneboy.domain.Helmet;
import com.cycloneboy.repository.HelmetRepository;
import com.cycloneboy.utils.ResultMsg;
import com.cycloneboy.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/15.
 */
@RestController
@RequestMapping("/helmet")
public class HelmetController {

    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    private final int LATEST_DATA_ID = 1;


    @Autowired
    private HelmetRepository helmetRepository;



    @RequestMapping("/gethelmet")
    public Object getHelmet(int id){
        Helmet  helmetEntity = helmetRepository.findHelmetById(id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),
                helmetEntity);
        return  resultMsg;
    }

    @RequestMapping("/gethelmets")
    public Object getHelmet(String name){
        List<Helmet> helmetEntities = helmetRepository.findHelmetsByName(name);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),
                helmetEntities);
        return  resultMsg;

    }

    @Modifying
    @RequestMapping("/addhelmet")
    public Object addHelmet(@RequestBody Helmet helmetEntity){
        Date date = new Date();
        helmetEntity.setTime(date);

        helmetRepository.save(helmetEntity);

        Helmet  helmet = helmetRepository.findHelmetById(LATEST_DATA_ID);
        if(helmet != null){
            helmet = helmetEntity;
            helmet.setId(LATEST_DATA_ID);
            helmetRepository.save(helmet);  //将最新的采集数据更新到 ID = 1
        }

        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),
                helmetEntity);
        return  resultMsg;
    }

    @Modifying
    @RequestMapping("/updatehelmet")
    public Object updateHelmet(@RequestBody Helmet helmetEntity){
        Helmet helmet = helmetRepository.findHelmetById(helmetEntity.getId());
        Date date = new Date();
        helmet.setTime(date);

        if(helmet != null){
            helmetRepository.save(helmet);
        }

        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),
                null);
        return  resultMsg;
    }

    @Modifying
    @RequestMapping("/deletehelmet")
    public Object deleteHelmet(int id){
        helmetRepository.delete(id);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),
                null);
        return  resultMsg;
    }
}
