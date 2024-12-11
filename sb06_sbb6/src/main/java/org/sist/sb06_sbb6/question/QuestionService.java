package org.sist.sb06_sbb6.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sist.sb06_sbb6.exception.DataNotFoundException;
import org.sist.sb06_sbb6.user.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	//페이징 처리 전 목록
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}
	
	
	//id에 해당하는 질문 가져와
	public Question getQuestion(Integer id) {
		Optional<Question> oQuestion = this.questionRepository.findById(id);
		if(oQuestion.isPresent()) {
			return oQuestion.get();//Optional<Question>을 Question으로 변환하여 return
		}else {
			//강제로 내가 만든 사용자 정의 예외를 발생시켜
			//exception package + DataNotFoundException 예외 클래스 추가
			throw new DataNotFoundException("질문이 없습니다~");
		}
		
	}
	
	//질문 등록
	public void create(String subject, String content, SiteUser user) {
		
		Question question = new Question();
		
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		
		question.setAuthor(user);//작성자 정보 추가
		this.questionRepository.save(question);
	}
	
	//페이징 처리된 목록
	public Page<Question> getList(int page) {
		
		//1번 페이지를 주고 싶다면 0이라고 주어야 한다.
		//								  		   pageNumber, pageSize
		
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));//정렬기준이 여러 개일 때가 있기 때문에 굳이 List로 만든 것
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		//현재 페이지 받아와서 10개씩 뿌려 direction이랑 property라는 parameter도 있으니 공부할 것
		return this.questionRepository.findAll(pageable); // 1번 페이지 끝
	}
	
	//질문 수정
	public void modify(Question question, String subject, String content) {
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
	
	//질문 삭제
	public void delete(Question question) {
		this.questionRepository.delete(question);
	}
	
	
}//class
