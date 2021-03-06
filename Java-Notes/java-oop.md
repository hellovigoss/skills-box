## Java面向对象
“面向对象”(英语：Object Oriented,简称OO)是一种以事物为中心的编程思想。
面向对象程序设计（英语：Object-oriented programming，缩写：OOP），是一种程序开发的方法。它将对象作为程序的基本单元，将程序和数据封装其中，以提高软件的重用性、灵活性和扩展性。
面向对象时相对于面向过程而已的（c则是一个典型的面向过程的语言），站在面向对象的角度去看问题，你则是对象的动作的指挥者。如果站在面向过程的角度去看问题，你则是动作的执行者。
#### 面向对象的特征
    封装(encapsulation)
    继承(inheritance)
    多态(polymorphism)
    开发的过程：其实就是不断的创建对象，使用对象，指挥对象做事情。
    设计的过程：其实就是在管理和维护对象之间的关系.

#### 构造方法
##### 构造函数与普通的函数的区别
1.一般函数是用于定义对象应该具备的功能。而构造函数定义的是，对象在调用功能之前，在建立时，应该具备的一些内容。也就是对象的初始化内容。
2.构造函数是在对象建立时由jvm调用, 给对象初始化。一般函数是对象建立后，当对象调用该功能时才会执行。
3.普通函数可以使用对象多次调用，构造函数就在创建对象时调用。
4.构造函数的函数名要与类名一样，而普通的函数只要符合标识符的命名规则即可。
5.构造函数没有返回值类型。

##### 构造函数注意的细节  
1.当类中没有定义构造函数时，系统会指定给该类加上一个空参数的构造函数。这个是类中默认的构造函数。当类中如果自定义了构造函数，这时默认的构造函数就没有了。
2.在一个类中可以定义多个构造函数，以进行不同的初始化。多个构造函数存在于类中，是以重载的形式体现的。因为构造函数的名称都相同。

构造代码块作用：给所有的对象进行统一的初始化。
#### static 关键字
##### static特点
        1 随着类的加载而加载，静态会随着类的加载而加载，随着类的消失而消失。说明它的生命周期很长。
      	2 优先于对象存在。-->静态是先存在，对象是后存在。
     	3 被所有实例(对象)所共享。
      	4 可以直接被类名调用	
##### 静态变量（类变量）和实例变量的区别:
    	1存放位置
        	1：类变量随着类的加载而加载存在于方法区中.
         	2：实例变量随着对象的建立而存在于堆内存中.
    	2生命周期
         	1：类变量生命周期最长,随着类的消失而消失.
         	2：实例变量生命周期随着对象的消失而消失.
##### 静态优缺点
        1： 优点:对对象的共享数据进行单独空间的存储,节省空间 例如Person 都有国籍。该数据可以共享可以被类名调
        2：缺点：生命周期过长
                    访问出现局限性。（静态只能访问静态）
##### 什么时候定义静态变量
		1:静态变量（类变量）当对象中出现共享数据
		  例如：学生的学校名称。学校名称可以共享
		        对象的数据要定义为非静态的存放在对内存中（学生的姓名，学生的年龄）
##### 什么时候定义静态函数
        如果功能内部没有访问到非静态数据（对象的特有数据。那么该功能就可以定义为静态）				
##### 静态的应用
        自定义工具类
#### 继承特点
     	1：描述类和类之间的关系
     	2：降低类和类之间的重复代码
        3：降低对象和对象之间的代码重复使用静态变量
     	4：降低类和类之间的代码重复使用就继承

#### 继承细节；	
    	1：类名的设定，被继承的类称之为父类(基类)，继承的类称之为子类
    	2：子类并不能继承父类中所有的成员
            1：父类定义完整的成员 静态成员，非静态，构造方法。静态变量和静态方
            法都可以通过子类名.父类静态成员的形式调用成功。
    		2：所有的私有成员不能继承,private修饰的成员。
    		3：构造函数不能被继承
    
    	3：如何使用继承
    1：不要为了使用继承而继承。工人和学生都有共性的成员，不要为了节省代
    码，让工人继承学生。
