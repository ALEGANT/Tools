# 关于Ioc容器的源码理解

## 关于Ioc
  
  1. Ioc是什么 : 控制反转(Inversion of Control)，依赖对象的获得被反转。本质上是一个容器，提供了数据存取的服务。
  2. Ioc处理了什么问题 :  当一个应用是由多个类来合作完成任务，那么会导致每个对象都要与合作的对象引用(即在A类中调用B类时需要去引用B类，使得代码高度耦合难以修改)。见code 1,code 2.
  3. Ioc改变了什么 : 对象的控制权发生了改变,本来对象内部的其他对象引用的控制由这个对象本身被抽取了出来(如code2里UserServiceImpl里面的UserDao的具体引用控制被抽取出来),使得对象的控制权由程序代码控制转变成了配置控制.(需要配合反射)

### code 1
```Java
public class test {

	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();

		userService.getUser();
	}

}

public interface UserService {
	
	void getUser();

}

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	public void getUser() {
		userDao.getUser();
	}
}

public interface UserDao {

	public void getUser();
	
}

public class UserDaoImpl implements UserDao{

	@Override
	public void getUser() {
		System.out.println("default method");
	}

}
// 当需要改动具体的业务实现时，需要从dao层进行修改，每次进行修改时都需要程序员在原代码上进行修改，当工程较大时维护成本会很高。
```

### code 2

``` Java
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void getUser() {
		userDao.getUser();
	}
}

public class test {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		((UserServiceImpl)userService).setUserDao(new UserDaoImpl());
		userService.getUser();
	}

}
// 开放了set接口在业务层，当业务变动时，直接通过set方法直接改变需要调用的dao对象即可，由程序员改代码维护变为修改配置维护。
```

## 用Ioc时会有什么问题

### 站在容器的角度:

  1. 它是拿来存放什么的?
  2. 存放的数据需要遵循什么规范?
  3. 存放的数据从哪里来?
  4. 找到数据后需要对数据进行什么处理?
  5. 怎么把数据存放到容器里?
  6. 怎么把数据提供给用户?
  7. 容器时怎么运作的?
  
### 站在数据的角度:

  1. 数据与数据之间有什么关系?
  2. 数据所具有的特性如何实现?
  3. 数据内容从哪来?

## Ioc的几个重要接口

### BeanFactory
BeanFactory是Spring容器的根接口,顾名思义这是个Bean的工厂.
|接口名|接口作用|
|---|---|
|containsBean|判断容器是否包含Bean|
|getAliases|获取bean的别名,别名在BeanDefinition中定义|
|getBean|获取Ioc容器的Bean的方法|
|getType|通过给定的名字决定Bean的类型|
|isProtoType|是否原型类型(每次返回一个新的实例)|
|isTypeMatch|检查给定名称的Bean的类型是否符合规范|
|isSingleton|是否单例|

以上是BeanFactory这个接口所定义的方法,通过这些方法名可以看出,Spring提供了最基础的存取和判断功能,而因为它只是接口，具体的实现在不同的类下再进行完善，也使得用户可以个性化地去调整容器。

### XmlBeanFactory

XmlBeanFactory是BeanFactory的其中一个实现类,通过它的继承关系如下 : 

|继承|接口|
|---|---|
|XmlBeanFactory|
|DefaultListableBeanFactory|ConfigurableListableBeanFactory, BeanDefinitionRegistry, Serializable|
|AbstractBeanFactory| AutowireCapableBeanFactory|
|FactoryBeanRegistrySupport|ConfigurableBeanFactory|
|DefaultSingletonBeanRegistry| |SingletonBeanRegistry
| | AliasRegistry|

DefaultListableBeanFactory则继承了ListableBeanFactory;ListableBeanFactory则继承了BeanFactory,从而XmlBeanFactory实现了BeanFactory.

在XmlBeanFactory的构造方法里,需要两个参数,分别为Resource和BeanFactory.从参数名看来,构造它需要资源,这个资源可能来自于机器本地资源,也可能来自于网络,也可能来自代码,那么这里就涉及到一个资源查找、载入、装配、使用的需求。

### Resource

