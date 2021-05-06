public class BeanFactory {

    public static Bean getBean(String beanName) throws Exception {
        Class<Bean> beanClass = (Class<Bean>) Class.forName(beanName);
        return (Bean) beanClass.newInstance();
    }
}