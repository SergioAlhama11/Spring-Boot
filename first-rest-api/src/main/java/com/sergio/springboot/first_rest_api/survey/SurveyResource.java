package com.sergio.springboot.first_rest_api.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {
	
	private SurveyService surveyService;
	
	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}
	
	// - GET METHOD -
	
	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {
		return surveyService.retrieveAllSurveys();
	}
	
	@RequestMapping("/surveys/{id}")
	public Survey retrieveSurveyById(@PathVariable String id) {
		Survey survey = surveyService.retrieveSurveyById(id);
		
		if (survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return survey;
	}
	
	@RequestMapping("/surveys/{id}/questions")
	public List<Question> retrieveAllQuestionsFromSurvey(@PathVariable String id) {
		Survey survey = surveyService.retrieveSurveyById(id);
		
		if (survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return survey.getQuestions();
	}
	
	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestionsFromSurveyById(@PathVariable String surveyId, @PathVariable String questionId) {		
		List<Question> questionsList = retrieveAllQuestionsFromSurvey(surveyId);
		
		return surveyService.retrieveQuestionById(questionsList, questionId);
	}
	
	// - POST METHOD -
	
	@RequestMapping(value="/surveys/{surveyId}/questions", method=RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {
		String questionId = surveyService.addNewSurveyQuestion(surveyId, question);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId).toUri();
		return ResponseEntity.created(location).build();
	}
	
	// - DELETE METHOD -
	
	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuestionById(@PathVariable String surveyId, @PathVariable String questionId) {
		surveyService.deleteSurveyQuestionById(surveyId, questionId);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAllSurveyQuestion(@PathVariable String surveyId) {
		surveyService.deleteAllSurveyQuestion(surveyId);
		
		return ResponseEntity.noContent().build();
	}
	
	// - PUT METHOD -
	
	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId, @RequestBody Question question) {
		surveyService.updateSurveyQuestion(surveyId, questionId, question);
		//surveyService.updateSurveyQuestion2(surveyId, questionId, question);
		
		return ResponseEntity.noContent().build();
	}
}
