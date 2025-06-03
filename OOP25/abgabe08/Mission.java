public class Mission {
    private double missionTime;
    private int difficulty;

    public Mission(double missionTime, int difficulty) {
        this.missionTime = missionTime;
        this.difficulty = difficulty;
    }

    public void adjustMissionTime(int zeit) {
        this.missionTime = Math.max(0, this.missionTime - zeit);
    }

    public int getDifficulty() {
        return this.difficulty;
    }
}
