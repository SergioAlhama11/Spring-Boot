package com.sergio.springboot.first_rest_api.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SurveyService {
	
	private static List<Survey> surveys = new ArrayList<Survey>();
	
	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool", Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
	
		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));
		
		Survey survey = new Survey("Survey1", "My favourite Survey", "Description of the Survey", questions);
		
		surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurveyById(String id) {
		
		Predicate<? super Survey> isEqualToGivenID = survey -> survey.getId().equalsIgnoreCase(id);
		Optional<Survey> optionalSurvey = surveys.stream().filter(isEqualToGivenID).findFirst();
		
		if (optionalSurvey.isEmpty()) {
			return null;
		}
	
		return optionalSurvey.get();
	}

	public Question retrieveQuestionById(List<Question> questionsList, String questionId) {
		Predicate<? super Question> isEqualToGivenID = question -> question.getId().equalsIgnoreCase(questionId);
		Optional<Question> optionalQuestion = questionsList.stream().filter(isEqualToGivenID).findFirst();
		
		if (optionalQuestion.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	
		return optionalQuestion.get();
	}

	public String addNewSurveyQuestion(String surveyId, Question question) {
		List<Question> questions = retrieveSurveyById(surveyId).getQuestions();
		question.setId(generateRandomId());
		questions.add(question);
		
		return question.getId();
	}
	
	public String deleteSurveyQuestionById(String surveyId, String questionId) {
		List<Question> questions = retrieveSurveyById(surveyId).getQuestions();
		
		if (null == questions) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Predicate<? super Question> isEqualToGivenID = question -> question.getId().equalsIgnoreCase(questionId);
		boolean removed = questions.removeIf(isEqualToGivenID);
		
		if (!removed) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return questionId;
	}
	
	public void deleteSurveyQuestionById2(String surveyId, String questionId) {
		List<Question> questions = retrieveSurveyById(surveyId).getQuestions();
		
		if (null == questions) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Predicate<? super Question> isEqualToGivenID = question -> question.getId().equalsIgnoreCase(questionId);
		questions.removeIf(isEqualToGivenID);
	}
	
	public void deleteAllSurveyQuestion(String surveyId) {
		List<Question> questions = retrieveSurveyById(surveyId).getQuestions();
		
		if (null == questions) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		questions.removeAll(questions);
	}


	// Forma 1 de hacerlo -> Eliminando primero e insertando despues
	
	public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
		List<Question> questions = retrieveSurveyById(surveyId).getQuestions();
		questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
		questions.add(question);
	}
	
	// Forma 2 de hacerlo -> Machacando los valores anteriores por los nuevos
	
	public void updateSurveyQuestion2(String surveyId, String questionId, Question question) {
		List<Question> questions = retrieveSurveyById(surveyId).getQuestions();
		
		Predicate<? super Question> isEqualToGivenID = q -> q.getId().equalsIgnoreCase(questionId);
		Optional<Question> optionalQuestion = questions.stream().filter(isEqualToGivenID).findFirst();
		
		if (optionalQuestion.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Question q = optionalQuestion.get();
		
		q.setId(question.getId());
		q.setDescription(question.getDescription());
		q.setOptions(question.getOptions());
		q.setCorrectAnswer(question.getCorrectAnswer());
		
	}
	
	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}
}
