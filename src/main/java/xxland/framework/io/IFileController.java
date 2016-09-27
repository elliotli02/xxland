package xxland.framework.io;

import java.io.File;
import java.util.List;

public interface IFileController {
	public void FileName(String filename);
	public File FileOpen();
	public File FileOpen(String filename);

	public boolean FileExists(String filename);
	public boolean PathExists(String passname);
	public void CreateFile();
	public void CreatePath(String filename);

	public void Write(List<?> addList,boolean appendFlg);

	public void WriteFile(List<?> addList,boolean appendFlg,String encoding);

	public void WriteFile(List<?> addList,boolean appendFlg);


	public void Write(String addLine,boolean appendFlg);

	public void WriteFile(String addLine,boolean appendFlg,String encoding);

	public void WriteFile(String addLine,boolean appendFlg);

}
