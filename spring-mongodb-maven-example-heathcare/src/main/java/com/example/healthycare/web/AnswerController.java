package com.example.healthycare.web;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.Patient;
import com.example.healthycare.entity.Question;
import com.example.healthycare.service.AnswerService;
import com.example.healthycare.service.PatientService;
import com.example.healthycare.service.QuestionService;
/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	PatientService patientService;

	@RequestMapping(value="update/{patientId}/{answerId}", method = RequestMethod.GET)
	public String updateMedicalRecordForm(@PathVariable String patientId, @PathVariable String answerId,ModelMap mm){
		Patient patient = patientService.findByPatientId(patientId);
		Answer answer= null;
		for (Iterator iterator = patient.getMedicalHistory().getAnswers().iterator(); iterator.hasNext();) {
			Answer ans = (Answer) iterator.next();
			if(ans.getId().equals(answerId)){
				answer = ans;
			}
		}
		
		mm.addAttribute("answer", answer);
		mm.addAttribute("patientId", patientId);
		return "answer/update";
	}
	
	@RequestMapping(value="update/{patientId}", method = RequestMethod.POST)
	public String updateAnswer(@PathVariable(value="patientId") String patientId,@ModelAttribute(value = "answer") Answer answer){
		Patient patient = patientService.findByPatientId(patientId);
		for (Iterator iterator = patient.getMedicalHistory().getAnswers().iterator(); iterator.hasNext();) {
			Answer ans = (Answer) iterator.next();
			if(ans.getId().equals(answer.getId())){
				ans.setAnswer(answer.getAnswer());
				patientService.update(patient);
			}
		}
		return "redirect:/index";
	}
}