class Solution {
    List<String> list = new ArrayList<>();
    int[] leds = new int[10];
    public List<String> readBinaryWatch(int turnedOn) {
        util(turnedOn,0,leds);
        return list;
    }
    public void util(int turnedOn, int idx, int[] leds){
        if(turnedOn==0){
            //calculate time and add to list
            int hr = 8*leds[0] + 4*leds[1] + 2*leds[2] + leds[3];
            if(hr>11) return;
            int min = 32*leds[4] + 16*leds[5] + 8*leds[6] + 4*leds[7] + 2*leds[8] + leds[9];
            if(min>=60) return;
            StringBuilder time = new StringBuilder();
            time.append(hr);
            time.append(':');
            if(min<10){
                time.append(0);
                time.append(min);
            }
            else time.append(min);
            list.add(time.toString());
            return;
        }
        if(idx==10) return;
        //pick or not pick
        leds[idx] = 1;
        util(turnedOn-1, idx+1, leds);
        leds[idx] = 0;
        util(turnedOn, idx+1, leds);
    } 
}