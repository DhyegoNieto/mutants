package com.mutants.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DnaHorizontalSequenceProcessorTest {

	@Autowired
	DnaHorizontalSequenceProcessor processor;
	
	private int nitroSeqValue = 4;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShouldReturnTwoSequences() {
		String[] dna = {"GGGGGA","CAGTGC","ataaGT","AGtatT","CCcCTA","TCACTG"};
		
		int actual = processor.analyzeSequences(dna, nitroSeqValue);
		
		assertEquals(2, actual);
	}
	
	@Test
	public void testShouldReturnZeroSequences() {
		String[] dna = {"GGtGGA","CAGTGC","ataaGT","AGtatT","CCaCTA","TCACTG"};
		
		int actual = processor.analyzeSequences(dna, nitroSeqValue);
		
		assertEquals(0, actual);
	}
	
}
