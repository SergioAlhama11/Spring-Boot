package com.sergio.springboot.first_rest_api.survey;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// SurveyResource
@WebMvcTest(controllers = SurveyResource.class)
@AutoConfigureMockMvc(addFilters = false) // Incluimos esta anotacion para que no peten los test al anadir Spring-Security
public class SurveyResourceTest {
	
	@MockitoBean
	private SurveyService surveyService;
	
	@Autowired
	private MockMvc mockMvc;
	
	// Mock -> surveyService.retrieveQuestionById(questionsList, questionId)
	
	// Fire a request
	// /surveys/{surveyId}/questions/{questionId}
	// GET METHOD -> http://localhost:8080/surveys/Survey1/questions/Question1
	
	private static String SPECIFIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions/Question1";
	private static String GENERIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions";
	
	@Test
	void retrieveQuestionsFromSurveyByIdTest_404Scenario() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(404, mvcResult.getResponse().getStatus());		
	}
	
	@Test
	void retrieveQuestionsFromSurveyByIdTest_basicScenario() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);

		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool", Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
	
		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));
		
		Survey survey = new Survey("Survey1", "My favourite Survey", "Description of the Survey", questions);
				
		when(surveyService.retrieveSurveyById(anyString())).thenReturn(survey);
		when(surveyService.retrieveQuestionById(any(), any())).thenReturn(question1);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedResponse = """
				{
					"id": "Question1"
				}
				""";
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		assertEquals(200, response.getStatus());
		JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), false);		
	}
	
	@Test
	void addNewSurveyQuestion_basicScenario() throws Exception {
		
		String requestBody = """
				{
					"description": "Your favourite Language",
					"options": [
						"Java",
						"Python",
						"Javascript",
						"Haskell"
					],
					"correctAnswer": "Java"
				}
				""";
		
		when(surveyService.addNewSurveyQuestion(any(), any())).thenReturn("RANDOM_ID");
		
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.post(GENERIC_QUESTION_URL)
					//.accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON)
					.content(requestBody);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(201, mvcResult.getResponse().getStatus());
		
		assertTrue(mvcResult.getResponse().getHeader("Location").contains("http://localhost:8080/surveys/Survey1/questions/RANDOM_ID"));
		
		//System.out.println("Request: " + mvcResult.getRequest().getContentAsString()); Lo comento porque falla al ejecutar el test por meterle Spring-Security
		System.out.println("Location: " + mvcResult.getResponse().getHeader("Location"));
	}
}
