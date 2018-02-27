/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;



/**
 * REST Web Service
 *
 * @author paulf
 */
public class Item_param_Resource {

    private String param;

    
    /**
     * Creates a new instance of Item_param_Resource
     */
    private Item_param_Resource(String param) {
        this.param = param;
    }
    
    

    /**
     * Get instance of the Item_param_Resource
     */
    public static Item_param_Resource getInstance(String param) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of Item_param_Resource class.
        return new Item_param_Resource(param) ;
        
        
        
    }

    /**
     * Retrieves representation of an instance of anagram.Item_param_Resource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
    //    throw new UnsupportedOperationException();
        
    //    return "{ \"anagram\" : }" + this.param + " }";
        
    //    JsonObject jsonreturn = Json.createObjectBuilder()
    //            .add("name","wally")
    //            .add("number",50)
    //            .build();
        
        
 //       JsonObject jsonreturn = Json.createObjectBuilder()
 //           .add( this.param , 
 //               Json.createArrayBuilder().add("00-000-0000")
 //                                        .add("11-111-1111")
 //                                        .add("11-111-1112")
 //                                        .build()                        
 //               )
 //       .build();
        
 //      return jsonreturn.toString() ;
        
        
                        
        data_reader l_reader = new data_reader() ;
        
        l_reader.read_data();   
        
        l_reader.build_hashset( this.param );
        
//        l_reader.get_anagram() ;
        

       
        JsonObjectBuilder  myjsonObjectBuilder = null;
       
        myjsonObjectBuilder = Json.createObjectBuilder();
        
        myjsonObjectBuilder.add( this.param , l_reader.p_answer ) ;

        
//        jsonObjectBuilder.build();
        
        
        return myjsonObjectBuilder.build().toString() ;
        
        
        
    }

    
    
    /**
     * PUT method for updating or creating an instance of Item_param_Resource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    /**
     * DELETE method for resource Item_param_Resource
     */
    @DELETE
    public void delete() {
    }
}
