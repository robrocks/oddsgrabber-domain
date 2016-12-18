package com.tellmetheodds.oddsgrabber.domain.resources;

import com.tellmetheodds.oddsgrabber.domain.models.OddsSampleAverage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * the oddsgrabber API.
 *
 * Created by rr.t3ch on 18/12/16.
 */
@Path("/")
@Produces(APPLICATION_JSON)
@Api(value = "/", description = "OddsGrabber Domain")
public class OddsGrabberDomainResource {

    private  static final Logger LOGGER = LoggerFactory.getLogger(OddsGrabberDomainResource.class);

    @GET
    @Path("/odds-average/{marketId}")
    @ApiOperation(value = "Returns average for the odds sample.")
    @ApiResponses(value={
            @ApiResponse(code=200, message="Happy response"),
    })
    public Response getOddsAverageForMarket(@PathParam("marketId") int marketId) {
        // generate fake data
        Double oddsMinValue = 0.1;
        Double oddsMaxValue = 10.0;
        ArrayList<OddsSampleAverage> randomOdds = new ArrayList();

        for (int i=0; i < 5; i++) {
            Random r = new Random();
            double oddsRandomValue = oddsMinValue + (oddsMaxValue - oddsMinValue) * r.nextDouble();
            randomOdds.add(new OddsSampleAverage("2016-12-18", marketId, new BigDecimal(oddsRandomValue).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        }

        return Response.ok(randomOdds).build();
    }
}
