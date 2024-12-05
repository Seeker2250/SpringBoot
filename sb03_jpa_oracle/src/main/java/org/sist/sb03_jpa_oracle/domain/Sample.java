package org.sist.sb03_jpa_oracle.domain;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_sample")
public class Sample {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "member_gen")
	@GeneratedValue(generator = "seq_tblsample", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_tblsample", sequenceName = "seq_tblsample", initialValue = 1, allocationSize = 1)//1씩 증가
	private Long sno;
	
	private String col1;
	
	//@Column(length = 30)
	private String col2;
}	
