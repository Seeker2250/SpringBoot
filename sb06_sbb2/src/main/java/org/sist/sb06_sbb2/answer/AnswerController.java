package org.sist.sb06_sbb2.answer;

import org.sist.sb06_sbb2.question.Question;
import org.sist.sb06_sbb2.question.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	//answer/create/${question.id}
	@PostMapping("/create/{id}")
	public String createAnswer(@PathVariable("id") Integer id, Model model, @RequestParam("content") String content){
		System.out.println("@@@@@@@@@@@@일단 AnswerController에서 createAnswer들어옴");
		
		Question question = this.questionService.getQuestion(id);
		this.answerService.create(question, content);
		
		//return String.format("redirect:/question/detail/%s", id);
		return "redirect:/question/detail/"+id;
	}
}
