package arrayList;
//�������� class(M) : �̸�, ����, ��/��/��  ��,��
//�������� class(c) : M.class ��ü 5 <-- �Է��ϱ�, ����ϱ�, ����ϱ�
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

