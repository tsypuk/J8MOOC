package additional;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.collections.ListMultiMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class LogicalPriorityTest {
private Map<Boolean, List<Boolean>> resultsMap = new HashMap<>();
    @BeforeClass
    public void generateMap() {
        resultsMap.put(true, Arrays.asList(true, false, false));
        resultsMap.put(false, Arrays.asList(false, false, false));
        resultsMap.put(false, Arrays.asList(false, false, false));
        resultsMap.put(true, Arrays.asList(true, false, true));
        resultsMap.put(true, Arrays.asList(true, true, false));
        resultsMap.put(true, Arrays.asList(false, true, true));
    }

    @Test
    public void testOperation1()
            throws Exception {
        resultsMap.forEach((result, booleanList) ->
                            assertEquals(result.booleanValue(), LogicalPriority.operation1(booleanList.get(0), booleanList.get(1), booleanList.get(2))));
    }

    @Test
    public void testOperation2()
            throws Exception {
        resultsMap.forEach((result, booleanList) ->
                            assertEquals(result.booleanValue(), LogicalPriority.operation2(booleanList.get(0), booleanList.get(1), booleanList.get(2))));
    }

    @Test
    public void testUnary() {
        int i = -4;
        assertEquals(-i, 4);
    }
}