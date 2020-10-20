package com.laohand.generator;


/**
 * @Author: LiuBing
 * @Description //TODO $
 * @Date: ${DATE} ${TIME}
 * @Version: 1.0
 */
public class TemplateSourceDefault implements TemplateSource {
    /**
     * 控制器模板
     *
     * @return
     */
    @Override
    public String getControllerTemplate() {
        return "package PACKAGE.controller;\n" +
                "\n" +
                "import com.alibaba.fastjson.JSONObject;\n"+
                "import org.slf4j.Logger;\n" +
                "import org.slf4j.LoggerFactory;\n"+
                "import PACKAGE.pojo.CLASS_NAME_UPPER;\n" +
                "import PACKAGE.service.CLASS_NAME_UPPERService;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.validation.annotation.Validated;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "/**\n" +
                " * @Author: LiuBing\n" +
                " * @Description generator\n" +
                " * @Version: 1.0\n" +
                " */\n" +
                "@RestController\n" +
                "@RequestMapping(path = \"/CLASS_NAME_LOWER\")\n" +
                "@Validated\n" +
                "public class CLASS_NAME_UPPERController {\n" +
                "    @Autowired\n" +
                "    private CLASS_NAME_UPPERService CLASS_NAME_LOWERService;\n" +
                "    private Logger logger = LoggerFactory.getLogger(this.getClass());\n"+
                "\n" +
                "    /**\n" +
                "     * 新增/更新数据\n" +
                "     *\n" +
                "     * @param CLASS_NAME_LOWER\n" +
                "     * @return\n" +
                "     */\n" +
                "    @PostMapping(\"/save\")\n" +
                "    @ResponseBody\n" +
                "    public Object save(CLASS_NAME_UPPER CLASS_NAME_LOWER) {\n" +
                "        Integer ret = CLASS_NAME_LOWERService.save(CLASS_NAME_LOWER);\n" +
                "        return ret;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 分页列表\n" +
                "     *\n" +
                "     * @param param\n" +
                "     * @return\n" +
                "     */\n" +
                "    @PostMapping(\"/list\")\n" +
                "    @ResponseBody\n" +
                "    public Object list(@RequestBody JSONObject param) {\n" +
                "        return CLASS_NAME_LOWERService.list(param);\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 更新数据\n" +
                "     *\n" +
                "     * @param id\n" +
                "     * @return\n" +
                "     */\n" +
                "    @PutMapping(\"/updateStatus\")\n" +
                "    @ResponseBody\n" +
                "    public Object updateStatus(Integer id) {\n" +
                "        if (id == null || id < 0) {\n" +
                "            return \"Params id Error\";\n" +
                "        }\n" +
                "        return CLASS_NAME_LOWERService.updateStatus(id, 2);\n" +
                "    }\n" +
                "}\n";
    }

    /**
     * pojo模板
     *
     * @return
     */
    @Override
    public String getPojoTemplate() {
        return "package PACKAGE.pojo;\n" +
                "\n" +
                "import lombok.Data;\n" +
                "\n" +
                "import javax.persistence.Column;\n" +
                "import javax.persistence.Id;\n" +
                "import javax.persistence.Table;\n" +
                "import java.io.Serializable;\n" +
                "import java.util.Date;\n" +
                "/*\n" +
                " * @Author: LiuBing\n" +
                " * @Description generator\n" +
                " * @Version: 1.0\n" +
                " */" +
                "@Data\n" +
                "@Table(name = \"TABLE_NAME\")\n" +
                "public class CLASS_NAME_UPPER implements Serializable {\n" +
                "POJO_FIELD" +
                "}";
    }

