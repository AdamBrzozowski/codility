package com.projects.codility;

import com.projects.codility.medium.CountConformingBitmask;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class CountConformingBitmaskTests {

	@Autowired
	private CountConformingBitmask countConformingBitmask;

	//A, B and C are integers within the range [0..1,073,741,823].
	@Test
	void countConformingBitmaskTest() {
		ArrayList<Assertion> assertions = new ArrayList<>();

		assertions.add(execute(30,12,2,20));
		assertions.add(execute(5,12,2,20));
		assertions.add(execute(30,12232,3112444,141242341));
		assertions.add(execute(30,1073741727,1073741631,1073741679));
		assertions.add(execute(10,232,932,20));
		assertions.add(execute(10,12,2,20));

		assertions.forEach(
				entry -> Assertions.assertEquals(entry.getExpected(), entry.getResult())
		);

	}

	private Assertion execute(int size, int A, int B, int C) {
		int bitSize=size;

		int check = check(A, B, C, bitSize);
		int solution = countConformingBitmask.solution(A, B, C, bitSize);

		String binaryA = Integer.toBinaryString(A);
		String binaryB = Integer.toBinaryString(B);
		String binaryC = Integer.toBinaryString(C);
		System.out.println("binaryA : " + padZero(binaryA,bitSize));
		System.out.println("binaryB : " + padZero(binaryB,bitSize));
		System.out.println("binaryC : " + padZero(binaryC,bitSize));

		System.out.println("RESCHECK : " + check);
		System.out.println("RES : " + solution);

		return Assertion.builder().expected(check).result(solution).build();
	}

	// Complexity O(2**30)=O(2^30)  VS  O(log(A+B+C))
	//Less efficient SOLUTION used to TEST the Real/Efficient one
	//Goes through all the numbers and checks for each one if it "CONFORMS" to at least one of A B or C looking at all the 1s and 0s
	private int check(int A, int B, int C, int binSize) {
		if(A<0 || B<0 || C<0) return 0;

		String binaryA = Integer.toBinaryString(A);
		String binaryB = Integer.toBinaryString(B);
		String binaryC = Integer.toBinaryString(C);

		binaryA=padZero(binaryA,binSize);
		binaryB=padZero(binaryB,binSize);
		binaryC=padZero(binaryC,binSize);

		if(binaryA.length()>binSize || binaryB.length()>binSize || binaryC.length()>binSize) return 0;

		int result = 0;

		int x = 0;
		String binaryX = Integer.toBinaryString(x);
		while (binaryX.length()<(binSize+1)) {
			binaryX=padZero(binaryX, binSize);
			boolean isConform = checkConform(binaryX, binaryA);
			if(isConform) {
				result++;
//				System.out.println("binaryX : " + binaryX);
				x++;
				binaryX = Integer.toBinaryString(x);
				continue;
			}
			isConform = checkConform(binaryX, binaryB);
			if(isConform) {
				result++;
//				System.out.println("binaryX : " + binaryX);
				x++;
				binaryX = Integer.toBinaryString(x);
				continue;
			}
			isConform = checkConform(binaryX, binaryC);
			if(isConform) {
				result++;
//				System.out.println("binaryX : " + binaryX);
				x++;
				binaryX = Integer.toBinaryString(x);
				continue;
			}
			x++;
			binaryX = Integer.toBinaryString(x);
		}

		return result;
	}

	private boolean checkConform(String input, String confront) {
		if(input.length()<confront.length()) {
			return false;
		}

		for (int i=0; i<confront.length();i++) {
			if(confront.charAt(i)=='1' && input.charAt(i)=='0') {
				return false;
			}
		}

		return true;
	}

	private String padZero(String input, int binSize) {
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length()<binSize) {
			inputBuilder.insert(0, '0');
		}
        input = inputBuilder.toString();
        return input;
	}

	@Getter
	@Setter
	@Builder
	static class Assertion {
		int result;
		int expected;
	}

}
