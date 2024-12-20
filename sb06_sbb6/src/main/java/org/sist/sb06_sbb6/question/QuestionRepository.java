package org.sist.sb06_sbb6.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//																				<CRUD할 Entity, 그 테이블의 pk 타입>																	
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	//CRUD하는 method가 이미 내장되어 있는거야

	//필요한 함수 만들어
	Question findBySubject(String subject);
	
	
	//1. Query Method(내부적으로는 JPQL로 날아가)
	//method 이름으로 query 자동 생성하는 기능
	//find컬럼명Like
	//find컬럼명Containing
	List<Question> findBySubjectContaining(String subject);
	
	//2. @Query(그냥 JPQL, 객체를 사용하는 거 바로 쿼리를 날려)
	/*
	@Query("SELECT q 	FROM Question q WHERE q.subject LIKE %:subject%")
	List<Question> findBySubjectLike(@Param("subject") String subject);
	*/
	
	
	//Query Method 사용
	List<Question> findBySubjectLike(String subject);
	
	
	//WHERE subject=? AND content=?
	Question findBySubjectAndContent(String subject, String content);
	
	//3. QueryDSL
	
	
	//페이징 처리 (암기)
	Page<Question> findAll(Pageable pageable);
}//interface
