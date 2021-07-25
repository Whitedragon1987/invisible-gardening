import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Employee;
import com.invisiblegardening.repositories.EmployeeRepository;
import com.invisiblegardening.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Captor
    ArgumentCaptor<Employee> employeeCaptor;

    @Test
    public void getEmployeeTest() {
        Employee employee = new Employee();
        employee.setName("test");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        employeeService.getEmployee(1L);
    }

    @Test
    public void getEmployeeExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> employeeService.getEmployee(null));
    }

    @Test
    public void getEmployeesTest() {
        List<Employee> testEmployees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("Henk");
        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("Kees");
        Employee employee3 = new Employee();
        employee3.setId(3L);
        employee3.setName("Jan");

        testEmployees.add(employee1);
        testEmployees.add(employee2);
        testEmployees.add(employee3);

        when(employeeRepository.findAll()).thenReturn(testEmployees);

        employeeService.getEmployees();

        verify(employeeRepository, times(1)).findAll();

        assertThat(testEmployees.size()).isEqualTo(3);
        assertThat(testEmployees.get(0)).isEqualTo(employee1);
        assertThat(testEmployees.get(1)).isEqualTo(employee2);
        assertThat(testEmployees.get(2)).isEqualTo(employee3);
    }

    @Test
    public void saveEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("test");

        employeeRepository.save(employee);

        verify(employeeRepository, times(1)).save(employeeCaptor.capture());
        var employee1 = employeeCaptor.getValue();

        assertThat(employee1.getName()).isEqualTo("test");
        assertThat(employee1.getId()).isEqualTo(1);
    }

    @Test
    public void updateEmployeeTest() {
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("test");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee1));

        employee1.setName("test1");
        employeeService.updateEmployee(1L, employee1);

        verify(employeeRepository).save(employee1);

        assertThat(employee1.getId()).isEqualTo(1);
        assertThat(employee1.getName()).isEqualTo("test1");
    }

    @Test
    public void updateEmployeeExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> employeeService.getEmployee(null));
    }

    @Test
    public void deleteEmployeeTest() {
        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("test");

        employeeRepository.delete(employee1);

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).delete(employee1);
    }


}