package designPatterns.builder;
/** Basic implementation of class NutritionFacts that contains nutritional info
 * about a food item. From "Effective Java" by Joshua Bloch. */
public class NutritionFacts {
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required

    private final int calories;     //                 optional
    private final int fat;          // (g)             optional
    private final int sodium;       // (mg)            optional
    private final int carbohydrate; // (g)             optional

    /**
     * Constructor for class NutritionFacts
     * @param servingSize serving size (in spoons)
     * @param servings number of servings
     * @param calories calories
     * @param fat fat
     * @param sodium sodium
     * @param carbohydrate carbs
     */
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    // Other methods could be added here like getters, toString etc.
}
