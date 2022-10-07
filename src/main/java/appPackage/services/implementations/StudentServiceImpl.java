package appPackage.services.implementations;

import appPackage.controllers.StudentController;
import appPackage.data.Course;
import appPackage.data.Student;
import appPackage.repositories.StudentRepository;
import appPackage.services.interfaces.CourseService;
import appPackage.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;



    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentByUsername(String username) {


        return studentRepository.getOne(username);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsByCourse(Course course) {
        return studentRepository.findByCourse(course);
    }


    //create a student. If the username already exists, the student is not made. Make sure you encrypt the password
    @Override
    public Student createStudent(Student student) {
            student = new Student(student.getUserName(), student.getPassWord(), student.getFirstName(), student.getLastName(), student.isOnBlackList(), student.getCourse());
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec(student.getPassWord().toCharArray(), salt, 65536, 128);
            try {
                SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
            if(getAllStudents().contains(getStudentByUsername(student.getUserName()))){
                System.out.println("Student already exists.");
            } else {
            studentRepository.save(student);
        }

        return student; }

    }



