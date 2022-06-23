import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class IdMapperTest {

    @Test
    public void getIdMapperY() {
        String arg1="dewjoiw";
        String arg2="djewoidew";
        IdMapper idMapper=new IdMapper();
        idMapper.getIdMapperY(arg1,arg2);
        assertEquals("dewjoiw:djewoidew:id:mapper",idMapper.getIdMapperY(arg1,arg2));
    }

    @Test
    public void getIdMapperN() {
    }
}