package com.in28minutes.springboot.rest.example.springboot2jpawithhibernateandh2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentDao implements Dao<StudentO> {

    private List<StudentO> students = new ArrayList<>();

    public StudentDao(){
        students.add(new StudentO( "Alexey", "AS123456"));
        students.add(new StudentO( "Alex", "A123458"));
    }

    @Override
    public Optional<StudentO> get(long id) {
        return Optional.ofNullable(students.get((int)id));
    }

    @Override
    public List<StudentO> getAll() {
        return students;
    }

    @Override
    public void save(StudentO studentO) {
        students.add(studentO);
    }

    @Override
    public void update(StudentO studentO, String[] params) {
        studentO.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        studentO.setPassportNumber(Objects.requireNonNull(params[1], "Email cannot be null"));
    }

    @Override
    public void delete(StudentO studentO) {
        students.remove(studentO);
    }
}
