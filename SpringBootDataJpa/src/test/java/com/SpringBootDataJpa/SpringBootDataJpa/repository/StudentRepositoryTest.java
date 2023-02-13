package com.SpringBootDataJpa.SpringBootDataJpa.repository;

import com.SpringBootDataJpa.SpringBootDataJpa.entity.Guradian;
import com.SpringBootDataJpa.SpringBootDataJpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
 class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudnet(){

        Student student = Student.builder()
                .emailId("Ram@gmail.com")
                .firstName("ram")
                .lastName("Patil")
              //  .guradianName("Honika")
                //.guradianEmail("honial@gmail.com")
               // .guradianMobie("985612347")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guradian guradian = Guradian.builder()
                .name("Janki")
                .email("Janki@gmail.com")
                .mobile("7889455611").build();



        Student student =Student.builder()
                .firstName("Sita")
                .emailId("Sita@gmail.com")
                .lastName("Ganika")
                .guradian(guradian)
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }


    @Test
    public void printStudentByName()
    {
        List<Student> students = studentRepository.findByFirstName("Sita");
        System.out.println(students);

    }

    @Test
    public void printStudnetfindByFirstNameContaining()
    {
        List<Student> students = studentRepository.findByFirstNameContaining("Ra");
        System.out.println("data Is \n"+ students);
    }


    @Test
    public  void printStudentfindbyLastNameNotnul()
    {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void printStudentfindByGuradianName()
    {
        List<Student> students = studentRepository.findByGuradianName("Janki");
        System.out.println(students);
    }

    @Test
    public void printStudentfindByFirstNameAndLastName()
    {
        Student student = studentRepository.findByFirstNameAndLastName("ram","patil");
        System.out.println(student);
    }

//------------------------------------JPA
    @Test
    public void printStudentByEmailAddress()
    {
        Student student =studentRepository.getStudentByEmailAddress("ram@gmail.com");
        System.out.println(student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress()
    {
        String  student
                = studentRepository.getStudentFirstNameByEmailAddress("Sita@gmail.com");
        System.out.println(student);
    }
//---------------------------------------------------------

    @Test
    public void printgetStudentByEmailAddressNative()
    {
        Student student = studentRepository.getStudentByEmailAddressNative("sita@gmail.com");
        System.out.println(student);
    }

//---------------------------------------------------------
//Query Named Params
    @Test
    public void printgetStudentByEmailAddressNativeNamedParam()
{
    Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("sita@gmail.com");
    System.out.println(student);
}

//------------------------------------------------------------------

@Test
    public void  MmodifyupdateStudnetNameByEmailId()
{
    studentRepository.updateStudnetNameByEmailId("rama kaka patil ","Ram@gmail.com");
}

@Test
    public  void AnydeleteStudnetNameByEmailId()
{
    studentRepository.deleteStudnetNameByEmailId("Sita@gmail.com");
}

}