package com.sun.recite.repository;

import com.sun.recite.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word,String>{

}
