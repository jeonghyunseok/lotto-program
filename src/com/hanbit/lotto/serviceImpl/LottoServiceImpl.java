package com.hanbit.lotto.serviceImpl;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {
	int[][] lottos;//항상 인스턴스 변수가 답이다.
	int[] lotto; //돈과 상관없이 생성되는 한줄(숫자 6) 로또
	private int count;
		
	@Override
	public void setCount(LottoBean bean) {
		// 몇 줄을 출력 할 것인지 로또 수 계산(최대값 5줄);
		count=(bean.getMoney()/1000>5)?5:bean.getMoney()/1000;
		}
	@Override
	public void setLotto(LottoBean bean) {
		//로또 만들기
		setCount(bean);
		lottos=new int[count][6];
		for(count=0;count<lottos.length;count++){
			for(int j=0;j<6;j++){
				int num=bean.getNumber();
				if(!isDuplication(count, num)){
				lottos[count][j]=num;
				}else{j--;}
			}
			sort(lottos[count]);
		}
	}
	@Override
	public int[][] getLottos() {
		//만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		// 중복된 번호인지 체크(중복이면 true 리턴)
	boolean flag=false;
		for(int i=0;i<6;i++){
		 if(num==lottos[count][i]){
			 flag=true;
		 }
	 }
		
		return flag;
	}

	@Override
	public void sort(int[] arr) {
		//오름차순으로 정렬
		//swap 정렬
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
}
	@Override
	public int getCount() {
		// 해당 로또 수만큼 출력
		return count;
	}

}
