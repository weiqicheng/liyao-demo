package com.codegen.service.impl;

import com.codegen.service.CodeGenerator;
import com.codegen.service.CodeGeneratorManager;
import com.codegen.util.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Model & Mapper 代码生成器
 * Created by zhh on 2017/09/20.
 */
public class ModelAndMapperGenerator extends CodeGeneratorManager implements CodeGenerator {

    @Override
    public void genCode(String tableName, String modelName) {
        Context initConfig = initConfig(tableName, modelName);
        List<String> warnings = null;
        MyBatisGenerator generator = null;
        try {
            Configuration cfg = new Configuration();
            cfg.addContext(initConfig);

            cfg.validate();

            DefaultShellCallback callback = new DefaultShellCallback(true);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(cfg, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("Model 和  Mapper 生成失败!", e);
        }

        if (generator == null || generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("Model 和  Mapper 生成失败, warnings: " + warnings);
        }

        if (StringUtils.isNullOrEmpty(modelName)) {
            modelName = tableNameConvertUpperCamel(tableName);
        }

        logger.info(modelName + ".java 生成成功!");
        logger.info(modelName + "Mapper.java 生成成功!");
        logger.info(modelName + "Mapper.xml 生成成功!");
    }

    /**
     * 完善初始化环境
     *
     * @param tableName 表名
     * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
     */
    private Context initConfig(String tableName, String modelName) {
        Context context = null;
        try {
            context = initMybatisGeneratorContext();
            JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
            javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
            javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
            //设置父类的实体类，可以进行公共字段继承
            if (BASE_ENTITY_CLASS != null) {
                javaModelGeneratorConfiguration.addProperty("rootClass", BASE_ENTITY_CLASS);
            }
            context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

            JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
            javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
            javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
            javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
            context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

            TableConfiguration tableConfiguration = new TableConfiguration(context);
            tableConfiguration.setTableName(tableName);
            tableConfiguration.setDomainObjectName(modelName);
            //设置table生成是需要忽略的字段，通过父类进行反射
            if (BASE_ENTITY_CLASS != null) {
                Class<?> clazz = Class.forName(BASE_ENTITY_CLASS); // 取得Class对象
//                tableConfiguration.addIgnoredColumn(IgnoredColumn);
                Field[] fields = clazz.getDeclaredFields();
                for(int i = 0 ; i < fields.length ; i++) {
                    //设置是否允许访问，不是修改原来的访问权限修饰词。
                    fields[i].setAccessible(true);
                    System.out.println(fields[i].getName());
                    IgnoredColumn ignoredColumn=new IgnoredColumn(fields[i].getName());
                    tableConfiguration.addIgnoredColumn(ignoredColumn);
                }

            }
            tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
            context.addTableConfiguration(tableConfiguration);
        } catch (Exception e) {
            throw new RuntimeException("ModelAndMapperGenerator 初始化环境异常!", e);
        }
        return context;
    }
}
