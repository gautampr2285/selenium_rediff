package windowmanagement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.devtools.domstorage.model.Item;

public class Set_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> s = new HashSet<String>();
		System.out.println(s.size());
		s.add("Test1");
		s.add("Test2");
		s.add("Test3");
		System.out.println(s.size());
		
		Iterator<String> it = s.iterator();
		//System.out.println(it.next());
		//System.out.println(it.next());
		//System.out.println(it.next());
		
		while(it.hasNext())
			System.out.println(it.next());
		
	}

}