Resource是一个接口，它定义了资源的规范,接口如下:

|接口名|接口功能|
|---|---|
|exists|判断资源是否存在|
|isReadable|资源是否可读(访问权限不足时可能不可读)|
|isOpen|判断资源是否打开流的句柄|
|getURL|获取资源的URL|
|getURI|获取资源URI|
|getFile|返回资源的文件句柄|
|contentLength|返回资源长度|
|lastModified|返回最后修改时间|
|getFilename|获取文件名|
|createRelative|创造相关的资源|
|getDescription|获取资源的描述|

关于前面的问题在这个接口的设计里已经提供了基础设施,只要对实现类进行调用就可以完成上述的要求

### ApplicationContext

ApplicationContext是一个高级的Ioc容器,在继承关系里面,最顶层继承了BeanFactory和ResourceLoader,这意味着它具有容器的功能,同时也具有加载资源的能力。此外直接继承了ListableBeanFactory、HierarchicalBeanFactory、EnviormentCapable、ResourcePatternResolver、MessageSource、ApplicationEventPublisher。

MessageSource接口意味着它可以支持不同的信息源,信息源扩展功能可以支持国际化实现，提供多语言应用服务。

ResourceLoader和Resource接口的接口关系可以知道,用户程序可以从不同的I/O途径获取到资源,这同时也是满足了上面提到的要求，即资源的查找和载入功能。一般来说ApplicationContext的子类都是继承了DefaultResourceLoader的子类,因为DefaultResourceLoader是AbstractApplicationContext的基类。

ApplicationEventPublisher接口提供了事件处理的服务,这使得Bean的生命周期可以与事件相结合,为Bean的管理提供便利。

## Ioc的工作

  Spring的Ioc容器提供了多种实现方式,这里用FileSystemXmlApplicationContext作为样例来研究.

### 初始化容器
  
  FileSystemXmlApplication的构造方法最终会落到这个方法里(除无参构造)
  ```Java
  public FileSystemXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
			throws BeansException {

		super(parent);
		setConfigLocations(configLocations);
		if (refresh) {
			refresh();
		}
	}
  ```
  里面首先用了父容器作为参数，调用父类的构造方法，设置配置路径后执行refresh()方法.沿着super层层往父类可以知道最顶层的父类是AbstractApplicationContext.
  
  ---
  以下是该父类所拥有的部分变量,这些容器的功能是这些变量的功能组合,由这边变量可以看出,AbstractApplicationContext的子类的功能十分强大,可以胜任许多不同种类的任务.
  |变量名|变量类型|作用|
  |---|---|---|
  |parent|ApplicationContext|父容器|
  |environment|ConfigurableEnvironment|可配置环境|
  |startupDate|long|开启时间戳|
  |shutdownHook|Thread|关闭钩子,关闭虚拟机时执行任务|
  |resourcePatternResolver|ResourcePatternResolver|配置模式解析器|
  |lifecycleProcessor|LifecycleProcessor|生命周期处理器|
  |messageSource|MessageSource|消息源|
  |applicationEventMulticaster|ApplicationEventMulticaster|应用事件发表器|
  |applicationListeners|Set<ApplicationListeners<?>>|应用程序监听器|
  |earlyApplicationEvents|earlyApplicationEvents|早期事件集合|
  ---
  ### 工厂构造
  
  设置好配置的路径后,就进入到了refresh()方法;
  
  1. 在方法里首先对启动关闭监视器上锁,
  2. 准备刷新,在准备刷新时会记录启动时间和记录激活状态,随后初始化属性源,配置好属性后开始准备BeanFactory.
  3. BeanFactory获得过程中,会执行refreshBeanFactory()方法,该方法会检查有没有工厂,如果由则摧毁并关闭，然后重建工厂
  4. 构建过程中需要去找到工厂的配置,即Resource的定位,这里的资源通过ResourceLoad的getResource方法可以获得,获得资源后加载相应地址
  5. 通过loadBeanDefinitions(EncodedResource encodedResource)方法找到相应的xml文件,并获取文件的输入流,并执行doLoadBeanDefinitions方法,
  6. doloadBeanDefinitions方法会拿到相应的xml文本,执行registerBeanDefinitions(doc, resource)方法.
  7. registerBeanDefinitions(doc, resource)方法里生成一个BeanDefinitionDocumentReader,具体的解析工作是交付给它执行的,它还会记录注册的BeanDefinition的计数,这里的BeanDefinitionDocumentReader类型为DefaultBeanDefinitionDocumentReader,这里使用的documentReader是默认设置好的,通过class.cast转换得来,最终的处理结果将存放在BeanDefinitionHolder里.BeanDefinition除了存放BeanDefinition对象之外,还存储Bean的名字、别名集合等,XmlBeanDefinitionReader里面并在doRefisterBeanDefinitions方法真正地执行注册,这个过程是按照spring的规范和要求通过ParserDelegate实现的.最终将相关信息存储在beanDefinitionMap里.
  8. 注册并保存了BeanDefinition后,注册bean的Components注册成功后,BeanFactory就已经被生成了.
  
