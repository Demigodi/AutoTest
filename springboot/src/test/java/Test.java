import com.source.entity.Student;
import com.source.repository.StudentRepository;
import com.source.repository.impl.StudentRepositoryImpl;

import java.util.Collection;

public class Test {

    @org.junit.Test
    public void testStudent(){
        StudentRepository repository = new StudentRepositoryImpl();

        Student student = new Student(4L,"啊哈",25);

        repository.save(student);
        Collection<Student> collection = repository.findAll();
        System.out.println(collection.size());
    }
}
