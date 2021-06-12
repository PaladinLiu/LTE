package myj2ee.controller;

import myj2ee.common.Common;
import myj2ee.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@Controller
public class TableController {

    @Autowired
    private TableService tableService;

    private Set<String> tableNames = new HashSet<String>();

    public TableController(){
        tableNames.add("1.tbCell.csv");
        tableNames.add("9.tbMROData.csv");
        tableNames.add("10.tbC2I.xlsx");
        tableNames.add("12.tbCellKPI-优化区17日-19日KPI指标统计表-0717至0719.xlsx");
        tableNames.add("13.tbPRB-表13优化区17日-19日每PRB干扰查询-15分钟.xlsx");
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> upload(@RequestParam("tables") MultipartFile[] tables) throws IOException{
        String dirPath = Common.importPath;
        Map<String, Object> respbody = new HashMap<String, Object>();
        System.out.println(tables.length);
        List<String> tbNames = new ArrayList<>();
        for (MultipartFile multipartFile: tables) {
            if (!multipartFile.isEmpty()) {
                try {
                    multipartFile.transferTo(new File(dirPath + multipartFile.getOriginalFilename()));
                    tbNames.add(multipartFile.getOriginalFilename());
                } catch (IOException e) {
                    respbody.put("isError", 1);
                    respbody.put("msg", "文件上传失败");
                    return respbody;
                }
            }
        }
        respbody.put("tables", tbNames);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/import",method = RequestMethod.POST)
    public Map<String, Object> importTable(@RequestBody Map<String, Object> map){
        List<String> tablesNames = (List<String>) map.get("tables");

        List<Integer> status = tableService.importTables(tablesNames);
        Map<String, Object> respbody = new HashMap<>();

        respbody.put("status", status);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/export",method = RequestMethod.POST)
    public Map<String, Object> exportTable(@RequestBody Map<String, Object> map){
        List<String> tablesNames = (List<String>) map.get("tables");

        List<Integer> status = tableService.exportTables(tablesNames);
        Map<String, Object> respbody = new HashMap<>();

        respbody.put("status", status);
        respbody.put("isError", 0);

        return respbody;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<byte[]> download(@RequestBody Map<String, Object> map) throws IOException{
        String dirPath = Common.exportPath;
        String filename = (String) map.get("tableName");
        FileInputStream is = new FileInputStream(dirPath + filename);

        byte[] tmp = new byte[is.available()];
        is.read(tmp);
        is.close();

        //2、将要下载的文件流返回
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Disposition", filename);

        return new ResponseEntity<byte[]>(tmp, httpHeaders, HttpStatus.OK);
    }


    @RequestMapping(value = "/getTables", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getTableNames(){
        File dir = new File(Common.exportPath);
        String[] tableNmaes = dir.list();
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("tables", tableNmaes);
        respbody.put("isError", 0);

        return respbody;
    }

}
