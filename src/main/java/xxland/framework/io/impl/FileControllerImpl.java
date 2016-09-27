package xxland.framework.io.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import xxland.framework.io.IFileController;

public class FileControllerImpl implements IFileController{

	protected String mFileAbsolutePath;
	protected String mFilePath;
	protected String mFileExtension;
	protected String mFileName;

	protected BufferedReader reader;


	protected File inputFile ;
	protected File outputFile ;


	protected FileInputStream fileInputStream;

	protected BufferedReader bufferedReader ;


	protected FileOutputStream fileOutputStream ;
	protected OutputStreamWriter outputStreamWriter ;
	protected PrintWriter printWriter;



	public FileControllerImpl() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public FileControllerImpl(String fileAbsolutePath) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.mFileAbsolutePath=fileAbsolutePath;
		inputFile = new File(fileAbsolutePath);
		mFilePath = inputFile.getPath();
		mFileExtension = getExtension(fileAbsolutePath);
		mFileName = inputFile.getName();
	}

@Override
public void FileName(String filename) {
	// TODO 自動生成されたメソッド・スタブ

}

@Override
public File FileOpen() {
	// TODO 自動生成されたメソッド・スタブ

	return null;
}

@Override
public File FileOpen(String filename) {
	// TODO 自動生成されたメソッド・スタブ





	return null;
}


@Override
public boolean FileExists(String filename) {
	// TODO 自動生成されたメソッド・スタブ
	return false;
}


@Override
public boolean PathExists(String passname) {
	// TODO 自動生成されたメソッド・スタブ
	return false;
}


@Override
public void CreateFile() {
	// TODO 自動生成されたメソッド・スタブ

//ファイル存在チェック


}


@Override
public void CreatePath(String filename) {
	// TODO 自動生成されたメソッド・スタブ

}



@Override
public void WriteFile(List<?> addList, boolean appendFlg, String encoding) {
	// TODO 自動生成されたメソッド・スタブ
	// TODO 自動生成されたメソッド・スタブ

		try {
			fileOutputStream  = new FileOutputStream(outputFile);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream,encoding);
			printWriter = new PrintWriter(outputStreamWriter);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
}

@Override
public void WriteFile(List<?> addList, boolean appendFlg) {
	// TODO 自動生成されたメソッド・スタブ
	inputFile = new File(mFileName);
	try {
		fileOutputStream  = new FileOutputStream(outputFile);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
		printWriter = new PrintWriter(outputStreamWriter);
		Write(addList,appendFlg);

	} catch (FileNotFoundException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}



}

@Override
public void Write(List<?> addList, boolean appendFlg) {
	// TODO 自動生成されたメソッド・スタブ


}

@Override
public void Write(String addLine, boolean appendFlg) {
	// TODO 自動生成されたメソッド・スタブ

}

@Override
public void WriteFile(String addLine, boolean appendFlg, String encoding) {
	// TODO 自動生成されたメソッド・スタブ
	inputFile = new File(mFileName);
	try {
		fileOutputStream  = new FileOutputStream(outputFile);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream,encoding);
		printWriter = new PrintWriter(outputStreamWriter);
	} catch (FileNotFoundException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
}

@Override
public void WriteFile(String addLine, boolean appendFlg) {
	// TODO 自動生成されたメソッド・スタブ
	inputFile = new File(mFileName);
	try {
		fileOutputStream  = new FileOutputStream(outputFile);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
		printWriter = new PrintWriter(outputStreamWriter);

		if (appendFlg){
			printWriter.println(addLine);
		}else{
			printWriter.append(addLine);
		}
		printWriter.close();

	} catch (FileNotFoundException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
}


public String getExtension(String fileName) {
    if (fileName == null) {
        return null;
    }

    // 最後の『 . 』の位置を取得します。
    int lastDotPosition = fileName.lastIndexOf(".");

    // 『 . 』が存在する場合は、『 . 』以降を返します。
    if (lastDotPosition != -1) {
        return fileName.substring(lastDotPosition + 1);
    }
    return null;
}







}
