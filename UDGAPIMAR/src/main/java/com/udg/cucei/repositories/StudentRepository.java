package com.udg.cucei.repositories;

import com.udg.cucei.models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel,Long> {

    public Optional<StudentModel> findByCode(String code);
    public Optional<List<StudentModel>> findByName(String name);
    public Optional<StudentModel> findByEmail(String email);

}
