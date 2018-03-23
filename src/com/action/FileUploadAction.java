package com.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.connection.ConnectionUtils;
import com.domains.User;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private File uploadDoc;
	private String uploadDocFileName;
	private String uploadDocContentType;
	List<User> mList;

    public String execute() {
    	System.out.println("execute called");
    	 try{
    		   if(uploadDocFileName==null){
    		    addFieldError("uploadFile", "file is required");
    		    return INPUT;
    		   }
    		    String name = getUploadDocFileName();
    		          String []fileext = name.split("\\."); 
    		          String ext = fileext[1];
    		    if(ext.equals("csv")){
    		    	System.out.println("execute uploadDocFileName:"+uploadDocFileName);
    		        BufferedReader br = null;
    		        String line = "";
    		        String cvsSplitBy = ",";
    		        mList=new ArrayList<User>();	
    		        try {

    		            br = new BufferedReader(new FileReader(uploadDoc));
    		            int i=1;
    		            while ((line = br.readLine()) != null) {
    		                // use comma as separator
    		            	User user=new User();
    		                String[] mobileNumber = line.split(cvsSplitBy);
    		                user.setId(i);
    		                user.setMobileNumber(mobileNumber[0]);
    		                i++;
    		               // ConnectionUtils.registerUser(user);
    		                mList.add(user);
    		            }
    		            System.out.println("mList:"+mList);
    		        } catch (FileNotFoundException e) {
    		            e.printStackTrace();
    		        } catch (IOException e) {
    		            e.printStackTrace();
    		        } finally {
    		            if (br != null) {
    		                try {
    		                    br.close();
    		                } catch (IOException e) {
    		                    e.printStackTrace();
    		                }
    		            }
    		         }
    		           
    		   }else{
    		       addFieldError("uploadFile", "Upload only csv file");
    		       return INPUT;
    		          }
    		  }catch(Exception e)
    		  {
    		   e.printStackTrace();
    		       addActionError(e.getMessage());
    		       return INPUT;
    		  }
	return SUCCESS;
}
    
	public String display() {
		return NONE;
	}

	public File getUploadDoc() {
		return uploadDoc;
	}

	public void setUploadDoc(File uploadDoc) {
		this.uploadDoc = uploadDoc;
	}

	public String getUploadDocFileName() {
		return uploadDocFileName;
	}

	public void setUploadDocFileName(String uploadDocFileName) {
		this.uploadDocFileName = uploadDocFileName;
	}

	public String getUploadDocContentType() {
		return uploadDocContentType;
	}

	public void setUploadDocContentType(String uploadDocContentType) {
		this.uploadDocContentType = uploadDocContentType;
	}

	public List<User> getmList() {
		return mList;
	}

	public void setmList(List<User> mList) {
		this.mList = mList;
	}
	
}
