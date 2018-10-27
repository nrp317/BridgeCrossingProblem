import java.util.*;

public class BridgeCrossingProblem
{
	private int[] crossingTimes;
	private int expectedTime;

	public BridgeCrossingProblem(int crossingTimes[], int expectedTime) {
		this.crossingTimes = crossingTimes;
		this.expectedTime = expectedTime;
	}

	public int getExpectedTime() {
		return this.expectedTime;
	}

	public int[] getCrossingTimes() {
		return this.crossingTimes;
	}

	public int calculateMinimumTime(int crossingTimes[]) {
		Arrays.sort(crossingTimes);
		return calculateTime(crossingTimes, crossingTimes.length);
	}

    public int calculateTime(int crossingTimes[], int noOfPeople)
    {

        // If only two people in the set, return the higher crossing time
        if (noOfPeople == 2)
        {
            return crossingTimes[noOfPeople - 1];
        }
        // if three people in the set, get two fastest ones cross
        // the faster of these two returns with torch
        // the two remaining then crosss the bridge
        else if (noOfPeople == 3)
        {
            return crossingTimes[0] + crossingTimes[1] + crossingTimes[2];
        }
        else {

            // cross the two people with least crossing times
            // get the fastest person back with the torch
            // then get two slowest ones to cross the bridge
            // finally bring the other person who crossed earlier back with the torch
            return crossingTimes[1] + crossingTimes[0] + crossingTimes[noOfPeople - 1] + crossingTimes[1] +
                    calculateTime(crossingTimes, noOfPeople - 2);
        }
    }

    public static void main(String[] args)
    {
		int sampleData1[] = {10 , 20 , 30};
        BridgeCrossingProblem bridgeCrossingProblem = new BridgeCrossingProblem(sampleData1 , 60);
		int calculatedTime = bridgeCrossingProblem.calculateMinimumTime(bridgeCrossingProblem.getCrossingTimes());
        assert calculatedTime == bridgeCrossingProblem.getExpectedTime() :
        				"Expected time : " + bridgeCrossingProblem.getExpectedTime() + ", but Actual time returned : " + calculatedTime;

        int sampleData2[] = {5 , 1 , 2, 10};
        bridgeCrossingProblem = new BridgeCrossingProblem(sampleData2 , 17);
		calculatedTime = bridgeCrossingProblem.calculateMinimumTime(bridgeCrossingProblem.getCrossingTimes());
        assert calculatedTime == bridgeCrossingProblem.getExpectedTime() :
        				"Expected time : " + bridgeCrossingProblem.getExpectedTime() + ", but Actual time returned : " + calculatedTime;

        int sampleData3[] = {6 , 4 , 11, 15};
        bridgeCrossingProblem = new BridgeCrossingProblem(sampleData3 , 37);
		calculatedTime = bridgeCrossingProblem.calculateMinimumTime(bridgeCrossingProblem.getCrossingTimes());
        assert calculatedTime == bridgeCrossingProblem.getExpectedTime() :
        				"Expected time : " + bridgeCrossingProblem.getExpectedTime() + ", but Actual time returned : " + calculatedTime;
    }
}