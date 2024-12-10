package org.sist.sb06_sbb3.question;

import java.util.List;

import org.sist.sb06_sbb3.answer.AnswerForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
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
	  public String detail(@PathVariable("id") Integer id, Model model, AnswerForm answerForm) {
		System.out.println("@@@@@@@@@@@QuestionController detail method  들어옴~");
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "/question/detail";
	  }
	
	//질문 등록하기
	@GetMapping("/create")
	public void create(QuestionForm questionForm) {//필요없어도 동기화 된 객체가 필요하니까 그냥 넣어... 없으면 view단에서 연결할 게 없어서 오류 나(create.html 확인)
		System.out.println("@@@@@@@@@@@QuestionController create method  들어옴~");
		
		
	}
	/*
	@PostMapping("/create")
	public String questionCreate(@RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content) {
		System.out.println("@@@@@@@@@@@QuestionController post로 questionCreate method  들어옴~");
		//질문 등록
		this.questionService.create(subject, content);
		//질문 목록으로 redirect
		return "redirect:/question/list";
	}*/
	//질문 등록 + 유효성 검사
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		System.out.println("@@@@@@@@@@@QuestionController post로 questionCreate method  들어옴~");
		
		if (bindingResult.hasErrors()) {
	        return "/question/create";
		}
		String subject = questionForm.getSubject();
		String content = questionForm.getContent();
		//질문 등록
		this.questionService.create(subject, content);
		//질문 목록으로 redirect
		return "redirect:/question/list";
	}
	
}//class
