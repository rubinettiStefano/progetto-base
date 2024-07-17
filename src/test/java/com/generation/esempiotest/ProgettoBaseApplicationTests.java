package com.generation.esempiotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.esempiotest.model.Impiegato;
import com.generation.esempiotest.repository.ImpiegatoRepository;

@SpringBootTest
class ProgettoBaseApplicationTests {

	@Autowired
	ImpiegatoRepository repo; 

	@BeforeEach
	void reset()
	{
		repo.reset();
	}

	@Test
	void inserimentoImpiegato() 
	{
		List<Impiegato> all = repo.findAll();

		Impiegato toInsert = 	Impiegato
								.builder()
								.nome("Davide")
								.cognome("Spera")
								.dataAssunzione(LocalDate.now())
								.stipendioMensile(3400)
								.build();

		repo.save(toInsert);

		List<Impiegato> dopoInserimento = repo.findAll();

		assertEquals(all.size()+1, dopoInserimento.size());
	}	

	@Test
	void letturaImpiegati() 
	{
		List<Impiegato> all = repo.findAll();


		assertEquals(5, all.size());
	}	

	@Test
	void letturaPerNominativo() 
	{
		Optional<Impiegato> letto = repo.findByNomeAndCognome("Marco","Rossi");


		assert(letto.isPresent());

		Optional<Impiegato> nonLetto = repo.findByNomeAndCognome("BABBAasd","Rossassi");

		assert(nonLetto.isEmpty());
	}	
	@Test
	void letturaPerNominativo2() 
	{
		Optional<Impiegato> letto = repo.comeSopraMaAmano("Marco","Rossi");


		assert(letto.isPresent());

		Optional<Impiegato> nonLetto = repo.comeSopraMaAmano("BABBAasd","Rossassi");

		assert(nonLetto.isEmpty());
	}	

	@Test
	void letturaPerNominativo3() 
	{
		Optional<Impiegato> letto = repo.comeSopraMaAmanoNativo("Marco","Rossi");


		assert(letto.isPresent());

		Optional<Impiegato> nonLetto = repo.comeSopraMaAmanoNativo("BABBAasd","Rossassi");

		assert(nonLetto.isEmpty());
	}	






}
