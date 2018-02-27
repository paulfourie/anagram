/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author paulf
 */

@Path("/anagram")
public class Item_param_sResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Item_param_sResource
     */
    public Item_param_sResource() {
    }

    /**
     * Retrieves representation of an instance of anagram.Item_param_sResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * Sub-resource locator method for {param}
     */
    @Path("{param}")
    public Item_param_Resource getItem_param_Resource(@PathParam("param") String param) {
        
        return Item_param_Resource.getInstance(param);
        
    }
}
