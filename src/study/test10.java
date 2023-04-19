package study;


public class test10 {
    public static void main(String[] args) {

        FishFrame fish1 = new FishFrame();
        FishFrame fish2 = new FishFrame(10, "까만색");

        System.out.println(fish1.fid);
        System.out.println(fish1.color);

        System.out.println(fish2.fid);
        System.out.println(fish2.color);

        int e = fish2.getEyes();
        int e1 = fish2.getEyes(11);


        FishFrame fish3 = new FishFrame();

        FishFrame fish4 = fish3.getFish();

        fish4.setFish(fish3);

    }
}