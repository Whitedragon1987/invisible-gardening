import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Machine;
import com.invisiblegardening.repositories.MachineRepository;
import com.invisiblegardening.services.MachineServiceImpl;
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
public class MachineServiceTest {

    @Mock
    MachineRepository machineRepository;

    @InjectMocks
    private MachineServiceImpl machineService;

    @Captor
    ArgumentCaptor<Machine> machineCaptor;

    @Test
    public void getMachineTest() {
        Machine machine = new Machine();
        machine.setMachineName("test");
        when(machineRepository.findById(1L)).thenReturn(Optional.of(machine));

        var machine1 =machineService.getMachine(1L);
        assertThat(machine1.getMachineName()).isEqualTo("test");
    }

    @Test
    public void getMachineExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> machineService.getMachine(null));
    }

    @Test
    public void getMachinesTest() {
        List<Machine> testMachines = new ArrayList<>();
        Machine machine1 = new Machine();
        machine1.setId(1L);
        machine1.setMachineName("kraan");
        Machine machine2 = new Machine();
        machine2.setId(2L);
        machine2.setMachineName("trilplaat");
        Machine machine3 = new Machine();
        machine3.setId(3L);
        machine3.setMachineName("shovel");

        testMachines.add(machine1);
        testMachines.add(machine2);
        testMachines.add(machine3);

        when(machineRepository.findAll()).thenReturn(testMachines);

        machineService.getMachines();

        verify(machineRepository, times(1)).findAll();

        assertThat(testMachines.size()).isEqualTo(3);
        assertThat(testMachines.get(0)).isEqualTo(machine1);
        assertThat(testMachines.get(1)).isEqualTo(machine2);
        assertThat(testMachines.get(2)).isEqualTo(machine3);
    }


    @Test
    public void saveMachineTest() {
        Machine machine = new Machine();
        machine.setId(1L);
        machine.setMachineName("test");

        machineRepository.save(machine);

        verify(machineRepository, times(1)).save(machineCaptor.capture());
        var machine1 = machineCaptor.getValue();

        assertThat(machine1.getMachineName()).isEqualTo("test");
        assertThat(machine1.getId()).isEqualTo(1);
    }


    @Test
    public void updateMachineTest() {
        Machine machine1 = new Machine();
        machine1.setId(1L);
        machine1.setMachineName("test");
        when(machineRepository.findById(1L)).thenReturn(Optional.of(machine1));

        machine1.setMachineName("test1");
        machineService.updateMachine(1L, machine1);

        verify(machineRepository).save(machine1);

        assertThat(machine1.getId()).isEqualTo(1);
        assertThat(machine1.getMachineName()).isEqualTo("test1");
    }

    @Test
    public void updateMachineExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> machineService.getMachine(null));
    }

    @Test
    public void deleteMachineTest() {
        Machine machine1 = new Machine();
        machine1.setId(1L);
        machine1.setMachineName("test");

        machineRepository.delete(machine1);

        machineService.deleteMachine(1L);

        verify(machineRepository, times(1)).delete(machine1);
    }
}