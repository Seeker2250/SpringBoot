package org.sist.sb06_sbb7.answer;

import java.time.LocalDateTime;

import org.sist.sb06_sbb7.question.Question;
import org.sist.sb06_sbb7.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Builder //setter 말고 이거 써도 돼~
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")//문자열 길이 제한 없어져(마치 oracle의 clob같이 길게 나열되어도 ㅇㅋ)
	private String content;
	private LocalDateTime createDate;
	
	@ManyToOne
	private Question question;//우리꺼 import한 거임~
	
	@ManyToOne
	private SiteUser author;
	
	private LocalDateTime modifyDate;
}
