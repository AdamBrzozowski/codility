package com.projects.codility;

import com.projects.codility.medium.CountConformingBitmask;
import com.projects.codility.test.MatrixSums;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class MatrixSumsOnesTests {

	@Autowired
	private MatrixSums matrixSums;


	@Test
	void test() {
		int[] C = {1,1,1,1,1,1,1,1,1,1,1,1,0,0,2,2,1,1,2,2};

		ArrayList<Assertion> assertions = new ArrayList<>();
		String solution = matrixSums.solution(4, 18, C);
		System.out.println(solution);

		Assertion assertion = Assertion.builder()
				.expected("00000000000000110011,11111111111100111111")
				.result(solution).build();

		assertions.add(assertion);


		int[] C1 = {1,1,1,0,1,1,1,1,1,1,1,1,0,0,2,2,1,1,2,2};
		solution = matrixSums.solution(4, 18, C1);
		System.out.println(solution);
		Assertion assertion1 = Assertion.builder()
				.expected("IMPOSSIBLE")// 4 + 18 != C1.sum  (=21)
				.result(solution).build();

		assertions.add(assertion1);
//		assertions.add(execute(5,12,2,20));
//		assertions.add(execute(30,12232,3112444,141242341));
//		assertions.add(execute(30,1073741727,1073741631,1073741679));
//		assertions.add(execute(10,232,932,20));
//		assertions.add(execute(10,12,2,20));

		assertions.forEach(
				entry -> Assertions.assertEquals(entry.getExpected(), entry.getResult())
		);

	}

	@Getter
	@Setter
	@Builder
	static class Assertion {
		String result;
		String expected;
	}
}
