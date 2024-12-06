package org.sist.sb06_sbb.domain;

import lombok.RequiredArgsConstructor;
/*[1]
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HelloLombok {
	
	private String hello;
	private int lombok;
	
	public static void main(String[] args) {
		//System.out.println("hello world");
		HelloLombok helloLombok = new HelloLombok();
		helloLombok.setHello("해윙");
		helloLombok.setLombok(5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
}
*/
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor//final이나 @NonNull을 잡는데 @NonNull은 lombok annotation으로 잡으니 주의할 것
public class HelloLombok {
	
	
	private final String hello;
	
	private final int lombok;
	
	public static void main(String[] args) {
		//System.out.println("hello world");
		HelloLombok helloLombok = new HelloLombok("헬로", 5);	
		
	}
}
