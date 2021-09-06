package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.HwFromStudent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HwFromStudentRepository implements MyJpaRepository<HwFromStudent, Long> {
/*
    List<HwFromStudent> findHwFromStudentByStudentName_FirstNameContains(String userName);

    List<HwFromStudent> findHwFromStudentTablesByStudentNameLastNameContains(String userName);

    List<HwFromStudent> findHwFromStudentByLessonNumber(Integer lessson);

   @Query(value = "select * from hw_from_students inner join tg_user u where u.last_name like %?1%", nativeQuery = true)
    Optional<HwFromStudent> findByLastName(String userName);

    List<HwFromStudent> findAll();

    @Query(value = "SELECT * FROM hw_from_students WHERE student_id = ?", nativeQuery = true)
    HwFromStudent findHwFromStudentByStudentId(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM hw_from_students WHERE student_id = ?1", nativeQuery = true)
    void deleteById(Long id);
*/

    public List<HwFromStudent> findAllById(Long id) {
        return null;
    }



}
