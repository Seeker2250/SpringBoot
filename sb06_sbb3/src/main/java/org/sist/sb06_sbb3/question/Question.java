package org.sist.sb06_sbb3.question;

import java.time.LocalDateTime;
import java.util.List;

import org.sist.sb06_sbb3.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter//entity에서는 setter를 잘 안 써 VO나 DTO가 따로 있으니까... setter로 저장할 이유가 없지.

//여기서 저장하면 persistence context에 저장되고 그게 거기에서 DB로 가는거야 그러니 바로 DB에 저장되는 건 아님
//Entity는 DB연동을 위한 거니까 그릇을 따로 만들거야
//class와 table에 관계가 맺어져 있는 것
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")//문자열 길이 제한 없어져(마치 oracle의 clob같이 길게 나열되어도 ㅇㅋ)
	private String content;
	private LocalDateTime createDate;//CREATE_DATE로 만들어져
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)//Answer의 question과 mapping, 질문 제거하면 답변들도 제거
	private List<Answer> answerList;

}
