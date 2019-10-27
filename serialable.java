//对象序列化
import java.io.*;
public class Cat implements Serializable{
	private String name;
	public Cat(){
		this.name = "new cat";
	}

	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public static void main(String[] args) {
		Cat cat = new Cat();
		try{
			FileOutputStream fos = new FileOutputStream("catDemo.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			System.out.println("1>" + cat.getName());
			cat.setName("My Cat");
			oos.writeObject(cat);
			oos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			FileInputStream fis = new FileInputStream("catDemo.out");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cat = (Cat)ois.readObject();
			System.out.println("2>"+ cat.getName());
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
//writeObject和readObject本身就是线程安全的，传输过程中是不允许被并发访问的。所以对象能一个一个接连不断的传过来。