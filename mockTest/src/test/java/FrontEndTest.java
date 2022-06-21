import static org.mockito.Mockito.when;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FrontEnd.class)
public class FrontEndTest {


    @Test
    public void sendAddTaskResultNormalTask() {
//        frontEnd=new FrontEnd(false);

        //准备数据
        Task task = new Task();

        IdMapper idMapper= PowerMockito.mock(IdMapper.class);
        BackendConfig.GatewayConfig gatewayConfig = PowerMockito.mock(BackendConfig.GatewayConfig.class);
        FrontEnd frontEnd=new FrontEnd(idMapper,gatewayConfig);
//        frontEnd.sendAddTaskResult(task);
        MyFinalClass f=PowerMockito.mock(MyFinalClass.class);
        when(f.getTest()).thenReturn("hello");
        when(f.getUrl()).thenReturn("haha");
        System.out.println(f.getUrl());
    }

//    @Mock
//    Task task2;
//    @Test
//    public void sendAddTaskResultOtherTask() {
//        //准备数据
//        when(task2.getTaskID()).thenReturn(3);
////        when(Task.TaskName).thenReturn("mockTaskName");
//
////        frontEnd.sendAddTaskResult(task2);
//    }
}