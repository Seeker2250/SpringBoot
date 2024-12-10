package org.sist.sb06_sbb5.answer;

import org.sist.sb06_sbb5.question.Question;
import org.sist.sb06_sbb5.question.QuestionForm;
import org.sist.sb06_sbb5.question.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	//answer/create/${question.id}
	/*
	@PostMapping("/create/{id}")
	public String createAnswer(@PathVariable("id") Integer id, @RequestParam("content") String content){
		System.out.println("@@@@@@@@@@@@일단 AnswerController에서 createAnswer들어옴");
		
		Question question = this.questionService.getQuestion(id);
		this.answerService.create(question, content);
		
		//return String.format("redirect:/question/detail/%s", id);
		return "redirect:/question/detail/"+id;
	}*/
	

	//[2] AnswerForm 사용
	@PostMapping("/create/{id}")
	public String createAnswer(@PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult, Model model){
		//@Valid 쓰면 걍 BindingResult 따라와야 함
		System.out.println("@@@@@@@@@@@@일단 AnswerController에서 createAnswer들어옴");
		
		//1. 에러가 있으면
		Question question = this.questionService.getQuestion(id);
		if (bindingResult.hasErrors()) {
			model.addAttribute("question", question);
	        return "/question/detail";//detail로 가려면 질문 내용들이 있어야 하니까 Question 객체 가져오자
		}
		
		//2. 
		this.answerService.create(question, answerForm.getContent());
		
		//return String.format("redirect:/question/detail/%s", id);
		return "redirect:/question/detail/"+id;
	}
}
