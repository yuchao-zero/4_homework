package club.banyuan;
public class PluckyDraw{
	//2 variate to sava data
	public static final String[] studentNameArr = {"1","2","3"};
	public static final String[] choseNameArr = {};

	public static String[] generateUnchoseNames(){ //保存未被选择的数组元素
		String[] rlt = new String[studentNameArr.length - choseNameArr.length];
		boolean isFind = false;//未找到
		int idex = 0;
		//嵌套循环找出未被选择的数组元素，保存进新数组rlt中
		for(int i = 0;i < studentNameArr.length;i++){
			isFind = false;//每次进入学生数组的时候都要重置状态
			for(int j = 0;j < choseNameArr.length;j++){
				if(studentNameArr[i].equals(choseNameArr[j])){
					isFind = true; //找到相同元素
					break; //如果找到相同元素就退出此循环,继续遍历数组
				}
			}
			if(!isFind){  //如果没找到相同的元素，表示isFind == true
				rlt[idex++] = studentNameArr[i];  //将不相同的数组元素放进新数组
			}
		}
		return rlt;
	}

	public static void main(String[] args) {
		String[] unchoseStudentName = generateUnchoseNames();
		int idex = (int)(Math.random() * unchoseStudentName.length);

		System.out.println("学生姓名" + unchoseStudentName[idex]);

	}

}