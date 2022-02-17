import org.junit.Assert;
import org.junit.Test;

public class FileTransformationTests {

    @Test
    public void ifReadFileCountWordsThenCorrect(){
        String expectedOutput ="{a=3, aasif=3, at=1, best=2, developer=3, is=5, java=5, " +
                "knoldus=4, language=4, programming=3, software=1, the=1, to=1, used=1, write=1}";
        String actualOutput = FileTransformation.readFile("src/test/java/test").toString();
        Assert.assertEquals(expectedOutput,actualOutput);
        System.out.println("Passed");
    }
}
