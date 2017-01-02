package com.aayud.restresource.messenger.Resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aayud.restresource.messenger.Exceptions.DataNotFoundException;
import com.aayud.restresource.messenger.model.Message;
import com.aayud.restresource.messenger.service.MessageService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {
	
	MessageService messageService = new MessageService();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId")long id) throws DataNotFoundException{
    	System.out.println("Id passed is :" + id);
    	return  messageService.getMessage(id); 
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){
    	return messageService.addMessage(message);
    }
    
    @PUT
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message,@PathParam("messageId")long id){
    	return messageService.updateMessage(message, id);
    }
    
    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteMessage(@PathParam("messageId")long id){
    	messageService.deleteMessage(id);
    	return "Deleted message with messageID :" + id;
    }
    
    @GET
    @Path("getCount")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessageCount(){
    	return "Message Count is: " + messageService.getMessageCount();
    	
    }
    
}
