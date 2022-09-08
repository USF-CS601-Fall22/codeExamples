package designPatterns.builder;
/** Driver class for the Builder Pattern */
public class Driver {
    public static void main(String[] args) {
        NutritionFactsWithBuilder.Builder builder = new NutritionFactsWithBuilder.Builder(20, 8);
        NutritionFactsWithBuilder nf = builder.calories(300).fat(10).build();
        System.out.println(nf);
    }

}
