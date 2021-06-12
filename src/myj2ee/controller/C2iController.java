package myj2ee.controller;

import myj2ee.service.C2iService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class C2iController {

    @Autowired
    private C2iService c2iService;

    @RequestMapping(value = "/generateC2INew", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> generateC2INew(){
        int status = c2iService.generateNew();
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("status", status);
        respbody.put("isError", 0);

        return respbody;
    }

    @RequestMapping(value = "/generateC2I3", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> generateC2I3(@RequestBody Map<String, Object> map){

        double x = (double) map.get("x");
        int status = c2iService.generate3(x);
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("status", status);
        respbody.put("isError", 0);

        return respbody;
    }

}
