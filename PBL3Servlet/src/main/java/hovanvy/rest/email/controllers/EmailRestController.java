package hovanvy.rest.email.controllers;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hovanvy.util.EmailSenderUtil;

/**
 * 
 * @author hovanvydut
 * @apiNote access url: contextPath/api/v1/emails
 * @apiNote config prefix /api/* in web.xml --> url-pattern
 */

@Path("/v1/emails")
public class EmailRestController {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Hello Vy";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String sendCheckoutEmail(@FormParam("from") String from, @FormParam("to") String to, 
			@FormParam("plateNumber") String plateNumber, @FormParam("checkinAt") String checkinAt, 
			@FormParam("checkoutAt") String checkoutAt, @FormParam("token") String token) {
		
		if (!token.equals("spbl3hethongguixe")) {
			return "FAIL";
		}
		
		EmailSenderUtil.getInstance().sendEmailCheckout(from, to, plateNumber, checkinAt, checkoutAt);
		
		return "OK";
	}

}
