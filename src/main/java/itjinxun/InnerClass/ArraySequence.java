package itjinxun.InnerClass;

import java.util.Arrays;

public class ArraySequence {
    private Object[] data;
    private int next = 0;

    public ArraySequence(int size) {
        this.data = new Object[size];
    }
    public void add(Object object){
        if(next < data.length){
            data[next++] = object;
        }
    }

    public void print(){
        System.out.println(Arrays.toString(data));
    }

    public Selector selectorReverse(){
        return new SelectorImplReverse();
    }

    public class SelectorImplReverse implements Selector{
        private int index;
        public SelectorImplReverse (){
            this.index = next-1;
        }
        @Override
        public boolean end() {
            return index < 0;
        }

        @Override
        public Object current() {
            if(index >= 0){
                return data[index];
            }
            return null;
        }

        @Override
        public void next() {
            index--;
        }
    }

    public Selector selector(){
        return new SelectorImpl();
    }

    public class SelectorImpl implements Selector{
        private int index = 0;
        @Override
        public boolean end() {
            return index >= next;
        }

        @Override
        public Object current() {
            if(index < next){
                return data[index];
            }
            return null;
        }

        @Override
        public void next() {
            index++;
        }
    }
}
