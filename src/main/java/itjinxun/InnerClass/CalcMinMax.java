package itjinxun.InnerClass;

public class CalcMinMax {
    public static int[] calc(int... numbs){
        int min = 0;
        int max = 0;
        for (int i = 0; i < numbs.length; i++) {
            if(i == 0){
                min = numbs[i];
                max = numbs[i];
            }else{
                if(min > numbs[i]){
                    min = numbs[i];
                }
                if(max < numbs[i]){
                    max = numbs[i];
                }
            }
        }
        return new int[] {min, max};
    }

    public static Pair calc2(int... numbs){
        Integer min = null;
        Integer max = null;

        for (int num : numbs){
            if(min == null ||min.intValue() > num){
                min = num;
            }
            if(max == null ||max.intValue() < num){
                max = num;
            }
        }
        return new Pair(min,max);
    }

    public static class Pair{
        private Integer minValue;
        private Integer maxValue;

        protected Pair(Integer minValue, Integer maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        public Integer getMinValue() {
            return minValue;
        }

        public void setMinValue(Integer minValue) {
            this.minValue = minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(Integer maxValue) {
            this.maxValue = maxValue;
        }
    }
}
