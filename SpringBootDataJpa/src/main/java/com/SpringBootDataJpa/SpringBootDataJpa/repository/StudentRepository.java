package com.SpringBootDataJpa.SpringBootDataJpa.repository;

import com.SpringBootDataJpa.SpringBootDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuradianName(String name);

    public Student findByFirstNameAndLastName(String firstName,String lastName);
//------------------------------------------------------------------------------
    //JPQL
    //Query is based on Class not on table
    @Query("select s from Student s Where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId );

    @Query("select s.firstName from Student s Where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String emailId );
//-----------------------------------------------------------------------------------
    //Native Query
    @Query(
            value = "select * from  tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


//------------------------------------------------------------------------------------
//Query Named Params
    @Query(
            value = "select * from  tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
//---------------------------------------------------------------------------------------------
//@Transaction And @Modifying  Annotation
//(use for update and delete data )
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name =?1 where email_address =?2",
            nativeQuery = true
    )
    int updateStudnetNameByEmailId(String firstName,String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "delete from tbl_student  where email_address =?1",
            nativeQuery = true
    )
    int deleteStudnetNameByEmailId(String emailId);

}
