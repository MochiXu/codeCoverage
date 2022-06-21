//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//@RunWith(PowerMockRunner.class)
//
//public class BookTest {
//
//    @InjectMocks
//    Book book;
//
//    @Mock
//    Utils utils;
//
//    @Test
//    public void fixBook() {
//        // stubbing 只在 text 中有效
//        when(utils.getBooksName2(anyString())).thenReturn("--");
//        int a = book.fixBook();
//        System.out.println(utils.getBooksName2("de"));
//        Assert.assertEquals(book.fixBook(),5);
//    }
//}