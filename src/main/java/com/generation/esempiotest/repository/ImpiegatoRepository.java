package com.generation.esempiotest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.generation.esempiotest.model.Impiegato;

public interface ImpiegatoRepository extends JpaRepository<Impiegato,Integer>
{
    @Procedure("resetinitialvalues")
    void reset();

    Optional<Impiegato> findByNomeAndCognome(String nome,String cognome);

    @Query("SELECT i FROM Impiegato i WHERE i.nome= :nome AND i.cognome= :cognome")//JPQL
    Optional<Impiegato> comeSopraMaAmano(@Param("nome") String nome,@Param("cognome") String cognome);

    @Query(value = "SELECT * FROM Impiegato  WHERE nome= :nome AND cognome= :cognome", nativeQuery = true)//MySQL
    Optional<Impiegato> comeSopraMaAmanoNativo(@Param("nome") String nome,@Param("cognome") String cognome);
}
