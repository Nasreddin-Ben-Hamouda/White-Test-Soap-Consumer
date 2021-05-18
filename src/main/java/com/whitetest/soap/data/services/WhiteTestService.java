package com.whitetest.soap.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.whitetest.soap.data.models.ExamsRequest;
import com.whitetest.soap.data.models.ExamsResponse;
import com.whitetest.soap.data.models.StudentRequest;
import com.whitetest.soap.data.models.WhiteTestResponse;

@Service
public class WhiteTestService {

    private WebServiceTemplate serviceTemplate;

	@Autowired
	private Jaxb2Marshaller marshaller;
	
	public WhiteTestResponse checkWhiteTest(StudentRequest studentRequest) {
		serviceTemplate = new WebServiceTemplate(marshaller);
		WhiteTestResponse response = (WhiteTestResponse) serviceTemplate.
				marshalSendAndReceive("http://localhost:8000/tekup",studentRequest);
		return response;
	}
	public ExamsResponse getAllWhiteTests(ExamsRequest examsRequest) {
		serviceTemplate = new WebServiceTemplate(marshaller);
		ExamsResponse response = (ExamsResponse) serviceTemplate.
				marshalSendAndReceive("http://localhost:8000/tekup",examsRequest);
		return response;
	}

}
