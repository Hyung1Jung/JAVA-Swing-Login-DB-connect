package arrayList;
//성적관리 class(M) : 이름, 변수, 국/영/수  총,평
//성적관리 class(c) : M.class 객체 5 <-- 입력하기, 출력하기, 계산하기
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M oo = new M();
		
		ArrayList<M> ob = new ArrayList<M>(5);
		
		oo.input();

		ob.add(oo);
		
		System.out.println(ob);
		
	}

}

