package xxland.framework.io.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xxland.com.domain.model.KnowLedge;
import xxland.framework.ComConstant;
import xxland.framework.io.IFileController;

public class KnowLedgeFileControllerImpl extends FileControllerImpl  implements IFileController{

	public KnowLedgeFileControllerImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public KnowLedgeFileControllerImpl(String fileAbsolutePath) {
		// TODO 自動生成されたコンストラクター・スタブ
//		super.mFileAbsolutePath = fileAbsolutePath;
		super(fileAbsolutePath);
	}
	public List<KnowLedge> FindKnowLedge(String mainKey){
		try {
//		 String path = "C:\\XXLAND\\knowledge";
		 FileSearch search = new FileSearch();
		 File[] files = search.listFiles(ComConstant.KNOWLEDGE_PASS, mainKey+".txt");
		 KnowLedge knowLedge ;
		 List<KnowLedge> knowLedgeList = new ArrayList<KnowLedge>();

		  for (int i = 0; i < files.length; i++) {
	          File file = files[i];

	          BufferedReader br;
	          br = new BufferedReader(new FileReader(file));

	          String str;
	          while((str = br.readLine()) != null){

//	        	  str = br.readLine();
	        	  String[] fruit = str.split(",", -1);
	        	  knowLedge = new KnowLedge();
	        	  knowLedge.setMainKey(fruit[0]);
	        	  knowLedge.setSubKey1(fruit[1]);
	        	  knowLedge.setSubKey2(fruit[2]);
	        	  knowLedge.setSubKey3(fruit[3]);
	        	  knowLedge.setSubKey4(fruit[4]);
	        	  knowLedge.setSubKey5(fruit[5]);

	        	  knowLedgeList.add(knowLedge);
	          }

	          br.close();

	      }

		  return knowLedgeList;

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;



	}

	public boolean AddKnowLedge(KnowLedge addknowLedge){

//		 String path = "C:\\XXLAND\\knowledge";
//		 FileSearch search = new FileSearch();
//		 File[] files = search.listFiles(ComConstant.KNOWLEDGE_PASS, mainKey+".txt");
		 KnowLedge knowLedge = new KnowLedge();

		knowLedge.setMainKey(addknowLedge.getSubMainKey());
		knowLedge.setSubKey1(addknowLedge.getSubSubKey1());
		knowLedge.setSubKey2(addknowLedge.getSubSubKey1());
		knowLedge.setSubKey3(addknowLedge.getSubSubKey1());
		knowLedge.setSubKey4(addknowLedge.getSubSubKey1());
		knowLedge.setSubKey5(addknowLedge.getSubSubKey1());
		String newLine = addknowLedge.getSubMainKey() + "," + addknowLedge.getSubSubKey1() + "," +
				addknowLedge.getSubSubKey2() + "," + addknowLedge.getSubSubKey3() + "," +
				addknowLedge.getSubSubKey4() + "," + addknowLedge.getSubSubKey5() ;
		String fileName = ComConstant.KNOWLEDGE_PASS + addknowLedge.getSubMainKey() + ".txt";

		WriteFile(newLine,true);

		return true;

	}


}
