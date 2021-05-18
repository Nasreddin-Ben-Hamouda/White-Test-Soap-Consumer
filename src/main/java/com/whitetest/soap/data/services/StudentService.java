package com.whitetest.soap.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.whitetest.soap.data.models.StudentsRequest;
import com.whitetest.soap.data.models.StudentsResponse;


@Service
public class StudentService {

	
	 private WebServiceTemplate serviceTemplate;

		@Autowired
		private Jaxb2Marshaller marshaller;
		
		
		public StudentsResponse getAllStudents(StudentsRequest studentsRequest) {
			serviceTemplate = new WebServiceTemplate(marshaller);
			StudentsResponse response = (StudentsResponse) serviceTemplate.
					marshalSendAndReceive("http://localhost:8000/tekup",studentsRequest);
			return response;
		}
}
