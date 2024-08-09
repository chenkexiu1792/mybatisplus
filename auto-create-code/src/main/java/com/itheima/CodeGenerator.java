package com.itheima;

import ch.qos.logback.core.CoreConstants;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author Administrator
 * @Version 1.0
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://192.168.134.189:33306/ora9a?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&allowMultiQueries=true&rewriteBatchedStatements=true&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("rootroot");

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //生成目录
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/auto-create-code/src/main/java");
        globalConfig.setAuthor("Herman"); //作者
        globalConfig.setOpen(false);//生成完毕后，是否打开生成文件所在目录
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        globalConfig.setFileOverride(true);//设置是否生成原始文件
        globalConfig.setMapperName("%sDao");//设置数据层接口
        //globalConfig.setIdType(IdType.ASSIGN_ID);//设置ID生成策略
        //包相关配置
        // 包配置
        PackageConfig packageInfo = new PackageConfig();
        //packageConfig.setModuleName(scanner("模块名"));  模块名
        packageInfo.setParent("com.xj.monitor"); //生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageInfo.setEntity("domain");//实体包名
        packageInfo.setMapper("mapper");//数据层包名

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("tb_suspend_status");
        strategy.setTablePrefix("tb_");
        strategy.setRestControllerStyle(true);//是否设置rest 风格
        strategy.setVersionFieldName("version");//乐观锁字段名
        strategy.setLogicDeleteFieldName("deleted");//逻辑删除字段名
        strategy.setEntityLombokModel(true); //是否启用 lombok 机制
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");

        autoGenerator.setStrategy(strategy);
        autoGenerator.setPackageInfo(packageInfo);
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.execute();
        System.out.println("test");
    }
}
