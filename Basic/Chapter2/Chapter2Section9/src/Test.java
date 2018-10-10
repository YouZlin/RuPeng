
/**
 * 变量注意事项
 *
 */
public class Test {

	public static void main(String[] args) {
		//变量必须定义才能使用
		{
		//错误例子 : error=7;
		int i;
		i=6;
		//int i=7;//变量名称定义不能重复,无论是类型相同与否
		i=7;//此处为赋值,不影响变量的定义
		}
		//局部变量的作用域,局部变量需要初始化
		int a=100;
		{
			int b=200;
			System.out.println(a);
			System.out.println(b);
		}
		System.out.println(a);//
//		System.out.println(b);//错误,b的作用域在{}内
	}

}
