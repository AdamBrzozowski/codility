package com.projects.codility;

import ch.qos.logback.core.joran.sanity.Pair;
import com.projects.codility.easy.BinaryGap;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CodilityApplicationTests {

	@Autowired
	private BinaryGap binaryGap;

	@Test
	void binaryGapTest() {
		ArrayList<Control> control = new ArrayList<>();

		int number = 1041;
		int solution = binaryGap.solution(number);
		String binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(5).result(solution).build());

		number = 15;
		solution = binaryGap.solution(number);
		binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(0).result(solution).build());

		number = 1;
		solution = binaryGap.solution(number);
		binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(0).result(solution).build());

		number = 5;
		solution = binaryGap.solution(number);
		binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(1).result(solution).build());

		number = 6;
		solution = binaryGap.solution(number);
		binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(0).result(solution).build());

		number = 328;
		solution = binaryGap.solution(number);
		binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(2).result(solution).build());

		number = 1376796946;
		solution = binaryGap.solution(number);
		binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(5).result(solution).build());

		number = 561892;
		solution = binaryGap.solution(number);
		binaryRepresentation = Integer.toBinaryString(number);
		System.out.println("INPUT: " + number + " - " + "BINARY: " + binaryRepresentation + " - " + "GAP: " + solution);
		control.add(Control.builder().expected(3).result(solution).build());

		control.forEach(
				entry -> {

					assertEquals(entry.getExpected(),entry.getResult());
				}
		);

	}

	@Getter
	@Setter
	@Builder
	static class Control {
		int result;
		int expected;
	}

}
