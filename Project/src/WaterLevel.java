public class WaterLevel {
    public static int waterLevel = 1;

    public static void increaseWaterLevel() {
        waterLevel++;
        if (waterLevel == 6) {
            //TODO: Add lose condition for water level reaching maximum
        }
    }
}
