package com.tellmetheodds.oddsgrabber.domain;

import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * The oddsgrabber domain application class.
 *
 * Created by rr.t3ch on 18/12/16.
 */
public class OddsgrabberDomainApplication extends Application<OddsgrabberDomainConfiguration>{

    private  static final Logger LOGGER = LoggerFactory.getLogger(OddsgrabberDomainApplication.class);

    /**
     * Starting point of the Dropwizard application.
     *
     * @param args the args to pass in.
     * @throws Exception the Exception thrown.
     */
    public static void main (String args[]) throws Exception {
        new OddsgrabberDomainApplication().run(args);
    }

    /**
     * Bootstrap the REST service.
     *
     * @param bootstrap config file of the application
     */
    @Override
    public void initialize(Bootstrap<OddsgrabberDomainConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<OddsgrabberDomainConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(OddsgrabberDomainConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });
    }

    /**
     * Run the application.
     *
     * @param configuration application config
     * @param environment Dropwizard evironment
     * @throws Exception unable to start Dropwizard application
     */
    @Override
    public void run(OddsgrabberDomainConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Oddsgrabber Domain started succesfully");
    }
}
