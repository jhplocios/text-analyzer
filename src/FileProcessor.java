
public class FileProcessor extends Thread {
	private FileUtility1 fileUtil;
	private String file;
	private ResultType type;
	
	public FileProcessor( String file, ResultType type) {
		this.fileUtil = new FileUtility1();
		this.file=file;
		this.type= type;
		
	}

	@Override
	public void run() {
		System.out.println(fileUtil.processFile(file,type));
	}

}
