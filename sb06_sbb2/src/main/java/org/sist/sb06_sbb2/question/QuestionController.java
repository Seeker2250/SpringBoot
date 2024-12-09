package org.sist.sb06_sbb2.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor//final로 자동 주입 마치 autowired
public class QuestionController {
	
	//private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	/*
	  @GetMapping("/question/list")
	  @ResponseBody
		  public String list() {
			  System.out.println("@@@@@@@@@@@QuestionController 들어옴~");
			  return "question list임"; 
	  }
	 */
	
	/*@GetMapping("/list")
	  public void list(Model model) {
		System.out.println("@@@@@@@@@@@QuestionController 들어옴~");
		List <Question> questionList = this.questionRepository.findAll();
		model.addAttribute("questionList", questionList);
	  }*/
	
	@GetMapping("/list")
	  public void list(Model model) {
		System.out.println("@@@@@@@@@@@QuestionController list method 들어옴~");
		//List <Question> questionList = this.questionRepository.findAll();
		List <Question> questionList = this.questionService.getList();
		model.addAttribute("qList", questionList);
	  }
	
	
	// 질문 상세 보기
	// /question/detail/2
	@GetMapping("/detail/{id}")
	  public String detail(@PathVariable("id") Integer id, Model model) {
		System.out.println("@@@@@@@@@@@QuestionController detail method  들어옴~");
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "/question/detail";
	  }
	
	
}
