package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void SetUp(){
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("크기 확인 테스트")
	@Test
	public void sizeTest(){
		int size = numbers.size();
		assertThat(size).isEqualTo(3);
		// assertThat(size).isEqualTo(4);
	}


	@DisplayName("1,2,3 value 확인 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	public void constainsTest(int number){

		assertThat(numbers.contains(number)).isTrue();

	}


	@DisplayName("값이 다른 경우 테스트")
	@ParameterizedTest
	@CsvSource({"true, 1", "true, 2", "true, 3", "false, 4", "false, 5"})
	public void constainsTest2(boolean flag,int number){
		assertThat(numbers.contains(number)).isEqualTo(flag);

	}



}
