package org.sist.sb06_sbb2.question;

import java.util.List;
import java.util.Optional;

import org.sist.sb06_sbb2.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}
	
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
}
