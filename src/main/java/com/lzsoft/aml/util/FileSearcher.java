package com.lzsoft.aml.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

/**
 * 已在beans.xml 定义
 * 
 * @author jjsoft.cn
 *
 */
public class FileSearcher {

	private FilenameFilter filenameFilter;
	
	private Set<String> foundFiles;

	public Set<String> search(String pathname) {
		return search(new File(pathname));
	}

	public Set<String> search(File path) {
		if (path.exists()) {
			if (path.isDirectory()) {
				searchInSubDirectory(path);
			} else if (path.isFile()) {
				foundFiles.add(path.getAbsolutePath());
			}
		}
		return foundFiles;
	}
	
	private void searchInSubDirectory(File currentPath) {
		String[] files = currentPath.list(filenameFilter);

		for (String filename : files) {
			String fullname = currentPath.getPath() + File.separator + filename;
			File foundFile = new File(fullname);
			if (foundFile.exists()) {
				if (foundFile.isDirectory()) {
					searchInSubDirectory(foundFile);
				} else if (foundFile.isFile()) {
					foundFiles.add(foundFile.getAbsolutePath());
				}
			}
		}

	}

	public FilenameFilter getFilenameFilter() {
		return filenameFilter;
	}

	public void setFilenameFilter(FilenameFilter filenameFilter) {
		this.filenameFilter = filenameFilter;
	}

	public Set<String> getFoundFiles() {
		return foundFiles;
	}

	public void setFoundFiles(Set<String> foundFiles) {
		this.foundFiles = foundFiles;
	}

}
