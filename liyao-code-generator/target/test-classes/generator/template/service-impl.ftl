package ${serviceImplPackage};

import ${mapperPackage}.${modelNameUpperCamel}Mapper;
import ${modelPackage}.${modelNameUpperCamel};
import ${servicePackage}.${modelNameUpperCamel}Service;
import ${abstractServiceClassReference};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
