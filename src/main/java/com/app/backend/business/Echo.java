package com.app.backend.business;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

//[START echo_api_annotation]
@Api(
name = "echo",
version = "v1",
namespace =
@ApiNamespace(
ownerDomain = "apiclient.business.api.app.com",
ownerName = "apiclient.business.api.app.com",
packagePath = ""
),
//[START_EXCLUDE]
issuers = {
@ApiIssuer(
name = "firebase",
issuer = "https://securetoken.google.com/my-api-new",
jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
}
//[END_EXCLUDE]
)
//[END echo_api_annotation]

public class Echo {

	
	@ApiMethod(name="print", path="print", httpMethod = HttpMethod.GET)
	public Message saveClient() {		
		Message message = new Message();			
		try {
			message.setMessage("Save...");
		} catch (Exception e) {
			e.printStackTrace();
			message.setMessage("Fail...");			
		}						
		return message;
	}
	
}