    /**
     * 生成Service模板
     *
     * @return
     */
    @Override
    public String getServiceTemplate() {
        return "package PACKAGE.service;\n" +
                "\n" +
                "import com.alibaba.fastjson.JSONObject;\n"+
                "import PACKAGE.pojo.CLASS_NAME_UPPER;\n"+
                "import java.util.Map;\n"+
                "\n" +
                "/**\n" +
                " * @Author: LiuBing\n" +
                " * @Description generator $\n" +
                " * @Version: 1.0\n" +
                " */" +
                "public interface CLASS_NAME_UPPERService {\n" +
                "\n" +
                "    /**\n" +
                "     * 新增/更新数据\n" +
                "     *\n" +
                "     * @param CLASS_NAME_LOWER\n" +
                "     * @return Integer\n" +
                "     */\n" +
                "    public Integer save(CLASS_NAME_UPPER CLASS_NAME_LOWER);" +
                "\n" +
                "    /**\n" +
                "     * 通过id获取一条记录\n" +
                "     *\n" +
                "     * @param id\n" +
                "     * @return CLASS_NAME_UPPER\n" +
                "     */\n" +
                "    public CLASS_NAME_UPPER getRowById(Integer id);" +
                "\n" +
                "    /**\n" +
                "     * 分页列表\n" +
                "     *\n" +
                "     * @param param\n" +
                "     * @return\n" +
                "     */\n" +
                "    public Map<String, Object> list(JSONObject param);"+
                "\n" +
                "    /**\n" +
                "     * 更新数据\n" +
                "     *\n" +
                "     * @param id\n" +
                "     * @param status\n" +
                "     * @return\n" +
                "     */\n" +
                "    public Integer updateStatus(Integer id, Integer status);" +
                "}\n";
    }

    /**
     * service实现模板
     *
     * @return
     */
    @Override
    public String getServiceImplTemplate() {
        return "package PACKAGE.service.impl;\n" +
                "\n" +
                "import com.github.pagehelper.PageHelper;\n" +
                "import com.alibaba.fastjson.JSONObject;\n"+
                "import PACKAGE.pojo.CLASS_NAME_UPPER;\n" +
                "import com.github.pagehelper.PageInfo;\n" +
                "import PACKAGE.mapper.CLASS_NAME_UPPERMapper;\n" +
                "import PACKAGE.service.CLASS_NAME_UPPERService;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.Map;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "import org.springframework.transaction.annotation.Transactional;\n"+
                "\n" +
                "import java.util.List;\n" +
                "/**\n" +
                " * @Author: LiuBing\n" +
                " * @Description generator $\n" +
                " * @Version: 1.0\n" +
                " */" +
                "@Service\n" +
                "public class CLASS_NAME_UPPERServiceImpl implements CLASS_NAME_UPPERService {\n" +
                "\n" +
                "    @Autowired\n" +
                "    private CLASS_NAME_UPPERMapper CLASS_NAME_LOWERMapper;\n" +
                "\n" +
                "    /**\n" +
                "     * 新增/更新数据\n" +
                "     *\n" +
                "     * @param CLASS_NAME_LOWER\n" +
                "     * @return Integer\n" +
                "     */\n" +
                "    @Override\n"+
                "    @Transactional(rollbackFor = Exception.class)\n"+
                "    public Integer save(CLASS_NAME_UPPER CLASS_NAME_LOWER) {\n" +
                "        int ret;\n" +
                "        if (CLASS_NAME_LOWER.getId() == null || CLASS_NAME_LOWER.getId() <= 0) {\n" +
                "            ret = CLASS_NAME_LOWERMapper.insertSelective(CLASS_NAME_LOWER);\n" +
                "        } else {\n" +
                "            ret = CLASS_NAME_LOWERMapper.updateByPrimaryKeySelective(CLASS_NAME_LOWER);\n" +
                "        }\n" +
                "        return ret;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 通过id获取一条记录\n" +
                "     *\n" +
                "     * @param id\n" +
                "     * @return CLASS_NAME_UPPER\n" +
                "     */\n" +
                "    @Override\n"+
                "    public CLASS_NAME_UPPER getRowById(Integer id) {\n" +
                "        return CLASS_NAME_LOWERMapper.getRowById(id);\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 分页列表\n" +
                "     *\n" +
                "     * @param param\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Override\n"+
                "    public Map<String, Object> list(JSONObject param) {\n" +
                "        List<CLASS_NAME_UPPER> list = CLASS_NAME_LOWERMapper.list(param);\n" +
                "        PageHelper.startPage(Integer.parseInt(String.valueOf(param.get(\"page\"))), Integer.parseInt(String.valueOf(param.get(\"size\"))));\n" +
                "        PageInfo<CLASS_NAME_UPPER> pageInfo = new PageInfo<>(list);\n" +
                "        long total = pageInfo.getTotal();\n" +
                "        Map<String,Object> pages = new HashMap<>();\n" +
                "        pages.put(\"total\",pageInfo.getTotal());\n" +
                "        pages.put(\"list\",pageInfo.getList());\n"+
                "        return pages;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 更新数据\n" +
                "     *\n" +
                "     * @param id\n" +
                "     * @param status\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Override\n"+
                "    @Transactional(rollbackFor = Exception.class)\n"+
                "    public Integer updateStatus(Integer id, Integer status) {\n" +
                "        CLASS_NAME_UPPER CLASS_NAME_LOWER = new CLASS_NAME_UPPER();\n" +
                "        CLASS_NAME_LOWER.setId(id);\n" +
                "        //CLASS_NAME_LOWER.setStatus(status);\n" +
                "        return CLASS_NAME_LOWERMapper.updateByPrimaryKeySelective(CLASS_NAME_LOWER);\n" +
                "    }\n" +
                "\n" +
                "}\n";
    }

