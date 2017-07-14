package com.hanbit.lotto.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.hanbit.lotto.constants.Butt;
import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args) {
	LottoService service = new LottoServiceImpl();
	LottoBean bean = new LottoBean();
	 Butt[]buttons={Butt.EXIT,Butt.ADD};
		do{
			flag:
		switch ((Butt) JOptionPane.showInputDialog(null,"LOTTO","SELECT MENU", JOptionPane.QUESTION_MESSAGE,null,buttons,buttons[1])) {
			case EXIT:return;
			case ADD:
				bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("how money")));
				StringBuffer buff=new StringBuffer();
				service.setLotto(bean);
				int [][] lottos=service.getLottos();
				for(int i=0;i<lottos.length;i++){
					for(int j=0;j<lottos[i].length;j++){
					//System.out.print(lottos[i][j]+"\t");
						buff.append(lottos[i][j]+"\t");
				}
				//System.out.println();			
					buff.append("/");
				}
				int lottoSerialNo=(int)(Math.random()*99999+10000);
				File output=new File("C:\\Users\\1027\\JavaProjects\\lottos\\"+lottoSerialNo+".txt");
			FileWriter fw=null;
			BufferedWriter bw=null;
			String[] lottoPrint=buff.toString().split("/");
			try {
				bw=new BufferedWriter(new FileWriter(output));
				for(String s:lottoPrint){
					s+=System.getProperty("line.separator");//="\n"
					bw.write(s);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				break flag;
			
		}}while(true);
	}}