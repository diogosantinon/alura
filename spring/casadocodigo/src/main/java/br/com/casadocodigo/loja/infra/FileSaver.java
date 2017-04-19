package br.com.casadocodigo.loja.infra;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver { //componente para transfer files
	
	@Autowired
	private HttpServletRequest request; 

	public String write(String baseFolder, MultipartFile file) {
	    try {
	        String folder = "/WEB-INF/"+baseFolder;
			String realPath = request.getServletContext().getRealPath(folder);
	        String path = realPath + "/" + file.getOriginalFilename();
	        file.transferTo(new File(path));
	        return baseFolder + "/" + file.getOriginalFilename();

	    } catch (Exception e) {
            throw new RuntimeException(e);    
        }
	}	
	
}
