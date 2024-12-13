package org.sist.sb06_sbb8.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionSearch {
	Page<Question> seachAll(String[] types, String keyword, Pageable pageable);
}
