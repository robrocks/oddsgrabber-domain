package com.tellmetheodds.oddsgrabber.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * The oddsgrabber domain configuration class.
 *
 * Created by rr.t3ch on 18/12/16.
 */
public class OddsgrabberDomainConfiguration extends Configuration {

    /**
     * The swagger bundle configuration.
     */
    @Valid
    @NotNull
    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;

    /**
     * Get the swagger config.
     * @return swaggerBundleConfiguration
     */
    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }
}
