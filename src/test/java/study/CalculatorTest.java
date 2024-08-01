package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@DisplayName("쉼표 더하기")
	@Test
	void isCorrectSumReturnWithSeparatedByCommas() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@DisplayName("콜론 숫자 합")
	@Test
	void isCorrectSumReturnWithSeparatedByColon() {
		assertEquals(6, Calculator.add("1:2:3"));
	}

	@DisplayName("쉽표와 콜론 반환의 합")
	@Test
	void isCorrectSumReturnWithSeparatedByCommasAndColon() {
		assertEquals(10, Calculator.add("1,2:3,4"));
	}

	@DisplayName("사용자 정의 구분자")
	@Test
	void isCorrectSumReturnWithSeparatedByCustomDelimiter() {
		assertEquals(6, Calculator.add("//;\\n1;2;3"));
	}

	@DisplayName("숫자 이외의 값일 때 ")
	@Test
	void testRuntimeExceptionThrownWithNonNumericArguments() {
		assertThrows(RuntimeException.class, () -> Calculator.add("1,2,삼"));
	}

	@DisplayName("음수가 포함되었을 때 RuntimeException이 발생하는지")
	@Test
	void testRuntimeExceptionThrownWithNegativeArguments() {
		assertThrows(RuntimeException.class, () -> Calculator.add("1,-2,3"));
	}
}

