package com.projects.codility;

import com.projects.codility.easy.BinaryGap;
import com.projects.codility.hard.SparseBinaryDecomposition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class SparseBinaryDecompositionTest {

	@Autowired
	private SparseBinaryDecomposition sparseBinaryDecomposition;

	@Test
	void sparseBinaryDecompositionTest() {
		ArrayList<Control> assertions = new ArrayList<>();

		assertions.add(execute(1));
		assertions.add(execute(0));
		assertions.add(execute(2));
		assertions.add(execute(8));
		assertions.add(execute(128));
		assertions.add(execute(127));
		assertions.add(execute(623986));
		assertions.add(execute(999));

		assertions.forEach(
				entry -> {
					Assertions.assertTrue(entry.isSparse);
					Assertions.assertTrue(entry.isOtherSparse);
					Assertions.assertTrue(entry.getOther()>-1);
				}
		);
	}

	private Control execute(int N) {
		int solution = sparseBinaryDecomposition.solution(N);

		boolean isSparse = isSparse(solution);
		int otherSparse = N-solution;
		boolean isOtherSparse = isSparse(otherSparse);

		System.out.println("N: " + N + " - bin: " + Integer.toBinaryString(N));
		System.out.println("sol: " + solution + " - bin: " + Integer.toBinaryString(solution));
		System.out.println("other: " + otherSparse + " - bin: " + Integer.toBinaryString(otherSparse));
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println();

		return Control.builder().isSparse(isSparse).isOtherSparse(isOtherSparse).other(otherSparse).build();
	}

	private boolean isSparse(int N) {
		String binary = Integer.toBinaryString(N);
		for (int i=0;i<binary.length()-1;i++) {
			if(binary.charAt(i)=='1' && binary.charAt(i+1)=='1') {
				return false;
			}
		}
		return true;
	}

	@Getter
	@Setter
	@Builder
	static class Control {
		boolean isSparse;
		boolean isOtherSparse;
		int other;
	}

}
