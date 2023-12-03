package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for(int i=0;i<presentCapacities.length;i++)
      {
        double soh=(double)presentCapacities[i]/120; //rated capacities 120Ah
        soh=soh*100;
        if(soh>80)                                  //at 80% it is 96Ah- 100% it is 120Ah
          counts.healthy++;
        else if(soh>=62)                            //at 62% it is 74.4Ah
          counts.exchange++;
        else
          counts.failed++;
      }
    return counts;                                  //returns the counts of healthy, exchangeable and failed batteries 
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};           //sample test case
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
