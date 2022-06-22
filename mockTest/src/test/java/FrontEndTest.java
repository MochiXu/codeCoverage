import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FrontEnd.class,Task.class,MyFinalClass.class})
public class FrontEndTest {


    @Test
    public void sendAddTaskResultNormalTask() {
//        frontEnd=new FrontEnd(false);

        //准备数据
        Task task = new Task();

        IdMapper idMapper= mock(IdMapper.class);
        BackendConfig.GatewayConfig gatewayConfig = mock(BackendConfig.GatewayConfig.class);
        FrontEnd frontEnd=new FrontEnd(idMapper,gatewayConfig);
        frontEnd.sendAddTaskResult(task);
        MyFinalClass f= mock(MyFinalClass.class);
        when(f.getTest()).thenReturn("hello");
        when(f.getUrl()).thenReturn("haha");
        System.out.println(f.getUrl());
    }

    @Test
    public void sendAddTaskResultNormalTask2() {
//        frontEnd=new FrontEnd(false);

        //准备数据
        Task task = mock(Task.class);
        when(task.getTaskID()).thenReturn(9);
        IdMapper idMapper= mock(IdMapper.class);
        BackendConfig.GatewayConfig gatewayConfig = mock(BackendConfig.GatewayConfig.class);
        FrontEnd frontEnd=new FrontEnd(idMapper,gatewayConfig);
        frontEnd.sendAddTaskResult(task);
        MyFinalClass f= mock(MyFinalClass.class);
        when(f.getTest()).thenReturn("hello");
        when(f.getUrl()).thenReturn("haha");
        System.out.println(f.getUrl());
    }

    @Test
    public void sendAddTaskResultNormalTask3() {
//        frontEnd=new FrontEnd(false);

        //准备数据
        Task task = mock(Task.class);
        when(task.getTaskID()).thenReturn(10);

        IdMapper idMapper= mock(IdMapper.class);
        BackendConfig.GatewayConfig gatewayConfig = mock(BackendConfig.GatewayConfig.class);
        FrontEnd frontEnd=new FrontEnd(idMapper,gatewayConfig);
        frontEnd.sendAddTaskResult(task);
        MyFinalClass f= mock(MyFinalClass.class);
        when(f.getTest()).thenReturn("hello");
        when(f.getUrl()).thenReturn("haha");
        System.out.println(f.getUrl());
        Mockito.verify(f,Mockito.times(0)).getTest();
    }

    @Test
    public void sendAddTaskResultNormalTask4() {
//        frontEnd=new FrontEnd(false);

        //准备数据
        Task task = mock(Task.class);
        when(task.getTaskID()).thenReturn(13);

        IdMapper idMapper= mock(IdMapper.class);
        BackendConfig.GatewayConfig gatewayConfig = mock(BackendConfig.GatewayConfig.class);
        FrontEnd frontEnd=new FrontEnd(idMapper,gatewayConfig);
        frontEnd.sendAddTaskResult(task);
        MyFinalClass f= mock(MyFinalClass.class);
        when(f.getTest()).thenReturn("hello");
        when(f.getUrl()).thenReturn("haha");
        System.out.println(f.getUrl());
        Mockito.verify(f,Mockito.times(0)).getTest();
    }

    @Test
    public void sendAddTaskResultNormalTask5() {
//        frontEnd=new FrontEnd(false);

        //准备数据
        Task task = mock(Task.class);
        when(task.getTaskID()).thenReturn(16);

        IdMapper idMapper= mock(IdMapper.class);
        BackendConfig.GatewayConfig gatewayConfig = mock(BackendConfig.GatewayConfig.class);
        FrontEnd frontEnd=new FrontEnd(idMapper,gatewayConfig);
        frontEnd.sendAddTaskResult(task);
        MyFinalClass f= mock(MyFinalClass.class);
        when(f.getTest()).thenReturn("hello");
        when(f.getUrl()).thenReturn("haha");
        System.out.println(f.getUrl());
        Mockito.verify(f,Mockito.times(0)).getTest();
    }
}