    /**
     * mapper模板
     *
     * @return
     */
    @Override
    public String getMapperTemplate() {
        return "package PACKAGE.mapper;\n" +
                "\n" +
                "import com.alibaba.fastjson.JSONObject;\n"+
                "import PACKAGE.pojo.CLASS_NAME_UPPER;\n" +
                "import org.apache.ibatis.annotations.Mapper;\n" +
                "import org.apache.ibatis.annotations.Select;\n" +
                "import org.apache.ibatis.annotations.SelectProvider;\n" +
                "import org.springframework.stereotype.Repository;\n" +
                "import tk.mybatis.mapper.common.BaseMapper;\n" +
                "\n" +
                "import java.util.List;\n" +
                "/**\n" +
                " * @Author: LiuBing\n" +
                " * @Description generator\n" +
                " * @Version: 1.0\n" +
                " */" +
                "@Mapper\n" +
                "@Repository\n" +
                "public interface CLASS_NAME_UPPERMapper extends BaseMapper<CLASS_NAME_UPPER> {\n" +
                "    /**\n" +
                "     * 列表\n" +
                "     *\n" +
                "     * @param param\n" +
                "     * @return\n" +
                "     */\n" +
                "    @SelectProvider(type = CLASS_NAME_UPPERSqlBuilder.class, method = \"list\")\n" +
                "    List<CLASS_NAME_UPPER> list(JSONObject param);\n" +
                "\n" +
                "    /**\n" +
                "     * 获取一条记录\n" +
                "     *\n" +
                "     * @param id\n" +
                "     * @return\n" +
                "     */\n" +
                "    @Select(\"select * from TABLE_NAME where id=#{id} limit 1\")\n" +
                "    CLASS_NAME_UPPER getRowById(Integer id);\n" +
                "}";
    }

    /**
     * sql生成器模板
     *
     * @return
     */
    @Override
    public String getSqlBuilderTemplate() {
        return "package PACKAGE.mapper;\n" +
                "\n" +
                "import com.alibaba.fastjson.JSONObject;\n"+
                "import org.apache.ibatis.jdbc.SQL;\n" +
                "\n" +
                "/**\n" +
                " * @Author: LiuBing\n" +
                " * @Description generator\n" +
                " * @Version: 1.0\n" +
                " */" +
                "public class CLASS_NAME_UPPERSqlBuilder {\n" +
                "    public String list(JSONObject param) {\n" +
                "        SQL sql = new SQL();\n" +
                "        sql.SELECT(\"*\").FROM(\"TABLE_NAME\");\n" +
                "        sql.ORDER_BY(\"id DESC\");\n" +
                "        return sql.toString();\n" +
                "    }\n" +
                "}";
    }


    /**
     * spring boot application生成器模板
     *
     * @return
     */
    @Override
    public String getApplicationTemplate() {
        return "package PACKAGE;\n" +
                "\n" +
                "import org.springframework.boot.SpringApplication;\n"+
                "import org.springframework.boot.autoconfigure.SpringBootApplication;\n" +
                "import tk.mybatis.spring.annotation.MapperScan;\n" +
                "\n" +
                "/**\n" +
                " * @Author: LiuBing\n" +
                " * @Description generator\n" +
                " * @Version: 1.0\n" +
                " */\n" +
                "@SpringBootApplication\n"+
                "@MapperScan(basePackages = \"PACKAGE.mapper\")\n"+
                "public class CLASS_NAME_UPPERApplication {\n" +
                " public static void main(String[] args) {\n" +
                "        SpringApplication.run(CLASS_NAME_UPPERApplication.class,args);\n" +
                "    }\n" +
                "}";
    }
}
