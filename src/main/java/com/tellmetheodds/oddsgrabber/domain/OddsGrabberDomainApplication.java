package com.tellmetheodds.oddsgrabber.domain;

import com.tellmetheodds.oddsgrabber.domain.resources.OddsGrabberDomainResource;
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
public class OddsGrabberDomainApplication extends Application<OddsGrabberDomainConfiguration>{

    private  static final Logger LOGGER = LoggerFactory.getLogger(OddsGrabberDomainApplication.class);

    /**
     * Starting point of the Dropwizard application.
     *
     * @param args the args to pass in.
     * @throws Exception the Exception thrown.
     */
    public static void main (String args[]) throws Exception {
        new OddsGrabberDomainApplication().run(args);
    }

    /**
     * Bootstrap the REST service.
     *
     * @param bootstrap config file of the application
     */
    @Override
    public void initialize(Bootstrap<OddsGrabberDomainConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<OddsGrabberDomainConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(OddsGrabberDomainConfiguration configuration) {
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
    public void run(OddsGrabberDomainConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new OddsGrabberDomainResource());
        LOGGER.info("Oddsgrabber Domain started succesfully");
    }
}
