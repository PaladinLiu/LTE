package myj2ee.controller;

import myj2ee.common.Common;
import myj2ee.dao.KPIDao;
import myj2ee.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KPIController {

    @Autowired
    private KPIService kpiService;

    @RequestMapping(value = "/KPI/getPicture", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getPicture() throws IOException{
        InputStream is = new FileInputStream(new File(Common.exportPath + "img/a.png"));
        byte[] tmp = new byte[is.available()];
        is.read(tmp);
        is.close();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition", "a.png");

        return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/getKPIbyCellName", method = RequestMethod.POST)
    public ResponseEntity<byte[]> getKPIAttributeByCellName(@RequestBody Map<String, Object> map) throws IOException {

        String attribute = (String) map.get("attribute");
        Timestamp startTime = Timestamp.valueOf((String)map.get("startTime"));
        Timestamp endTime = Timestamp.valueOf((String)map.get("endTime"));
        String cellName = (String) map.get("cellName");

        File img = kpiService.getKPIAttributeByCellName( cellName, attribute, startTime, endTime);
        InputStream is = new FileInputStream(img);

        byte[] tmp = new byte[is.available()];
        is.read(tmp);
        is.close();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition", img.getName());

        return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping("/KPI/cellNames")
    @ResponseBody
    public Map<String ,Object> getAllCellNames(){
        List<String> names = kpiService.getAllCellNames();
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("cellNames", names);
        respbody.put("isError", 0);

        return respbody;
    }

}
