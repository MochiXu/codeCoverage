

public class FrontEnd {

    private static final int count = 3;
    private static final String token = "e59afdef516e53b32120ce0c2aff8ff8faf516b8";

    private final IdMapper idMapper;
    private final BackendConfig.GatewayConfig gatewayConfig;


    public FrontEnd(IdMapper idMapper, BackendConfig.GatewayConfig gatewayConfig) {
        this.idMapper = idMapper;
        this.gatewayConfig = gatewayConfig;
    }

    public void sendAddTaskResult(Task task) {
        if (task.getTaskID() == 0) {
            System.out.println("this Task is default task");
        } else {
            if (task.getTaskID() == 9) {
                System.out.println("this Task has changed taskNum");
            } else {
                System.out.println("this Task has been mocked totaly!");
            }
        }
    }
}
