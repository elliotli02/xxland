package xxland.framework.io.impl;

import java.io.File;

public interface IFileController {
	public void FileName();
	public File FileOpen();
	public File FileOpen(String filename);

	public boolean FileExists(String filename);
	public boolean PathExists(String passname);
	public void CreateFile(String filename);
	public void CreatePath(String filename);


}
