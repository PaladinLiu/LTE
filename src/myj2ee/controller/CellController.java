package myj2ee.controller;

import myj2ee.bean.Cell;
import myj2ee.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class CellController {

    @Autowired
    private CellService cellService;

    @ResponseBody
    @RequestMapping(value = "/getCellByCellId", method = RequestMethod.POST)
    public Map<String, Object> getCellByCellId(@RequestBody Map<String, Object> map){

        String id = (String) map.get("cellId");
        Cell cell = cellService.getCellByCellId(id);
        List<Cell> cells = new LinkedList<>();
        cells.add(cell);

        Map<String, Object> respbody = new HashMap<>();
        respbody.put("cells", cells);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/getCellByCellName", method = RequestMethod.POST)
    public Map<String, Object> getCellByCellName(@RequestBody Map<String, Object> map){

        String name = (String) map.get("cellName");
        Cell cell = cellService.getCellByCellName(name);
        List<Cell> cells = new LinkedList<>();
        cells.add(cell);

        Map<String, Object> respbody = new HashMap<>();
        respbody.put("cells", cells);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/getCellByEnodebId", method = RequestMethod.POST)
    public Map<String, Object> getCellByEnodebId(@RequestBody Map<String, Object> map){

        Integer id = (Integer) map.get("enodebId");
        List<Cell> cells = cellService.getCellByEnodebId(id);

        Map<String, Object> respbody = new HashMap<>();
        respbody.put("cells", cells);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/getCellByEnodebName", method = RequestMethod.POST)
    public Map<String, Object> getCellByEnodebName(@RequestBody Map<String, Object> map){

        String name = (String) map.get("enodebName");
        List<Cell> cells = cellService.getCellByEnodebName(name);

        Map<String, Object> respbody = new HashMap<>();
        respbody.put("cells", cells);
        respbody.put("isError", 0);

        return respbody;
    }


    @ResponseBody
    @RequestMapping(value = "/cellIds",method = RequestMethod.POST)
    public Map<String, Object> getAllCellId(){

        List<String> ids = cellService.getAllCellId();
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("cellIds", ids);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/cell/cellNames",method = RequestMethod.POST)
    public Map<String, Object> getAllCellName(){

        List<String> names = cellService.getAllCellName();
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("cellNames", names);
        respbody.put("isError", 0);

        return respbody;
    }



    @ResponseBody
    @RequestMapping(value = "/enodebIds",method = RequestMethod.POST)
    public Map<String, Object> getAllEnodebId(){

        List<Integer> ids = cellService.getAllEnodebId();
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("enodebIds", ids);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/enodebNames",method = RequestMethod.POST)
    public Map<String, Object> getAllEnodebName(){

        List<String> names = cellService.getAllEnodebName();
        Map<String, Object> respbody = new HashMap<>();
        respbody.put("enodebNames", names);
        respbody.put("isError", 0);

        return respbody;
    }


}
