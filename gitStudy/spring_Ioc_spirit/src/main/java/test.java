public class test {

    public static void main(String[] args) {
        try {
            Bean bean = BeanFactory.getBean("HelloWorld");
            bean.run();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}