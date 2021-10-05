package com.gft.immunization;

import org.junit.Test;

class ImmunizationControlApplicationTests {

	@Test
	void contextLoads() {
	}
	
	/*private BatchRepository repository;

	@Test
	public void whenFindByDeliveryDate_thenBatch1And2Returned() {

		List<Batch> result = repository.findAllByDeliveryDate(

				new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"));

		assertEquals(2, result.size());
		assertTrue(result.stream().map(Batch::getId).allMatch(id -> Arrays.asList(1, 2).contains(id)));
	}

	@Test
	public void whenFindByDeliveryDateBetween_thenBatch2And3Returned() {
		
		List<Batch> result = repository.findAllByDeliveryDateBetween(
				
				new SimpleDateFormat("HH:mm").parse("15:15"),
				new SimpleDateFormat("HH:mm").parse("16:30"));

		assertEquals(2, result.size());
		assertTrue(result.stream().map(Batch::getId).allMatch(id -> Arrays.asList(2, 3).contains(id)));
	}
	
	@Test
    public void givenBatchWhenFindWithExpirationDateThenArticles2And3Returned() {
		
        List<Batch> result = repository.findAllWithExpirationDateBefore(
        		
          new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00"));

        assertEquals(2, result.size());
        assertTrue(result.stream()
          .map(Batch::getId)
          .allMatch(id -> Arrays.asList(2, 3).contains(id));
    }*/
	
}
