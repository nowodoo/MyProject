package com.zach.dubboprovider;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpsConfig {
    @Value("${server.port}")
    private int serverHttpPort;
    @Value("${server.https.port}")
    private int serverHttpsPort;
    @Value("${custom.tomcat.ssl.key-store}")
    private String keystoreFilePath;
    @Value("${custom.tomcat.ssl.key-store-password}")
    private String keystorePass;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/static*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };


        //主要的连接配置都在这里
        tomcat.addAdditionalTomcatConnectors(initiateHttpsConnector());
        return tomcat;
    }


    //原先的http转发为https协议
    private Connector initiateHttpsConnector() {
        Connector connector = new Connector();
        connector.setPort(serverHttpsPort);
        connector.setSecure(true);
        connector.setScheme("https");
        connector.setProperty("SSLEnabled", "true");
        connector.setProperty("keystoreFile", keystoreFilePath);
        connector.setProperty("keystorePass", keystorePass);
        return connector;
    }
}
