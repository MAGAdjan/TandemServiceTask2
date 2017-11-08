import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestAssigner {
    private final ElementExampleImpl.Context context = new ElementExampleImpl.Context();


    @Test
    public void testEmptyList() {
        List<IElement> emptyList = new ArrayList();
        Task2Impl.INSTANCE.assignNumbers(emptyList);
        assertTrue(emptyList.size() == 0);
    }

    @Test
    public void testNull() {
        List<IElement> nullList = null;
        Task2Impl.INSTANCE.assignNumbers(nullList);
        assertEquals(null, nullList);
    }

    @Test
    public void testCorrectness() {
        List<IElement> testList = new ArrayList();
        testList.add(new ElementExampleImpl(context, 3));
        testList.add(new ElementExampleImpl(context, 1));
        testList.add(new ElementExampleImpl(context, 6));
        testList.add(new ElementExampleImpl(context, 4));
        testList.add(new ElementExampleImpl(context, 0));
        testList.add(new ElementExampleImpl(context, 5));
        testList.add(new ElementExampleImpl(context, 2));
        Task2Impl.INSTANCE.assignNumbers(testList);
        int testingResult = countDiff(testList);
        assertTrue(testingResult == 0);
    }

    public int countDiff(List<IElement> toBeTested) {
        int countDifference = 0;
        for(int i = 0; i < toBeTested.size(); i++) {
            if(toBeTested.get(i).getNumber() != i) {
                countDifference++;
            }
        }
        return countDifference;
    }

}
