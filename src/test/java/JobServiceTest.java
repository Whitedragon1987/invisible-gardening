import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Employee;
import com.invisiblegardening.Models.Job;
import com.invisiblegardening.repositories.EmployeeRepository;
import com.invisiblegardening.repositories.JobRepository;
import com.invisiblegardening.services.JobServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class JobServiceTest {

    @Mock
    JobRepository jobRepository;

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private JobServiceImpl jobService;

    @Captor
    ArgumentCaptor<Job> jobCaptor;

    @Test
    public void getJobTest() {
        Job job = new Job();
        job.setJobName("test");
        when(jobRepository.findById(1L)).thenReturn(Optional.of(job));

        jobService.getJob(1L);
    }

    @Test
    public void getJobExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> jobService.getJob(null));
    }

    @Test
    public void getJobsTest() {
        List<Job> testJobs = new ArrayList<>();
        Job job1 = new Job();
        job1.setId(1L);
        job1.setJobName("terras aanleggen");
        Job job2 = new Job();
        job2.setId(2L);
        job2.setJobName("tuinonderhoud");
        Job job3 = new Job();
        job3.setId(3L);
        job3.setJobName("zwembad plaatsen");

        testJobs.add(job1);
        testJobs.add(job2);
        testJobs.add(job3);

        when(jobRepository.findAll()).thenReturn(testJobs);

        jobService.getJobs();

        verify(jobRepository, times(1)).findAll();



        assertThat(testJobs.size()).isEqualTo(3);
        assertThat(testJobs.get(0)).isEqualTo(job1);
        assertThat(testJobs.get(1)).isEqualTo(job2);
        assertThat(testJobs.get(2)).isEqualTo(job3);
    }


    @Test
    public void saveJobTest() {
        Job job = new Job();
        job.setId(1L);
        job.setJobName("test");

        jobRepository.save(job);

        verify(jobRepository, times(1)).save(jobCaptor.capture());
        var job1 = jobCaptor.getValue();

        assertThat(job1.getJobName()).isEqualTo("test");
        assertThat(job1.getId()).isEqualTo(1);
    }


    @Test
    public void updateJobTest() {
        Job job1 = new Job();
        job1.setId(1L);
        job1.setJobName("test");
        when(jobRepository.findById(1L)).thenReturn(Optional.of(job1));

        job1.setJobName("test1");
        jobService.updateJob(1L, job1);

        verify(jobRepository).save(job1);

        assertThat(job1.getId()).isEqualTo(1);
        assertThat(job1.getJobName()).isEqualTo("test1");
    }

    @Test
    public void updateJobExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> jobService.getJob(null));
    }

    @Test
    public void deleteJobTest() {
        Job job1 = new Job();
        job1.setId(1L);
        job1.setJobName("test");

        jobRepository.delete(job1);

        jobService.deleteJob(1L);

        verify(jobRepository, times(1)).delete(job1);
    }

    @Test
    public void assignEmployeeTest() {
        Job job = new Job();
        job.setId(1L);
        when(jobRepository.findById(1L)).thenReturn(Optional.of(job));

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("kees");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        jobService.assignEmployee(1L,1L);

        job.setEmployee(employee);
        verify(jobRepository, times(1)).save(jobCaptor.capture());

        var job1 = jobCaptor.getValue();

        assertThat(job1.getId()).isEqualTo(1);
        assertThat(job1.getEmployee().getId()).isEqualTo(1);
        assertThat(job1.getEmployee().getName()).isEqualTo("kees");
    }
}
