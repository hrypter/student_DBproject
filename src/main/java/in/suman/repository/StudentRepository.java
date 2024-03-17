package in.suman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.suman.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
