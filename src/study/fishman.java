package study;

class FishFrame {

    int fid;
    String color;
    int eyes = 2;

    FishFrame() {
        this.fid = 0;
        this.color = "노란색";
    }

    FishFrame(int f, String c) {
        this.fid = f;
        this.color = c;
    }

    FishFrame(String c, int f) {
        this.fid = f;
        this.color = c;
    }

    int getEyes() {
        return this.eyes;
    }

    int getEyes(int i) {
        return this.eyes;
    }



    FishFrame getFish() {

        FishFrame fish = new FishFrame();

        return fish;
    }

    void setFish(FishFrame fish) {

        this.fid = fish.fid;
        this.color = fish.color;


    }


}


