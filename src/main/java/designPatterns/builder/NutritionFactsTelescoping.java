package designPatterns.builder;

/** Creating an object without Builder pattern, using "telescoping" approach
 *  (constructors with different number of parameters - in this example 2, 3, 4,..)
 *  The issue with this approach is that it is hard to read and write client code.
 *  From "Effective Java" by Joshua Bloch. */
public class NutritionFactsTelescoping {
    private final int servingSize;  // (mL)            required, essential
    private final int servings;     // (per container) required, essential

    private final int calories;     //                 optional
    private final int fat;          // (g)             optional
    private final int sodium;       // (mg)            optional
    private final int carbohydrate; // (g)             optional

    /**
     * Constructor that takes only required parametes
     * @param servingSize serving size
     * @param servings serving size
     */
    public NutritionFactsTelescoping(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    /**
     * Constructor that takes 3 parameters
     * @param servingSize  serving size
     * @param servings serving size
     * @param calories calories
     */
    public NutritionFactsTelescoping(int servingSize, int servings,
                                     int calories) {
        this(servingSize, servings, calories, 0);
    }

    /**
     * Constructor that takes 4 parameters
     * @param servingSize  serving size
     * @param servings serving size
     * @param calories calories
     * @param fat fat */
    public NutritionFactsTelescoping(int servingSize, int servings,
                                     int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }


    /**
     * Constructor that takes 5 parameters
     * @param servingSize  serving size
     * @param servings serving size
     * @param calories calories
     * @param fat fat
     * @param sodium sodium
     */
    public NutritionFactsTelescoping(int servingSize, int servings,
                                     int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    /**
     * Constructor that takes all possible parameters
     * @param servingSize  serving size
     * @param servings serving size
     * @param calories calories
     * @param fat fat
     * @param sodium sodium
     * @param carbohydrate carbohydrate
     */
    public NutritionFactsTelescoping(int servingSize, int servings,
                                     int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsTelescoping cocaCola =
                new NutritionFactsTelescoping(240, 8, 100, 0, 35, 27);

    }
}
