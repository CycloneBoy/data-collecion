package com.cycloneboy.controller;

import com.cycloneboy.domain.Helmet;
import com.cycloneboy.repository.HelmetRepository;
import com.cycloneboy.utils.ResultMsg;
import com.cycloneboy.utils.ResultStatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by CycloneBoy on 2017/7/15.
 */
@RestController
@RequestMapping("/helmet")
public class HelmetController {

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
        helmetRepository.save(helmetEntity);
        ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),ResultStatusCode.OK.getErrmsg(),
                helmetEntity);
        return  resultMsg;
    }

    @Modifying
    @RequestMapping("/updatehelmet")
    public Object updateHelmet(@RequestBody Helmet helmetEntity){
        Helmet helmet = helmetRepository.findHelmetById(helmetEntity.getId());
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
