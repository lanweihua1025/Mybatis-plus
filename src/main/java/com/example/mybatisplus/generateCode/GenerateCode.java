package com.example.mybatisplus.generateCode;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateCode {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        // .setKotlin(true) 是否生成 kotlin 代码
        gc.setAuthor("weihua lan");
        gc.setSwagger2(true);//swagger2 实体生成代码
        gc.setOpen(false);//是否打开输出目录

        gc.setDateType(DateType.ONLY_DATE);


        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        gc.setServiceName("%sService");
        // gc.setServiceImplName("%sServiceDiy");
//        gc.setControllerName("%sAction");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("19971025lwh");
        dsc.setUrl("jdbc:mysql://localhost:3306/mtg_ssdb?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC");
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix("s_", "g_","edr_","dd_","td_","uaams_","ncp_","t_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setEntityLombokModel(true);// 设置生成LombokModel注解
        strategy.setFieldPrefix("F_"); //设置字段前缀忽略
        strategy.setRestControllerStyle(true);//生成 RESTFul风格对的 controller 代码
        strategy.setEntityBooleanColumnRemoveIsPrefix(false);//Boolean类型是否去掉is前缀
        strategy.setSkipView(true);//跳过视图
        strategy.setEntityTableFieldAnnotationEnable(true);//生成实体是生成注解字段
        strategy.setVersionFieldName("version");

        //默认填充字段策略
        List<TableFill> tableFillList = new ArrayList<>(4);
        tableFillList.add(new TableFill("C_DATE", FieldFill.INSERT));
        tableFillList.add(new TableFill("CREATE_DATE", FieldFill.INSERT));
        tableFillList.add(new TableFill("U_DATE", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("UPDATE_DATE", FieldFill.INSERT_UPDATE));
        strategy.setTableFillList(tableFillList);//默认填充字段策略

        strategy.setInclude("bu_order"); // 需要生成的表

        // 排除生成的表
        //strategy.setExclude("f_ggroup_detail", "f_oerder_detail");
        //用于扩展plus功能
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        // 生成乐观锁注解字段
        //strategy.setVersionFieldName("VERSION_CODE");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example");
        pc.setModuleName("mybatisplus");
        pc.setEntity("moudel");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };


        // 自定义文件和模板 xxList.jsp 生成
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
        // 自定义输入文件名称
//                return "target/jsp/my_" + tableInfo.getEntityName() + ".jsp";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // 调整 xml 生成目录
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String tableName=tableInfo.getEntityName().replace("Edr","");
                return projectPath+"/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);

        //关闭controller 生成设置参数为 null
//        tc.setController(null);
        mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);


        // 执行生成
        mpg.execute();

        // 打印注入设置【可无】
//        logger.warn("Custom value test: {}", mpg.getCfg().getMap().get("abc"));
    }
}
