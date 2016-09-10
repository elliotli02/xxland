package xxland.framework.io.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xxland.com.domain.model.KnowLedge;

public class KnowLedgeFileControllerImpl extends FileControllerImpl  implements IFileController{

	public KnowLedgeFileControllerImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public KnowLedgeFileControllerImpl(String fileName) {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public List<KnowLedge> FindKnowLedge(String mainKey){
		try {
		 String path = "C:\\XXLAND\\knowledge";
		 FileSearch search = new FileSearch();
		 File[] files = search.listFiles(path, mainKey);
		 KnowLedge knowLedge = new KnowLedge();
		 List<KnowLedge> knowLedgeList = new ArrayList<KnowLedge>();

		  for (int i = 0; i < files.length; i++) {
	          File file = files[i];

	          BufferedReader br;
	          br = new BufferedReader(new FileReader(file));

	          String str;
	          while((str = br.readLine()) != null){

//	        	  str = br.readLine();
	        	  String[] fruit = str.split(" ", 0);
	        	  knowLedge.setMainKey(mainKey);
	        	  knowLedge.setSubKey1(fruit[0]);
	        	  knowLedge.setSubKey2(fruit[1]);
	        	  knowLedge.setSubKey3(fruit[2]);
	        	  knowLedge.setSubKey4(fruit[3]);
	        	  knowLedge.setSubKey5(fruit[4]);

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

}
