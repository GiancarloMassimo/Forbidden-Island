public class WaterLevel {
    public static int waterMarkerLevel = 2;
    public static int waterLevel = 2;


    public static void increaseWaterLevel() {
        waterMarkerLevel++;

        if (waterMarkerLevel == 10) {
            //TODO: Add lose condition for water level reaching maximum
        }

        if (waterMarkerLevel >= 3) {
            waterLevel = 3;
        }
        if (waterMarkerLevel >= 6) {
            waterLevel = 4;
        }
        if (waterMarkerLevel >= 8) {
            waterLevel = 5;
        }
    }
}
