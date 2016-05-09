package additional.chapter3;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DishStreamTest {

    @Test
    public void testGenerateMenuList()
            throws Exception {
        List<Dish> menu = DishStream.generateMenuList(600, 30);
        assertEquals(DishStream.getLowCaloriesDishNamesList(menu), DishStream.getLowCaloriesDishNamesListJava8(menu));
    }

    @Test
    public void testGetLowCaloriesDishCount() {
        List<Dish> menu = DishStream.generateMenuList(600, 30);
        assertEquals(DishStream.getLowCaloriesDishCount(menu, 300), DishStream.getLowCaloriesDishCountJava8(menu, 300));
    }
}