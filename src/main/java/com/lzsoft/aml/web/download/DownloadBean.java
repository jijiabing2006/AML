package com.lzsoft.aml.web.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.lzsoft.aml.entity.model.Download;

@ManagedBean(name = "downloadBean")
@ViewScoped
public class DownloadBean {
	@ManagedProperty("#{download}")
	private Download download;

	public Download getDownload() {
		return download;
	}

	public void setDownload(Download download) {
		this.download = download;
	}

	public void downloadFile() throws IOException {
		String fileName = download.getFileName();
		if (null == fileName) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("需要下载的文件不存在"));

		} else {
			String fullPath = "";
			if (!download.isAbsolutePath()) {
				String rootPath = ((ServletContext) FacesContext
						.getCurrentInstance().getExternalContext().getContext())
						.getRealPath("/");
				fullPath = rootPath + fileName;
			} else {
				fullPath = fileName;
			}

			File exportFile = new File(fullPath);

			if (!exportFile.exists()) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("需要下载的文件不存在"));
			} else {
				HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
						.getCurrentInstance().getExternalContext()
						.getResponse();
				ServletOutputStream servletOutputStream = null;
				try {
					servletOutputStream = httpServletResponse.getOutputStream();
				} catch (IOException e) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("下载文件发生错误" + e.getMessage()));
					throw e;
				}
				int index = fileName.lastIndexOf("\\");
				fileName = fileName.substring(index + 1, fileName.length());
				httpServletResponse.setHeader("Content-disposition",
						"attachment; filename=" + fileName);
				httpServletResponse.setContentLength((int) exportFile.length());
				httpServletResponse.setContentType("application/x-download");
				// httpServletResponse.setContentType("application/vnd.ms-excel");

				byte[] b = new byte[1024];
				FileInputStream fis = null ;
				int i = 0;
				try {
					fis= new java.io.FileInputStream(
							exportFile);
					while ((i = fis.read(b)) > 0) {
						servletOutputStream.write(b, 0, i);
					}
					servletOutputStream.flush();
				} catch (IOException e) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("下载文件发生错误" + e.getMessage()));
					throw e;
				} finally {
					if (fis != null)
						fis.close();
					if (servletOutputStream != null)
						servletOutputStream.close();
				}
				FacesContext.getCurrentInstance().responseComplete();
			}
		}
	}

	/**
	 * <p>
	 * 功能说明：将服务器上的文件下载到本地 文件名为原文件名
	 * </p>
	 * 
	 * @param strfileName
	 *            String 处理得到的文件URL+实际文件名
	 * @param S_Name
	 *            String 原文件名
	 * @return void
	 * @throws IOException
	 */
	public static void downloadFileAsS_Name(String strfileName, String S_Name)
			throws IOException {
		File exportFile = new File(strfileName);
		try {
			// exportFile = FileEncrypt.dencrypt(exportFile); //解密
			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			ServletOutputStream servletOutputStream = httpServletResponse
					.getOutputStream();
			// 此处只写文件名exportFile.getName()，不需绝对路径

			httpServletResponse
					.setHeader(
							"Content-Disposition",
							"attachment;filename="
									+ new String(S_Name.getBytes("gb2312"),
											"ISO8859-1"));
			httpServletResponse.setContentLength((int) exportFile.length());
			httpServletResponse.setContentType("application/x-download");

			byte[] b = new byte[1024];
			int i = 0;
			FileInputStream fis = new java.io.FileInputStream(exportFile);
			while ((i = fis.read(b)) > 0) {
				servletOutputStream.write(b, 0, i);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		exportFile.delete();
		FacesContext.getCurrentInstance().responseComplete();
	}

}
