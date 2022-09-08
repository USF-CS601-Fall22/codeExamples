package designPatterns.builder;

/** This class demonstrates how to construct an object of class NutritionFacts using
 * Builder design pattern.
 * Based on the example from Effective Java by Joshua Bloch.
 */
public class NutritionFactsWithBuilder {
    private final int servingSize; //essential
    private final int servings; // essential
    private final int calories; // optional
    private final int fat; // optional
    private final int sodium; // optional

    /** Nested helper class that will be constructing objects of class NutritionFacts.. */
    public static class Builder {

        private int servingSize, servings; // essential parameters

        // optional parameters - assigning default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;

        /**
         * Constructor for class Builder
         * @param servingSize serving size
         * @param servings number of servings
         */
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        /**
         * Setter for calories.
         * @param calories calories
         * @return instance of this builder
         */
        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        /**
         * Setter for fat
         * @param fat fat
         * @return Instance of class Builder
         */
        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        /**
         * Setter for sodium
         * @param sodium
         * @return instance of class Builder
         */
        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        /** The method that constructs an instance of class NutritionFactsWithBuilder
         *
         * @return a new instance of class NutritionFactsWithBuilder
         */
        public NutritionFactsWithBuilder build() {
            // Validity checks could be added here to make sure parameters make sense
            // and the object is valid

            return new NutritionFactsWithBuilder(this); //this here refers to this instance of the Builder
        }
    } // The end of the nested class Builder --------------

    /**
     * Constructor for class NutritionFactsWithBuilder
     * @param builder instance of Builder
     */
    public NutritionFactsWithBuilder(Builder builder) {
        this.servingSize  = builder.servingSize;
        this.servings     = builder.servings;
        this.calories     = builder.calories;
        this.fat          = builder.fat;
        this.sodium       = builder.sodium;
    }

    /**
     * Getter for calories
     * @return calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Getter for fat
     * @return fat
     */
    public int getFat() {
        return fat;
    }

    /**
     * Getter for sodium
     * @return sodium
     */
    public int getSodium() {
        return sodium;
    }

    /**
     * Returns a string representation of this object.
     * @return a string representation of this object. The string currently contains only
     * essential variables - feel free to modify to print all instance variables.
     */
    @Override
    public String toString() {
        return "Nutrition Facts (Printing servings and serving size only):" + System.lineSeparator() +
                "servingSize: " + servingSize + " servings: " + servings;

    }
}