#### 交互过程

1. AbstractApplicationContext执行refresh委托到AbstractRefreshableApplicationContext执行
2. AbstractRefreshableApplicationContext执行createBeanFactory委托到DefaultListableBeanFactory执行
3. AbstractRefreshableApplicationContext执行loadBeanDefinitions委托到XmlBeanDefinitionReader执行
4. XmlBeanDefinitionReader执行parseBeanDefinitionElement委托到BeanDefinitionParserDelegate执行
5. XmlBeanDefinitionReader执行processBeanDefinition委托到DefaultBeanDefinitionDocumentReader执行
6. DefaultBeanDefinitionDocumentReader执行registerBeanDefinition委托到DefaultBeanFactory执行

### 依赖注入

在完成了工厂的配置与初始化之后,对Bean依赖注入的工作是在用户向Ioc容器请求的时候触发的,当然这也是可以通过配置里BeanDefinition的lazy-init属性来让容器对bean完成预实例化.这个实例化过程就是完成依赖注入的过程,只不过设置了lazy-init的话这个过程会在初始化时才进行.

1. getBean方法调用获取所需要的Bean,这个方法最终会调用doGetBean.
2. ① doGetBean会先从缓存获取Bean,如果是已经被创建了的且是单例的Bean就不重复创建直接返回实例，②否则就通过BeanDefinition再去构造一个,获取BeanDefinition时会进行存在性检验，先去工厂获取如果工厂没有就去找当前双亲的工厂，如果还是没有就找双亲的工厂链,则递归查找，
3. 获取当前Bean的所有的依赖的Bean，触发getBean的递归调用，直到取到一个没有任何依赖的Bean为止，截止Bean依赖的处理完毕，
4. 最后是对于各种不同类型(singleton、protoType、Scope)的处理，这里的处理是具体处理Bean的生成，最终落入createBean方法，直到这里Bean才真正地进行创建
5. 创建Bean时会去获取Bean的加载器,这里会通过resolveBeanClass方法去解析BeanDefinition找到具体类里面所匹配的构造器,如果Bean配置了PostProcrocee`ssor那么将会返回一个proxy.最终调用doCreateBean去生成
6. doCreateBean会定义一个instanceWrapper去持有创建出来的Bean对象,如果时Singleton则先把缓存的同名Bean清除,然后由createBeanInstance方法去创建Bean实例,这个方法提供了多种方式去生成Bean,其中包括工厂方法生成、通过容器的AutoWire(自动装配)生成，这由BeanDefinition所指定.
7. 生成bean之后紧接着就是执行依赖注入,与依赖注入有关的两个方法分别是populateBean和createBeanInstance


#### 交互过程
1. DefaultListableBeanFactory执行doGetBean方法委托到AbstractBeanFactory执行
2. AbstractBeanFactory执行createBean方法委托到AbstractAutowireCapableBeanFactory执行
3. AbstractAutowireCapableBeanFactory执行instantiate委托到SimpleInstantiationStrategy执行，并返回populateBean方法
4. AbstractAutowireCapableBeanFactory适配了属性值后执行resolveReference委托到BeanDefinitionResolver执行