#### super关键字作用
     		1：主要存在于子类方法中，用于指向子类对象中父类对象。
     		2：访问父类的属性
     		3：访问父类的函数
     		4：访问父类的构造函数
     	6：super注意
     this和super很像，this指向的是当前对象的调用，super指向的是当前调用对象的父类。Demo类被加载，执行main方法，Son.class加载，发现有父类Father类，于是Father类也加载进内存。类加载完毕，创建对象，父类的构造方法会被调用（默认自动无参），然后执行子类相应构造创建了一个子类对象，该子类对象还包含了一个父类对象。该父类对象在子类对象内部。this super只能在有对象的前提下使用，不能在静态上下文使用。
     2：子类的构造函数默认第一行会默认调用父类无参的构造函数，隐式语句
     super();
     			1：父类无参构造函数不存在，编译报错。
     	3：子类显式调用父类构造函数
     在子类构造函数第一行通过super关键字调用父类任何构造函数。如果显式调用父类构造函数，编译器自动添加的调用父类无参数的构造就消失。构造函数间的调用只能放在第一行，只能调用一次。super() 和this()不能同时存在构造函数第一行。
     7：子类对象查找属性或方法时的顺序：
	1：原则：就近原则。
    如果子类的对象调用方法，默认先使用this进行查找，如果当前对象没有找到属性或方法，找当前对象中维护的super关键字指向的对象，如果还没有找到编译报错，找到直接调用。
    8：重载和重写的不同
        1：重载(overload)：  
            1：前提： 所有的重载函数必须在同一个类中 
            2：特点： 
                   函数名相同，参数列表不同，与其他的无关(访问控制符、返回值类型)
            3：不同：
                个数不同 、 顺序不同、 类型不同 
        2：重写(override)：
             1：前提： 继承
            2：特点：
                  函数名必须相同、参数列表必须相同。
                  子类的返回值类型要等于或者小于父类的返回值
#### instanceof 关键字
     		1：属于比较运算符：
      		2：instanceof关键字：该关键字用来判断一个对象是否是指定类的对象。
      		3：用法：
           			对象  instanceof 类;   
     	  	该表达式是一个比较运算符，返回的结果是boolea类型  true|false
     	注意：使用instanceof关键字做判断时，两个类之间必须有关系。

#### final 关键字
     		1：final关键字主要用于修饰类、类成员、方法、以及方法的形参。
     		2：final修饰成员属性：
     
     			1：说明该成员属性是常量，不能被修改。
     				public static final double PI=3.14;
     				1：public ：访问权限最大
     				2：static ：内存中只有一份
     				3：final  ：是一个常量
     				4：常量名大写
     				5：必须初赋值。
     
     			2：使用类名.成员。修改该成员的值，报错。--常量不能被修改
     				1：基本数据类型，final使值不变
                     2：对象引用，final使其引用恒定不变，无法让其指向一个新的对象，但是对象自身却可以被修改。
     				3：该关键字一般和static关键字结合使用
     					1：常量可以优先加载，不必等到创建对象的时候再初始化。
     				4：final和static可以互换位置
     				5：常量一般被修饰为final
     			3：fianl修饰类：
     				1：该类是最终类，不能被继承。
     					1：将父类加final修饰，子类继承，就会报错。
                        2：查看api文档发现String类是final的。Integer类也是final的
     					1：为了防止代码功能被重写
     					2：该类没有必要进行扩展
     			4：final修饰方法：
     				1：该方法是最终方法，不能被重写
                    2：当一个类被继承，那么所有的非私有函数都将被继承，如果函数不想被子类继承并重写可以将该函数final修饰	
     				3：当一个类中的函数都被修饰为final时，可以将类定义为final的。
     			5：final关键字修饰形参
     				1：当形参被修饰为final,那么该形参所属的方法中不能被篡改。
                    2： 项目中主要用于一些只用来遍历未知数据的函数。将未知变量声明为final的。增强数据的安全性。

