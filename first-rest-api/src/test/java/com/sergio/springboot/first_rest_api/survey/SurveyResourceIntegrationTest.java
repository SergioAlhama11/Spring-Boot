package com.sergio.springboot.first_rest_api.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIntegrationTest {
	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	private static String GENERIC_QUESTIONS_URL = "/surveys/Survey1/questions";
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	//{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
	
	@Test
	void retrieveQuestionsFromSurveyById_basicScenario() throws JSONException {
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(null, createHttpContentTypeAndAuthorizationHeaders());
		
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(SPECIFIC_QUESTION_URL, HttpMethod.GET, httpEntity, String.class);
		
		// ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(SPECIFIC_QUESTION_URL, String.class); // Utilizamos .exchange ya que debemos utilizar el header para la autenticacion
		
		String expectedResponse = """
				{
					"id":"Question1",
					"description":"Most Popular Cloud Platform Today",
					"correctAnswer":"AWS"
				}
				""";
		
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
	}
	
	@Test
	void retrieveAllQuestionsFromSurveyById_basicScenario() throws JSONException {
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(null, createHttpContentTypeAndAuthorizationHeaders());
		
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(GENERIC_QUESTIONS_URL, HttpMethod.GET, httpEntity, String.class);
		
		// ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(GENERIC_QUESTIONS_URL, String.class); // Utilizamos .exchange ya que debemos utilizar el header para la autenticacion
		
		String expectedResponse = """
				[
					{
						"id": "Question1"
					},
					{
						"id": "Question2"
					},
					{
						"id": "Question3"
					}
				]
				""";
		
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
	}
	
	@Test
	void addNewSurveyQuestion_basicScenario() throws JSONException {
		
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
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, createHttpContentTypeAndAuthorizationHeaders());
		
		ResponseEntity<String> responseEntity = testRestTemplate.exchange(GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity, String.class);
		
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		
		System.out.println(locationHeader);

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertTrue(locationHeader.contains("/surveys/Survey1/questions/"));
		
		ResponseEntity<String> responseEntityDelete = testRestTemplate.exchange(locationHeader, HttpMethod.DELETE, httpEntity, String.class);
		assertTrue(responseEntityDelete.getStatusCode().is2xxSuccessful());
		// testRestTemplate.delete(locationHeader); // Estamos borrando para que no pete el test que obtiene todas las preguntas del cuestionario ya que estamos obteniendo 4 y comprueba que haya 3
	}

	private HttpHeaders createHttpContentTypeAndAuthorizationHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/json");
		headers.add("Authorization", "Basic " + performBasicAuthEncoding("admin", "admin"));
		return headers;
	}
	
	private String performBasicAuthEncoding(String user, String password) {
		String combined = user + ":" + password;
		// Base64 Encoding => Bytes
		byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
		// Bytes => String
		return new String(encodedBytes);
	}

}
