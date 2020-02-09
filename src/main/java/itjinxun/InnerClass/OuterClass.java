package itjinxun.InnerClass;

public class OuterClass {
    private Integer index;

    private String name;

    public OuterClass(Integer index, String name){
        this.index = index;
        this.name = name;
    }

    public class InnerClass{
        private String name;

        public InnerClass(String name){
            this.name = name;
        }

        public class InnerClass2{
            public class InnerClass3{
            }
        }

        public void printInfo(){
            /*StringBuilder sb = new StringBuilder();
            sb.append("外围类index=");
            sb.append(OuterClass.this.index);
            sb.append("外围类name=");
            sb.append(OuterClass.this.name);
            System.out.println(sb.toString());*/

            String name = "方法";
            //name = "";
            //使用局部内部类实现打印
            /*class PrintClass{
                void print(){
                    StringBuilder sb = new StringBuilder();
                    sb.append("外围类index=");
                    sb.append(OuterClass.this.index);
                    sb.append("外围类name=");
                    sb.append(name);
                    System.out.println(sb.toString());
                }
            }
            new PrintClass().print();*/

            //使用匿名内部类实现打印(实现接口)
            /*new PrintInterface(){
                @Override
                public void print() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("外围类index=");
                    sb.append(OuterClass.this.index);
                    sb.append("外围类name=");
                    sb.append(name);
                    System.out.println(sb.toString());
                }
            }.print();*/
            //上面匿名内部类写法等价于下面内容
            /*class PrintInterfaceImpl implements PrintInterface{
                @Override
                public void print() {

                }
            }
            new PrintInterfaceImpl().print();*/

            //使用匿名内部类实现打印(实现抽象类)
            /*new PrintAbstract(){
                @Override
                public void print() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("外围类index=");
                    sb.append(OuterClass.this.index);
                    sb.append("外围类name=");
                    sb.append(name);
                    System.out.println(sb.toString());
                }
            }.print();*/
            //上面匿名内部类写法等价于下面内容
            /*class PrintAbstractImpl extends PrintAbstract{
                @Override
                public void print() {

                }
            }
            new PrintAbstractImpl().print();*/

            //使用匿名内部类实现打印(实现普通类)
            new PrintClass("类名"){
                @Override
                public void print() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("外围类index=");
                    sb.append(OuterClass.this.index);
                    sb.append("外围类name=");
                    sb.append(super.name);
                    System.out.println(sb.toString());
                }
            }.print();
            //上面匿名内部类写法等价于下面内容
            /*class PrintClassImpl extends PrintClass{
                @Override
                public void print() {

                }
            }
            new PrintClassImpl().print();*/
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass(1,"我是外围类");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass("我是内部类");
        innerClass.printInfo();
    }
}
