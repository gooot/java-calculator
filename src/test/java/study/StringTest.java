package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	String str1;

	String str2;

	String str3;

	String str4;

	String[] strList;

	@DisplayName("테스트마다 초기화")
	@BeforeEach
	public void init(){
		this.str1 = "1,2";
		this.str2 = "1";
		this.strList = new String[5];

		this.str3 = "(1,2)";

		this.str4 = "abc";

	}

	@DisplayName("split 테스트")
	@Test
	public void divideString(){
		strList = str1.split(",");
		assertThat(strList).contains(new String[] {"1", "2"});

		strList = str2.split(",");
		assertThat(strList).containsExactly("1");


	}


	@DisplayName("subString 테스트")
	@Test
	public void subStringTest(){
		String result = str3.substring(1,4);
		assertThat(result).isEqualTo("1,2");
	}


	@DisplayName("charAt , OUtOfBounds 테스트 ")
	@Test
	public void charAtTest(){
		char result = str4.charAt(2);
		assertThat(result).isEqualTo('c');

		// result = str4.charAt(5);
		// assertThat(result).isInstanceOf(StringIndexOutOfBoundsException.class);
		assertThatThrownBy(()->{
			char result1=str4.charAt(10);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range");
	}




}
