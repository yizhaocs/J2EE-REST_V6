package org.koushik.javabrains.messenger6.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger6.model.Message;
import org.koushik.javabrains.messenger6.service.MessageService;

/**
 * REST Web Services 19 - Implementing POST Method
 * http://localhost:8080/messenger6/webapi/messages
 * http://localhost:8080/messenger6/webapi/messages/1
 * http://localhost:8080/messenger6/webapi/messages/2
 * http://localhost:8080/messenger6/webapi/messages/test
 */
@Path("/messages")
public class MessageResource {	
	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	// public Message test3(@PathParam("messageId")String messageId){
	public Message getMessage(@PathParam("messageId")long messageId){
		return messageService.getMessage(messageId);
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test1(){
		return "test";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}

//	@GET
//	@Path("/{messageId}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test2(){
//		return "messageId";
//	}
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getHelloWorld(){
//		return "Hello World!";
//	}
}
