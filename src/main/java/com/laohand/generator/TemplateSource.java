package com.laohand.generator;

/**
 * @author liuBing
 */
public interface TemplateSource {
    /**
     * 控制器模板
     *
     * @return
     */
    String getControllerTemplate();

    /**
     * pojo模板
     *
     * @return
     */
    String getPojoTemplate();

    /**
     * service接口模板
     *
     * @return
     */
    String getServiceTemplate();

    /**
     * service实现模板
     *
     * @return
     */
    String getServiceImplTemplate();

    /**
     * mapper模板
     *
     * @return
     */
    String getMapperTemplate();


    /**
     * sql生成器模板
     *
     * @return
     */
    String getSqlBuilderTemplate();

    /**
     * spring boot application核心启动类配置文件
     * @return
     */
    String getApplicationTemplate();
}
